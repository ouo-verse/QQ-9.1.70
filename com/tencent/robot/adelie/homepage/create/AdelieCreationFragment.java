package com.tencent.robot.adelie.homepage.create;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.google.gson.Gson;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernel.nativeinterface.AiAvatarInfo;
import com.tencent.qqnt.kernel.nativeinterface.AiGenBotInfoOperationType;
import com.tencent.qqnt.kernel.nativeinterface.AiGenPicInfo;
import com.tencent.qqnt.kernel.nativeinterface.BotGender;
import com.tencent.qqnt.kernel.nativeinterface.ChangeMyBotOperationType;
import com.tencent.qqnt.kernel.nativeinterface.IAiGenAvatarCallback;
import com.tencent.qqnt.kernel.nativeinterface.MyBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.PromptLabel;
import com.tencent.qqnt.kernel.nativeinterface.RobotPromptConversation;
import com.tencent.qqnt.kernel.nativeinterface.UGCConversationSetting;
import com.tencent.qqnt.kernel.nativeinterface.UgcSettingInfo;
import com.tencent.robot.adelie.AdelieFragmentActivity;
import com.tencent.robot.adelie.constant.AdelieConstant;
import com.tencent.robot.adelie.homepage.AdelieUtils;
import com.tencent.robot.adelie.homepage.create.ak;
import com.tencent.robot.adelie.homepage.create.view.AdelieEditTextView;
import com.tencent.robot.adelie.homepage.create.view.AdelieGenderPickerView;
import com.tencent.robot.adelie.homepage.create.view.AdelieHeadIconView;
import com.tencent.robot.adelie.homepage.create.view.AdeliePolarLightBkgView;
import com.tencent.robot.adelie.homepage.create.view.AdelieScrollView;
import com.tencent.robot.adelie.homepage.create.view.AdelieSettingEditView;
import com.tencent.robot.adelie.homepage.create.view.InterceptTouchEditText;
import com.tencent.robot.adelie.homepage.create.view.TextCategory;
import com.tencent.robot.adelie.homepage.create.viewmodel.AdelieCreateOrEditPageViewModel;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import com.tencent.robot.adelie.homepage.utils.b;
import com.tencent.robot.adelie.kuikly.module.AdelieTtsSelectResult;
import com.tencent.robot.adelie.kuikly.module.p;
import com.tencent.robot.api.IRobotAIORouteApi;
import com.tencent.robot.api.RobotAIORouteArgs;
import com.tencent.robot.api.RouteFailedReason;
import com.tencent.robot.qqmc.RobotQQMC;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.Switch;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C11736d;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d6\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\t*\u0004\u00da\u0002\u00de\u0002\b\u0016\u0018\u0000 \u00e4\u00022\u00020\u0001:\u0002\u00e5\u0002B\t\u00a2\u0006\u0006\b\u00e2\u0002\u0010\u00e3\u0002J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u001e\u0010\u0011\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J(\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J(\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J(\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010#\u001a\u00020\u0002H\u0002J\b\u0010$\u001a\u00020\u0002H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020\u0002H\u0002J\b\u0010(\u001a\u00020\u0002H\u0003J\b\u0010)\u001a\u00020\u0002H\u0002J\b\u0010*\u001a\u00020\u0002H\u0002J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020!H\u0002J \u00100\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u0012H\u0002J\b\u00101\u001a\u00020\u0002H\u0002J\u0010\u00103\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0012H\u0002J\b\u00104\u001a\u00020\u0002H\u0002J\b\u00105\u001a\u00020\u0002H\u0002J\u0010\u00106\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0014\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020807H\u0002J\u0010\u0010<\u001a\u00020\u00022\u0006\u0010;\u001a\u00020:H\u0002J\u0010\u0010=\u001a\u00020\u00022\u0006\u0010;\u001a\u00020:H\u0002J\u0018\u0010>\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J.\u0010?\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010;\u001a\u00020:H\u0002J$\u0010C\u001a\u00020\u00022\u0006\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020:2\b\b\u0002\u0010B\u001a\u00020\u0007H\u0002J\b\u0010D\u001a\u00020\u0002H\u0002J&\u0010I\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00072\u0014\u0010H\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010G\u0012\u0004\u0012\u00020\u00020FH\u0002J\u0010\u0010K\u001a\u00020\u00022\u0006\u0010J\u001a\u00020!H\u0002J\b\u0010L\u001a\u00020\u0002H\u0002J\b\u0010M\u001a\u00020\u0002H\u0002J\u0014\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020807H\u0002J\b\u0010O\u001a\u00020!H\u0016J\u0010\u0010P\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010Q\u001a\u00020\u0012H\u0014J\b\u0010R\u001a\u00020\u0012H\u0014J\u001c\u0010U\u001a\u00020\u00022\b\u0010S\u001a\u0004\u0018\u00010\u00072\b\u0010T\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010V\u001a\u00020\u0007H\u0016J\n\u0010X\u001a\u0004\u0018\u00010WH\u0016J\u0016\u0010Y\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000208\u0018\u000107H\u0016J\u0012\u0010\\\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010ZH\u0016J&\u0010a\u001a\u00020\u00022\b\u0010^\u001a\u0004\u0018\u00010]2\b\u0010`\u001a\u0004\u0018\u00010_2\b\u0010[\u001a\u0004\u0018\u00010ZH\u0014J\b\u0010b\u001a\u00020\u0002H\u0016J\n\u0010c\u001a\u0004\u0018\u00010\u001aH\u0016J\n\u0010e\u001a\u0004\u0018\u00010dH\u0016J\u0012\u0010h\u001a\u00020\u00022\b\u0010g\u001a\u0004\u0018\u00010fH\u0016J\b\u0010j\u001a\u00020iH\u0016J\u0018\u0010k\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J.\u0010l\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0006\u0010m\u001a\u00020\u0002J\u001a\u0010q\u001a\u00020!2\u0006\u0010n\u001a\u00020\u00122\b\u0010p\u001a\u0004\u0018\u00010oH\u0016J\b\u0010r\u001a\u00020!H\u0016J\u0012\u0010s\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0004J\b\u0010t\u001a\u00020\u0002H\u0004J\b\u0010u\u001a\u00020\u0002H\u0004J\u0010\u0010w\u001a\u00020\u00022\u0006\u0010v\u001a\u00020!H\u0004J\"\u0010z\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00072\u0006\u0010x\u001a\u00020\u00152\b\b\u0002\u0010y\u001a\u00020\u0007H\u0004J\b\u0010{\u001a\u00020\u0002H\u0014J\b\u0010|\u001a\u00020\u0002H\u0016J\b\u0010}\u001a\u00020\u0002H\u0016J\b\u0010~\u001a\u00020\u0002H\u0016R+\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u007f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R,\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R+\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u001a8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R,\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R,\u0010\u00a1\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u009e\u0001\u0010\u0098\u0001\u001a\u0006\b\u009f\u0001\u0010\u009a\u0001\"\u0006\b\u00a0\u0001\u0010\u009c\u0001R+\u0010\u00a5\u0001\u001a\u0004\u0018\u00010\u001a8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00a2\u0001\u0010\u0090\u0001\u001a\u0006\b\u00a3\u0001\u0010\u0092\u0001\"\u0006\b\u00a4\u0001\u0010\u0094\u0001R+\u0010\u00a9\u0001\u001a\u0004\u0018\u00010\u001a8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00a6\u0001\u0010\u0090\u0001\u001a\u0006\b\u00a7\u0001\u0010\u0092\u0001\"\u0006\b\u00a8\u0001\u0010\u0094\u0001R+\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u001a8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00aa\u0001\u0010\u0090\u0001\u001a\u0006\b\u00ab\u0001\u0010\u0092\u0001\"\u0006\b\u00ac\u0001\u0010\u0094\u0001R,\u0010\u00b5\u0001\u001a\u0005\u0018\u00010\u00ae\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00af\u0001\u0010\u00b0\u0001\u001a\u0006\b\u00b1\u0001\u0010\u00b2\u0001\"\u0006\b\u00b3\u0001\u0010\u00b4\u0001R,\u0010\u00bd\u0001\u001a\u0005\u0018\u00010\u00b6\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00b7\u0001\u0010\u00b8\u0001\u001a\u0006\b\u00b9\u0001\u0010\u00ba\u0001\"\u0006\b\u00bb\u0001\u0010\u00bc\u0001R,\u0010\u00c5\u0001\u001a\u0005\u0018\u00010\u00be\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00bf\u0001\u0010\u00c0\u0001\u001a\u0006\b\u00c1\u0001\u0010\u00c2\u0001\"\u0006\b\u00c3\u0001\u0010\u00c4\u0001R,\u0010\u00c9\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00c6\u0001\u0010\u0098\u0001\u001a\u0006\b\u00c7\u0001\u0010\u009a\u0001\"\u0006\b\u00c8\u0001\u0010\u009c\u0001R+\u0010\u00d0\u0001\u001a\u0004\u0018\u00010d8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00ca\u0001\u0010\u00cb\u0001\u001a\u0006\b\u00cc\u0001\u0010\u00cd\u0001\"\u0006\b\u00ce\u0001\u0010\u00cf\u0001R\u001c\u0010\u00d4\u0001\u001a\u0005\u0018\u00010\u00d1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d2\u0001\u0010\u00d3\u0001R,\u0010\u00dc\u0001\u001a\u0005\u0018\u00010\u00d5\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00d6\u0001\u0010\u00d7\u0001\u001a\u0006\b\u00d8\u0001\u0010\u00d9\u0001\"\u0006\b\u00da\u0001\u0010\u00db\u0001R\"\u0010\u00e0\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00dd\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00de\u0001\u0010\u00df\u0001R\u001c\u0010\u00e4\u0001\u001a\u0005\u0018\u00010\u00e1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e2\u0001\u0010\u00e3\u0001R\u001c\u0010\u00e8\u0001\u001a\u0005\u0018\u00010\u00e5\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e6\u0001\u0010\u00e7\u0001R,\u0010\u00f0\u0001\u001a\u0005\u0018\u00010\u00e9\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00ea\u0001\u0010\u00eb\u0001\u001a\u0006\b\u00ec\u0001\u0010\u00ed\u0001\"\u0006\b\u00ee\u0001\u0010\u00ef\u0001R\u001b\u0010\u00f2\u0001\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f1\u0001\u0010\u0090\u0001R\u001b\u0010\u00f4\u0001\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f3\u0001\u0010\u0090\u0001R\u001c\u0010\u00f8\u0001\u001a\u0005\u0018\u00010\u00f5\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f6\u0001\u0010\u00f7\u0001R\u0019\u0010\u00fb\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f9\u0001\u0010\u00fa\u0001R\u0019\u0010\u00fd\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00fc\u0001\u0010\u008f\u0001R)\u0010\u0083\u0002\u001a\u00020!8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00fe\u0001\u0010\u00e6\u0001\u001a\u0006\b\u00ff\u0001\u0010\u0080\u0002\"\u0006\b\u0081\u0002\u0010\u0082\u0002R\u0019\u0010\u0085\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0084\u0002\u0010\u00fa\u0001R,\u0010\u008d\u0002\u001a\u0005\u0018\u00010\u0086\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u0087\u0002\u0010\u0088\u0002\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002\"\u0006\b\u008b\u0002\u0010\u008c\u0002R\u001c\u0010\u008f\u0002\u001a\u0005\u0018\u00010\u00d5\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0002\u0010\u00d7\u0001R)\u0010\u0095\u0002\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u0090\u0002\u0010\u00fa\u0001\u001a\u0006\b\u0091\u0002\u0010\u0092\u0002\"\u0006\b\u0093\u0002\u0010\u0094\u0002R)\u0010\u0099\u0002\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u0096\u0002\u0010\u00fa\u0001\u001a\u0006\b\u0097\u0002\u0010\u0092\u0002\"\u0006\b\u0098\u0002\u0010\u0094\u0002R\u001c\u0010\u009b\u0002\u001a\u0005\u0018\u00010\u00d1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0002\u0010\u00d3\u0001R\u001c\u0010\u009d\u0002\u001a\u0005\u0018\u00010\u00d5\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009c\u0002\u0010\u00d7\u0001R\u001c\u0010\u009f\u0002\u001a\u0005\u0018\u00010\u00d5\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009e\u0002\u0010\u00d7\u0001R\u001c\u0010\u00a3\u0002\u001a\u0005\u0018\u00010\u00a0\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0002\u0010\u00a2\u0002R\u0019\u0010\u00a5\u0002\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a4\u0002\u0010\u00e6\u0001R,\u0010\u00ab\u0002\u001a\u0005\u0018\u00010\u00d1\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00a6\u0002\u0010\u00d3\u0001\u001a\u0006\b\u00a7\u0002\u0010\u00a8\u0002\"\u0006\b\u00a9\u0002\u0010\u00aa\u0002R,\u0010\u00af\u0002\u001a\u0005\u0018\u00010\u00d5\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00ac\u0002\u0010\u00d7\u0001\u001a\u0006\b\u00ad\u0002\u0010\u00d9\u0001\"\u0006\b\u00ae\u0002\u0010\u00db\u0001R*\u0010\u00b7\u0002\u001a\u00030\u00b0\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00b1\u0002\u0010\u00b2\u0002\u001a\u0006\b\u00b3\u0002\u0010\u00b4\u0002\"\u0006\b\u00b5\u0002\u0010\u00b6\u0002R)\u0010\u00bd\u0002\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b8\u0002\u0010\u0088\u0001\u001a\u0006\b\u00b9\u0002\u0010\u00ba\u0002\"\u0006\b\u00bb\u0002\u0010\u00bc\u0002R)\u0010\u00c1\u0002\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00be\u0002\u0010\u0088\u0001\u001a\u0006\b\u00bf\u0002\u0010\u00ba\u0002\"\u0006\b\u00c0\u0002\u0010\u00bc\u0002R)\u0010\u00c5\u0002\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00c2\u0002\u0010\u0088\u0001\u001a\u0006\b\u00c3\u0002\u0010\u00ba\u0002\"\u0006\b\u00c4\u0002\u0010\u00bc\u0002R!\u0010\u00cb\u0002\u001a\u00030\u00c6\u00028BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c7\u0002\u0010\u00c8\u0002\u001a\u0006\b\u00c9\u0002\u0010\u00ca\u0002R'\u0010\u00d0\u0002\u001a\t\u0012\u0004\u0012\u00020\u000f0\u00cc\u00028BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00cd\u0002\u0010\u00c8\u0002\u001a\u0006\b\u00ce\u0002\u0010\u00cf\u0002R\u0019\u0010\u00d2\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d1\u0002\u0010\u0088\u0001R\u001b\u0010\u00d5\u0002\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d3\u0002\u0010\u00d4\u0002R\u0018\u0010\u00d9\u0002\u001a\u00030\u00d6\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d7\u0002\u0010\u00d8\u0002R\u0018\u0010\u00dd\u0002\u001a\u00030\u00da\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00db\u0002\u0010\u00dc\u0002R\u0018\u0010\u00e1\u0002\u001a\u00030\u00de\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00df\u0002\u0010\u00e0\u0002\u00a8\u0006\u00e6\u0002"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/AdelieCreationFragment;", "Lcom/tencent/robot/adelie/homepage/create/AdelieBaseFragment;", "", "mk", "initView", "Oj", "fk", "", "data", "ck", "Landroid/view/View$OnClickListener;", "rj", "wk", "Lmqq/util/WeakReference;", "weakFragment", "Lcom/tencent/qqnt/kernel/nativeinterface/MyBotInfo;", "botInfo", "Wj", "", "errCode", "ik", "", "startTime", "endTime", "errMsg", "gk", "Landroid/view/View;", "view", "setting", "openRemark", "nickname", "dj", "desc", "", "Zi", "Kj", "dk", "Landroid/graphics/drawable/Drawable;", "ej", "yk", "Nj", "aj", "ij", "isHintEmpty", "Vi", "holderHeight", "barHeight", "buttonBottom", "Ui", "Xj", "keyboardHeight", "Yi", "nk", "Lj", "gj", "", "", "wj", "Lcom/tencent/qqnt/kernel/nativeinterface/AiGenBotInfoOperationType;", "type", "Wi", "Dk", "hk", "Ck", "nickName", "genType", "templateId", "kj", "jk", "url", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "onGetBitmap", "mj", "success", "lk", "Ij", "Mj", "lj", "isAllowLandscape", "Xi", "getPageType", "getContentLayoutId", "avatarPath", "bgPath", "Oh", "Kh", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieHeadIconView;", "Dh", "Aj", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "doOnCreateView", "onFinish", "Bh", "Lcom/tencent/robot/adelie/homepage/create/view/AdeliePolarLightBkgView;", "Ih", "Landroid/content/Context;", "context", "yh", "Lcom/tencent/qqnt/kernel/nativeinterface/ChangeMyBotOperationType;", "zj", "Yj", "Ak", "bk", "keyCode", "Landroid/view/KeyEvent;", "event", "doOnKeyDown", "onBackEvent", "uk", "Bk", "xk", "enable", "Ek", "generateStartTime", "source", "vk", "zk", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText;", "H", "Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText;", "xj", "()Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText;", "setNicknameEditText", "(Lcom/tencent/robot/adelie/homepage/create/view/InterceptTouchEditText;)V", "nicknameEditText", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "I", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "tj", "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "setCreationButton", "(Lcom/tencent/biz/qui/quibutton/QUIButton;)V", "creationButton", "J", "Landroid/view/View;", "pj", "()Landroid/view/View;", "setButtomBar", "(Landroid/view/View;)V", "buttomBar", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieEditTextView;", "K", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieEditTextView;", "yj", "()Lcom/tencent/robot/adelie/homepage/create/view/AdelieEditTextView;", "setOpenMarkView", "(Lcom/tencent/robot/adelie/homepage/create/view/AdelieEditTextView;)V", "openMarkView", "L", "uj", "setDescView", "descView", "M", "qj", "setContentContainerView", "contentContainerView", "N", "Gj", "setTopSettingContainerView", "topSettingContainerView", "P", "oj", "setBottomSettingContainerView", "bottomSettingContainerView", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieSettingEditView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/robot/adelie/homepage/create/view/AdelieSettingEditView;", "Ej", "()Lcom/tencent/robot/adelie/homepage/create/view/AdelieSettingEditView;", "setSettingView", "(Lcom/tencent/robot/adelie/homepage/create/view/AdelieSettingEditView;)V", "settingView", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieGenderPickerView;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/robot/adelie/homepage/create/view/AdelieGenderPickerView;", "vj", "()Lcom/tencent/robot/adelie/homepage/create/view/AdelieGenderPickerView;", "setGenderView", "(Lcom/tencent/robot/adelie/homepage/create/view/AdelieGenderPickerView;)V", "genderView", "Landroid/widget/ImageView;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/ImageView;", "getMagicIcon", "()Landroid/widget/ImageView;", "setMagicIcon", "(Landroid/widget/ImageView;)V", "magicIcon", "T", "getCurrentEditTextView", "rk", "currentEditTextView", "U", "Lcom/tencent/robot/adelie/homepage/create/view/AdeliePolarLightBkgView;", "getBkgView", "()Lcom/tencent/robot/adelie/homepage/create/view/AdeliePolarLightBkgView;", "setBkgView", "(Lcom/tencent/robot/adelie/homepage/create/view/AdeliePolarLightBkgView;)V", "bkgView", "Landroid/widget/RelativeLayout;", "V", "Landroid/widget/RelativeLayout;", "ttsLayout", "Landroid/widget/TextView;", "W", "Landroid/widget/TextView;", "Hj", "()Landroid/widget/TextView;", "setTtsNameView", "(Landroid/widget/TextView;)V", "ttsNameView", "Landroidx/lifecycle/LiveData;", "X", "Landroidx/lifecycle/LiveData;", "botInfoLiveData", "Lcom/tencent/robot/adelie/homepage/create/ak;", "Y", "Lcom/tencent/robot/adelie/homepage/create/ak;", "keyboardStateHelper", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieScrollView;", "Z", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieScrollView;", "scrollView", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "a0", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "getCheckBox", "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "setCheckBox", "(Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;)V", "checkBox", "b0", "placeholderView", "c0", "placeHolderStay", "Lcom/tencent/robot/adelie/homepage/create/ao;", "d0", "Lcom/tencent/robot/adelie/homepage/create/ao;", "startupParams", "e0", "Ljava/lang/String;", "avatarGenSource", "f0", "genStartTime", "g0", "Vj", "()Z", "sk", "(Z)V", "isPickImage", "h0", ISchemeApi.KEY_REFERER, "Landroid/widget/LinearLayout;", "i0", "Landroid/widget/LinearLayout;", "Bj", "()Landroid/widget/LinearLayout;", "setPrivacyContainer", "(Landroid/widget/LinearLayout;)V", "privacyContainer", "j0", "recyclerHint", "k0", "getActivityId", "()Ljava/lang/String;", "pk", "(Ljava/lang/String;)V", "activityId", "l0", "getActivityName", "qk", "activityName", "m0", "activityLayout", "n0", "activityNameView", "o0", "activityTipsView", "Lcom/tencent/widget/Switch;", "p0", "Lcom/tencent/widget/Switch;", "activitySwitch", "q0", "enableActivity", "r0", "Cj", "()Landroid/widget/RelativeLayout;", "setPromptConversationContainer", "(Landroid/widget/RelativeLayout;)V", "promptConversationContainer", "s0", "Dj", "setPromptConversationName", "promptConversationName", "Lcom/tencent/robot/adelie/kuikly/module/o;", "t0", "Lcom/tencent/robot/adelie/kuikly/module/o;", "getTtsSelectResult", "()Lcom/tencent/robot/adelie/kuikly/module/o;", "tk", "(Lcom/tencent/robot/adelie/kuikly/module/o;)V", "ttsSelectResult", "u0", "getOpenMarkPosition", "()I", "setOpenMarkPosition", "(I)V", "openMarkPosition", "v0", "getSettingPosition", "setSettingPosition", "settingPosition", "w0", "getDescPosition", "setDescPosition", "descPosition", "Lcom/tencent/robot/adelie/homepage/create/al;", "x0", "Lkotlin/Lazy;", "Fj", "()Lcom/tencent/robot/adelie/homepage/create/al;", "textLimitNumber", "Landroidx/lifecycle/Observer;", "y0", "nj", "()Landroidx/lifecycle/Observer;", "botInfoObserver", "z0", "currentScrollY", "A0", "Ljava/lang/Integer;", "currentKeyboardHeightInPx", "Lh53/q;", "B0", "Lh53/q;", "nickNameWatcher", "com/tencent/robot/adelie/homepage/create/AdelieCreationFragment$c", "C0", "Lcom/tencent/robot/adelie/homepage/create/AdelieCreationFragment$c;", "editTextViewListener", "com/tencent/robot/adelie/homepage/create/AdelieCreationFragment$ttsSelectResultBroadcastReceiver$1", "D0", "Lcom/tencent/robot/adelie/homepage/create/AdelieCreationFragment$ttsSelectResultBroadcastReceiver$1;", "ttsSelectResultBroadcastReceiver", "<init>", "()V", "E0", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class AdelieCreationFragment extends AdelieBaseFragment {

    /* renamed from: E0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A0, reason: from kotlin metadata */
    @Nullable
    private Integer currentKeyboardHeightInPx;

    /* renamed from: B0, reason: from kotlin metadata */
    @NotNull
    private final h53.q nickNameWatcher;

    /* renamed from: C0, reason: from kotlin metadata */
    @NotNull
    private final c editTextViewListener;

    /* renamed from: D0, reason: from kotlin metadata */
    @NotNull
    private final AdelieCreationFragment$ttsSelectResultBroadcastReceiver$1 ttsSelectResultBroadcastReceiver;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private InterceptTouchEditText nicknameEditText;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private QUIButton creationButton;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private View buttomBar;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private AdelieEditTextView openMarkView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private AdelieEditTextView descView;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private View contentContainerView;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private View topSettingContainerView;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private View bottomSettingContainerView;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private AdelieSettingEditView settingView;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private AdelieGenderPickerView genderView;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private ImageView magicIcon;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private AdelieEditTextView currentEditTextView;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private AdeliePolarLightBkgView bkgView;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout ttsLayout;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private TextView ttsNameView;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private LiveData<MyBotInfo> botInfoLiveData;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private ak keyboardStateHelper;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private AdelieScrollView scrollView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUICheckBox checkBox;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View placeholderView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View placeHolderStay;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private StartupParams startupParams;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private long genStartTime;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private boolean isPickImage;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout privacyContainer;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView recyclerHint;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout activityLayout;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView activityNameView;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView activityTipsView;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Switch activitySwitch;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout promptConversationContainer;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView promptConversationName;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private int openMarkPosition;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private int settingPosition;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private int descPosition;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy textLimitNumber;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy botInfoObserver;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    private int currentScrollY;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String avatarGenSource = "avatar_auto_fill";

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String referer = "";

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String activityId = "";

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String activityName = "";

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private boolean enableActivity = true;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AdelieTtsSelectResult ttsSelectResult = new AdelieTtsSelectResult(null, null, 0, 7, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/AdelieCreationFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "a", "", "KUIKLY_EVENT_CREATE_ROBOT", "Ljava/lang/String;", "", "PICK_IMAGE_REQUEST", "I", "TAG", "UID", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.homepage.create.AdelieCreationFragment$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull Intent intent) {
            Activity activity;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            String mainSource = ap.a(intent).getMainSource();
            AdelieFragmentActivity.INSTANCE.a(context, intent, AdelieCreationFragment.class);
            if (Intrinsics.areEqual(mainSource, "main_tab")) {
                if (context instanceof Activity) {
                    activity = (Activity) context;
                } else {
                    activity = null;
                }
                if (activity != null) {
                    activity.overridePendingTransition(R.anim.f155068vk, R.anim.f155078vu);
                }
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f366099a;

        static {
            int[] iArr = new int[AiGenBotInfoOperationType.values().length];
            try {
                iArr[AiGenBotInfoOperationType.KPOLISHPROMPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AiGenBotInfoOperationType.KPOLISHWELCOMEMSG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AiGenBotInfoOperationType.KPOLISHDESC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AiGenBotInfoOperationType.KGENINFOBYBOTINFO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AiGenBotInfoOperationType.KBYBOTNAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AiGenBotInfoOperationType.KAVATARBYTEMPLATE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f366099a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/robot/adelie/homepage/create/AdelieCreationFragment$c", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieEditTextView$b;", "Lcom/tencent/robot/adelie/homepage/create/view/AdelieEditTextView;", "view", "Landroid/text/Editable;", "editable", "", "a", "", "hasFocus", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements AdelieEditTextView.b {
        c() {
        }

        @Override // com.tencent.robot.adelie.homepage.create.view.AdelieEditTextView.b
        public void a(@Nullable AdelieEditTextView view, @Nullable Editable editable) {
            CharSequence trim;
            trim = StringsKt__StringsKt.trim((CharSequence) String.valueOf(editable));
            String obj = trim.toString();
            if (Intrinsics.areEqual(view, AdelieCreationFragment.this.getOpenMarkView())) {
                AdelieCreationFragment.this.Lh().B2(obj);
            } else if (Intrinsics.areEqual(view, AdelieCreationFragment.this.getSettingView())) {
                AdelieCreationFragment.this.Lh().z2(obj);
            } else if (Intrinsics.areEqual(view, AdelieCreationFragment.this.getDescView())) {
                AdelieCreationFragment.this.Lh().w2(obj);
            }
            AdelieCreationFragment.this.zk();
            Integer num = AdelieCreationFragment.this.currentKeyboardHeightInPx;
            if (num != null) {
                AdelieCreationFragment adelieCreationFragment = AdelieCreationFragment.this;
                adelieCreationFragment.Yi(num.intValue());
                adelieCreationFragment.nk();
            }
        }

        @Override // com.tencent.robot.adelie.homepage.create.view.AdelieEditTextView.b
        public void b(@Nullable AdelieEditTextView view, boolean hasFocus) {
            if (hasFocus) {
                AdelieCreationFragment.this.rk(view);
            }
            if (hasFocus) {
                ak akVar = AdelieCreationFragment.this.keyboardStateHelper;
                boolean z16 = false;
                if (akVar != null && akVar.getIsSoftKeyboardOpened()) {
                    z16 = true;
                }
                if (z16) {
                    AdelieCreationFragment.this.nk();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/adelie/homepage/create/AdelieCreationFragment$e", "Lcom/tencent/robot/adelie/homepage/utils/b$a;", "Landroid/content/Context;", "context", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class e implements b.a {
        e() {
        }

        @Override // com.tencent.robot.adelie.homepage.utils.b.a
        public void a(@Nullable Context context) {
            AdelieCreationFragment.this.Mh(context);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/robot/adelie/homepage/create/AdelieCreationFragment$f", "Lcom/tencent/robot/adelie/homepage/create/view/v;", "", "enable", "", "a", "", "visibility", "b", "Landroid/view/ViewGroup;", "getRootView", "getContentView", "Landroid/view/View;", "getTitleBarView", "c", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class f implements com.tencent.robot.adelie.homepage.create.view.v {
        f() {
        }

        @Override // com.tencent.robot.adelie.homepage.create.view.v
        public void a(boolean enable) {
            AdelieScrollView adelieScrollView = AdelieCreationFragment.this.scrollView;
            if (adelieScrollView != null) {
                adelieScrollView.setScrollable(enable);
            }
        }

        @Override // com.tencent.robot.adelie.homepage.create.view.v
        public void b(int visibility) {
            LinearLayout privacyContainer;
            QUIButton creationButton = AdelieCreationFragment.this.getCreationButton();
            if (creationButton != null) {
                creationButton.setVisibility(visibility);
            }
            View buttomBar = AdelieCreationFragment.this.getButtomBar();
            if (buttomBar != null) {
                buttomBar.setVisibility(visibility);
            }
            if (ae.f366120a.d() && (privacyContainer = AdelieCreationFragment.this.getPrivacyContainer()) != null) {
                privacyContainer.setVisibility(visibility);
            }
        }

        @Override // com.tencent.robot.adelie.homepage.create.view.v
        @Nullable
        public View c() {
            return AdelieCreationFragment.this.getTopSettingContainerView();
        }

        @Override // com.tencent.robot.adelie.homepage.create.view.v
        @Nullable
        public View d() {
            return AdelieCreationFragment.this.getBottomSettingContainerView();
        }

        @Override // com.tencent.robot.adelie.homepage.create.view.v
        @Nullable
        public ViewGroup getContentView() {
            View view = ((QIphoneTitleBarFragment) AdelieCreationFragment.this).mContentView;
            if (view instanceof RelativeLayout) {
                return (RelativeLayout) view;
            }
            return null;
        }

        @Override // com.tencent.robot.adelie.homepage.create.view.v
        @Nullable
        public ViewGroup getRootView() {
            return AdelieCreationFragment.this.titleRoot;
        }

        @Override // com.tencent.robot.adelie.homepage.create.view.v
        @Nullable
        public View getTitleBarView() {
            return AdelieCreationFragment.this.quiSecNavBar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/adelie/homepage/create/AdelieCreationFragment$g", "Lcom/tencent/robot/adelie/homepage/create/view/u;", "", "newState", "", "onChange", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class g implements com.tencent.robot.adelie.homepage.create.view.u {
        g() {
        }

        @Override // com.tencent.robot.adelie.homepage.create.view.u
        public void onChange(int newState) {
            if (newState == 2) {
                AdelieScrollView adelieScrollView = AdelieCreationFragment.this.scrollView;
                if (adelieScrollView != null) {
                    adelieScrollView.setScrollable(false);
                }
                AdeliePolarLightBkgView Ih = AdelieCreationFragment.this.Ih();
                if (Ih != null) {
                    Ih.setMaskVisibility(0);
                }
                View contentContainerView = AdelieCreationFragment.this.getContentContainerView();
                if (contentContainerView != null) {
                    contentContainerView.setBackgroundResource(0);
                    return;
                }
                return;
            }
            AdelieScrollView adelieScrollView2 = AdelieCreationFragment.this.scrollView;
            if (adelieScrollView2 != null) {
                adelieScrollView2.setScrollable(true);
            }
            AdeliePolarLightBkgView Ih2 = AdelieCreationFragment.this.Ih();
            if (Ih2 != null) {
                Ih2.setMaskVisibility(8);
            }
            View contentContainerView2 = AdelieCreationFragment.this.getContentContainerView();
            if (contentContainerView2 != null) {
                contentContainerView2.setBackgroundResource(R.drawable.j3m);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/adelie/homepage/create/AdelieCreationFragment$h", "Lcom/tencent/robot/api/a;", "", "isSuccess", "Lcom/tencent/robot/api/RouteFailedReason;", "failedReason", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class h implements com.tencent.robot.api.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference<AdelieCreationFragment> f366105a;

        h(WeakReference<AdelieCreationFragment> weakReference) {
            this.f366105a = weakReference;
        }

        @Override // com.tencent.robot.api.a
        public void a(boolean isSuccess, @NotNull RouteFailedReason failedReason) {
            FragmentActivity activity;
            Intrinsics.checkNotNullParameter(failedReason, "failedReason");
            AdelieCreationFragment adelieCreationFragment = this.f366105a.get();
            if (adelieCreationFragment != null && (activity = adelieCreationFragment.getActivity()) != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/robot/adelie/homepage/create/AdelieCreationFragment$i", "Lcom/tencent/robot/adelie/homepage/create/ak$b;", "", "keyboardHeightInPx", "", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "a", "height", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class i implements ak.b {
        i() {
        }

        @Override // com.tencent.robot.adelie.homepage.create.ak.b
        public void a(int keyboardHeightInPx) {
            AdelieCreationFragment.this.Yi(keyboardHeightInPx);
            AdelieSettingEditView settingView = AdelieCreationFragment.this.getSettingView();
            if (settingView != null) {
                settingView.a(keyboardHeightInPx);
            }
        }

        @Override // com.tencent.robot.adelie.homepage.create.ak.b
        public void b(int height) {
            AdelieSettingEditView settingView = AdelieCreationFragment.this.getSettingView();
            if (settingView != null) {
                settingView.b(height);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
        
            if (r0.getIsScrollable() == true) goto L12;
         */
        @Override // com.tencent.robot.adelie.homepage.create.ak.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onSoftKeyboardClosed() {
            boolean z16;
            AdelieScrollView adelieScrollView;
            View view = AdelieCreationFragment.this.placeholderView;
            if (view != null) {
                view.setVisibility(8);
            }
            AdelieScrollView adelieScrollView2 = AdelieCreationFragment.this.scrollView;
            if (adelieScrollView2 != null) {
                z16 = true;
            }
            z16 = false;
            if (z16 && (adelieScrollView = AdelieCreationFragment.this.scrollView) != null) {
                adelieScrollView.smoothScrollTo(0, AdelieCreationFragment.this.currentScrollY);
            }
            AdelieSettingEditView settingView = AdelieCreationFragment.this.getSettingView();
            if (settingView != null) {
                settingView.onSoftKeyboardClosed();
            }
        }

        @Override // com.tencent.robot.adelie.homepage.create.ak.b
        public void onSoftKeyboardOpened(int keyboardHeightInPx) {
            int i3;
            ScrollView scrollView;
            AdelieCreationFragment adelieCreationFragment = AdelieCreationFragment.this;
            View view = ((QIphoneTitleBarFragment) adelieCreationFragment).mContentView;
            if (view != null && (scrollView = (ScrollView) view.findViewById(R.id.iig)) != null) {
                i3 = scrollView.getScrollY();
            } else {
                i3 = 0;
            }
            adelieCreationFragment.currentScrollY = i3;
            View view2 = AdelieCreationFragment.this.placeholderView;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            AdelieCreationFragment.this.Yi(keyboardHeightInPx);
            AdelieCreationFragment.this.nk();
            AdelieSettingEditView settingView = AdelieCreationFragment.this.getSettingView();
            if (settingView != null) {
                settingView.onSoftKeyboardOpened(keyboardHeightInPx);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/robot/adelie/homepage/create/AdelieCreationFragment$k", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class k implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f366108d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AdelieCreationFragment f366109e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f366110f;

        k(String str, AdelieCreationFragment adelieCreationFragment, long j3) {
            this.f366108d = str;
            this.f366109e = adelieCreationFragment;
            this.f366110f = j3;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable drawable) {
            QLog.i("AdelieCreationFragment", 1, "showPic onLoadCanceled, url=" + this.f366108d);
            AdelieUtils.f365929a.a0(String.valueOf(this.f366109e.getPageType()), -2, "", this.f366110f);
            AdelieHeadIconView Dh = this.f366109e.Dh();
            if (Dh != null) {
                Dh.i(false);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable cause) {
            String str;
            String str2 = this.f366108d;
            String str3 = null;
            if (cause != null) {
                str = cause.toString();
            } else {
                str = null;
            }
            QLog.e("AdelieCreationFragment", 1, "showPic onLoadFailed, url=" + str2 + ", msg=" + str);
            AdelieUtils adelieUtils = AdelieUtils.f365929a;
            String valueOf = String.valueOf(this.f366109e.getPageType());
            if (cause != null) {
                str3 = cause.toString();
            }
            adelieUtils.a0(valueOf, -1, str3, this.f366110f);
            AdelieHeadIconView Dh = this.f366109e.Dh();
            if (Dh != null) {
                Dh.i(false);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
            AdelieHeadIconView Dh = this.f366109e.Dh();
            if (Dh != null) {
                Dh.i(false);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable drawable) {
            QLog.i("AdelieCreationFragment", 1, "showPic onLoadSuccesses url=" + this.f366108d);
            AdelieUtils.f365929a.a0(String.valueOf(this.f366109e.getPageType()), 0, "", this.f366110f);
            AdelieHeadIconView Dh = this.f366109e.Dh();
            if (Dh != null) {
                Dh.i(false);
            }
            this.f366109e.sk(true);
            this.f366109e.zk();
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.tencent.robot.adelie.homepage.create.AdelieCreationFragment$ttsSelectResultBroadcastReceiver$1] */
    public AdelieCreationFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CreateTextLimitNumber>() { // from class: com.tencent.robot.adelie.homepage.create.AdelieCreationFragment$textLimitNumber$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CreateTextLimitNumber invoke() {
                return RobotQQMC.INSTANCE.getAdelieCreateTextLimitNumber();
            }
        });
        this.textLimitNumber = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new AdelieCreationFragment$botInfoObserver$2(this));
        this.botInfoObserver = lazy2;
        this.nickNameWatcher = new j();
        this.editTextViewListener = new c();
        this.ttsSelectResultBroadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.robot.adelie.homepage.create.AdelieCreationFragment$ttsSelectResultBroadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                String str;
                String stringExtra;
                Object obj = null;
                if (intent != null) {
                    str = intent.getStringExtra(AdMetricTag.EVENT_NAME);
                } else {
                    str = null;
                }
                QLog.i("AdelieCreationFragment", 1, "ttsSelectResultBroadcastReceiver onReceive " + str);
                if (Intrinsics.areEqual(str, "adelie_tts_select_result")) {
                    if (intent != null && (stringExtra = intent.getStringExtra("data")) != null) {
                        p.Companion companion = com.tencent.robot.adelie.kuikly.module.p.INSTANCE;
                        try {
                            obj = new Gson().fromJson(stringExtra, (Class<Object>) AdelieTtsSelectResult.class);
                        } catch (Exception e16) {
                            QLog.e("AdelieModuleData", 1, "AdelieModuleData fromJson exception = " + e16);
                        }
                        AdelieTtsSelectResult adelieTtsSelectResult = (AdelieTtsSelectResult) obj;
                        if (adelieTtsSelectResult == null) {
                            return;
                        }
                        QLog.i("AdelieCreationFragment", 1, "ttsId = " + adelieTtsSelectResult.getTtsId());
                        TextView ttsNameView = AdelieCreationFragment.this.getTtsNameView();
                        if (ttsNameView != null) {
                            ttsNameView.setText(adelieTtsSelectResult.getTtsName());
                        }
                        AdelieCreationFragment.this.Lh().A2(adelieTtsSelectResult.getTtsId(), adelieTtsSelectResult.getTtsName());
                        AdelieCreationFragment.this.zk();
                        AdelieCreationFragment.this.tk(adelieTtsSelectResult);
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual(str, "adelie_prompt_conversation_edit")) {
                    AdelieCreationFragment.this.ck(intent.getStringExtra("data"));
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ck(WeakReference<AdelieCreationFragment> weakFragment, int errCode, String errMsg, AiGenBotInfoOperationType type) {
        AdelieCreationFragment adelieCreationFragment = weakFragment.get();
        if (adelieCreationFragment != null) {
            if (errCode != 0) {
                adelieCreationFragment.ci(errCode, errMsg);
                AdelieEditTextView adelieEditTextView = adelieCreationFragment.openMarkView;
                if (adelieEditTextView != null) {
                    adelieEditTextView.J();
                }
                AdelieEditTextView adelieEditTextView2 = adelieCreationFragment.descView;
                if (adelieEditTextView2 != null) {
                    adelieEditTextView2.J();
                }
                AdelieSettingEditView adelieSettingEditView = adelieCreationFragment.settingView;
                if (adelieSettingEditView != null) {
                    adelieSettingEditView.J();
                }
                AdelieHeadIconView Dh = adelieCreationFragment.Dh();
                if (Dh != null) {
                    Dh.i(false);
                }
            }
            int i3 = b.f366099a[type.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        AdelieEditTextView adelieEditTextView3 = adelieCreationFragment.openMarkView;
                        if (adelieEditTextView3 != null) {
                            adelieEditTextView3.setAIGenerateState(false);
                        }
                        AdelieEditTextView adelieEditTextView4 = adelieCreationFragment.descView;
                        if (adelieEditTextView4 != null) {
                            adelieEditTextView4.setAIGenerateState(false);
                        }
                        AdelieSettingEditView adelieSettingEditView2 = adelieCreationFragment.settingView;
                        if (adelieSettingEditView2 != null) {
                            adelieSettingEditView2.setAIGenerateState(false);
                        }
                    } else {
                        AdelieEditTextView adelieEditTextView5 = adelieCreationFragment.descView;
                        if (adelieEditTextView5 != null) {
                            adelieEditTextView5.setAIGenerateState(false);
                        }
                    }
                } else {
                    AdelieEditTextView adelieEditTextView6 = adelieCreationFragment.openMarkView;
                    if (adelieEditTextView6 != null) {
                        adelieEditTextView6.setAIGenerateState(false);
                    }
                }
            } else {
                AdelieSettingEditView adelieSettingEditView3 = adelieCreationFragment.settingView;
                if (adelieSettingEditView3 != null) {
                    adelieSettingEditView3.setAIGenerateState(false);
                }
            }
            adelieCreationFragment.Ek(true);
            adelieCreationFragment.Yh(true);
            ImageView imageView = adelieCreationFragment.magicIcon;
            if (imageView != null) {
                imageView.setEnabled(true);
            }
        }
    }

    private final void Dk(AiGenBotInfoOperationType type) {
        String str;
        boolean z16;
        String str2;
        boolean z17;
        boolean z18;
        AdelieHeadIconView Dh;
        AdelieSettingEditView adelieSettingEditView;
        String y16;
        AdelieEditTextView adelieEditTextView;
        AdelieEditTextView adelieEditTextView2;
        ImageView imageView = this.magicIcon;
        if (imageView != null) {
            imageView.setEnabled(false);
        }
        Ij();
        switch (b.f366099a[type.ordinal()]) {
            case 1:
                AdelieSettingEditView adelieSettingEditView2 = this.settingView;
                if (adelieSettingEditView2 != null) {
                    adelieSettingEditView2.setAIGenerateState(true);
                    break;
                }
                break;
            case 2:
                AdelieEditTextView adelieEditTextView3 = this.openMarkView;
                if (adelieEditTextView3 != null) {
                    adelieEditTextView3.setAIGenerateState(true);
                    break;
                }
                break;
            case 3:
                AdelieEditTextView adelieEditTextView4 = this.descView;
                if (adelieEditTextView4 != null) {
                    adelieEditTextView4.setAIGenerateState(true);
                    break;
                }
                break;
            case 4:
            case 5:
            case 6:
                AdelieEditTextView adelieEditTextView5 = this.openMarkView;
                String str3 = "";
                if (adelieEditTextView5 == null || (str = adelieEditTextView5.y()) == null) {
                    str = "";
                }
                if (str.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && (adelieEditTextView2 = this.openMarkView) != null) {
                    adelieEditTextView2.setAIGenerateState(true);
                }
                AdelieEditTextView adelieEditTextView6 = this.descView;
                if (adelieEditTextView6 == null || (str2 = adelieEditTextView6.y()) == null) {
                    str2 = "";
                }
                if (str2.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17 && (adelieEditTextView = this.descView) != null) {
                    adelieEditTextView.setAIGenerateState(true);
                }
                AdelieSettingEditView adelieSettingEditView3 = this.settingView;
                if (adelieSettingEditView3 != null && (y16 = adelieSettingEditView3.y()) != null) {
                    str3 = y16;
                }
                if (str3.length() == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18 && (adelieSettingEditView = this.settingView) != null) {
                    adelieSettingEditView.setAIGenerateState(true);
                }
                if (!this.isPickImage && (Dh = Dh()) != null) {
                    Dh.i(true);
                    break;
                }
                break;
        }
        Yh(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CreateTextLimitNumber Fj() {
        return (CreateTextLimitNumber) this.textLimitNumber.getValue();
    }

    private final void Ij() {
        AdelieEditTextView adelieEditTextView = this.currentEditTextView;
        if (adelieEditTextView != null) {
            if (adelieEditTextView != null) {
                adelieEditTextView.post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        AdelieCreationFragment.Jj(AdelieCreationFragment.this);
                    }
                });
            }
        } else {
            InterceptTouchEditText interceptTouchEditText = this.nicknameEditText;
            if (interceptTouchEditText != null) {
                interceptTouchEditText.r();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jj(AdelieCreationFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdelieEditTextView adelieEditTextView = this$0.currentEditTextView;
        if (adelieEditTextView != null) {
            adelieEditTextView.D();
        }
    }

    private final void Kj() {
        String str;
        if (je0.a.a(BaseApplication.getContext())) {
            str = "#14181F";
        } else {
            str = "#CFEAFF";
        }
        int parseColor = Color.parseColor(str);
        View view = this.buttomBar;
        if (view != null) {
            view.setBackgroundColor(parseColor);
        }
    }

    private final void Lj() {
        View g16;
        View h16;
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            VideoReport.setPageId(view, "pg_bas_agent_custom_edit");
            VideoReport.setPageReportPolicy(view, PageReportPolicy.REPORT_NONE);
            VideoReport.setPageParams(view, new PageParams((Map<String, ?>) Aj()));
            QUIButton qUIButton = this.creationButton;
            if (qUIButton != null) {
                Nh(qUIButton, "em_bas_finish");
            }
            com.tencent.biz.qui.quisecnavbar.a Gh = Gh();
            if (Gh != null && (h16 = this.quiSecNavBar.h(Gh)) != null) {
                Nh(h16, "em_interact_tag_portal_moreaction");
                VideoReport.reportEvent("imp", h16, null);
            }
            QUISecNavBar qUISecNavBar = this.quiSecNavBar;
            if (qUISecNavBar != null && (g16 = qUISecNavBar.g(BaseAction.ACTION_LEFT_BUTTON)) != null) {
                Nh(g16, "em_bas_cancel");
                VideoReport.reportEvent("imp", g16, null);
            }
            AdelieHeadIconView Dh = Dh();
            if (Dh != null) {
                com.tencent.robot.adelie.homepage.utils.h.b(com.tencent.robot.adelie.homepage.utils.h.f366661a, Dh, "em_bas_customized_image", null, null, null, null, null, 124, null);
                VideoReport.reportEvent("imp", Dh, Dh.e());
            }
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.twg);
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "this");
            Nh(relativeLayout, "em_bas_select_tone");
            VideoReport.reportEvent("imp", relativeLayout, null);
        }
    }

    private final void Mj() {
        LiveData<MyBotInfo> h26 = Lh().h2();
        this.botInfoLiveData = h26;
        if (h26 != null) {
            h26.observe(getLifecycleOwner(), nj());
        }
        com.tencent.robot.adelie.homepage.utils.b.f366646a.b(new e());
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void Nj() {
        AdelieSettingEditView adelieSettingEditView = this.settingView;
        if (adelieSettingEditView != null) {
            adelieSettingEditView.setScrollController(new f());
        }
        AdelieSettingEditView adelieSettingEditView2 = this.settingView;
        if (adelieSettingEditView2 != null) {
            adelieSettingEditView2.setOnEditStateChangeListener(new g());
        }
    }

    private final void Oj() {
        RelativeLayout relativeLayout;
        TextView textView;
        Context context;
        ViewStub viewStub;
        if (!RobotQQMC.INSTANCE.enablePromptConversation()) {
            QLog.w("AdelieCreationFragment", 1, "promptConversation disable");
            return;
        }
        if (this.promptConversationContainer != null) {
            QLog.w("AdelieCreationFragment", 1, "promptConversation has inflated");
            return;
        }
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null && (viewStub = (ViewStub) view.findViewById(R.id.u95)) != null) {
            viewStub.inflate();
        }
        View view2 = ((QIphoneTitleBarFragment) this).mContentView;
        if (view2 != null) {
            relativeLayout = (RelativeLayout) view2.findViewById(R.id.f164910u91);
        } else {
            relativeLayout = null;
        }
        this.promptConversationContainer = relativeLayout;
        View view3 = ((QIphoneTitleBarFragment) this).mContentView;
        if (view3 != null) {
            textView = (TextView) view3.findViewById(R.id.f164914u93);
        } else {
            textView = null;
        }
        this.promptConversationName = textView;
        RelativeLayout relativeLayout2 = this.promptConversationContainer;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    AdelieCreationFragment.Pj(AdelieCreationFragment.this, view4);
                }
            });
        }
        if (getPageType() == 1 && (context = getContext()) != null) {
            RelativeLayout relativeLayout3 = this.promptConversationContainer;
            if (relativeLayout3 != null) {
                relativeLayout3.setClickable(true);
            }
            TextView textView2 = this.promptConversationName;
            if (textView2 != null) {
                textView2.setTextColor(context.getColor(R.color.qui_common_text_primary));
            }
        }
        RelativeLayout relativeLayout4 = this.promptConversationContainer;
        if (relativeLayout4 != null) {
            Nh(relativeLayout4, "em_bas_conversational_style");
            VideoReport.reportEvent("imp", relativeLayout4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pj(AdelieCreationFragment this$0, View view) {
        Context it;
        int i3;
        ArrayList<RobotPromptConversation> robotPromptConversationList;
        UGCConversationSetting uGCConversationSetting;
        UGCConversationSetting uGCConversationSetting2;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u64.g.f438512a.g() && (it = this$0.getContext()) != null) {
            Bundle bundle = new Bundle();
            bundle.putString("page_name", "adelie_prompt_conversation");
            bundle.putString(KuiklyLaunchParams.PARAM_LOCAL_BUNDLE_NAME, "nearbypro");
            bundle.putString(KuiklyLaunchParams.PARAM_USE_HOST_DISPLAY_METRICS, "1");
            bundle.putString("version", "1");
            bundle.putString(ISchemeApi.KEY_IOS_SRC_TYPE, "web");
            bundle.putBoolean(MiniGamePAHippyBaseFragment.KEY_THEME, je0.a.a(BaseApplication.getContext()));
            bundle.putString(KuiklyLaunchParams.PARAM_CUSTOM_BACK_PRESSED, "1");
            JSONObject jSONObject = new JSONObject();
            UgcSettingInfo value = this$0.Lh().i2().getValue();
            int i16 = 0;
            if (value != null && (uGCConversationSetting2 = value.conversation) != null) {
                i3 = uGCConversationSetting2.maxRound;
            } else {
                i3 = 0;
            }
            UgcSettingInfo value2 = this$0.Lh().i2().getValue();
            if (value2 != null && (uGCConversationSetting = value2.conversation) != null) {
                i16 = uGCConversationSetting.maxWord;
            }
            if (i3 <= 0) {
                i3 = 10;
            }
            if (i16 <= 0) {
                i16 = 100;
            }
            jSONObject.put("pageUuid", this$0.getPageUuid());
            jSONObject.put("maxRound", i3);
            jSONObject.put("maxWord", i16);
            JSONArray jSONArray = new JSONArray();
            MyBotInfo value3 = this$0.Lh().h2().getValue();
            if (value3 != null && (robotPromptConversationList = value3.robotPromptConversationList) != null) {
                Intrinsics.checkNotNullExpressionValue(robotPromptConversationList, "robotPromptConversationList");
                for (RobotPromptConversation robotPromptConversation : robotPromptConversationList) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("question", robotPromptConversation.question);
                    jSONObject2.put("answer", robotPromptConversation.answer);
                    jSONArray.mo162put(jSONObject2);
                }
            }
            Unit unit = Unit.INSTANCE;
            jSONObject.put("contentList", jSONArray);
            bundle.putString("conversation", jSONObject.toString());
            IQQKuiklyRouter iQQKuiklyRouter = (IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            iQQKuiklyRouter.launchKuiklyPage(it, bundle);
            VideoReport.reportEvent("clck", this$0.promptConversationContainer, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qj(AdelieSettingEditView adelieSettingEditView, AdelieCreationFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        adelieSettingEditView.setRootViewHeight(this$0.titleRoot.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rj(TextView textView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.robot.adelie.homepage.utils.n nVar = com.tencent.robot.adelie.homepage.utils.n.f366680a;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        nVar.f(context, ae.f366120a.b());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sj(AdelieCreationFragment this$0, RelativeLayout relativeLayout, View view) {
        MyBotInfo myBotInfo;
        LiveData<MyBotInfo> h26;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdelieCreateOrEditPageViewModel Lh = this$0.Lh();
        if (Lh == null || (h26 = Lh.h2()) == null || (myBotInfo = h26.getValue()) == null) {
            myBotInfo = new MyBotInfo();
        }
        ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(relativeLayout.getContext(), com.tencent.robot.adelie.homepage.utils.n.f366680a.c(myBotInfo));
        VideoReport.reportEvent("clck", relativeLayout, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Tj(AdelieCreationFragment this$0, Switch r56, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.enableActivity = z16;
        this$0.Lh().s2(this$0.activityId, this$0.activityName, this$0.enableActivity);
        this$0.Lh().q2();
        this$0.zk();
        VideoReport.reportEvent("clck", r56, this$0.lj());
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void Ui(int holderHeight, int barHeight, int buttonBottom) {
        ViewGroup.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        ViewGroup.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        Object obj;
        View view = this.placeHolderStay;
        RelativeLayout.LayoutParams layoutParams5 = null;
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        } else {
            layoutParams2 = null;
        }
        if (layoutParams2 != null) {
            layoutParams2.height = c24.a.a(holderHeight);
        }
        View view2 = this.buttomBar;
        if (view2 != null) {
            layoutParams3 = view2.getLayoutParams();
        } else {
            layoutParams3 = null;
        }
        if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
            layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        } else {
            layoutParams4 = null;
        }
        if (layoutParams4 != null) {
            layoutParams4.height = c24.a.a(barHeight);
        }
        QUIButton qUIButton = this.creationButton;
        if (qUIButton != null) {
            obj = qUIButton.getLayoutParams();
        } else {
            obj = null;
        }
        if (obj instanceof RelativeLayout.LayoutParams) {
            layoutParams5 = (RelativeLayout.LayoutParams) obj;
        }
        if (layoutParams5 != null) {
            layoutParams5.bottomMargin = c24.a.a(buttonBottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Uj(View view, MotionEvent motionEvent) {
        return true;
    }

    private final void Vi(boolean isHintEmpty) {
        Object obj;
        ViewGroup.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        Object obj2;
        Object obj3;
        RelativeLayout.LayoutParams layoutParams3 = null;
        if (!ae.f366120a.d()) {
            LinearLayout linearLayout = this.privacyContainer;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            Ui(168, 120, 59);
            if (!isHintEmpty) {
                TextView textView = this.recyclerHint;
                if (textView != null) {
                    obj3 = textView.getLayoutParams();
                } else {
                    obj3 = null;
                }
                if (obj3 instanceof RelativeLayout.LayoutParams) {
                    layoutParams3 = (RelativeLayout.LayoutParams) obj3;
                }
                if (layoutParams3 != null) {
                    layoutParams3.bottomMargin = c24.a.a(30);
                    return;
                }
                return;
            }
            TextView textView2 = this.recyclerHint;
            if (textView2 != null) {
                textView2.setVisibility(8);
                return;
            }
            return;
        }
        if (!isHintEmpty) {
            Ui(197, 149, 88);
            LinearLayout linearLayout2 = this.privacyContainer;
            if (linearLayout2 != null) {
                layoutParams = linearLayout2.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            } else {
                layoutParams2 = null;
            }
            if (layoutParams2 != null) {
                layoutParams2.bottomMargin = c24.a.a(59);
            }
            TextView textView3 = this.recyclerHint;
            if (textView3 != null) {
                obj2 = textView3.getLayoutParams();
            } else {
                obj2 = null;
            }
            if (obj2 instanceof RelativeLayout.LayoutParams) {
                layoutParams3 = (RelativeLayout.LayoutParams) obj2;
            }
            if (layoutParams3 != null) {
                layoutParams3.bottomMargin = c24.a.a(30);
                return;
            }
            return;
        }
        Ui(168, 120, 59);
        LinearLayout linearLayout3 = this.privacyContainer;
        if (linearLayout3 != null) {
            obj = linearLayout3.getLayoutParams();
        } else {
            obj = null;
        }
        if (obj instanceof RelativeLayout.LayoutParams) {
            layoutParams3 = (RelativeLayout.LayoutParams) obj;
        }
        if (layoutParams3 != null) {
            layoutParams3.bottomMargin = c24.a.a(30);
        }
        TextView textView4 = this.recyclerHint;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.trim(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wi(final AiGenBotInfoOperationType type) {
        String str;
        boolean z16;
        CharSequence trim;
        final WeakReference weakReference = new WeakReference(this);
        InterceptTouchEditText interceptTouchEditText = this.nicknameEditText;
        if (interceptTouchEditText == null || (r1 = interceptTouchEditText.getText()) == null || trim == null || (str = trim.toString()) == null) {
            str = "";
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && type == AiGenBotInfoOperationType.KGENINFOBYBOTINFO) {
            QQToastUtil.showQQToastInUiThread(0, "\u8bf7\u586b\u5199\u540d\u79f0");
        } else {
            Dk(type);
            Lh().o2(type, new Function2<Integer, String, Unit>() { // from class: com.tencent.robot.adelie.homepage.create.AdelieCreationFragment$aiGenerateByBotInfo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2) {
                    invoke(num.intValue(), str2);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @NotNull String errMsg) {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    AdelieCreationFragment.this.Ck(weakReference, i3, errMsg, type);
                    AdelieCreationFragment.this.hk(i3, errMsg);
                    if (type == AiGenBotInfoOperationType.KGENINFOBYBOTINFO && !AdelieCreationFragment.this.getIsPickImage() && i3 == 0) {
                        AdelieCreationFragment.this.jk();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wj(WeakReference<AdelieCreationFragment> weakFragment, MyBotInfo botInfo) {
        FragmentActivity activity;
        Bundle bundle = new Bundle();
        bundle.putString("key_from", "AdelieCreate");
        bundle.putBoolean("key_ignore_pre_scale_chat", true);
        AdelieCreationFragment adelieCreationFragment = weakFragment.get();
        if (adelieCreationFragment != null && (activity = adelieCreationFragment.getActivity()) != null) {
            ((IRobotAIORouteApi) QRoute.api(IRobotAIORouteApi.class)).fetchAndRouteToRobotAIO(new RobotAIORouteArgs(activity, String.valueOf(botInfo.uin), null, "27", null, false, null, null, new h(weakFragment), 240, null));
        }
    }

    private final void Xj() {
        AdelieScrollView adelieScrollView;
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            adelieScrollView = (AdelieScrollView) view.findViewById(R.id.iig);
        } else {
            adelieScrollView = null;
        }
        this.scrollView = adelieScrollView;
        View rootView = requireActivity().getWindow().getDecorView().getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "requireActivity().window.decorView.rootView");
        ak akVar = new ak(rootView);
        this.keyboardStateHelper = akVar;
        akVar.f(new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yi(int keyboardHeight) {
        AdelieSettingEditView adelieSettingEditView;
        AdelieEditTextView adelieEditTextView;
        this.currentKeyboardHeightInPx = Integer.valueOf(keyboardHeight);
        AdelieEditTextView adelieEditTextView2 = this.openMarkView;
        if (adelieEditTextView2 == null || (adelieSettingEditView = this.settingView) == null || (adelieEditTextView = this.descView) == null) {
            return;
        }
        int[] iArr = new int[2];
        adelieEditTextView2.getLocationOnScreen(iArr);
        int height = iArr[1] + adelieEditTextView2.getHeight() + ViewUtils.dpToPx(16.0f);
        adelieSettingEditView.getLocationOnScreen(iArr);
        int height2 = iArr[1] + adelieSettingEditView.getHeight() + ViewUtils.dpToPx(16.0f);
        adelieEditTextView.getLocationOnScreen(iArr);
        int height3 = iArr[1] + adelieEditTextView.getHeight() + ViewUtils.dpToPx(16.0f);
        int i3 = ScreenUtil.SCREEN_HIGHT - keyboardHeight;
        this.openMarkPosition = height - i3;
        this.settingPosition = height2 - i3;
        this.descPosition = height3 - i3;
    }

    private final boolean Zi(String nickname, String setting, String desc, String openRemark) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        String str;
        String str2;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToastInUiThread(1, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5");
            return false;
        }
        if (nickname.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (setting.length() == 0) {
                z27 = true;
            } else {
                z27 = false;
            }
            if (!z27 && this.isPickImage) {
                if (desc.length() == 0) {
                    z28 = true;
                } else {
                    z28 = false;
                }
                if (!z28) {
                    if (openRemark.length() == 0) {
                        z29 = true;
                    } else {
                        z29 = false;
                    }
                    if (!z29) {
                        if (ae.f366120a.d()) {
                            QUICheckBox qUICheckBox = this.checkBox;
                            if (qUICheckBox != null && !qUICheckBox.isChecked()) {
                                z36 = true;
                            } else {
                                z36 = false;
                            }
                            if (z36) {
                                QLog.i("AdelieCreationFragment", 1, "privacy checked false");
                                uk(this.privacyContainer);
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        if (nickname.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            arrayList.add("\u540d\u79f0");
        }
        if (setting.length() == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            arrayList.add("\u8bbe\u5b9a");
        }
        if (desc.length() == 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            arrayList.add("\u4e2a\u6027\u7b7e\u540d");
        }
        if (openRemark.length() == 0) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (z26) {
            arrayList.add("\u5f00\u573a\u767d");
        }
        int size = arrayList.size();
        boolean z37 = this.isPickImage;
        if (!z37) {
            size++;
        }
        if (size == 1) {
            if (!z37) {
                str2 = "\u8bf7\u5b9a\u5236\u5f62\u8c61";
            } else {
                str2 = "\u8bf7\u586b\u5199" + arrayList.get(0);
            }
        } else {
            if (size == 2) {
                str = "";
            } else {
                str = "\u7b49";
            }
            if (!z37) {
                str2 = "\u8bf7\u5b9a\u5236\u5f62\u8c61\u3001\u586b\u5199" + arrayList.get(0) + str;
            } else {
                str2 = "\u8bf7\u586b\u5199" + arrayList.get(0) + "\u3001" + arrayList.get(1) + str;
            }
        }
        QQToastUtil.showQQToastInUiThread(0, str2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zj(AdelieCreationFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            dialogInterface.dismiss();
            activity.finish();
            View view = new View(activity);
            this$0.Nh(view, "em_bas_definite_exit");
            VideoReport.reportEvent("clck", view, null);
        }
    }

    private final void aj() {
        if (getPageType() == 2) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this);
        Lh().f2().observe(getLifecycleOwner(), new Observer() { // from class: com.tencent.robot.adelie.homepage.create.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AdelieCreationFragment.bj(AdelieCreationFragment.this, weakReference, (String) obj);
            }
        });
        Lh().Z1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ak(AdelieCreationFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            dialogInterface.dismiss();
            View view = new View(activity);
            this$0.Nh(view, "em_bas_continue_create");
            VideoReport.reportEvent("clck", view, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bj(AdelieCreationFragment this$0, final WeakReference weakFragment, String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(weakFragment, "$weakFragment");
        if (str == null) {
            str = "";
        }
        String str2 = str;
        if (str2.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this$0.getContext(), 230, (String) null, str2, (String) null, "\u6211\u77e5\u9053\u4e86", new DialogInterface.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AdelieCreationFragment.cj(WeakReference.this, dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026    }, null\n            )");
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void cj(WeakReference weakFragment, DialogInterface dialogInterface, int i3) {
        FragmentActivity requireActivity;
        Intrinsics.checkNotNullParameter(weakFragment, "$weakFragment");
        dialogInterface.dismiss();
        AdelieCreationFragment adelieCreationFragment = (AdelieCreationFragment) weakFragment.get();
        if (adelieCreationFragment != null && (requireActivity = adelieCreationFragment.requireActivity()) != null) {
            requireActivity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ck(String data) {
        String str;
        QLog.i("AdelieCreationFragment", 1, "receiveConversation data=" + data);
        if (data == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(data);
        String optString = jSONObject.optString("pageUuid", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("contentList");
        if (Intrinsics.areEqual(optString, getPageUuid()) && optJSONArray != null) {
            ArrayList<RobotPromptConversation> arrayList = new ArrayList<>();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                RobotPromptConversation robotPromptConversation = new RobotPromptConversation();
                robotPromptConversation.question = jSONObject2.optString("question", "");
                robotPromptConversation.answer = jSONObject2.optString("answer", "");
                arrayList.add(robotPromptConversation);
            }
            Lh().v2(arrayList);
            zk();
            TextView textView = this.promptConversationName;
            if (textView != null) {
                if (!arrayList.isEmpty()) {
                    str = "\u5df2\u8bbe\u5b9a";
                } else {
                    str = "\u65e0";
                }
                textView.setText(str);
            }
        }
    }

    private final void dj(View view, String setting, String openRemark, String nickname) {
        int i3;
        String str;
        boolean z16;
        String str2;
        Map mapOf;
        ArrayList<RobotPromptConversation> arrayList;
        BotGender currentGender;
        Pair[] pairArr = new Pair[8];
        boolean z17 = false;
        pairArr[0] = TuplesKt.to(QCircleDaTongConstant.ElementParamValue.SETTINGS, setting);
        pairArr[1] = TuplesKt.to("opening_remarks", openRemark);
        pairArr[2] = TuplesKt.to("nickname", nickname);
        AdelieGenderPickerView adelieGenderPickerView = this.genderView;
        if (adelieGenderPickerView != null && (currentGender = adelieGenderPickerView.getCurrentGender()) != null) {
            i3 = currentGender.ordinal();
        } else {
            i3 = 0;
        }
        pairArr[3] = TuplesKt.to("gender", Integer.valueOf(i3));
        MyBotInfo value = Lh().h2().getValue();
        if (value != null) {
            str = value.ttsId;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        pairArr[4] = TuplesKt.to("timbre_id", str);
        MyBotInfo value2 = Lh().h2().getValue();
        if (value2 != null && (arrayList = value2.robotPromptConversationList) != null && arrayList.isEmpty()) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str3 = "0";
        if (z16) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        pairArr[5] = TuplesKt.to("conversational_style", str2);
        String str4 = this.activityId;
        if (str4.length() == 0) {
            z17 = true;
        }
        if (!z17) {
            str3 = str4;
        }
        pairArr[6] = TuplesKt.to("activity_id", str3);
        pairArr[7] = TuplesKt.to("timbre_type", Integer.valueOf(this.ttsSelectResult.getTtsType()));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        VideoReport.reportEvent("clck", view, mapOf);
    }

    private final void dk() {
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            view.post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.l
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieCreationFragment.ek(AdelieCreationFragment.this);
                }
            });
        }
    }

    private final Drawable ej() {
        int i3;
        GradientDrawable gradientDrawable = new GradientDrawable();
        Context context = getContext();
        if (context != null) {
            i3 = CommonExKt.l(context.getColor(R.color.qui_common_fill_light_primary), 0.5f);
        } else {
            i3 = -1;
        }
        gradientDrawable.setColor(i3);
        gradientDrawable.setCornerRadius(c24.a.a(4));
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ek(AdelieCreationFragment this$0) {
        RelativeLayout relativeLayout;
        TextView textView;
        TextView textView2;
        ImageView imageView;
        ImageView imageView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            View view = ((QIphoneTitleBarFragment) this$0).mContentView;
            if (view != null && (textView6 = (TextView) view.findViewById(R.id.f5e)) != null) {
                textView6.setTextColor(context.getColor(R.color.qui_common_text_primary));
            }
            InterceptTouchEditText interceptTouchEditText = this$0.nicknameEditText;
            if (interceptTouchEditText != null) {
                interceptTouchEditText.setBackground(this$0.ej());
            }
            InterceptTouchEditText interceptTouchEditText2 = this$0.nicknameEditText;
            if (interceptTouchEditText2 != null) {
                interceptTouchEditText2.setHintTextColor(context.getColor(R.color.qui_common_text_tertiary));
            }
            InterceptTouchEditText interceptTouchEditText3 = this$0.nicknameEditText;
            if (interceptTouchEditText3 != null) {
                interceptTouchEditText3.setTextColor(context.getColor(R.color.qui_common_text_primary));
            }
            RelativeLayout relativeLayout2 = this$0.activityLayout;
            if (relativeLayout2 != null) {
                relativeLayout2.setBackground(this$0.ej());
            }
            TextView textView7 = this$0.activityTipsView;
            if (textView7 != null) {
                textView7.setTextColor(context.getColor(R.color.qui_common_text_secondary));
            }
            TextView textView8 = this$0.activityNameView;
            if (textView8 != null) {
                textView8.setTextColor(context.getColor(R.color.qui_common_text_primary));
            }
            View view2 = ((QIphoneTitleBarFragment) this$0).mContentView;
            if (view2 != null && (textView5 = (TextView) view2.findViewById(R.id.uvq)) != null) {
                textView5.setTextColor(context.getColor(R.color.qui_common_text_primary));
            }
            View view3 = ((QIphoneTitleBarFragment) this$0).mContentView;
            if (view3 != null && (textView4 = (TextView) view3.findViewById(R.id.f1200178e)) != null) {
                textView4.setTextColor(context.getColor(R.color.qui_common_text_primary));
            }
            View view4 = ((QIphoneTitleBarFragment) this$0).mContentView;
            if (view4 != null) {
                relativeLayout = (RelativeLayout) view4.findViewById(R.id.twg);
            } else {
                relativeLayout = null;
            }
            if (relativeLayout != null) {
                relativeLayout.setBackground(this$0.ej());
            }
            View view5 = ((QIphoneTitleBarFragment) this$0).mContentView;
            if (view5 != null && (textView3 = (TextView) view5.findViewById(R.id.u96)) != null) {
                textView3.setTextColor(context.getColor(R.color.qui_common_text_primary));
            }
            RelativeLayout relativeLayout3 = this$0.promptConversationContainer;
            if (relativeLayout3 != null) {
                relativeLayout3.setBackground(this$0.ej());
            }
            TextView textView9 = this$0.ttsNameView;
            if (textView9 != null) {
                textView9.setTextColor(context.getColor(R.color.qui_common_text_primary));
            }
            Drawable o16 = ie0.a.f().o(context, R.drawable.qui_chevron_right, R.color.qui_common_icon_secondary, 1000);
            View view6 = ((QIphoneTitleBarFragment) this$0).mContentView;
            if (view6 != null && (imageView2 = (ImageView) view6.findViewById(R.id.f1042162p)) != null) {
                imageView2.setImageDrawable(o16);
            }
            View view7 = ((QIphoneTitleBarFragment) this$0).mContentView;
            if (view7 != null && (imageView = (ImageView) view7.findViewById(R.id.f164909u90)) != null) {
                imageView.setImageDrawable(o16);
            }
            if (ae.f366120a.d()) {
                View view8 = ((QIphoneTitleBarFragment) this$0).mContentView;
                if (view8 != null && (textView2 = (TextView) view8.findViewById(R.id.sfc)) != null) {
                    textView2.setTextColor(context.getColor(R.color.qui_common_text_secondary));
                }
                View view9 = ((QIphoneTitleBarFragment) this$0).mContentView;
                if (view9 != null && (textView = (TextView) view9.findViewById(R.id.f27670gv)) != null) {
                    textView.setTextColor(context.getColor(R.color.qui_common_text_link));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fj(AdelieCreationFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ij();
    }

    private final void fk() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.ecommerce.broadcast.hr.notify");
            MobileQQ.sMobileQQ.registerReceiver(this.ttsSelectResultBroadcastReceiver, intentFilter);
        } catch (Exception e16) {
            QLog.e("AdelieCreationFragment", 1, "registerKuiklyBroadcast registerReceiver fail.", e16);
        }
    }

    private final void gj(View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AdelieCreationFragment.hj(AdelieCreationFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gk(long startTime, long endTime, int errCode, String errMsg) {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("cost_time", String.valueOf(endTime - startTime)), TuplesKt.to("error_code", String.valueOf(errCode)), TuplesKt.to("error_msg", errMsg), TuplesKt.to("upload_cost_time", String.valueOf(Lh().getUploadCostTime())), TuplesKt.to(IQQLiveUtil.UPLOAD_ERROR_CODE, String.valueOf(Lh().getUploadErrorCode())), TuplesKt.to("upload_scene", String.valueOf(getPageType())));
        com.tencent.robot.adelie.homepage.utils.d.c(null, "adelie_completed", mapOf, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void hj(AdelieCreationFragment this$0, View it) {
        Editable text;
        CharSequence trim;
        String obj;
        String str;
        String str2;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String y16;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u64.g.f438512a.g()) {
            boolean z26 = true;
            if (!NetworkUtil.isNetworkAvailable()) {
                QQToastUtil.showQQToastInUiThread(1, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5");
            } else {
                InterceptTouchEditText interceptTouchEditText = this$0.nicknameEditText;
                if (interceptTouchEditText != null && (text = interceptTouchEditText.getText()) != null) {
                    Intrinsics.checkNotNullExpressionValue(text, "text");
                    trim = StringsKt__StringsKt.trim(text);
                    if (trim != null && (obj = trim.toString()) != null) {
                        AdelieSettingEditView adelieSettingEditView = this$0.settingView;
                        String str3 = "";
                        if (adelieSettingEditView == null || (str = adelieSettingEditView.y()) == null) {
                            str = "";
                        }
                        AdelieEditTextView adelieEditTextView = this$0.openMarkView;
                        if (adelieEditTextView == null || (str2 = adelieEditTextView.y()) == null) {
                            str2 = "";
                        }
                        AdelieEditTextView adelieEditTextView2 = this$0.descView;
                        if (adelieEditTextView2 != null && (y16 = adelieEditTextView2.y()) != null) {
                            str3 = y16;
                        }
                        if (obj.length() > 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            if (str.length() > 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                                if (str2.length() > 0) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                if (z18) {
                                    if (str3.length() > 0) {
                                        z19 = true;
                                    } else {
                                        z19 = false;
                                    }
                                    if (z19 && this$0.isPickImage) {
                                        QQToastUtil.showQQToastInUiThread(1, "\u5df2\u586b\u5199\u6240\u6709\u5fc5\u586b\u5b57\u6bb5");
                                        if (obj.length() <= 0) {
                                            z26 = false;
                                        }
                                        if (z26) {
                                            Intrinsics.checkNotNullExpressionValue(it, "it");
                                            this$0.Nh(it, "em_bas_intelligent_filling");
                                            VideoReport.reportEvent("clck", it, this$0.wj());
                                        }
                                    }
                                }
                            }
                        }
                        this$0.Wi(AiGenBotInfoOperationType.KGENINFOBYBOTINFO);
                        if (obj.length() <= 0) {
                        }
                        if (z26) {
                        }
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hk(int errCode, String errMsg) {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("cost_time", String.valueOf(System.currentTimeMillis() - this.genStartTime)), TuplesKt.to("error_code", String.valueOf(errCode)), TuplesKt.to("error_msg", errMsg));
        com.tencent.robot.adelie.homepage.utils.d.c(null, "adelie_auto_fill_text", mapOf, 1, null);
    }

    private final void ij() {
        Lh().i2().observe(getLifecycleOwner(), new Observer() { // from class: com.tencent.robot.adelie.homepage.create.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AdelieCreationFragment.jj(AdelieCreationFragment.this, (UgcSettingInfo) obj);
            }
        });
        Lh().c2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ik(int errCode) {
        Map mapOf;
        Pair[] pairArr = new Pair[3];
        int i3 = 0;
        pairArr[0] = TuplesKt.to("image_source", Integer.valueOf(getImageResource()));
        int i16 = 1;
        if (errCode == 0) {
            i3 = 1;
        }
        pairArr[1] = TuplesKt.to("create_result", Integer.valueOf(i3));
        if (zj() != ChangeMyBotOperationType.KCREATE) {
            i16 = 2;
        }
        pairArr[2] = TuplesKt.to("pub_kind", Integer.valueOf(i16));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        VideoReport.reportEvent("ev_bas_agent_image_created", mapOf);
    }

    private final void initView() {
        QUICheckBox qUICheckBox;
        LinearLayout linearLayout;
        TextView textView;
        View view;
        View view2;
        View view3;
        ViewGroup.LayoutParams layoutParams;
        View view4 = ((QIphoneTitleBarFragment) this).mContentView;
        String str = null;
        if (view4 != null) {
            qUICheckBox = (QUICheckBox) view4.findViewById(R.id.f27580gm);
        } else {
            qUICheckBox = null;
        }
        this.checkBox = qUICheckBox;
        View view5 = ((QIphoneTitleBarFragment) this).mContentView;
        if (view5 != null) {
            linearLayout = (LinearLayout) view5.findViewById(R.id.f27590gn);
        } else {
            linearLayout = null;
        }
        this.privacyContainer = linearLayout;
        View view6 = ((QIphoneTitleBarFragment) this).mContentView;
        if (view6 != null) {
            textView = (TextView) view6.findViewById(R.id.f71883pc);
        } else {
            textView = null;
        }
        this.recyclerHint = textView;
        View view7 = ((QIphoneTitleBarFragment) this).mContentView;
        if (view7 != null) {
            view = view7.findViewById(R.id.t_4);
        } else {
            view = null;
        }
        this.buttomBar = view;
        View view8 = ((QIphoneTitleBarFragment) this).mContentView;
        if (view8 != null) {
            view2 = view8.findViewById(R.id.f25590b9);
        } else {
            view2 = null;
        }
        this.placeHolderStay = view2;
        View view9 = ((QIphoneTitleBarFragment) this).mContentView;
        if (view9 != null) {
            view3 = view9.findViewById(R.id.fuj);
        } else {
            view3 = null;
        }
        if (FontSettingManager.isFontSizeLarge()) {
            if (view3 != null) {
                try {
                    layoutParams = view3.getLayoutParams();
                } catch (Exception unused) {
                }
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.height = ViewUtils.dpToPx(200.0f);
            }
            if (view3 != null) {
                view3.setLayoutParams(layoutParams);
            }
        }
        this.placeholderView = view3;
        View view10 = this.buttomBar;
        if (view10 != null) {
            view10.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.robot.adelie.homepage.create.v
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view11, MotionEvent motionEvent) {
                    boolean Uj;
                    Uj = AdelieCreationFragment.Uj(view11, motionEvent);
                    return Uj;
                }
            });
        }
        View view11 = ((QIphoneTitleBarFragment) this).mContentView;
        if (view11 != null) {
            FontSettingManager.resetViewSize2Normal(getContext(), view11);
            Kj();
            QUIButton qUIButton = (QUIButton) view11.findViewById(R.id.ubb);
            this.creationButton = qUIButton;
            if (qUIButton != null) {
                qUIButton.setOnClickListener(rj());
            }
            AdelieEditTextView adelieEditTextView = (AdelieEditTextView) view11.findViewById(R.id.zz7);
            adelieEditTextView.p("\u5f00\u573a\u767d", "\u586b\u5199\u667a\u80fd\u4f53\u7684\u5f00\u573a\u767d\uff0c\u5f00\u573a\u767d\u4f5c\u4e3a\u667a\u80fd\u4f53\u53d1\u8d77\u7684\u7b2c\u4e00\u53e5\u8bdd\uff0c\u53ef\u5f15\u5bfc\u540e\u7eed\u5bf9\u8bdd\u5185\u5bb9\u7684\u53d1\u5c55\u3002", Fj().getWelcomeMsg(), TextCategory.WELCOME_MSG, new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.create.AdelieCreationFragment$initView$3$1$1
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
                    AdelieCreationFragment.this.Wi(AiGenBotInfoOperationType.KPOLISHWELCOMEMSG);
                }
            });
            adelieEditTextView.o(this.editTextViewListener);
            this.openMarkView = adelieEditTextView;
            AdelieEditTextView adelieEditTextView2 = (AdelieEditTextView) view11.findViewById(R.id.f85314om);
            adelieEditTextView2.p("\u4e2a\u6027\u7b7e\u540d", "\u586b\u5199\u667a\u80fd\u4f53\u7684\u4e2a\u6027\u7b7e\u540d\uff0c\u8be5\u4e2a\u6027\u7b7e\u540d\u4f1a\u663e\u793a\u5728\u667a\u80fd\u4f53\u7684\u540d\u5b57\u4e0b\u65b9\uff0c\u5e76\u4e0d\u4f1a\u5f71\u54cd\u5230\u5bf9\u8bdd\u8868\u73b0\u3002", Fj().getDesc(), TextCategory.DESC, new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.create.AdelieCreationFragment$initView$3$2$1
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
                    AdelieCreationFragment.this.Wi(AiGenBotInfoOperationType.KPOLISHDESC);
                }
            });
            adelieEditTextView2.o(this.editTextViewListener);
            this.descView = adelieEditTextView2;
            final AdelieSettingEditView adelieSettingEditView = (AdelieSettingEditView) view11.findViewById(R.id.f83694k9);
            String string = getString(R.string.zpa);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.creation_setting_input_hint)");
            adelieSettingEditView.p("\u8bbe\u5b9a", string, Fj().getPrompt(), TextCategory.PROMPT, new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.create.AdelieCreationFragment$initView$3$3$1
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
                    AdelieCreationFragment.this.Wi(AiGenBotInfoOperationType.KPOLISHPROMPT);
                }
            });
            adelieSettingEditView.o(this.editTextViewListener);
            adelieSettingEditView.post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.w
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieCreationFragment.Qj(AdelieSettingEditView.this, this);
                }
            });
            this.settingView = adelieSettingEditView;
            this.contentContainerView = view11.findViewById(R.id.b9t);
            this.topSettingContainerView = view11.findViewById(R.id.f100025rd);
            this.bottomSettingContainerView = view11.findViewById(R.id.tah);
            AdelieGenderPickerView adelieGenderPickerView = (AdelieGenderPickerView) view11.findViewById(R.id.vn8);
            adelieGenderPickerView.f(BotGender.KDEFAULT, new Function1<BotGender, Unit>() { // from class: com.tencent.robot.adelie.homepage.create.AdelieCreationFragment$initView$3$4$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(BotGender botGender) {
                    invoke2(botGender);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull BotGender gender) {
                    Intrinsics.checkNotNullParameter(gender, "gender");
                    AdelieCreationFragment.this.Lh().x2(gender);
                    AdelieCreationFragment.this.zk();
                }
            });
            this.genderView = adelieGenderPickerView;
            InterceptTouchEditText interceptTouchEditText = (InterceptTouchEditText) view11.findViewById(R.id.upo);
            this.nicknameEditText = interceptTouchEditText;
            if (interceptTouchEditText != null) {
                interceptTouchEditText.setInputViewWatcher(this.nickNameWatcher);
            }
            InterceptTouchEditText interceptTouchEditText2 = this.nicknameEditText;
            if (interceptTouchEditText2 != null) {
                interceptTouchEditText2.setFilters(new am[]{new am()});
            }
            InterceptTouchEditText interceptTouchEditText3 = this.nicknameEditText;
            if (interceptTouchEditText3 != null) {
                interceptTouchEditText3.setHint(Fj().getName() + " \u5b57\u4ee5\u5185");
            }
            final TextView textView2 = (TextView) view11.findViewById(R.id.f27670gv);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view12) {
                    AdelieCreationFragment.Rj(textView2, view12);
                }
            });
            final RelativeLayout relativeLayout = (RelativeLayout) view11.findViewById(R.id.twg);
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view12) {
                    AdelieCreationFragment.Sj(AdelieCreationFragment.this, relativeLayout, view12);
                }
            });
            this.ttsLayout = relativeLayout;
            TextView textView3 = (TextView) view11.findViewById(R.id.f1042962x);
            MyBotInfo value = Lh().h2().getValue();
            if (value != null) {
                str = value.ttsName;
            }
            textView3.setText(str);
            this.ttsNameView = textView3;
            this.activityLayout = (RelativeLayout) view11.findViewById(R.id.uvr);
            this.activityNameView = (TextView) view11.findViewById(R.id.sam);
            this.activityTipsView = (TextView) view11.findViewById(R.id.saq);
            final Switch r06 = (Switch) view11.findViewById(R.id.sap);
            r06.setChecked(this.enableActivity);
            r06.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.robot.adelie.homepage.create.z
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    AdelieCreationFragment.Tj(AdelieCreationFragment.this, r06, compoundButton, z16);
                }
            });
            this.activitySwitch = r06;
        }
        Oj();
        Xj();
        Nj();
        dk();
        aj();
        ij();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jj(AdelieCreationFragment this$0, UgcSettingInfo ugcSettingInfo) {
        CharSequence charSequence;
        boolean z16;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (ugcSettingInfo != null) {
            AdelieSettingEditView adelieSettingEditView = this$0.settingView;
            if (adelieSettingEditView != null) {
                ArrayList<PromptLabel> arrayList = ugcSettingInfo.promptLabelList;
                Intrinsics.checkNotNullExpressionValue(arrayList, "it.promptLabelList");
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((PromptLabel) it.next()).labelName);
                }
                adelieSettingEditView.setLabelList(arrayList2);
            }
            AdelieSettingEditView adelieSettingEditView2 = this$0.settingView;
            if (adelieSettingEditView2 != null) {
                adelieSettingEditView2.setMaxWordCount(ugcSettingInfo.promptMaxLength);
            }
            TextView textView = this$0.recyclerHint;
            if (textView != null) {
                textView.setText(ugcSettingInfo.recycle.recycleTips);
            }
            TextView textView2 = this$0.recyclerHint;
            if (textView2 != null) {
                charSequence = textView2.getText();
            } else {
                charSequence = null;
            }
            if (charSequence != null && charSequence.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            this$0.Vi(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void jk() {
        MyBotInfo value = Lh().h2().getValue();
        if (value == null) {
            return;
        }
        AdelieHeadIconView Dh = Dh();
        if (Dh != null) {
            Dh.i(true);
        }
        System.currentTimeMillis();
        AdelieUtils.f365929a.v(value, String.valueOf(getPageType()), "avatar_auto_fill", new IAiGenAvatarCallback() { // from class: com.tencent.robot.adelie.homepage.create.j
            @Override // com.tencent.qqnt.kernel.nativeinterface.IAiGenAvatarCallback
            public final void onResult(int i3, String str, AiAvatarInfo aiAvatarInfo) {
                AdelieCreationFragment.kk(AdelieCreationFragment.this, i3, str, aiAvatarInfo);
            }
        });
    }

    private final void kj(String nickName, final AiGenBotInfoOperationType genType, String templateId) {
        String str;
        AiGenBotInfoOperationType aiGenBotInfoOperationType = AiGenBotInfoOperationType.KBYBOTNAME;
        if (genType == aiGenBotInfoOperationType) {
            str = "avatar_auto_fill";
        } else {
            str = "avatar_template";
        }
        this.avatarGenSource = str;
        final WeakReference weakReference = new WeakReference(this);
        Lh().p2(nickName, genType, templateId, new Function2<Integer, String, Unit>() { // from class: com.tencent.robot.adelie.homepage.create.AdelieCreationFragment$generateTemplate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2) {
                invoke(num.intValue(), str2);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String errMsg) {
                long j3;
                Map mapOf;
                AdelieSettingEditView settingView;
                AdelieEditTextView descView;
                AdelieEditTextView openMarkView;
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                if (i3 != 0) {
                    AdelieCreationFragment adelieCreationFragment = weakReference.get();
                    if (adelieCreationFragment != null) {
                        adelieCreationFragment.ci(i3, errMsg);
                    }
                    AdelieCreationFragment adelieCreationFragment2 = weakReference.get();
                    if (adelieCreationFragment2 != null && (openMarkView = adelieCreationFragment2.getOpenMarkView()) != null) {
                        openMarkView.setAIGenerateState(false);
                    }
                    AdelieCreationFragment adelieCreationFragment3 = weakReference.get();
                    if (adelieCreationFragment3 != null && (descView = adelieCreationFragment3.getDescView()) != null) {
                        descView.setAIGenerateState(false);
                    }
                    AdelieCreationFragment adelieCreationFragment4 = weakReference.get();
                    if (adelieCreationFragment4 != null && (settingView = adelieCreationFragment4.getSettingView()) != null) {
                        settingView.setAIGenerateState(false);
                    }
                    AdelieCreationFragment adelieCreationFragment5 = weakReference.get();
                    if (adelieCreationFragment5 != null) {
                        adelieCreationFragment5.Ek(true);
                    }
                    if (genType == AiGenBotInfoOperationType.KAVATARBYTEMPLATE) {
                        AdelieCreationFragment adelieCreationFragment6 = weakReference.get();
                        InterceptTouchEditText nicknameEditText = adelieCreationFragment6 != null ? adelieCreationFragment6.getNicknameEditText() : null;
                        if (nicknameEditText != null) {
                            nicknameEditText.setHint("");
                        }
                        AdelieCreationFragment adelieCreationFragment7 = weakReference.get();
                        InterceptTouchEditText nicknameEditText2 = adelieCreationFragment7 != null ? adelieCreationFragment7.getNicknameEditText() : null;
                        if (nicknameEditText2 != null) {
                            nicknameEditText2.setEnabled(true);
                        }
                    }
                }
                this.Yh(true);
                long currentTimeMillis = System.currentTimeMillis();
                j3 = this.genStartTime;
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("cost_time", String.valueOf(currentTimeMillis - j3)), TuplesKt.to("error_code", String.valueOf(i3)), TuplesKt.to("error_msg", errMsg));
                com.tencent.robot.adelie.homepage.utils.d.c(null, genType == AiGenBotInfoOperationType.KBYBOTNAME ? "adelie_auto_fill_text" : "adelie_template_fill_text", mapOf, 1, null);
            }
        });
        if (genType == aiGenBotInfoOperationType && !this.isPickImage) {
            jk();
        }
        Ij();
        AdelieEditTextView adelieEditTextView = this.openMarkView;
        if (adelieEditTextView != null) {
            adelieEditTextView.setAIGenerateState(true);
        }
        AdelieEditTextView adelieEditTextView2 = this.descView;
        if (adelieEditTextView2 != null) {
            adelieEditTextView2.setAIGenerateState(true);
        }
        Yh(false);
        AdelieSettingEditView adelieSettingEditView = this.settingView;
        if (adelieSettingEditView != null) {
            adelieSettingEditView.setAIGenerateState(true);
        }
        Ek(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void kk(AdelieCreationFragment this$0, int i3, String str, AiAvatarInfo aiAvatarInfo) {
        Map mapOf;
        boolean z16;
        Object first;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("cost_time", String.valueOf(System.currentTimeMillis() - this$0.genStartTime)), TuplesKt.to("error_code", String.valueOf(i3)), TuplesKt.to("error_msg", str));
        ArrayList<AiGenPicInfo> arrayList = null;
        com.tencent.robot.adelie.homepage.utils.d.c(null, "adelie_auto_fill_text_and_avatar", mapOf, 1, null);
        if (this$0.getActivity() != null) {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null && activity.isFinishing()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (i3 != 0) {
                    if (i3 <= 10000) {
                        str = "\u5934\u50cf\u751f\u6210\u5931\u8d25";
                    }
                    QQToastUtil.showQQToastInUiThread(1, str);
                    this$0.lk(false);
                    return;
                }
                this$0.Xh(AdelieConstant.ImageSource.MAGIC_ICON_FILLED.getValue());
                if (aiAvatarInfo != null) {
                    arrayList = aiAvatarInfo.picInfoList;
                }
                if (arrayList == null) {
                    return;
                }
                if (!arrayList.isEmpty()) {
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                    AiGenPicInfo aiGenPicInfo = (AiGenPicInfo) first;
                    if (aiGenPicInfo == null) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    String str2 = aiGenPicInfo.url;
                    Intrinsics.checkNotNullExpressionValue(str2, "firstPicInfo.url");
                    this$0.mj(str2, new AdelieCreationFragment$requestAvatar$1$1(this$0, currentTimeMillis));
                    return;
                }
                QLog.w("AdelieCreationFragment", 1, "requestAvatar picInfoList is isEmpty");
                this$0.lk(false);
                return;
            }
        }
        QLog.w("AdelieCreationFragment", 1, "requestAvatar activity is finished");
    }

    private final Map<String, Object> lj() {
        Map<String, Object> mapOf;
        int i3 = 2;
        Pair[] pairArr = new Pair[2];
        if (this.enableActivity) {
            i3 = 1;
        }
        boolean z16 = false;
        pairArr[0] = TuplesKt.to("status", Integer.valueOf(i3));
        String str = this.activityId;
        if (str.length() == 0) {
            z16 = true;
        }
        if (z16) {
            str = "0";
        }
        pairArr[1] = TuplesKt.to("activity_id", str);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void lk(boolean success) {
        AdelieHeadIconView Dh = Dh();
        if (Dh != null) {
            Dh.i(false);
        }
        this.isPickImage = success;
        zk();
    }

    private final void mj(String url, Function1<? super Bitmap, Unit> onGetBitmap) {
        QLog.i("AdelieCreationFragment", 1, "getBitmapFromUrl url: " + url);
        if (TextUtils.isEmpty(url)) {
            return;
        }
        try {
            URLDrawable drawable = URLDrawable.getDrawable(url, URLDrawable.URLDrawableOptions.obtain());
            drawable.setURLDrawableListener(new d(onGetBitmap));
            if (drawable.getStatus() == 1) {
                onGetBitmap.invoke(BaseImageUtil.drawabletoBitmapV2(drawable, 100, 100));
            } else {
                drawable.startDownload();
            }
        } catch (Throwable th5) {
            onGetBitmap.invoke(null);
            QLog.e("AdelieCreationFragment", 1, "getBitmapFromUrl: " + th5);
        }
    }

    private final void mk() {
        String str;
        boolean z16;
        StartupParams startupParams = this.startupParams;
        if (startupParams == null || (str = startupParams.getTplInfo()) == null) {
            str = "";
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        AdelieHeadIconView Dh = Dh();
        if (Dh != null) {
            Dh.i(true);
        }
        kj("", AiGenBotInfoOperationType.KAVATARBYTEMPLATE, str);
    }

    private final Observer<MyBotInfo> nj() {
        return (Observer) this.botInfoObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void nk() {
        View view;
        final AdelieEditTextView adelieEditTextView = this.currentEditTextView;
        if (adelieEditTextView != null && (view = ((QIphoneTitleBarFragment) this).mContentView) != null) {
            view.post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.t
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieCreationFragment.ok(AdelieEditTextView.this, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ok(AdelieEditTextView editText, AdelieCreationFragment this$0) {
        int i3;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(editText, "$editText");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int[] iArr = new int[2];
        editText.getLocationOnScreen(iArr);
        boolean z16 = true;
        int height = iArr[1] + editText.getHeight() + ViewUtils.dpToPx(16.0f);
        ak akVar = this$0.keyboardStateHelper;
        if (akVar != null) {
            i3 = akVar.getLastSoftKeyboardHeightInPx();
        } else {
            i3 = 0;
        }
        if (height - (ScreenUtil.SCREEN_HIGHT - i3) > 0) {
            AdelieEditTextView adelieEditTextView = this$0.currentEditTextView;
            if (Intrinsics.areEqual(adelieEditTextView, this$0.openMarkView)) {
                i16 = this$0.openMarkPosition;
            } else if (Intrinsics.areEqual(adelieEditTextView, this$0.descView)) {
                i16 = this$0.descPosition;
            } else if (Intrinsics.areEqual(adelieEditTextView, this$0.settingView)) {
                i16 = this$0.settingPosition;
            } else {
                i16 = 0;
            }
            if (i16 > 0) {
                AdelieScrollView adelieScrollView = this$0.scrollView;
                if (adelieScrollView == null || !adelieScrollView.getIsScrollable()) {
                    z16 = false;
                }
                if (z16) {
                    AdelieScrollView adelieScrollView2 = this$0.scrollView;
                    if (adelieScrollView2 != null) {
                        i17 = adelieScrollView2.getScrollY();
                    } else {
                        i17 = 0;
                    }
                    AdelieScrollView adelieScrollView3 = this$0.scrollView;
                    if (adelieScrollView3 != null) {
                        adelieScrollView3.smoothScrollTo(0, i17 + i16);
                    }
                }
            }
        }
    }

    private final View.OnClickListener rj() {
        return new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdelieCreationFragment.sj(AdelieCreationFragment.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sj(AdelieCreationFragment this$0, View it) {
        String str;
        CharSequence trim;
        String str2;
        CharSequence trim2;
        String str3;
        CharSequence trim3;
        CharSequence trim4;
        String y16;
        Editable text;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u64.g.f438512a.g()) {
            InterceptTouchEditText interceptTouchEditText = this$0.nicknameEditText;
            String str4 = "";
            if (interceptTouchEditText == null || (text = interceptTouchEditText.getText()) == null || (str = text.toString()) == null) {
                str = "";
            }
            trim = StringsKt__StringsKt.trim((CharSequence) str);
            String obj = trim.toString();
            AdelieSettingEditView adelieSettingEditView = this$0.settingView;
            if (adelieSettingEditView == null || (str2 = adelieSettingEditView.y()) == null) {
                str2 = "";
            }
            trim2 = StringsKt__StringsKt.trim((CharSequence) str2);
            String obj2 = trim2.toString();
            AdelieEditTextView adelieEditTextView = this$0.descView;
            if (adelieEditTextView == null || (str3 = adelieEditTextView.y()) == null) {
                str3 = "";
            }
            trim3 = StringsKt__StringsKt.trim((CharSequence) str3);
            String obj3 = trim3.toString();
            AdelieEditTextView adelieEditTextView2 = this$0.openMarkView;
            if (adelieEditTextView2 != null && (y16 = adelieEditTextView2.y()) != null) {
                str4 = y16;
            }
            trim4 = StringsKt__StringsKt.trim((CharSequence) str4);
            String obj4 = trim4.toString();
            if (this$0.Zi(obj, obj2, obj3, obj4)) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this$0.dj(it, obj2, obj4, obj);
                this$0.Bk();
                this$0.wk();
            }
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final Map<String, Object> wj() {
        String str;
        String str2;
        Map<String, Object> mapOf;
        BotGender currentGender;
        Pair[] pairArr = new Pair[5];
        MyBotInfo value = Lh().h2().getValue();
        String str3 = null;
        if (value != null) {
            str = value.botPrompt;
        } else {
            str = null;
        }
        String str4 = "";
        if (str == null) {
            str = "";
        }
        int i3 = 0;
        pairArr[0] = TuplesKt.to(QCircleDaTongConstant.ElementParamValue.SETTINGS, str);
        MyBotInfo value2 = Lh().h2().getValue();
        if (value2 != null) {
            str2 = value2.botDesc;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        pairArr[1] = TuplesKt.to("personal_signature", str2);
        MyBotInfo value3 = Lh().h2().getValue();
        if (value3 != null) {
            str3 = value3.botWelcomeMsg;
        }
        if (str3 != null) {
            str4 = str3;
        }
        pairArr[2] = TuplesKt.to("opening_remarks", str4);
        AdelieGenderPickerView adelieGenderPickerView = this.genderView;
        if (adelieGenderPickerView != null && (currentGender = adelieGenderPickerView.getCurrentGender()) != null) {
            i3 = currentGender.ordinal();
        }
        pairArr[3] = TuplesKt.to("gender", Integer.valueOf(i3));
        pairArr[4] = TuplesKt.to("is_generate_image", Integer.valueOf(!this.isPickImage ? 1 : 0));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    private final void wk() {
        final WeakReference weakReference = new WeakReference(this);
        final long currentTimeMillis = System.currentTimeMillis();
        Lh().X1(zj(), new Function3<Integer, String, MyBotInfo, Unit>() { // from class: com.tencent.robot.adelie.homepage.create.AdelieCreationFragment$startCreation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, MyBotInfo myBotInfo) {
                invoke(num.intValue(), str, myBotInfo);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String errMsg, @NotNull MyBotInfo botInfo) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(botInfo, "botInfo");
                AdelieCreationFragment.this.gk(currentTimeMillis, System.currentTimeMillis(), i3, errMsg);
                AdelieCreationFragment.this.ik(i3);
                AdelieCreationFragment.this.Yj(i3, botInfo);
                AdelieCreationFragment.this.Ak(weakReference, i3, errMsg, botInfo);
            }
        });
    }

    private final void yk() {
        try {
            MobileQQ.sMobileQQ.unregisterReceiver(this.ttsSelectResultBroadcastReceiver);
        } catch (Exception e16) {
            QLog.e("AdelieCreationFragment", 1, "unRegisterKuiklyBroadcast registerReceiver fail.", e16);
        }
    }

    @Nullable
    public Map<String, Object> Aj() {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("page_model", Integer.valueOf(getPageType())));
        return mapOf;
    }

    public void Ak(@NotNull final WeakReference<AdelieCreationFragment> weakFragment, final int errCode, @NotNull final String errMsg, @NotNull final MyBotInfo botInfo) {
        Intrinsics.checkNotNullParameter(weakFragment, "weakFragment");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(botInfo, "botInfo");
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.create.AdelieCreationFragment$updateViewAfterCreation$1
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
                if (errCode == 0) {
                    ae.f366120a.c();
                    this.Wj(weakFragment, botInfo);
                    return;
                }
                AdelieCreationFragment adelieCreationFragment = weakFragment.get();
                if (adelieCreationFragment != null) {
                    adelieCreationFragment.ci(errCode, errMsg);
                }
                AdelieCreationFragment adelieCreationFragment2 = weakFragment.get();
                if (adelieCreationFragment2 != null) {
                    adelieCreationFragment2.xk();
                }
            }
        });
    }

    @Override // com.tencent.robot.adelie.homepage.create.AdelieBaseFragment
    @Nullable
    public View Bh() {
        Context context;
        if (!getAiGenerateConfig().b() || (context = getContext()) == null) {
            return null;
        }
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.f160057mi1);
        imageView.setId(R.id.yvz);
        gj(imageView);
        this.magicIcon = imageView;
        return imageView;
    }

    @Nullable
    /* renamed from: Bj, reason: from getter */
    protected final LinearLayout getPrivacyContainer() {
        return this.privacyContainer;
    }

    protected final void Bk() {
        QUIButton qUIButton = this.creationButton;
        if (qUIButton != null) {
            qUIButton.setText("\u667a\u80fd\u4f53\u751f\u6210\u4e2d");
        }
        QUIButton qUIButton2 = this.creationButton;
        if (qUIButton2 != null) {
            qUIButton2.setClickableWhenLoading(false);
        }
        QUIButton qUIButton3 = this.creationButton;
        if (qUIButton3 != null) {
            qUIButton3.r();
        }
        Switch r06 = this.activitySwitch;
        if (r06 != null) {
            r06.setEnabled(false);
        }
        ImageView imageView = this.magicIcon;
        if (imageView != null) {
            imageView.setEnabled(false);
        }
        Ek(false);
        Ij();
        Yh(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: Cj, reason: from getter */
    public final RelativeLayout getPromptConversationContainer() {
        return this.promptConversationContainer;
    }

    @Override // com.tencent.robot.adelie.homepage.create.AdelieBaseFragment
    @Nullable
    public AdelieHeadIconView Dh() {
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            return (AdelieHeadIconView) view.findViewById(R.id.x7y);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: Dj, reason: from getter */
    public final TextView getPromptConversationName() {
        return this.promptConversationName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: Ej, reason: from getter */
    public final AdelieSettingEditView getSettingView() {
        return this.settingView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Ek(boolean enable) {
        AdelieEditTextView adelieEditTextView = this.openMarkView;
        if (adelieEditTextView != null) {
            adelieEditTextView.setEditEnabled(enable);
        }
        AdelieEditTextView adelieEditTextView2 = this.descView;
        if (adelieEditTextView2 != null) {
            adelieEditTextView2.setEditEnabled(enable);
        }
        AdelieSettingEditView adelieSettingEditView = this.settingView;
        if (adelieSettingEditView != null) {
            adelieSettingEditView.setEditEnabled(enable);
        }
        InterceptTouchEditText interceptTouchEditText = this.nicknameEditText;
        if (interceptTouchEditText != null) {
            interceptTouchEditText.clearFocus();
        }
        InterceptTouchEditText interceptTouchEditText2 = this.nicknameEditText;
        if (interceptTouchEditText2 != null) {
            interceptTouchEditText2.setEnabled(enable);
        }
        RelativeLayout relativeLayout = this.ttsLayout;
        if (relativeLayout != null) {
            relativeLayout.setEnabled(enable);
        }
        AdelieGenderPickerView adelieGenderPickerView = this.genderView;
        if (adelieGenderPickerView != null) {
            adelieGenderPickerView.setEnabled(enable);
        }
    }

    @Nullable
    /* renamed from: Gj, reason: from getter */
    protected final View getTopSettingContainerView() {
        return this.topSettingContainerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: Hj, reason: from getter */
    public final TextView getTtsNameView() {
        return this.ttsNameView;
    }

    @Override // com.tencent.robot.adelie.homepage.create.AdelieBaseFragment
    @Nullable
    public AdeliePolarLightBkgView Ih() {
        AdeliePolarLightBkgView adeliePolarLightBkgView;
        if (this.bkgView == null) {
            Context context = getContext();
            if (context != null) {
                adeliePolarLightBkgView = new AdeliePolarLightBkgView(context, null, 0, 6, null);
            } else {
                adeliePolarLightBkgView = null;
            }
            this.bkgView = adeliePolarLightBkgView;
        }
        return this.bkgView;
    }

    @Override // com.tencent.robot.adelie.homepage.create.AdelieBaseFragment
    @NotNull
    public String Kh() {
        return "\u521b\u5efa\u667a\u80fd\u4f53";
    }

    @Override // com.tencent.robot.adelie.homepage.create.AdelieBaseFragment
    public void Oh(@Nullable String avatarPath, @Nullable String bgPath) {
        AdelieHeadIconView Dh;
        AdelieCreateOrEditPageViewModel Lh = Lh();
        if (Lh != null) {
            Lh.y2(avatarPath, bgPath);
        }
        this.isPickImage = true;
        zk();
        if (avatarPath != null && (Dh = Dh()) != null) {
            VideoReport.reportEvent("imp", Dh, Dh.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Vj, reason: from getter */
    public final boolean getIsPickImage() {
        return this.isPickImage;
    }

    public void Xi(@NotNull final MyBotInfo botInfo) {
        Intrinsics.checkNotNullParameter(botInfo, "botInfo");
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.create.AdelieCreationFragment$botInfoObserver$4
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

            /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x007a  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x0088  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x00ab  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x00c1  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                boolean z16;
                AdelieSettingEditView settingView;
                AdelieEditTextView descView;
                AdelieEditTextView openMarkView;
                String str;
                AdelieGenderPickerView genderView;
                TextView ttsNameView;
                long j3;
                String str2;
                InterceptTouchEditText nicknameEditText;
                String str3 = MyBotInfo.this.botName;
                boolean z17 = false;
                if (str3 != null) {
                    if (str3.length() > 0) {
                        z16 = true;
                        if (z16 && (nicknameEditText = this.getNicknameEditText()) != null) {
                            nicknameEditText.setText(Editable.Factory.getInstance().newEditable(MyBotInfo.this.botName));
                        }
                        settingView = this.getSettingView();
                        if (settingView != null) {
                            String str4 = MyBotInfo.this.botPrompt;
                            Intrinsics.checkNotNullExpressionValue(str4, "botInfo.botPrompt");
                            settingView.setEditText(str4);
                        }
                        descView = this.getDescView();
                        if (descView != null) {
                            String str5 = MyBotInfo.this.botDesc;
                            Intrinsics.checkNotNullExpressionValue(str5, "botInfo.botDesc");
                            descView.setEditText(str5);
                        }
                        openMarkView = this.getOpenMarkView();
                        if (openMarkView != null) {
                            String str6 = MyBotInfo.this.botWelcomeMsg;
                            Intrinsics.checkNotNullExpressionValue(str6, "botInfo.botWelcomeMsg");
                            openMarkView.setEditText(str6);
                        }
                        this.Ek(true);
                        str = MyBotInfo.this.botAvatar;
                        if (str != null) {
                            if (str.length() > 0) {
                                z17 = true;
                            }
                        }
                        if (z17) {
                            AdelieCreationFragment adelieCreationFragment = this;
                            String str7 = MyBotInfo.this.botAvatar;
                            Intrinsics.checkNotNullExpressionValue(str7, "botInfo.botAvatar");
                            j3 = this.genStartTime;
                            str2 = this.avatarGenSource;
                            adelieCreationFragment.vk(str7, j3, str2);
                        }
                        genderView = this.getGenderView();
                        if (genderView != null) {
                            BotGender botGender = MyBotInfo.this.botGender;
                            Intrinsics.checkNotNullExpressionValue(botGender, "botInfo.botGender");
                            genderView.m(botGender);
                        }
                        ttsNameView = this.getTtsNameView();
                        if (ttsNameView != null) {
                            ttsNameView.setText(MyBotInfo.this.ttsName);
                        }
                        this.zk();
                    }
                }
                z16 = false;
                if (z16) {
                    nicknameEditText.setText(Editable.Factory.getInstance().newEditable(MyBotInfo.this.botName));
                }
                settingView = this.getSettingView();
                if (settingView != null) {
                }
                descView = this.getDescView();
                if (descView != null) {
                }
                openMarkView = this.getOpenMarkView();
                if (openMarkView != null) {
                }
                this.Ek(true);
                str = MyBotInfo.this.botAvatar;
                if (str != null) {
                }
                if (z17) {
                }
                genderView = this.getGenderView();
                if (genderView != null) {
                }
                ttsNameView = this.getTtsNameView();
                if (ttsNameView != null) {
                }
                this.zk();
            }
        });
    }

    public void Yj(int errCode, @NotNull MyBotInfo botInfo) {
        Intrinsics.checkNotNullParameter(botInfo, "botInfo");
        if (errCode == 0) {
            com.tencent.robot.adelie.homepage.g.f366352a.a().postValue(new a24.i(ChangeMyBotOperationType.KCREATE, botInfo));
            Context context = getContext();
            if (context != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uid", botInfo.uid);
                Unit unit = Unit.INSTANCE;
                com.tencent.kuikly.core.render.android.expand.module.l.e(context, "adelie_create_robot", jSONObject);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bk() {
        boolean z16;
        boolean z17;
        boolean z18;
        if (this.activityId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (this.activityName.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                z17 = true;
                this.enableActivity = z17;
                if (!z17) {
                    TextView textView = this.activityNameView;
                    if (textView != null) {
                        textView.setText("#" + this.activityName);
                    }
                    TextView textView2 = this.activityTipsView;
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                    RelativeLayout relativeLayout = this.activityLayout;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(0);
                    }
                    Lh().s2(this.activityId, this.activityName, true);
                    Switch r06 = this.activitySwitch;
                    if (r06 != null) {
                        Nh(r06, "em_bas_unlabel");
                        return;
                    }
                    return;
                }
                TextView textView3 = this.activityTipsView;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                RelativeLayout relativeLayout2 = this.activityLayout;
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(8);
                    return;
                }
                return;
            }
        }
        z17 = false;
        this.enableActivity = z17;
        if (!z17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.robot.adelie.homepage.create.AdelieBaseFragment, com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        initView();
        Mj();
        Lj();
        mk();
        bk();
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            view.post(new Runnable() { // from class: com.tencent.robot.adelie.homepage.create.s
                @Override // java.lang.Runnable
                public final void run() {
                    AdelieCreationFragment.fj(AdelieCreationFragment.this);
                }
            });
        }
        fk();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int keyCode, @Nullable KeyEvent event) {
        if (keyCode == 4) {
            AdelieSettingEditView adelieSettingEditView = this.settingView;
            boolean z16 = false;
            if (adelieSettingEditView != null && adelieSettingEditView.v0()) {
                z16 = true;
            }
            if (z16) {
                return true;
            }
            super.doOnKeyDown(keyCode, event);
        }
        return super.doOnKeyDown(keyCode, event);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.drw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getPageType() {
        return 1;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean isAllowLandscape() {
        return false;
    }

    @Nullable
    /* renamed from: oj, reason: from getter */
    protected final View getBottomSettingContainerView() {
        return this.bottomSettingContainerView;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        View g16;
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (qUISecNavBar != null && (g16 = qUISecNavBar.g(BaseAction.ACTION_LEFT_BUTTON)) != null) {
            VideoReport.reportEvent("clck", g16, null);
        }
        if (Lh().getHasChanged()) {
            Context context = getContext();
            if (context != null) {
                View view = new View(context);
                Nh(view, "em_bas_double_confirm_window");
                VideoReport.reportEvent("imp", view, null);
            }
            DialogUtil.createNoTitleDialog(getActivity(), getString(R.string.zp8), R.string.zpc, R.string.zp7, new DialogInterface.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AdelieCreationFragment.Zj(AdelieCreationFragment.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.create.r
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AdelieCreationFragment.ak(AdelieCreationFragment.this, dialogInterface, i3);
                }
            }).show();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        String str;
        String str2;
        String activityName;
        super.onCreate(savedInstanceState);
        StartupParams a16 = ap.a(requireActivity().getIntent());
        this.startupParams = a16;
        String str3 = "";
        if (a16 == null || (str = a16.getMainSource()) == null) {
            str = "";
        }
        this.referer = str;
        StartupParams startupParams = this.startupParams;
        if (startupParams == null || (str2 = startupParams.getActivityId()) == null) {
            str2 = "";
        }
        this.activityId = str2;
        StartupParams startupParams2 = this.startupParams;
        if (startupParams2 != null && (activityName = startupParams2.getActivityName()) != null) {
            str3 = activityName;
        }
        this.activityName = str3;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.tencent.robot.adelie.homepage.utils.b.f366646a.c();
        AdeliePolarLightBkgView adeliePolarLightBkgView = this.bkgView;
        if (adeliePolarLightBkgView != null) {
            adeliePolarLightBkgView.b();
        }
        this.bkgView = null;
        AdelieEditTextView adelieEditTextView = this.openMarkView;
        if (adelieEditTextView != null) {
            adelieEditTextView.q();
        }
        AdelieEditTextView adelieEditTextView2 = this.descView;
        if (adelieEditTextView2 != null) {
            adelieEditTextView2.q();
        }
        AdelieSettingEditView adelieSettingEditView = this.settingView;
        if (adelieSettingEditView != null) {
            adelieSettingEditView.q();
        }
        yk();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        Activity activity;
        super.onFinish();
        if (Intrinsics.areEqual(this.referer, "main_tab")) {
            Context context = getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null) {
                activity.overridePendingTransition(R.anim.f155078vu, R.anim.f155069vl);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            VideoReport.reportPgOut(view);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            VideoReport.reportPgIn(view, false);
        }
        Switch r06 = this.activitySwitch;
        if (r06 != null) {
            VideoReport.reportEvent("imp", r06, lj());
        }
    }

    @Nullable
    /* renamed from: pj, reason: from getter */
    protected final View getButtomBar() {
        return this.buttomBar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void pk(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.activityId = str;
    }

    @Nullable
    /* renamed from: qj, reason: from getter */
    protected final View getContentContainerView() {
        return this.contentContainerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void qk(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.activityName = str;
    }

    protected final void rk(@Nullable AdelieEditTextView adelieEditTextView) {
        this.currentEditTextView = adelieEditTextView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void sk(boolean z16) {
        this.isPickImage = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: tj, reason: from getter */
    public final QUIButton getCreationButton() {
        return this.creationButton;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void tk(@NotNull AdelieTtsSelectResult adelieTtsSelectResult) {
        Intrinsics.checkNotNullParameter(adelieTtsSelectResult, "<set-?>");
        this.ttsSelectResult = adelieTtsSelectResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: uj, reason: from getter */
    public final AdelieEditTextView getDescView() {
        return this.descView;
    }

    protected final void uk(@Nullable View view) {
        Vibrator vibrator;
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f155059vh);
        if (view != null) {
            view.startAnimation(loadAnimation);
        }
        Context context = getContext();
        if (context != null) {
            Object systemService = context.getSystemService("vibrator");
            if (systemService instanceof Vibrator) {
                vibrator = (Vibrator) systemService;
            } else {
                vibrator = null;
            }
            if (vibrator != null) {
                vibrator.vibrate(50L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: vj, reason: from getter */
    public final AdelieGenderPickerView getGenderView() {
        return this.genderView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void vk(@NotNull String url, long generateStartTime, @NotNull String source) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(source, "source");
        long currentTimeMillis = System.currentTimeMillis();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable(url, obtain);
        if (drawable2.getStatus() == 1) {
            AdelieHeadIconView Dh = Dh();
            if (Dh != null) {
                Dh.i(false);
            }
            AdelieHeadIconView Dh2 = Dh();
            if (Dh2 != null) {
                Intrinsics.checkNotNullExpressionValue(drawable2, "drawable");
                Dh2.setDrawable(drawable2);
            }
            this.isPickImage = true;
            zk();
            return;
        }
        drawable2.setURLDrawableListener(new k(url, this, currentTimeMillis));
        drawable2.startDownload();
        AdelieHeadIconView Dh3 = Dh();
        if (Dh3 != null) {
            Intrinsics.checkNotNullExpressionValue(drawable2, "drawable");
            Dh3.setDrawable(drawable2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: xj, reason: from getter */
    public final InterceptTouchEditText getNicknameEditText() {
        return this.nicknameEditText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void xk() {
        QUIButton qUIButton = this.creationButton;
        if (qUIButton != null) {
            qUIButton.s();
        }
        QUIButton qUIButton2 = this.creationButton;
        if (qUIButton2 != null) {
            qUIButton2.setText("\u5b8c\u6210");
        }
        QUIButton qUIButton3 = this.creationButton;
        if (qUIButton3 != null) {
            qUIButton3.setEnabled(true);
        }
        Switch r06 = this.activitySwitch;
        if (r06 != null) {
            r06.setEnabled(true);
        }
        ImageView imageView = this.magicIcon;
        if (imageView != null) {
            imageView.setEnabled(true);
        }
        Ek(true);
        Yh(true);
    }

    @Override // com.tencent.robot.adelie.homepage.create.AdelieBaseFragment
    public void yh(@Nullable Context context) {
        BotGender botGender;
        String str;
        MyBotInfo value;
        if (context != null) {
            com.tencent.robot.adelie.homepage.ugc.ac acVar = com.tencent.robot.adelie.homepage.ugc.ac.f366521a;
            LiveData<MyBotInfo> liveData = this.botInfoLiveData;
            if (liveData != null && (value = liveData.getValue()) != null) {
                botGender = value.botGender;
            } else {
                botGender = null;
            }
            if (botGender == null) {
                botGender = BotGender.KDEFAULT;
            } else {
                Intrinsics.checkNotNullExpressionValue(botGender, "botInfoLiveData?.value?.\u2026der ?: BotGender.KDEFAULT");
            }
            AdelieSettingEditView adelieSettingEditView = this.settingView;
            if (adelieSettingEditView == null || (str = adelieSettingEditView.y()) == null) {
                str = "";
            }
            acVar.a(context, botGender, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: yj, reason: from getter */
    public final AdelieEditTextView getOpenMarkView() {
        return this.openMarkView;
    }

    @NotNull
    public ChangeMyBotOperationType zj() {
        return ChangeMyBotOperationType.KCREATE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.trim(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void zk() {
        String str;
        String str2;
        String str3;
        float f16;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String y16;
        CharSequence trim;
        InterceptTouchEditText interceptTouchEditText = this.nicknameEditText;
        String str4 = "";
        if (interceptTouchEditText == null || (r0 = interceptTouchEditText.getText()) == null || trim == null || (str = trim.toString()) == null) {
            str = "";
        }
        AdelieSettingEditView adelieSettingEditView = this.settingView;
        if (adelieSettingEditView == null || (str2 = adelieSettingEditView.y()) == null) {
            str2 = "";
        }
        AdelieEditTextView adelieEditTextView = this.openMarkView;
        if (adelieEditTextView == null || (str3 = adelieEditTextView.y()) == null) {
            str3 = "";
        }
        AdelieEditTextView adelieEditTextView2 = this.descView;
        if (adelieEditTextView2 != null && (y16 = adelieEditTextView2.y()) != null) {
            str4 = y16;
        }
        boolean z26 = false;
        if (this.isPickImage) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (str2.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    if (str3.length() > 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        if (str4.length() > 0) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (z19) {
                            z26 = true;
                        }
                    }
                }
            }
        }
        QUIButton qUIButton = this.creationButton;
        if (qUIButton != null) {
            if (z26) {
                f16 = 1.0f;
            } else {
                f16 = 0.3f;
            }
            qUIButton.setAlpha(f16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0012H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/robot/adelie/homepage/create/AdelieCreationFragment$j", "Lh53/q;", "", "title", "", "A4", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "", "hasFocus", "f8", "Landroid/text/Editable;", "afterTextChanged", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class j implements h53.q {
        j() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
        
            r4 = kotlin.text.StringsKt__StringsKt.trim(r4);
         */
        @Override // h53.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void afterTextChanged(@Nullable Editable s16) {
            String str;
            InterceptTouchEditText nicknameEditText;
            CharSequence trim;
            if (s16 == null) {
                return;
            }
            CharSequence h06 = AdelieUtils.f365929a.h0(s16, AdelieCreationFragment.this.Fj().getName());
            boolean z16 = false;
            if (h06 != s16) {
                s16.replace(0, s16.length(), h06);
                QQToast.makeText(AdelieCreationFragment.this.getContext(), 0, "\u5b57\u6570\u5df2\u8fbe\u5230\u4e0a\u9650", 0).show();
                return;
            }
            InterceptTouchEditText nicknameEditText2 = AdelieCreationFragment.this.getNicknameEditText();
            if (nicknameEditText2 == null || (r4 = nicknameEditText2.getText()) == null || trim == null || (str = trim.toString()) == null) {
                str = "";
            }
            AdelieCreationFragment.this.Lh().u2(str);
            if (str.length() == 0) {
                z16 = true;
            }
            if (z16 && (nicknameEditText = AdelieCreationFragment.this.getNicknameEditText()) != null) {
                nicknameEditText.setHint(AdelieCreationFragment.this.Fj().getName() + " \u5b57\u4ee5\u5185");
            }
            AdelieCreationFragment.this.zk();
        }

        @Override // h53.k
        public void f8(boolean hasFocus) {
            AdelieCreationFragment.this.rk(null);
        }

        @Override // h53.q
        public void A4(@Nullable String title) {
        }

        @Override // h53.k
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }

        @Override // h53.k
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/robot/adelie/homepage/create/AdelieCreationFragment$d", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Bitmap, Unit> f366101d;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super Bitmap, Unit> function1) {
            this.f366101d = function1;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable drawable) {
            this.f366101d.invoke(null);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable cause) {
            this.f366101d.invoke(null);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable drawable) {
            if (drawable != null) {
                this.f366101d.invoke(BaseImageUtil.drawabletoBitmapV2(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()));
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
        }
    }
}
