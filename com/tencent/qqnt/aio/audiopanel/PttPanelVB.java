package com.tencent.qqnt.aio.audiopanel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.PopupWindow;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.widget.ClickableColorSpanTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableSpanTextView;
import com.tencent.mobileqq.widget.bq;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.open.base.MD5Utils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.audiopanel.PttPanelVB;
import com.tencent.qqnt.aio.audiopanel.PttUIState;
import com.tencent.qqnt.aio.audiopanel.q;
import com.tencent.qqnt.aio.reserve2.Reserve2Event;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XPanelContainer;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.light.LightConstants;

@Metadata(d1 = {"\u0000\u00dc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u008b\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u00020\u0007:\u0004\u008c\u0001\u008d\u0001B\t\u00a2\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010!\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\nH\u0016J\u001a\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020(0'H\u0016J\u0010\u0010*\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0018\u0010.\u001a\u00020\n2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u001aH\u0016J\u0010\u00100\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u0017H\u0016J\b\u00101\u001a\u00020\nH\u0016J\b\u00102\u001a\u00020\nH\u0016J:\u0010:\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u00010\u00152\u0006\u00105\u001a\u0002042\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020706j\b\u0012\u0004\u0012\u000207`82\u0006\u0010-\u001a\u00020\u001aH\u0016JR\u0010>\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u00010\u00152\u0006\u00105\u001a\u0002042\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020706j\b\u0012\u0004\u0012\u000207`82\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\u0011H\u0016J\u0010\u0010@\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u0015H\u0016JR\u0010A\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u00010\u00152\u0006\u00105\u001a\u0002042\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020706j\b\u0012\u0004\u0012\u000207`82\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u00172\u0006\u0010=\u001a\u00020\u0011H\u0016J\b\u0010B\u001a\u00020\nH\u0016J\u0012\u0010C\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010D\u001a\u00020\u0017H\u0016J\u0010\u0010F\u001a\u00020\n2\u0006\u0010E\u001a\u00020\u0015H\u0016J$\u0010H\u001a\u00020\n2\b\u0010E\u001a\u0004\u0018\u00010\u00152\u0006\u0010G\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010I\u001a\u00020\u0011H\u0016J8\u0010J\u001a\u00020\n2\u0006\u0010E\u001a\u00020\u00152\u0006\u00105\u001a\u0002042\u0016\u00109\u001a\u0012\u0012\u0004\u0012\u00020706j\b\u0012\u0004\u0012\u000207`82\u0006\u0010-\u001a\u00020\u001aH\u0016J\b\u0010K\u001a\u00020\u0017H\u0016J\b\u0010L\u001a\u00020\u0017H\u0016J\u0010\u0010N\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u0017H\u0016J\u0010\u0010O\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u0017H\u0016J\b\u0010P\u001a\u00020\u0011H\u0016J\u0018\u0010S\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\u00112\u0006\u0010R\u001a\u00020\u0011H\u0016J\u0012\u0010U\u001a\u0004\u0018\u00010$2\u0006\u0010T\u001a\u00020\u0011H\u0016J\b\u0010V\u001a\u00020\nH\u0016J\u0010\u0010W\u001a\u00020\u00172\u0006\u0010T\u001a\u00020\u0011H\u0016J\n\u0010X\u001a\u0004\u0018\u00010$H\u0016R\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u001b\u0010b\u001a\u00020]8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u0018\u00103\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010p\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010s\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010w\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010y\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010xRq\u0010\u0081\u0001\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001c |*\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001c\u0018\u00010{0{ |**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001c |*\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001c\u0018\u00010{0{\u0018\u00010}0z8BX\u0082\u0084\u0002\u00a2\u0006\r\n\u0004\b~\u0010_\u001a\u0005\b\u007f\u0010\u0080\u0001R\u001b\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0088\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u00a8\u0006\u008e\u0001"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/PttPanelVB;", "Landroid/os/Handler$Callback;", "Lcom/tencent/widget/XPanelContainer$g;", "Lcom/tencent/qqnt/aio/audiopanel/m;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/aio/audiopanel/q;", "Lcom/tencent/qqnt/aio/audiopanel/PttUIState;", "Lcom/tencent/qqnt/aio/audiopanel/l;", "Lmqq/app/AppRuntime;", ICustomDataEditor.NUMBER_PARAM_1, "", Constants.APK_CERTIFICATE, "u1", "w1", "A1", "k1", "C1", "", "state", "y1", "l1", "", "q1", "", "H1", "m1", "Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "recordParam", "", "o1", "(Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;)Ljava/lang/Long;", "Landroid/os/Message;", "msg", "handleMessage", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/mobileqq/ptt/d$a;", "listener", "param", "s0", "sync", "j", "z1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "audioPath", "", "totalTime", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "audioData", "P0", "isVoiceChange", "isAutoConvertText", "voiceChangeType", "Z", "text", "sendMessage", "C0", "W0", "I0", "H0", "path", "O", "isNoPermission", "g0", "c", "B", "isRecording", "M0", "bEditState", BdhLogUtil.LogTag.Tag_Req, "r", "v", "oldPanel", "newPanel", "onPanelChanged", "panelId", "E2", "E", "T", "a0", "Lcom/tencent/qqnt/aio/audiopanel/AudioPanel;", "d", "Lcom/tencent/qqnt/aio/audiopanel/AudioPanel;", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "Lcom/tencent/util/MqqWeakReferenceHandler;", "e", "Lkotlin/Lazy;", "r1", "()Lcom/tencent/util/MqqWeakReferenceHandler;", "uiHandler", "f", "Ljava/lang/String;", "Ll61/d;", tl.h.F, "Ll61/d;", "panelManager", "Landroid/widget/PopupWindow;", "i", "Landroid/widget/PopupWindow;", "popupWindow", "Lcom/tencent/mobileqq/activity/aio/audiopanel/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/activity/aio/audiopanel/a;", "androidBug5497Workaround", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "voice2TextPanelView", "Lcom/tencent/mobileqq/widget/bq;", "D", "Lcom/tencent/mobileqq/widget/bq;", "recordToastDialog", "Ljava/lang/Long;", "mPttFakeMsgId", "", "Lkotlin/Pair;", "kotlin.jvm.PlatformType", "", UserInfo.SEX_FEMALE, "p1", "()Ljava/util/List;", "mPttFakeMsgIdList", "G", "Ljava/lang/Boolean;", "mUsePopupWindowSwitch", "Lcom/tencent/mobileqq/qdispatchqueue/h;", "H", "Lcom/tencent/mobileqq/qdispatchqueue/h;", "serialQueue", "<init>", "()V", "I", "a", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PttPanelVB extends com.tencent.aio.base.mvvm.a<q, PttUIState> implements Handler.Callback, XPanelContainer.g, m, l {

    /* renamed from: C, reason: from kotlin metadata */
    private View voice2TextPanelView;

    /* renamed from: D, reason: from kotlin metadata */
    private bq recordToastDialog;

    /* renamed from: E, reason: from kotlin metadata */
    private Long mPttFakeMsgId;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy mPttFakeMsgIdList;

    /* renamed from: G, reason: from kotlin metadata */
    private Boolean mUsePopupWindowSwitch;

    /* renamed from: H, reason: from kotlin metadata */
    private final com.tencent.mobileqq.qdispatchqueue.h serialQueue;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AudioPanel panel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy uiHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String audioPath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private l61.d panelManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private PopupWindow popupWindow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.activity.aio.audiopanel.a androidBug5497Workaround;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0001\u00a2\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\u0096\u0001J)\u0010\n\u001a\u00020\t2\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\u0096\u0001J\t\u0010\u000b\u001a\u00020\tH\u0096\u0001J)\u0010\f\u001a\u00020\t2\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\u0096\u0001J1\u0010\u000f\u001a\u00020\t2\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001J9\u0010\u0010\u001a\u00020\t2\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u000e\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\u0096\u0001J)\u0010\u0011\u001a\u00020\t2\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\u0096\u0001JQ\u0010\u0016\u001a\u00020\t2\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00120\u00122\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\r2\u000e\u0010\u0015\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0007H\u0096\u0001R\u0014\u0010\u001b\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/aio/audiopanel/PttPanelVB$a;", "Lcom/tencent/mobileqq/ptt/d$a;", "", "kotlin.jvm.PlatformType", "p0", "Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "p1", "", "onBeginReceiveData", "", "onInitFailed", "onInitSuccess", "onRecorderAbnormal", "", "p2", "onRecorderEnd", "onRecorderError", "onRecorderPrepare", "", "p3", "p4", "p5", "onRecorderSilceEnd", "onRecorderStart", "onRecorderVolumeStateChanged", "d", "Lcom/tencent/mobileqq/ptt/d$a;", "listener", "<init>", "(Lcom/tencent/mobileqq/ptt/d$a;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static abstract class a implements d.a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final d.a listener;

        public a(d.a listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public int onBeginReceiveData(String p06, RecordParams.RecorderParam p16) {
            return this.listener.onBeginReceiveData(p06, p16);
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onInitFailed(String p06, RecordParams.RecorderParam p16) {
            this.listener.onInitFailed(p06, p16);
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onInitSuccess() {
            this.listener.onInitSuccess();
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderAbnormal(String p06, RecordParams.RecorderParam p16) {
            this.listener.onRecorderAbnormal(p06, p16);
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderEnd(String p06, RecordParams.RecorderParam p16, double p26) {
            this.listener.onRecorderEnd(p06, p16, p26);
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderError(String p06, RecordParams.RecorderParam p16, String p26) {
            this.listener.onRecorderError(p06, p16, p26);
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderPrepare(String p06, RecordParams.RecorderParam p16) {
            this.listener.onRecorderPrepare(p06, p16);
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderSilceEnd(String p06, byte[] p16, int p26, int p36, double p46, RecordParams.RecorderParam p56) {
            this.listener.onRecorderSilceEnd(p06, p16, p26, p36, p46, p56);
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public int onRecorderStart() {
            return this.listener.onRecorderStart();
        }

        @Override // com.tencent.mobileqq.ptt.d.a
        public void onRecorderVolumeStateChanged(int p06) {
            this.listener.onRecorderVolumeStateChanged(p06);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/qqnt/aio/audiopanel/PttPanelVB$c", "Lcom/tencent/qqnt/aio/audiopanel/PttPanelVB$a;", "", "path", "Lcom/tencent/mobileqq/utils/RecordParams$RecorderParam;", "p", "", "totalTime", "", "onRecorderEnd", "", "state", "onRecorderVolumeStateChanged", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PttPanelVB f349651e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RecordParams.RecorderParam f349652f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(d.a aVar, PttPanelVB pttPanelVB, RecordParams.RecorderParam recorderParam) {
            super(aVar);
            this.f349651e = pttPanelVB;
            this.f349652f = recorderParam;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(PttPanelVB this$0, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.y1(i3);
        }

        @Override // com.tencent.qqnt.aio.audiopanel.PttPanelVB.a, com.tencent.mobileqq.ptt.d.a
        public void onRecorderEnd(String path, RecordParams.RecorderParam p16, double totalTime) {
            super.onRecorderEnd(path, p16, totalTime);
            this.f349651e.sendIntent(q.b.f349711d);
            PttPanelVB pttPanelVB = this.f349651e;
            pttPanelVB.sendIntent(new q.RecordEndEvent(pttPanelVB.audioPath, this.f349652f));
        }

        @Override // com.tencent.qqnt.aio.audiopanel.PttPanelVB.a, com.tencent.mobileqq.ptt.d.a
        public void onRecorderVolumeStateChanged(final int state) {
            super.onRecorderVolumeStateChanged(state);
            MqqWeakReferenceHandler r16 = this.f349651e.r1();
            final PttPanelVB pttPanelVB = this.f349651e;
            r16.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.x
                @Override // java.lang.Runnable
                public final void run() {
                    PttPanelVB.c.b(PttPanelVB.this, state);
                }
            });
        }
    }

    public PttPanelVB() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MqqWeakReferenceHandler>() { // from class: com.tencent.qqnt.aio.audiopanel.PttPanelVB$uiHandler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MqqWeakReferenceHandler invoke() {
                return new MqqWeakReferenceHandler(Looper.getMainLooper(), PttPanelVB.this);
            }
        });
        this.uiHandler = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<List<Pair<? extends RecordParams.RecorderParam, ? extends Long>>>() { // from class: com.tencent.qqnt.aio.audiopanel.PttPanelVB$mPttFakeMsgIdList$2
            @Override // kotlin.jvm.functions.Function0
            public final List<Pair<? extends RecordParams.RecorderParam, ? extends Long>> invoke() {
                return Collections.synchronizedList(new LinkedList());
            }
        });
        this.mPttFakeMsgIdList = lazy2;
        com.tencent.mobileqq.qdispatchqueue.h a16 = com.tencent.mobileqq.qdispatchqueue.d.a("PttPanelVB");
        Intrinsics.checkNotNullExpressionValue(a16, "createSerialQueue(\"PttPanelVB\")");
        this.serialQueue = a16;
    }

    private final void A1() {
        Window window;
        Context mContext = getMContext();
        Activity activity = mContext instanceof Activity ? (Activity) mContext : null;
        if (activity != null && (window = activity.getWindow()) != null) {
            window.addFlags(128);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PttPanelVB", 2, "remainScreenOn");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(String str, float f16, Ref.ObjectRef msgId, boolean z16) {
        Intrinsics.checkNotNullParameter(msgId, "$msgId");
        QLog.i("PttPanelVB", 1, "sendMessage audioPath:" + str + ", totalTime: " + f16 + ", fakeMsgId: " + msgId.element + ", isVoiceChange:" + z16 + ", md5:" + MD5Utils.encodeFileHexStr(str));
    }

    private final void C1() {
        boolean equals;
        boolean equals2;
        boolean equals3;
        int i3;
        if (getMContext() instanceof Activity) {
            Context mContext = getMContext();
            Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
            if (((Activity) mContext).isFinishing()) {
                if (QLog.isColorLevel()) {
                    QLog.d("PttPanelVB", 2, "showAbnormalRecordDlg failed, mContext not valid");
                    return;
                }
                return;
            }
        }
        String str = Build.MANUFACTURER;
        equals = StringsKt__StringsJVMKt.equals(str, "meizu", true);
        boolean z16 = false;
        if (equals) {
            i3 = R.string.f8w;
        } else {
            equals2 = StringsKt__StringsJVMKt.equals(str, "xiaomi", true);
            if (equals2) {
                i3 = R.string.f8y;
            } else {
                equals3 = StringsKt__StringsJVMKt.equals(str, CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO, true);
                if (equals3) {
                    i3 = R.string.f8x;
                } else {
                    i3 = R.string.f8v;
                    z16 = true;
                }
            }
        }
        try {
            SpannableString spannableString = new SpannableString(getMContext().getString(i3));
            if (z16) {
                spannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(getMContext().getResources().getColor(R.color.f157037i4), getMContext().getResources().getColor(R.color.f157042i9)), spannableString.length() - 7, spannableString.length() - 1, 33);
                DialogUtil.createContentClickableDialog(getMContext(), HardCodeUtil.qqStr(R.string.jxo), spannableString, 0, R.string.i5e, null, null, new ClickableColorSpanTextView.a() { // from class: com.tencent.qqnt.aio.audiopanel.v
                    @Override // com.tencent.mobileqq.widget.ClickableColorSpanTextView.a
                    public final void a(ClickableColorSpanTextView clickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan statableForegroundColorSpan) {
                        PttPanelVB.D1(PttPanelVB.this, clickableColorSpanTextView, statableForegroundColorSpan);
                    }
                }).show();
            } else {
                DialogUtil.createCustomDialog(getMContext(), 230, HardCodeUtil.qqStr(R.string.jx8), spannableString.toString(), HardCodeUtil.qqStr(R.string.jxu), "", (DialogInterface.OnClickListener) null, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.audiopanel.w
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i16) {
                        PttPanelVB.E1(dialogInterface, i16);
                    }
                }).show();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("PttPanelVB", 2, "show showAbnormalRecordDlg error : " + e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D1(PttPanelVB this$0, ClickableColorSpanTextView clickableColorSpanTextView, StatableSpanTextView.StatableForegroundColorSpan statableForegroundColorSpan) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0.getMContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", IQQRecorderUtils.ABNORMAL_RECORD_URL);
        this$0.getMContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E1(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(PttPanelVB this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l1();
        this$0.k1();
        if (z16) {
            this$0.C1();
        } else {
            QQToast.makeText(this$0.getMContext(), R.string.f170311lx, 1).show(this$0.getMContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
    }

    private final void G1() {
        QLog.d("PttPanelVB", 1, "showVoice2TextPanel");
        if (H1()) {
            PopupWindow popupWindow = this.popupWindow;
            if ((popupWindow == null || popupWindow.isShowing()) ? false : true) {
                FrameworkVM mUIModel = getMUIModel();
                Intrinsics.checkNotNull(mUIModel);
                com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) mUIModel.getMContext()).e();
                if (e16 != null) {
                    PopupWindow popupWindow2 = this.popupWindow;
                    Intrinsics.checkNotNull(popupWindow2);
                    e16.h(new Reserve2Event.PopupWindowShowAtLocation(popupWindow2, 0, 0, 0));
                    return;
                }
                return;
            }
            return;
        }
        FrameworkVM mUIModel2 = getMUIModel();
        Intrinsics.checkNotNull(mUIModel2);
        com.tencent.mvi.base.route.j e17 = ((com.tencent.aio.api.runtime.a) mUIModel2.getMContext()).e();
        if (e17 != null) {
            e17.h(new ExternalCommIntent("add_text_voice_panel", new Bundle()));
        }
    }

    private final boolean H1() {
        Boolean bool = this.mUsePopupWindowSwitch;
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        if (this.mUsePopupWindowSwitch != null) {
            return booleanValue;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_voice2text_panel_switch_9015", false);
        this.mUsePopupWindowSwitch = Boolean.valueOf(isSwitchOn);
        return isSwitchOn;
    }

    private final void k1() {
        Window window;
        try {
            Context mContext = getMContext();
            Activity activity = mContext instanceof Activity ? (Activity) mContext : null;
            if (activity != null && (window = activity.getWindow()) != null) {
                window.clearFlags(128);
            }
            if (QLog.isColorLevel()) {
                QLog.d("PttPanelVB", 2, "cancelRemainScreenOn");
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("PttPanelVB", 2, "cancelRemainScreenOn Throwable = ", th5);
            }
        }
    }

    private final void l1() {
        bq bqVar = this.recordToastDialog;
        if (bqVar != null) {
            Intrinsics.checkNotNull(bqVar);
            if (bqVar.isShowing()) {
                bq bqVar2 = this.recordToastDialog;
                Intrinsics.checkNotNull(bqVar2);
                if (bqVar2.getWindow() != null) {
                    bq bqVar3 = this.recordToastDialog;
                    Intrinsics.checkNotNull(bqVar3);
                    bqVar3.dismiss();
                    this.recordToastDialog = null;
                }
            }
        }
    }

    private final boolean m1() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("fake_msg_fix_bug_9120_132999836", true);
    }

    private final AppRuntime n1() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        return peekAppRuntime;
    }

    private final Long o1(RecordParams.RecorderParam recordParam) {
        Pair<RecordParams.RecorderParam, Long> pair;
        Object lastOrNull;
        if (recordParam == null) {
            List<Pair<RecordParams.RecorderParam, Long>> mPttFakeMsgIdList = p1();
            Intrinsics.checkNotNullExpressionValue(mPttFakeMsgIdList, "mPttFakeMsgIdList");
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) mPttFakeMsgIdList);
            Pair pair2 = (Pair) lastOrNull;
            if (pair2 != null) {
                return Long.valueOf(((Number) pair2.getSecond()).longValue());
            }
            return null;
        }
        List<Pair<RecordParams.RecorderParam, Long>> mPttFakeMsgIdList2 = p1();
        Intrinsics.checkNotNullExpressionValue(mPttFakeMsgIdList2, "mPttFakeMsgIdList");
        ListIterator<Pair<RecordParams.RecorderParam, Long>> listIterator = mPttFakeMsgIdList2.listIterator(mPttFakeMsgIdList2.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                pair = null;
                break;
            }
            pair = listIterator.previous();
            if (Intrinsics.areEqual(pair.getFirst(), recordParam)) {
                break;
            }
        }
        Pair<RecordParams.RecorderParam, Long> pair3 = pair;
        if (pair3 != null) {
            return Long.valueOf(pair3.getSecond().longValue());
        }
        return null;
    }

    private final List<Pair<RecordParams.RecorderParam, Long>> p1() {
        return (List) this.mPttFakeMsgIdList.getValue();
    }

    private final String q1() {
        FrameworkVM mUIModel = getMUIModel();
        z zVar = mUIModel instanceof z ? (z) mUIModel : null;
        if (zVar != null) {
            return zVar.getPcmForVadPath();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MqqWeakReferenceHandler r1() {
        return (MqqWeakReferenceHandler) this.uiHandler.getValue();
    }

    private final void u1() {
        QLog.d("PttPanelVB", 1, "hideVoice2TextPanel");
        l61.d dVar = null;
        if (H1()) {
            PopupWindow popupWindow = this.popupWindow;
            if (popupWindow != null && popupWindow.isShowing()) {
                l61.d dVar2 = this.panelManager;
                if (dVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelManager");
                } else {
                    dVar = dVar2;
                }
                dVar.a().J();
                PopupWindow popupWindow2 = this.popupWindow;
                if (popupWindow2 != null) {
                    popupWindow2.dismiss();
                    return;
                }
                return;
            }
            return;
        }
        l61.d dVar3 = this.panelManager;
        if (dVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelManager");
        } else {
            dVar = dVar3;
        }
        XPanelContainer a16 = dVar.a();
        if (a16 != null) {
            a16.J();
        }
        View view = this.voice2TextPanelView;
        if (view != null) {
            view.setPadding(0, 0, 0, 0);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.r
                @Override // java.lang.Runnable
                public final void run() {
                    PttPanelVB.v1(PttPanelVB.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(PttPanelVB this$0) {
        com.tencent.aio.api.runtime.a aVar;
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameworkVM mUIModel = this$0.getMUIModel();
        if (mUIModel == null || (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) == null || (e16 = aVar.e()) == null) {
            return;
        }
        e16.h(new ExternalCommIntent("remove_text_voice_panel", new Bundle()));
    }

    private final void w1() {
        l61.d dVar = null;
        if (H1()) {
            if (this.popupWindow == null) {
                FrameworkVM mUIModel = getMUIModel();
                Intrinsics.checkNotNull(mUIModel);
                FragmentActivity requireActivity = ((com.tencent.aio.api.runtime.a) mUIModel.getMContext()).c().requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "mUIModel!!.mContext.fragment.requireActivity()");
                VoiceTextPopupWindowContanier voiceTextPopupWindowContanier = new VoiceTextPopupWindowContanier(requireActivity);
                voiceTextPopupWindowContanier.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                l61.d dVar2 = this.panelManager;
                if (dVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelManager");
                    dVar2 = null;
                }
                voiceTextPopupWindowContanier.addView(dVar2.a());
                voiceTextPopupWindowContanier.setFitsSystemWindows(true);
                PopupWindow popupWindow = new PopupWindow((View) voiceTextPopupWindowContanier, -1, com.tencent.mobileqq.activity.aio.audiopanel.a.d(requireActivity), true);
                popupWindow.setInputMethodMode(1);
                popupWindow.setSoftInputMode(16);
                try {
                    popupWindow.setAttachedInDecor(false);
                    popupWindow.setClippingEnabled(false);
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e("PttPanelVB", 2, th5, new Object[0]);
                    }
                }
                l61.d dVar3 = this.panelManager;
                if (dVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelManager");
                } else {
                    dVar = dVar3;
                }
                this.androidBug5497Workaround = com.tencent.mobileqq.activity.aio.audiopanel.a.b(requireActivity, dVar.a());
                this.popupWindow = popupWindow;
                return;
            }
            return;
        }
        if (this.voice2TextPanelView == null) {
            VoiceTextPopupWindowContanier voiceTextPopupWindowContanier2 = new VoiceTextPopupWindowContanier(getMContext());
            voiceTextPopupWindowContanier2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            l61.d dVar4 = this.panelManager;
            if (dVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelManager");
            } else {
                dVar = dVar4;
            }
            voiceTextPopupWindowContanier2.addView(dVar.a());
            voiceTextPopupWindowContanier2.setFitsSystemWindows(true);
            this.voice2TextPanelView = voiceTextPopupWindowContanier2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(PttPanelVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l61.d dVar = this$0.panelManager;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelManager");
            dVar = null;
        }
        XPanelContainer a16 = dVar.a();
        if (a16 != null) {
            a16.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y1(int state) {
        if (QLog.isColorLevel()) {
            QLog.d("PttPanelVB", 2, "recorderVolumeChange " + state);
        }
        if (state != 0) {
            if (state == 1) {
                if (!isRecording()) {
                    QLog.i("PttPanelVB", 1, "volueme state err" + Build.MANUFACTURER + DeviceInfoMonitor.getModel());
                    return;
                }
                bq bqVar = this.recordToastDialog;
                if (bqVar != null && bqVar.isShowing()) {
                    return;
                }
                bq bqVar2 = new bq(getMContext());
                this.recordToastDialog = bqVar2;
                bqVar2.N(getMContext().getString(R.string.f8u));
                bq bqVar3 = this.recordToastDialog;
                if (bqVar3 != null) {
                    bqVar3.show();
                    return;
                }
                return;
            }
            if (state != 2) {
                return;
            }
        }
        bq bqVar4 = this.recordToastDialog;
        if (bqVar4 != null) {
            Intrinsics.checkNotNull(bqVar4);
            if (bqVar4.isShowing()) {
                bq bqVar5 = this.recordToastDialog;
                Intrinsics.checkNotNull(bqVar5);
                if (bqVar5.getWindow() != null) {
                    bq bqVar6 = this.recordToastDialog;
                    if (bqVar6 != null) {
                        bqVar6.dismiss();
                    }
                    this.recordToastDialog = null;
                }
            }
        }
    }

    @Override // com.tencent.qqnt.aio.audiopanel.m
    public void B(String path, float totalTime, ArrayList<Byte> audioData, RecordParams.RecorderParam param) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(audioData, "audioData");
        Intrinsics.checkNotNullParameter(param, "param");
        l61.d dVar = null;
        if (getMUIModel() != null) {
            FrameworkVM mUIModel = getMUIModel();
            Intrinsics.checkNotNull(mUIModel);
            View requireView = ((com.tencent.aio.api.runtime.a) mUIModel.getMContext()).c().requireView();
            Intrinsics.checkNotNullExpressionValue(requireView, "mUIModel!!.mContext.fragment.requireView()");
            l61.d dVar2 = this.panelManager;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelManager");
                dVar2 = null;
            }
            if (dVar2.a() == null) {
                FrameworkVM mUIModel2 = getMUIModel();
                Intrinsics.checkNotNull(mUIModel2);
                XPanelContainer xPanelContainer = new XPanelContainer(((com.tencent.aio.api.runtime.a) mUIModel2.getMContext()).c().getContext());
                xPanelContainer.c(requireView.findViewById(R.id.input));
                xPanelContainer.setOnPanelChangeListener(this);
                l61.d dVar3 = this.panelManager;
                if (dVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelManager");
                    dVar3 = null;
                }
                dVar3.e(xPanelContainer);
                FrameworkVM mUIModel3 = getMUIModel();
                Intrinsics.checkNotNull(mUIModel3);
                com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) mUIModel3.getMContext();
                l61.d dVar4 = this.panelManager;
                if (dVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelManager");
                    dVar4 = null;
                }
                a61.d dVar5 = new a61.d(aVar, dVar4);
                AppRuntime n16 = n1();
                Intrinsics.checkNotNull(n16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                o oVar = new o(dVar5, (QQAppInterface) n16, this);
                l61.d dVar6 = this.panelManager;
                if (dVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelManager");
                    dVar6 = null;
                }
                dVar6.d(oVar);
            }
            w1();
            G1();
            l61.d dVar7 = this.panelManager;
            if (dVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelManager");
                dVar7 = null;
            }
            o oVar2 = (o) dVar7.b(36);
            if (oVar2 != null) {
                QLog.d("PttPanelVB", 2, "showVoiceTextPanel input height=" + oVar2.h().getHeight() + ", panelLayout height=" + oVar2.i().getHeight());
                XPanelContainer.f384714h0 = oVar2.h().getHeight() + oVar2.i().getHeight() + getMContext().getResources().getDimensionPixelSize(R.dimen.f158195bz2);
            }
        }
        l61.d dVar8 = this.panelManager;
        if (dVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelManager");
            dVar8 = null;
        }
        dVar8.f(36, true);
        l61.d dVar9 = this.panelManager;
        if (dVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelManager");
        } else {
            dVar = dVar9;
        }
        o oVar3 = (o) dVar.b(36);
        if (oVar3 != null) {
            oVar3.g(path, (int) totalTime, param, q1());
        }
    }

    @Override // com.tencent.qqnt.aio.audiopanel.m
    public void C0(String audioPath, float totalTime, ArrayList<Byte> audioData, RecordParams.RecorderParam param, boolean isVoiceChange, boolean isAutoConvertText, int voiceChangeType) {
        Intrinsics.checkNotNullParameter(audioData, "audioData");
        Intrinsics.checkNotNullParameter(param, "param");
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public View E2(int panelId) {
        l61.d dVar = this.panelManager;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelManager");
            dVar = null;
        }
        View E2 = dVar.E2(panelId);
        if (panelId == 2 && E2 == null) {
            QLog.d("PttPanelVB", 1, "onCreatePanel need to show ptt panel");
            FrameworkVM mUIModel = getMUIModel();
            Intrinsics.checkNotNull(mUIModel);
            com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) mUIModel.getMContext()).e();
            if (e16 != null) {
                e16.h(new PanelContainerMsgIntent.ShowPanelMsgIntent("PttPanelVB", 1000, false, 0, 12, null));
            }
        }
        return E2;
    }

    @Override // com.tencent.qqnt.aio.audiopanel.m
    public boolean H0() {
        int D = com.tencent.mobileqq.activity.aio.l.D(getMContext());
        RecordParams.RecorderParam recorderParam = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).getRecorderParam();
        if (!((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).checkExternalStorageForRecord()) {
            QLog.w("PttPanelVB", 1, "[couldStartRecord] insufficient external storage space");
            QQToast.makeText(getMContext(), R.string.f224266ig, 0).show(D);
        } else if (!((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).checkIntenalStorageForRecord(recorderParam.f307257f)) {
            QLog.w("PttPanelVB", 1, "[couldStartRecord] insufficient internal storage space");
            QQToast.makeText(getMContext(), R.string.by8, 0).show(D);
        } else {
            AppRuntime n16 = n1();
            Intrinsics.checkNotNull(n16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            if (((QQAppInterface) n16).isVideoChatting()) {
                QLog.w("PttPanelVB", 1, "[couldStartRecord] isVideoChatting ");
                QQToast.makeText(getMContext(), R.string.f171206d52, 0).show();
            } else {
                if (!AudioUtil.h(1)) {
                    return true;
                }
                QLog.w("PttPanelVB", 1, "[couldStartRecord] meizu forbid");
                ((IPttUtils) QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission(getMContext());
            }
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.audiopanel.m
    public boolean M0() {
        FrameworkVM mUIModel = getMUIModel();
        z zVar = mUIModel instanceof z ? (z) mUIModel : null;
        return zVar != null && zVar.x();
    }

    @Override // com.tencent.qqnt.aio.audiopanel.m
    public void O(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        new File(path).delete();
    }

    @Override // com.tencent.qqnt.aio.audiopanel.m
    public void P0(String audioPath, float totalTime, ArrayList<Byte> audioData, RecordParams.RecorderParam param) {
        Intrinsics.checkNotNullParameter(audioData, "audioData");
        Intrinsics.checkNotNullParameter(param, "param");
        Z(audioPath, totalTime, audioData, param, false, false, 0);
    }

    @Override // com.tencent.qqnt.aio.audiopanel.m
    public void R(boolean bEditState) {
        QLog.d("PttPanelVB", 1, "changePanelUIState " + bEditState);
        sendIntent(new q.PanelUIStateChange(bEditState));
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public boolean T(int panelId) {
        l61.d dVar = this.panelManager;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelManager");
            dVar = null;
        }
        return dVar.T(panelId);
    }

    @Override // com.tencent.qqnt.aio.audiopanel.l
    /* renamed from: a0, reason: from getter */
    public View getVoice2TextPanelView() {
        return this.voice2TextPanelView;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        q.GetAIOTypeIntent getAIOTypeIntent = new q.GetAIOTypeIntent(false);
        sendIntent(getAIOTypeIntent);
        AudioPanel audioPanel = this.panel;
        if (audioPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL);
            audioPanel = null;
        }
        audioPanel.h(getAIOTypeIntent.getIsRobotAIO());
    }

    @Override // com.tencent.qqnt.aio.audiopanel.m
    public int c() {
        int c16;
        AppRuntime n16 = n1();
        Intrinsics.checkNotNull(n16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        int c17 = com.tencent.mobileqq.activity.aio.item.n.c((QQAppInterface) n16, "Normal_MaxPtt") * 1000;
        int privilegeFlags = VasUtil.getSignedService(n1()).getVipStatus().getPrivilegeFlags(null);
        if ((privilegeFlags & 4) != 0) {
            AppRuntime n17 = n1();
            Intrinsics.checkNotNull(n17, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            c16 = com.tencent.mobileqq.activity.aio.item.n.c((QQAppInterface) n17, "SVIP_MaxPtt");
        } else {
            if ((privilegeFlags & 2) != 0) {
                AppRuntime n18 = n1();
                Intrinsics.checkNotNull(n18, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                c16 = com.tencent.mobileqq.activity.aio.item.n.c((QQAppInterface) n18, "VIP_MaxPtt");
            }
            int i3 = c17 + 400;
            r1().sendEmptyMessageDelayed(16711687, i3);
            return i3 + LightConstants.ErrorCode.TEMPLATE_JSON_EMPTY;
        }
        c17 = c16 * 1000;
        int i36 = c17 + 400;
        r1().sendEmptyMessageDelayed(16711687, i36);
        return i36 + LightConstants.ErrorCode.TEMPLATE_JSON_EMPTY;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public BaseVM<q, PttUIState, com.tencent.aio.api.runtime.a> createVM() {
        return new z(this);
    }

    @Override // com.tencent.qqnt.aio.audiopanel.m
    public void g0(String path, final boolean isNoPermission, RecordParams.RecorderParam param) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.u
            @Override // java.lang.Runnable
            public final void run() {
                PttPanelVB.F1(PttPanelVB.this, isNoPermission);
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what != 16711687) {
            return false;
        }
        j(false);
        return true;
    }

    @Override // com.tencent.qqnt.aio.audiopanel.m
    public boolean isRecording() {
        FrameworkVM mUIModel = getMUIModel();
        z zVar = mUIModel instanceof z ? (z) mUIModel : null;
        return zVar != null && zVar.y();
    }

    @Override // com.tencent.qqnt.aio.audiopanel.m
    public void j(boolean sync) {
        l1();
        k1();
        sendIntent(new q.StopRecordEvent(sync));
    }

    @Override // com.tencent.mvi.mvvm.b
    public View onCreateView(com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View inflate = View.inflate(createViewParams.a(), R.layout.gvq, null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.qqnt.aio.audiopanel.AudioPanel");
        AudioPanel audioPanel = (AudioPanel) inflate;
        this.panel = audioPanel;
        if (audioPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL);
            audioPanel = null;
        }
        AppRuntime n16 = n1();
        Intrinsics.checkNotNull(n16, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        audioPanel.u((QQAppInterface) n16, this);
        this.panelManager = new l61.d(createViewParams.a());
        AudioPanel audioPanel2 = this.panel;
        if (audioPanel2 != null) {
            return audioPanel2;
        }
        Intrinsics.throwUninitializedPropertyAccessException(WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL);
        return null;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        z1();
        AudioPanel audioPanel = this.panel;
        l61.d dVar = null;
        if (audioPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL);
            audioPanel = null;
        }
        audioPanel.y();
        l61.d dVar2 = this.panelManager;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelManager");
        } else {
            dVar = dVar2;
        }
        o oVar = (o) dVar.b(36);
        if (oVar != null) {
            oVar.e();
        }
        com.tencent.mobileqq.activity.aio.audiopanel.a aVar = this.androidBug5497Workaround;
        if (aVar != null) {
            aVar.e();
        }
        p1().clear();
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public void onPanelChanged(int oldPanel, int newPanel) {
        QLog.d("PttPanelVB", 1, "onPanelChanged[" + oldPanel + "->" + newPanel + "]");
        l61.d dVar = null;
        if (oldPanel == 1 && newPanel == 0) {
            l61.d dVar2 = this.panelManager;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelManager");
                dVar2 = null;
            }
            XPanelContainer a16 = dVar2.a();
            if (a16 != null) {
                a16.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        PttPanelVB.x1(PttPanelVB.this);
                    }
                });
            }
        } else if (oldPanel == 36 && newPanel != 36 && newPanel != 1 && newPanel != 0) {
            u1();
        }
        l61.d dVar3 = this.panelManager;
        if (dVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelManager");
        } else {
            dVar = dVar3;
        }
        dVar.onPanelChanged(oldPanel, newPanel);
    }

    @Override // com.tencent.qqnt.aio.audiopanel.m
    public void r(boolean bEditState) {
        QLog.d("PttPanelVB", 1, "changePanelBlurViewState " + bEditState);
        sendIntent(new q.PanelBlurViewChange(bEditState));
    }

    @Override // com.tencent.qqnt.aio.audiopanel.m
    public void s0(d.a listener, RecordParams.RecorderParam param) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(param, "param");
        String transferFilePath = TransFileUtil.getTransferFilePath(n1().getCurrentAccountUin(), null, 2, null, false);
        this.audioPath = transferFilePath;
        String localFilePath = MessageForPtt.getLocalFilePath(param.f307257f, transferFilePath);
        if (!Intrinsics.areEqual(this.audioPath, localFilePath)) {
            String str = this.audioPath;
            Intrinsics.checkNotNull(str);
            new File(str).deleteOnExit();
            this.audioPath = localFilePath;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PttPanelVB", 2, "path: " + this.audioPath);
        }
        r1().removeMessages(16711687);
        A1();
        c cVar = new c(listener, this, param);
        String str2 = this.audioPath;
        Intrinsics.checkNotNull(str2);
        sendIntent(new q.StartRecordEvent(str2, cVar, param));
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(PttUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        l61.d dVar = null;
        AudioPanel audioPanel = null;
        if (state instanceof PttUIState.OnBackStace) {
            if (QLog.isColorLevel()) {
                QLog.d("PttPanelVB", 2, "on backevent");
            }
            PttUIState.OnBackStace onBackStace = (PttUIState.OnBackStace) state;
            AudioPanel audioPanel2 = this.panel;
            if (audioPanel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL);
            } else {
                audioPanel = audioPanel2;
            }
            onBackStace.b(audioPanel.x());
            u1();
            return;
        }
        if (state instanceof PttUIState.OnPauseState) {
            AudioPanel audioPanel3 = this.panel;
            if (audioPanel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL);
                audioPanel3 = null;
            }
            audioPanel3.C();
            l61.d dVar2 = this.panelManager;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelManager");
            } else {
                dVar = dVar2;
            }
            o oVar = (o) dVar.b(36);
            if (oVar != null) {
                oVar.f();
                return;
            }
            return;
        }
        if (state instanceof PttUIState.OnHidePanel) {
            QLog.d("PttPanelVB", 2, "on OnHidePanel");
            PopupWindow r16 = AudioPanel.r();
            if (r16 != null) {
                r16.dismiss();
            }
            R(false);
        }
    }

    @Override // com.tencent.qqnt.aio.audiopanel.m
    public void sendMessage(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        sendIntent(new q.SendTextIntent(text));
    }

    @Override // com.tencent.qqnt.aio.audiopanel.m
    public int v() {
        FrameworkVM mUIModel = getMUIModel();
        z zVar = mUIModel instanceof z ? (z) mUIModel : null;
        if (zVar != null) {
            return zVar.q() - getMContext().getResources().getDimensionPixelSize(R.dimen.f158195bz2);
        }
        return 0;
    }

    public void z1() {
        sendIntent(q.h.f349718d);
    }

    @Override // com.tencent.widget.XPanelContainer.g
    public void E() {
        QLog.d("PttPanelVB", 1, "onHideAllPanel");
        u1();
        l61.d dVar = this.panelManager;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelManager");
            dVar = null;
        }
        dVar.E();
    }

    @Override // com.tencent.qqnt.aio.audiopanel.m
    public void W0() {
        I0(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Long] */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.Long] */
    @Override // com.tencent.qqnt.aio.audiopanel.m
    public void Z(final String audioPath, final float totalTime, ArrayList<Byte> audioData, RecordParams.RecorderParam param, final boolean isVoiceChange, boolean isAutoConvertText, int voiceChangeType) {
        Intrinsics.checkNotNullParameter(audioData, "audioData");
        Intrinsics.checkNotNullParameter(param, "param");
        AudioUtil.n(R.raw.f169415m, false);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (m1()) {
            objectRef.element = o1(param);
            Intrinsics.checkNotNull(audioPath);
            sendIntent(new q.SendIntent(audioPath, totalTime, param.f307257f, audioData, isVoiceChange, isAutoConvertText, voiceChangeType, (Long) objectRef.element));
        } else {
            objectRef.element = this.mPttFakeMsgId;
            Intrinsics.checkNotNull(audioPath);
            sendIntent(new q.SendIntent(audioPath, totalTime, param.f307257f, audioData, isVoiceChange, isAutoConvertText, voiceChangeType, this.mPttFakeMsgId));
            this.mPttFakeMsgId = null;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.t
            @Override // java.lang.Runnable
            public final void run() {
                PttPanelVB.B1(audioPath, totalTime, objectRef, isVoiceChange);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qqnt.aio.audiopanel.m
    public void I0(RecordParams.RecorderParam recordParam) {
    }
}
