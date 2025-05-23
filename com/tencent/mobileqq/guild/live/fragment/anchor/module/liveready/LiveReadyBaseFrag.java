package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.impl.GuildDTReportApiImpl;
import com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag$mOnKeyboardUpListener$2;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.fragment.dialog.GuildLiveReadyTipsDialog;
import com.tencent.mobileqq.guild.live.helper.GuildTimeRecHelper;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.livemanager.anchor.GLiveRoomInfo;
import com.tencent.mobileqq.guild.performance.report.GuildLiveStartReportTask;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.guild.util.timerecord.GuildLiveTimeEvent;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.bl;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.cd;
import vh2.de;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 \u00c9\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u00ca\u0001B\t\u00a2\u0006\u0006\b\u00c7\u0001\u0010\u00c8\u0001J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0014J\u001a\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\u0006\u0010\u001e\u001a\u00020\u001dJ\u0018\u0010!\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rH\u0016J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0016J\u000e\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%J\u001e\u0010-\u001a\u00020,2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020(J\"\u00102\u001a\u00020\u00072\u0006\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\r2\n\b\u0002\u00101\u001a\u0004\u0018\u000100J\b\u00103\u001a\u00020(H\u0004J\u0010\u00104\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\rH\u0016J$\u00109\u001a\u00020\u00192\u0006\u00105\u001a\u00020\r2\b\u00107\u001a\u0004\u0018\u0001062\b\u00108\u001a\u0004\u0018\u00010(H\u0016J\u000e\u0010:\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\rJ$\u0010=\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010;\u001a\u00020\r2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010(J\u0010\u0010?\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\rH\u0004J\b\u0010@\u001a\u00020\u0019H\u0016J\u001a\u0010C\u001a\u00020\u00072\b\u0010A\u001a\u0004\u0018\u00010(2\u0006\u0010B\u001a\u00020(H\u0016J\u0010\u0010F\u001a\u00020\u00072\u0006\u0010E\u001a\u00020DH\u0016J\u0010\u0010H\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0019H\u0016J\b\u0010I\u001a\u00020\u0007H\u0016J\b\u0010J\u001a\u00020\u0007H\u0016J\u000e\u0010K\u001a\u00020\u00072\u0006\u0010+\u001a\u00020(J\u0012\u0010L\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010(H\u0004J\u0016\u0010N\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\rJ\u0010\u0010O\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0016R\u001b\u0010U\u001a\u00020P8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\"\u0010\\\u001a\u00020\u00058\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010d\u001a\u00020]8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010k\u001a\u00020%8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010s\u001a\u00020l8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\"\u0010w\u001a\u00020l8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bt\u0010n\u001a\u0004\bu\u0010p\"\u0004\bv\u0010rR\"\u0010{\u001a\u00020l8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bx\u0010n\u001a\u0004\by\u0010p\"\u0004\bz\u0010rR&\u0010\u0083\u0001\u001a\u00020|8\u0006@\u0006X\u0086.\u00a2\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R(\u0010\u0087\u0001\u001a\u00020|8\u0006@\u0006X\u0086.\u00a2\u0006\u0017\n\u0005\b\u0084\u0001\u0010~\u001a\u0006\b\u0085\u0001\u0010\u0080\u0001\"\u0006\b\u0086\u0001\u0010\u0082\u0001R*\u0010\u008f\u0001\u001a\u00030\u0088\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R&\u0010\u0093\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086.\u00a2\u0006\u0015\n\u0005\b\u0090\u0001\u0010W\u001a\u0005\b\u0091\u0001\u0010Y\"\u0005\b\u0092\u0001\u0010[R&\u0010\u0097\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086.\u00a2\u0006\u0015\n\u0005\b\u0094\u0001\u0010W\u001a\u0005\b\u0095\u0001\u0010Y\"\u0005\b\u0096\u0001\u0010[R#\u0010\u009d\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190\u0098\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R#\u0010\u00a0\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190\u0098\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u009e\u0001\u0010\u009a\u0001\u001a\u0006\b\u009f\u0001\u0010\u009c\u0001R)\u0010\u00a7\u0001\u001a\u00030\u00a1\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00a2\u0001\u0010e\u001a\u0006\b\u00a3\u0001\u0010\u00a4\u0001\"\u0006\b\u00a5\u0001\u0010\u00a6\u0001R)\u0010\u00ae\u0001\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a8\u0001\u0010\u00a9\u0001\u001a\u0006\b\u00aa\u0001\u0010\u00ab\u0001\"\u0006\b\u00ac\u0001\u0010\u00ad\u0001R \u0010\u00b3\u0001\u001a\u00030\u00af\u00018FX\u0086\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00b0\u0001\u0010R\u001a\u0006\b\u00b1\u0001\u0010\u00b2\u0001R)\u0010\u00ba\u0001\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b4\u0001\u0010\u00b5\u0001\u001a\u0006\b\u00b6\u0001\u0010\u00b7\u0001\"\u0006\b\u00b8\u0001\u0010\u00b9\u0001R,\u0010\u00c2\u0001\u001a\u0005\u0018\u00010\u00bb\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00bc\u0001\u0010\u00bd\u0001\u001a\u0006\b\u00be\u0001\u0010\u00bf\u0001\"\u0006\b\u00c0\u0001\u0010\u00c1\u0001R)\u0010\u00c6\u0001\u001a\u00020\u00198\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00c3\u0001\u0010\u00b5\u0001\u001a\u0006\b\u00c4\u0001\u0010\u00b7\u0001\"\u0006\b\u00c5\u0001\u0010\u00b9\u0001\u00a8\u0006\u00cb\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyBaseFrag;", "Lcom/tencent/mobileqq/guild/live/fragment/base/QQGuildLiveModuleBaseFragment;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/e;", "Lcom/tencent/mobileqq/guild/live/livemanager/h;", "Landroid/view/View;", "v", "", "wh", "vh", "initSubVideoBarHeight", "Bi", "wi", "", "getLayoutId", "view", "initView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, NodeProps.ON_CLICK, "Ai", "Wh", "di", "vi", "", "finishActivity", "Ci", "Qh", "Landroid/graphics/drawable/Drawable;", "Ph", "requestCode", QzoneIPCModule.RESULT_CODE, com.tencent.bugly.common.constants.Constants.USER_SET_DEVICE_ID, "Landroid/content/Intent;", "intent", "Sb", "Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText;", "editText", "Th", "", "clickStr", "showText", "h5Url", "Landroid/text/SpannableString;", "yh", "liveRoomID", "pushType", "Lcom/tencent/mobileqq/qqguildsdk/data/bl;", "programInfo", "Xh", "getGuildId", "Sh", "result", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "securityResult", "errMsg", "Rh", "ai", "errorCode", "errorMsg", "bi", "liveType", "zi", "onLiveRoomStatusOpenEvent", "dialogTip", "reason", "onAutoExitRoomPage", "Lsq1/b;", "model", "onEndLiveEvent", "isFirstCreate", "onSelected", "d6", "onDestroyView", "Vh", "Ei", "type", "fi", "ei", "Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/ChooseCoverController;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "xh", "()Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/ChooseCoverController;", "chooseCoverController", "D", "Landroid/view/View;", "Dh", "()Landroid/view/View;", WidgetCacheLunarData.JI, "(Landroid/view/View;)V", "mLiveAvatarContainer", "Lcom/tencent/biz/qqstory/storyHome/discover/RoundCornerImageView;", "E", "Lcom/tencent/biz/qqstory/storyHome/discover/RoundCornerImageView;", "Ch", "()Lcom/tencent/biz/qqstory/storyHome/discover/RoundCornerImageView;", "ii", "(Lcom/tencent/biz/qqstory/storyHome/discover/RoundCornerImageView;)V", "mLiveAvatar", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText;", "Eh", "()Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText;", "ki", "(Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText;)V", "mLiveName", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "Fh", "()Landroid/widget/TextView;", "li", "(Landroid/widget/TextView;)V", "mLiveNameTv", "H", "Gh", "mi", "mLiveProtocol", "I", "Nh", "si", "mStepOneTitle", "Landroid/widget/Button;", "J", "Landroid/widget/Button;", "Ih", "()Landroid/widget/Button;", "oi", "(Landroid/widget/Button;)V", "mLiveStartBtn", "K", "Jh", "pi", "mLiveStartBtnDis", "Landroid/widget/ImageView;", "L", "Landroid/widget/ImageView;", "Hh", "()Landroid/widget/ImageView;", "ni", "(Landroid/widget/ImageView;)V", "mLiveProtocolCheckBox", "M", "getMScrollArea", "ri", "mScrollArea", "N", "Oh", "ti", "mVideoPreContainer", "Landroidx/lifecycle/MutableLiveData;", "P", "Landroidx/lifecycle/MutableLiveData;", "Mh", "()Landroidx/lifecycle/MutableLiveData;", "mProtocolStatus", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Bh", "mHasFillName", "", BdhLogUtil.LogTag.Tag_Req, "getMStepOneTitleSize", "()F", "setMStepOneTitleSize", "(F)V", "mStepOneTitleSize", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/String;", OcrConfig.CHINESE, "()Ljava/lang/String;", "gi", "(Ljava/lang/String;)V", "mCoverLocalPath", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "T", "Lh", "()Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mOnKeyboardUpListener", "U", "Z", "Ah", "()Z", "hi", "(Z)V", "mHasExited", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "V", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "Kh", "()Lcom/tencent/mobileqq/widget/QQProgressDialog;", "qi", "(Lcom/tencent/mobileqq/widget/QQProgressDialog;)V", "mLoadingDialog", "W", "getNeedRecordAgreeTips", SensorJsPlugin.SENSOR_INTERVAL_UI, "needRecordAgreeTips", "<init>", "()V", "X", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class LiveReadyBaseFrag extends QQGuildLiveModuleBaseFragment implements View.OnClickListener, e, com.tencent.mobileqq.guild.live.livemanager.h {

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static int Y;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy chooseCoverController;

    /* renamed from: D, reason: from kotlin metadata */
    public View mLiveAvatarContainer;

    /* renamed from: E, reason: from kotlin metadata */
    public RoundCornerImageView mLiveAvatar;

    /* renamed from: F, reason: from kotlin metadata */
    public CharacterCountEditText mLiveName;

    /* renamed from: G, reason: from kotlin metadata */
    public TextView mLiveNameTv;

    /* renamed from: H, reason: from kotlin metadata */
    public TextView mLiveProtocol;

    /* renamed from: I, reason: from kotlin metadata */
    public TextView mStepOneTitle;

    /* renamed from: J, reason: from kotlin metadata */
    public Button mLiveStartBtn;

    /* renamed from: K, reason: from kotlin metadata */
    public Button mLiveStartBtnDis;

    /* renamed from: L, reason: from kotlin metadata */
    public ImageView mLiveProtocolCheckBox;

    /* renamed from: M, reason: from kotlin metadata */
    public View mScrollArea;

    /* renamed from: N, reason: from kotlin metadata */
    public View mVideoPreContainer;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> mProtocolStatus;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> mHasFillName;

    /* renamed from: R, reason: from kotlin metadata */
    private float mStepOneTitleSize;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private String mCoverLocalPath;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy mOnKeyboardUpListener;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean mHasExited;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private QQProgressDialog mLoadingDialog;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean needRecordAgreeTips;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyBaseFrag$a;", "", "", "selectType", "I", "getSelectType", "()I", "a", "(I)V", "LAST_GAME_LIVE_NOT_RELEASE", "MAX_NAME_LENGTH", "START_LIVE_RESULT_CODE_IN_LIVE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(int i3) {
            LiveReadyBaseFrag.Y = i3;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyBaseFrag$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f226536e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f226537f;

        b(String str, int i3) {
            this.f226536e = str;
            this.f226537f = i3;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            LiveReadyBaseFrag.this.Vh(this.f226536e);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setColor(this.f226537f);
            ds5.setUnderlineText(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J#\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyBaseFrag$d", "Lcom/tencent/mobileqq/guild/live/livemanager/anchor/f;", "", "a", "", "errCode", "", "errMsg", "b", "(Ljava/lang/Integer;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements com.tencent.mobileqq.guild.live.livemanager.anchor.f {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.anchor.f
        public void a() {
            QLog.d("QGL.LiveReadyBaseFrag", 1, "setRoomInfo suc.");
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.anchor.f
        public void b(@Nullable Integer errCode, @Nullable String errMsg) {
            QLog.d("QGL.LiveReadyBaseFrag", 1, "setRoomInfo onFail " + errCode + " ");
        }
    }

    public LiveReadyBaseFrag() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ChooseCoverController>() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag$chooseCoverController$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ChooseCoverController invoke() {
                FragmentActivity requireActivity = LiveReadyBaseFrag.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                IGProGuildInfo guildInfo = GLiveChannelCore.f226698a.s().getGuildInfo();
                Intrinsics.checkNotNull(guildInfo);
                AppRuntime appRuntime = LiveReadyBaseFrag.this.getAppRuntime();
                Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
                return new ChooseCoverController(requireActivity, guildInfo, appRuntime);
            }
        });
        this.chooseCoverController = lazy;
        Boolean bool = Boolean.FALSE;
        this.mProtocolStatus = new MutableLiveData<>(bool);
        this.mHasFillName = new MutableLiveData<>(bool);
        this.mCoverLocalPath = "";
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<LiveReadyBaseFrag$mOnKeyboardUpListener$2.a>() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag$mOnKeyboardUpListener$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyBaseFrag$mOnKeyboardUpListener$2$a", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "", "d", "I", "mUsableHeightPrevious", "Landroid/graphics/Rect;", "e", "Landroid/graphics/Rect;", "mRect", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes14.dex */
            public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

                /* renamed from: d, reason: collision with root package name and from kotlin metadata */
                private int mUsableHeightPrevious;

                /* renamed from: e, reason: collision with root package name and from kotlin metadata */
                @NotNull
                private final Rect mRect = new Rect();

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ LiveReadyBaseFrag f226541f;

                a(LiveReadyBaseFrag liveReadyBaseFrag) {
                    this.f226541f = liveReadyBaseFrag;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    View view = this.f226541f.getView();
                    if (view != null) {
                        LiveReadyBaseFrag liveReadyBaseFrag = this.f226541f;
                        view.getWindowVisibleDisplayFrame(this.mRect);
                        Rect rect = this.mRect;
                        int i3 = rect.bottom - rect.top;
                        if (i3 != this.mUsableHeightPrevious) {
                            int height = view.getRootView().getHeight();
                            if (height - i3 > height / 4) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("QGL.LiveReadyBaseFrag", 2, "mOnGlobalLayoutListener: on Keyboard Up");
                                }
                                liveReadyBaseFrag.Eh().setSelection(liveReadyBaseFrag.Eh().getText().length());
                                liveReadyBaseFrag.Eh().setAlpha(1.0f);
                                liveReadyBaseFrag.Fh().setVisibility(4);
                            } else {
                                liveReadyBaseFrag.Fh().setVisibility(0);
                                liveReadyBaseFrag.Eh().setAlpha(0.0f);
                                liveReadyBaseFrag.Ei(liveReadyBaseFrag.Eh().getText().toString());
                            }
                            this.mUsableHeightPrevious = i3;
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(LiveReadyBaseFrag.this);
            }
        });
        this.mOnKeyboardUpListener = lazy2;
    }

    private final void Bi() {
        String str;
        String str2;
        IGProChannelInfo channelInfo = GLiveChannelCore.f226698a.s().getChannelInfo();
        if (channelInfo != null) {
            str = channelInfo.getGuildId();
            str2 = channelInfo.getChannelUin();
        } else {
            str = null;
            str2 = null;
        }
        com.tencent.mobileqq.guild.performance.report.k.e(str, str2);
        com.tencent.mobileqq.guild.performance.report.l.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Di(int i3, String str) {
        QLog.i("QGL.LiveGameReadyFragment", 1, "terminateLiveStream, result:" + i3 + ",errMsg:" + str);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(i3);
        com.tencent.mobileqq.guild.util.aa.f(sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(LiveReadyBaseFrag this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.initSubVideoBarHeight();
    }

    public static /* synthetic */ void Yh(LiveReadyBaseFrag liveReadyBaseFrag, String str, int i3, bl blVar, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 4) != 0) {
                blVar = null;
            }
            liveReadyBaseFrag.Xh(str, i3, blVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportStartLive");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(LiveReadyBaseFrag this$0, int i3, Ref.LongRef startSendTs, int i16, String str, IGProSecurityResult iGProSecurityResult) {
        Map emptyMap;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(startSendTs, "$startSendTs");
        GuildTimeRecHelper.Companion.e(GuildTimeRecHelper.INSTANCE, GuildLiveTimeEvent.REQUEST_BEGIN_BROADCAST, 0L, 2, null);
        emptyMap = MapsKt__MapsKt.emptyMap();
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        com.tencent.mobileqq.guild.performance.report.l.g("live_room_request_begin_broadcast_callback", emptyMap, i16, str2);
        QLog.d("QGL.LiveReadyBaseFrag", 1, "reportBeginBroadcast: " + i16 + ", errMsg" + str);
        if (i16 == 0) {
            this$0.Sh(i3);
        } else {
            this$0.bi(i3, i16, "requestBeginBroadcast error:" + vq1.c.a(startSendTs.element, str));
            this$0.Rh(i16, iGProSecurityResult, str);
        }
        this$0.needRecordAgreeTips = false;
    }

    public static /* synthetic */ void ci(LiveReadyBaseFrag liveReadyBaseFrag, int i3, int i16, String str, int i17, Object obj) {
        if (obj == null) {
            if ((i17 & 2) != 0) {
                i16 = 0;
            }
            if ((i17 & 4) != 0) {
                str = null;
            }
            liveReadyBaseFrag.bi(i3, i16, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportStartLiveResultEvent");
    }

    private final void initSubVideoBarHeight() {
        if (getContext() == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = Oh().getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = GLiveChannelCore.f226698a.t().u(getContext());
        Oh().setLayoutParams(layoutParams);
    }

    private final void vh() {
        float measureText = Nh().getPaint().measureText(HardCodeUtil.qqStr(R.string.f148420zj));
        if (com.tencent.mobileqq.util.x.f(getContext()).f185860a - (getResources().getDimensionPixelSize(R.dimen.cgm) * 2) < measureText) {
            this.mStepOneTitleSize = (int) (Nh().getTextSize() * (r1 / measureText));
            Nh().setTextSize(0, this.mStepOneTitleSize);
        }
    }

    private final void wh(View v3) {
        if (v3.getId() != R.id.ylu) {
            Object systemService = v3.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(v3.getWindowToken(), 0);
        }
    }

    private final void wi() {
        DialogUtil.createCustomDialog(getContext(), 230, (String) null, getString(R.string.f147610xc), getString(R.string.f146610un), getString(R.string.f147620xd), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                LiveReadyBaseFrag.xi(LiveReadyBaseFrag.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.r
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                LiveReadyBaseFrag.yi(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xi(LiveReadyBaseFrag this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ci(false);
    }

    /* renamed from: Ah, reason: from getter */
    public final boolean getMHasExited() {
        return this.mHasExited;
    }

    @NotNull
    public final MutableLiveData<Boolean> Bh() {
        return this.mHasFillName;
    }

    @NotNull
    public final RoundCornerImageView Ch() {
        RoundCornerImageView roundCornerImageView = this.mLiveAvatar;
        if (roundCornerImageView != null) {
            return roundCornerImageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLiveAvatar");
        return null;
    }

    public final void Ci(boolean finishActivity) {
        ((IGPSService) ch.R0(IGPSService.class)).terminateLiveStream("0", "0", 1, new de() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.s
            @Override // vh2.de
            public final void a(int i3, String str) {
                LiveReadyBaseFrag.Di(i3, str);
            }
        });
        if (finishActivity) {
            finishActivityJudgePadWithAnim();
        }
    }

    @NotNull
    public final View Dh() {
        View view = this.mLiveAvatarContainer;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLiveAvatarContainer");
        return null;
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.e
    public void E8(int requestCode, int resultCode) {
        if (resultCode == -1 && requestCode == 257) {
            xh().o();
        }
    }

    @NotNull
    public final CharacterCountEditText Eh() {
        CharacterCountEditText characterCountEditText = this.mLiveName;
        if (characterCountEditText != null) {
            return characterCountEditText;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLiveName");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Ei(@Nullable String showText) {
        boolean z16;
        boolean isBlank;
        if (getContext() == null) {
            return;
        }
        if (showText != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(showText);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    Fh().setText(requireContext().getString(R.string.f148390zg));
                    Fh().setTextColor(requireContext().getResources().getColor(R.color.bri));
                    return;
                } else {
                    Fh().setText(showText);
                    Fh().setTextColor(requireContext().getResources().getColor(R.color.brj));
                    return;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @NotNull
    public final TextView Fh() {
        TextView textView = this.mLiveNameTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLiveNameTv");
        return null;
    }

    @NotNull
    public final TextView Gh() {
        TextView textView = this.mLiveProtocol;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLiveProtocol");
        return null;
    }

    @NotNull
    public final ImageView Hh() {
        ImageView imageView = this.mLiveProtocolCheckBox;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLiveProtocolCheckBox");
        return null;
    }

    @NotNull
    public final Button Ih() {
        Button button = this.mLiveStartBtn;
        if (button != null) {
            return button;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLiveStartBtn");
        return null;
    }

    @NotNull
    public final Button Jh() {
        Button button = this.mLiveStartBtnDis;
        if (button != null) {
            return button;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLiveStartBtnDis");
        return null;
    }

    @Nullable
    /* renamed from: Kh, reason: from getter */
    public final QQProgressDialog getMLoadingDialog() {
        return this.mLoadingDialog;
    }

    @NotNull
    public final ViewTreeObserver.OnGlobalLayoutListener Lh() {
        return (ViewTreeObserver.OnGlobalLayoutListener) this.mOnKeyboardUpListener.getValue();
    }

    @NotNull
    public final MutableLiveData<Boolean> Mh() {
        return this.mProtocolStatus;
    }

    @NotNull
    public final TextView Nh() {
        TextView textView = this.mStepOneTitle;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mStepOneTitle");
        return null;
    }

    @NotNull
    public final View Oh() {
        View view = this.mVideoPreContainer;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPreContainer");
        return null;
    }

    @NotNull
    public final Drawable Ph() {
        Drawable guildFaceIcon = ch.J(QQGuildUIUtil.n(getGuildId(), ((IGPSService) getAppRuntime().getRuntimeService(IGPSService.class, "")).getSelfTinyId(), (AppInterface) getAppRuntime()), ViewUtils.dpToPx(37.0f), new BitmapDrawable(QQGuildUIUtil.j(false)), false);
        Intrinsics.checkNotNullExpressionValue(guildFaceIcon, "guildFaceIcon");
        return guildFaceIcon;
    }

    public void Qh() {
        QLog.d("QGL.LiveReadyBaseFrag", 1, "handleCheckBoxClick: isSelected=" + Hh().isSelected());
        Hh().setSelected(Hh().isSelected() ^ true);
        this.mProtocolStatus.setValue(Boolean.valueOf(Hh().isSelected()));
    }

    public boolean Rh(int result, @Nullable IGProSecurityResult securityResult, @Nullable String errMsg) {
        boolean z16 = true;
        if (result == 97001) {
            wi();
            return true;
        }
        if (errMsg != null && errMsg.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            com.tencent.mobileqq.guild.util.aa.e(errMsg);
        } else {
            com.tencent.mobileqq.guild.util.aa.d(R.string.f147700xl);
        }
        return false;
    }

    public void Sb(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (!TextUtils.isEmpty(stringExtra)) {
            if (QLog.isColorLevel()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("doOnNewIntent path=%s", Arrays.copyOf(new Object[]{stringExtra}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                QLog.d("QGL.LiveReadyBaseFrag", 2, format);
            }
            Ch().setImageURI(Uri.fromFile(new File(stringExtra)));
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.mCoverLocalPath = stringExtra;
        }
    }

    public void Sh(int pushType) {
        bw.L().encodeInt(ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE, pushType);
        if (this.needRecordAgreeTips) {
            GuildLiveReadyTipsDialog.INSTANCE.c(pushType);
        }
    }

    public final void Th(@NotNull CharacterCountEditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        editText.setLimitCount(20);
        editText.addTextChangedListener(new c());
    }

    public final void Vh(@NotNull String h5Url) {
        Intrinsics.checkNotNullParameter(h5Url, "h5Url");
        cx.c(getContext(), URLUtil.guessUrl(h5Url), getGuildId());
    }

    public void Wh() {
        com.tencent.mobileqq.guild.main.d.d(getAppRuntime(), getGuildId(), "startLive");
    }

    public final void Xh(@NotNull String liveRoomID, final int pushType, @Nullable bl programInfo) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(liveRoomID, "liveRoomID");
        QLog.d("QGL.LiveReadyBaseFrag", 1, "reportStartLive: room=" + liveRoomID + ", type=" + pushType);
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        IGProChannelInfo channelInfo = gLiveChannelCore.s().getChannelInfo();
        if (channelInfo == null) {
            QLog.d("QGL.LiveReadyBaseFrag", 1, "getCache().getChannelInfo() == null, please check it.");
            return;
        }
        if (pushType == 1) {
            ai(pushType);
        }
        GuildTimeRecHelper.INSTANCE.m(GuildLiveTimeEvent.REQUEST_BEGIN_BROADCAST);
        HashMap hashMap = new HashMap();
        hashMap.put("live_room_type", String.valueOf(pushType));
        com.tencent.mobileqq.guild.performance.report.l.i("live_room_request_begin_broadcast_start", hashMap, 0, null, 12, null);
        String str = "";
        IRuntimeService runtimeService = getAppRuntime().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(this.mCoverLocalPath, "http", false, 2, null);
        if (startsWith$default) {
            str = this.mCoverLocalPath;
        } else {
            xh().k(this.mCoverLocalPath, "", pushType);
        }
        gLiveChannelCore.h().e(pushType, new GLiveRoomInfo(Eh().getText().toString(), str), 0, new d());
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = System.currentTimeMillis();
        iGPSService.requestBeginBroadcast(channelInfo.getGuildId(), channelInfo.getChannelUin(), liveRoomID, pushType, programInfo, new cd() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.o
            @Override // vh2.cd
            public final void a(int i3, String str2, IGProSecurityResult iGProSecurityResult) {
                LiveReadyBaseFrag.Zh(LiveReadyBaseFrag.this, pushType, longRef, i3, str2, iGProSecurityResult);
            }
        });
    }

    public final void ai(int pushType) {
        HashMap hashMap = new HashMap();
        hashMap.put("live_room_type", String.valueOf(pushType));
        com.tencent.mobileqq.guild.performance.report.l.i("live_room_anchor_start_live", hashMap, 0, null, 12, null);
        GuildLiveStartReportTask.INSTANCE.c();
    }

    public final void bi(int pushType, int errorCode, @Nullable String errorMsg) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("live_room_type", String.valueOf(pushType));
        if (errorMsg == null) {
            str = "";
        } else {
            str = errorMsg;
        }
        com.tencent.mobileqq.guild.performance.report.l.g("live_room_anchor_start_live_result", hashMap, errorCode, str);
        GuildLiveStartReportTask.INSTANCE.a(pushType, errorCode, errorMsg);
    }

    public void di() {
        Dh().setOnClickListener(this);
        Ch().setOnClickListener(this);
        Ih().setOnClickListener(this);
        Jh().setOnClickListener(this);
        Hh().setOnClickListener(this);
    }

    public void ei(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        GuildDTReportApiImpl guildDTReportApiImpl = ch.f235509b;
        guildDTReportApiImpl.setElementExposureAndClickParams(view.findViewById(R.id.ym6), "em_stream_star_type", null);
        guildDTReportApiImpl.setElementExposureAndClickParams(view.findViewById(R.id.ylu), "em_stream_star_title", null);
        guildDTReportApiImpl.setElementExposureAndClickParams(view.findViewById(R.id.ykq), "em_stream_star_cover", null);
    }

    public final void fi(@NotNull View view, int type) {
        Intrinsics.checkNotNullParameter(view, "view");
        com.tencent.mobileqq.guild.util.z zVar = new com.tencent.mobileqq.guild.util.z();
        String selfTinyId = ((IGPSService) getAppRuntime().getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        HashMap<String, Object> pageParams = zVar.b();
        Integer valueOf = Integer.valueOf(type);
        Intrinsics.checkNotNullExpressionValue(pageParams, "pageParams");
        pageParams.put("sgrp_stream_star_type", valueOf);
        pageParams.put("sgrp_access_id", selfTinyId);
        com.tencent.mobileqq.guild.data.w.a(pageParams);
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, "pg_sgrp_stream_star");
        VideoReport.setPageParams(view, new PageParams(pageParams));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String getGuildId() {
        IGProChannelInfo channelInfo = GLiveChannelCore.f226698a.s().getChannelInfo();
        if (channelInfo != null) {
            String guildId = channelInfo.getGuildId();
            Intrinsics.checkNotNullExpressionValue(guildId, "channelInfo.guildId");
            return guildId;
        }
        return "0";
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected int getLayoutId() {
        return 0;
    }

    public final void gi(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mCoverLocalPath = str;
    }

    public final void hi(boolean z16) {
        this.mHasExited = z16;
    }

    public final void ii(@NotNull RoundCornerImageView roundCornerImageView) {
        Intrinsics.checkNotNullParameter(roundCornerImageView, "<set-?>");
        this.mLiveAvatar = roundCornerImageView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.initView(view);
        View findViewById = view.findViewById(R.id.yly);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.live_ready_cover_ll)");
        ji(findViewById);
        View findViewById2 = view.findViewById(R.id.ykq);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.live_avatar_iv)");
        ii((RoundCornerImageView) findViewById2);
        Ch().setCorner(ViewUtils.dpToPx(4.0f));
        View findViewById3 = view.findViewById(R.id.ylu);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.live_name_et)");
        ki((CharacterCountEditText) findViewById3);
        View findViewById4 = view.findViewById(R.id.ylv);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.live_name_tv)");
        li((TextView) findViewById4);
        View findViewById5 = view.findViewById(R.id.ym6);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.live_start_btn)");
        oi((Button) findViewById5);
        View findViewById6 = view.findViewById(R.id.ym7);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.live_start_btn_disable)");
        pi((Button) findViewById6);
        View findViewById7 = view.findViewById(R.id.ylw);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.live_protocol_checkbox)");
        ni((ImageView) findViewById7);
        View findViewById8 = view.findViewById(R.id.ylx);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.live_protocol_tv)");
        mi((TextView) findViewById8);
        View findViewById9 = view.findViewById(R.id.soz);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.anchor_pre_container)");
        ti(findViewById9);
        View findViewById10 = view.findViewById(R.id.f89174z2);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.stream_info_step_one_title)");
        si((TextView) findViewById10);
        vh();
        View findViewById11 = view.findViewById(R.id.f80454bi);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.scroll_area)");
        ri(findViewById11);
    }

    public final void ji(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mLiveAvatarContainer = view;
    }

    public final void ki(@NotNull CharacterCountEditText characterCountEditText) {
        Intrinsics.checkNotNullParameter(characterCountEditText, "<set-?>");
        this.mLiveName = characterCountEditText;
    }

    public final void li(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mLiveNameTv = textView;
    }

    public final void mi(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mLiveProtocol = textView;
    }

    public final void ni(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mLiveProtocolCheckBox = imageView;
    }

    public final void oi(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.mLiveStartBtn = button;
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.h
    public void onAutoExitRoomPage(@Nullable String dialogTip, @NotNull String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (AppSetting.t(getContext())) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onKeyDown(4, new KeyEvent(4, 4));
                return;
            }
            return;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 != null) {
            activity3.overridePendingTransition(0, 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        wh(v3);
        int id5 = v3.getId();
        boolean z17 = false;
        if (id5 == R.id.ykq || id5 == R.id.yly) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (getContext() != null) {
                xh().m();
            }
        } else if (id5 == R.id.ylw) {
            Qh();
        } else {
            if (id5 == R.id.ym7 || id5 == R.id.ym6) {
                z17 = true;
            }
            if (z17) {
                Ai();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ViewTreeObserver viewTreeObserver;
        View view = getView();
        if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(Lh());
        }
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.h
    public void onEndLiveEvent(@NotNull sq1.b model) {
        Intrinsics.checkNotNullParameter(model, "model");
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.h
    public boolean onLiveRoomStatusOpenEvent() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        GuildTimeRecHelper.Companion companion = GuildTimeRecHelper.INSTANCE;
        companion.m(GuildLiveTimeEvent.ANCHOR_PAGE_BETWEEN_SHOW_FIRST_FRAME);
        GuildTimeRecHelper.Companion.e(companion, GuildLiveTimeEvent.CLICK_START_BETWEEN_PREPARE_PAGE_SHOW, 0L, 2, null);
        Bi();
        com.tencent.mobileqq.guild.performance.report.l.i("live_room_live_ready_ui_showed", null, 0, null, 14, null);
        di();
        Th(Eh());
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(Lh());
        }
        initSubVideoBarHeight();
        vi();
        GLiveChannelCore.f226698a.t().t().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveReadyBaseFrag.Uh(LiveReadyBaseFrag.this, (Integer) obj);
            }
        });
    }

    public final void pi(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.mLiveStartBtnDis = button;
    }

    public final void qi(@Nullable QQProgressDialog qQProgressDialog) {
        this.mLoadingDialog = qQProgressDialog;
    }

    public final void ri(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mScrollArea = view;
    }

    public final void si(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mStepOneTitle = textView;
    }

    public final void ti(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mVideoPreContainer = view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ui(boolean z16) {
        this.needRecordAgreeTips = z16;
    }

    @NotNull
    public final ChooseCoverController xh() {
        return (ChooseCoverController) this.chooseCoverController.getValue();
    }

    @NotNull
    public final SpannableString yh(@NotNull String clickStr, @NotNull String showText, @NotNull String h5Url) {
        int indexOf$default;
        Intrinsics.checkNotNullParameter(clickStr, "clickStr");
        Intrinsics.checkNotNullParameter(showText, "showText");
        Intrinsics.checkNotNullParameter(h5Url, "h5Url");
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) showText, clickStr, 0, false, 6, (Object) null);
        SpannableString spannableString = new SpannableString(showText);
        spannableString.setSpan(new b(h5Url, getResources().getColor(R.color.brg)), indexOf$default, clickStr.length() + indexOf$default, 33);
        return spannableString;
    }

    @NotNull
    /* renamed from: zh, reason: from getter */
    public final String getMCoverLocalPath() {
        return this.mCoverLocalPath;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zi(int liveType) {
        GuildLiveReadyTipsDialog.Companion companion = GuildLiveReadyTipsDialog.INSTANCE;
        if (companion.d(liveType) && getActivity() != null) {
            FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().supportFragmentManager");
            companion.e(liveType, supportFragmentManager, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyBaseFrag$showLiveReadyTipsDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    LiveReadyBaseFrag.this.ui(z16);
                    LiveReadyBaseFrag.this.Wh();
                }
            });
            return true;
        }
        return false;
    }

    public void Ai() {
    }

    public void d6() {
    }

    public void vi() {
    }

    public void onSelected(boolean isFirstCreate) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yi(DialogInterface dialogInterface, int i3) {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000e\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyBaseFrag$c", "Landroid/text/TextWatcher;", "", "charSequence", "", "i", "i1", "i2", "", "beforeTextChanged", ReportConstant.COSTREPORT_PREFIX, "start", "before", "count", "onTextChanged", "Landroid/text/Editable;", "editable", "afterTextChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable editable) {
            CharSequence trim;
            boolean z16;
            Intrinsics.checkNotNullParameter(editable, "editable");
            trim = StringsKt__StringsKt.trim((CharSequence) editable.toString());
            if (trim.toString().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                LiveReadyBaseFrag.this.Bh().postValue(Boolean.TRUE);
            } else {
                LiveReadyBaseFrag.this.Bh().postValue(Boolean.FALSE);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence charSequence, int i3, int i16, int i26) {
            Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        }
    }
}
