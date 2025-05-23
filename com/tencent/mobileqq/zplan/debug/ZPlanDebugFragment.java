package com.tencent.mobileqq.zplan.debug;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.aio.guidance.ZPlanMiniHomeGuidanceDialog;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.bubble.ZPlanMiniHomeGuidanceBubbleViewController;
import com.tencent.mobileqq.zplan.easteregg.PortraitSource;
import com.tencent.mobileqq.zplan.easteregg.model.ErrorMsg;
import com.tencent.mobileqq.zplan.easteregg.model.PortraitQueryType;
import com.tencent.mobileqq.zplan.minihome.MiniHomeSceneEnum;
import com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper;
import com.tencent.mobileqq.zplan.minihome.api.impl.MiniHomeHelperImpl;
import com.tencent.mobileqq.zplan.minixwconnected.AIOMiniHomeConnectedEntranceHelper;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.view.page.PortalStoreSectionPanelPage;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.meme.Priority;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u0092\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0093\u0001B\t\u00a2\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J&\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\u001a\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J$\u0010\u0019\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001aH\u0016J8\u0010#\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u001dH\u0002J\u0012\u0010&\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010$H\u0002J\b\u0010'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J\b\u0010)\u001a\u00020\u000bH\u0002J\n\u0010*\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u001dH\u0002J\b\u0010-\u001a\u00020\u000bH\u0002J\b\u0010.\u001a\u00020\u000bH\u0002R\u0014\u00101\u001a\u00020\u001d8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001a\u00020\u001d8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00106R\u0018\u0010=\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00106R\u0018\u0010?\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00106R\u0018\u0010A\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00106R\u0018\u0010C\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u00106R\u0018\u0010E\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u00106R\u0018\u0010G\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u00106R\u0018\u0010I\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u00106R\u0018\u0010K\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u00106R\u0018\u0010M\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u00106R\u0018\u0010O\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u00106R\u0018\u0010Q\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u00106R\u0018\u0010S\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u00106R\u0018\u0010U\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u00106R\u0018\u0010W\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u00106R\u0018\u0010Y\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u00106R\u0018\u0010[\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u00106R\u0018\u0010]\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u00106R\u0018\u0010_\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u00106R\u0018\u0010a\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u00106R\u0018\u0010c\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u00106R\u0018\u0010g\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010i\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u00106R\u0018\u0010k\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u00106R\u0018\u0010m\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u00106R\u0018\u0010o\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u00106R\u0014\u0010s\u001a\u00020p8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010u\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u00106R\u0018\u0010w\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u00106R\u0018\u0010y\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u00106R\u0018\u0010{\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u00106R\u0018\u0010}\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u00106R\u0018\u0010\u007f\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u00106R\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u00106R\u001a\u0010\u0083\u0001\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0082\u0001\u0010fR\u001a\u0010\u0085\u0001\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0084\u0001\u0010fR\u001a\u0010\u0087\u0001\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0086\u0001\u0010fR\u001a\u0010\u0089\u0001\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0088\u0001\u0010fR\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001a\u0010\u008f\u0001\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008e\u0001\u00106\u00a8\u0006\u0094\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/debug/ZPlanDebugFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Landroid/view/View$OnClickListener;", "Landroid/widget/TextView$OnEditorActionListener;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreateView", "", "getContentLayoutId", "Landroid/widget/CompoundButton;", "buttonView", "", "isChecked", "onCheckedChanged", "Landroid/widget/TextView;", "v", "actionId", "Landroid/view/KeyEvent;", "event", "onEditorAction", "Landroid/view/View;", NodeProps.ON_CLICK, "id", "", "uin", "appearanceKey", "width", "height", "scene", "ii", "Landroid/app/Activity;", "context", "di", "Jh", "Kh", "ci", "getUin", "content", WidgetCacheLunarData.JI, "Mh", "Lh", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "TAG", "D", "RESOURCE_SAVE_PATH", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "E", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "forceAccessibleItem", UserInfo.SEX_FEMALE, "forceAIGC20AccessibleItem", "G", "uploadAvatarJsonItem", "H", "zplanPreloadProcessItem", "I", "zplanPreloadSwitchItem", "J", "zplanPreloadKillItem", "K", "forceCloseZPlan", "L", "enableUEHotPatch", "M", "debugForceLowQQVersion", "N", "showDebugStoreInfo", "P", "showDebugAllDyeingCloth", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "hideOutfitPreviewChangePoseBtn", BdhLogUtil.LogTag.Tag_Req, "forceHideLoading", ExifInterface.LATITUDE_SOUTH, "forceUseFilamentAvatar", "T", "forceUseUEAvatar", "U", "forceUseFilamentRecord", "V", "forceUseUERecord", "W", "enablePortalShadow", "X", "paralleWorldItem", "Y", "preloadWorldItem", "Z", "gameInMainWorldItem", "a0", "gameUseSurfaceViewItem", "b0", "chatAioItem", "Landroid/widget/EditText;", "c0", "Landroid/widget/EditText;", "avatarBubbleDebugItem", "d0", "qzoneConciseDynamicAvatarItem", "e0", "aioEmoticon2DGif", "f0", "avatarRecordUseClound", "g0", "emoticonRecordUseClound", "Ldc4/a;", "h0", "Ldc4/a;", "repository", "i0", "zplanEnableFilament", "j0", "zplanEnableJsFilament", "k0", "zplanEnableNativeFilament", "l0", "zplanEnableFilamentSaveInSdcard", "m0", "zplanForceShowMiniHomeGuidanceBubble", "n0", "zplanCleanMiniHomeEntranceBubbleShown", "o0", "zplanForceAioDisableMiniHomeEntrance", "p0", "emoticonRecordWidth", "q0", "emoticonRecordHeight", "r0", "emoticonEncodeWidth", "s0", "emoticonEncodeHeight", "Landroid/widget/Button;", "t0", "Landroid/widget/Button;", "emoticonSizeConfirmButton", "u0", "msfChannelSaveFile", "<init>", "()V", "v0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanDebugFragment extends QIphoneTitleBarFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, TextView.OnEditorActionListener {

    /* renamed from: E, reason: from kotlin metadata */
    private FormSwitchItem forceAccessibleItem;

    /* renamed from: F, reason: from kotlin metadata */
    private FormSwitchItem forceAIGC20AccessibleItem;

    /* renamed from: G, reason: from kotlin metadata */
    private FormSwitchItem uploadAvatarJsonItem;

    /* renamed from: H, reason: from kotlin metadata */
    private FormSwitchItem zplanPreloadProcessItem;

    /* renamed from: I, reason: from kotlin metadata */
    private FormSwitchItem zplanPreloadSwitchItem;

    /* renamed from: J, reason: from kotlin metadata */
    private FormSwitchItem zplanPreloadKillItem;

    /* renamed from: K, reason: from kotlin metadata */
    private FormSwitchItem forceCloseZPlan;

    /* renamed from: L, reason: from kotlin metadata */
    private FormSwitchItem enableUEHotPatch;

    /* renamed from: M, reason: from kotlin metadata */
    private FormSwitchItem debugForceLowQQVersion;

    /* renamed from: N, reason: from kotlin metadata */
    private FormSwitchItem showDebugStoreInfo;

    /* renamed from: P, reason: from kotlin metadata */
    private FormSwitchItem showDebugAllDyeingCloth;

    /* renamed from: Q, reason: from kotlin metadata */
    private FormSwitchItem hideOutfitPreviewChangePoseBtn;

    /* renamed from: R, reason: from kotlin metadata */
    private FormSwitchItem forceHideLoading;

    /* renamed from: S, reason: from kotlin metadata */
    private FormSwitchItem forceUseFilamentAvatar;

    /* renamed from: T, reason: from kotlin metadata */
    private FormSwitchItem forceUseUEAvatar;

    /* renamed from: U, reason: from kotlin metadata */
    private FormSwitchItem forceUseFilamentRecord;

    /* renamed from: V, reason: from kotlin metadata */
    private FormSwitchItem forceUseUERecord;

    /* renamed from: W, reason: from kotlin metadata */
    private FormSwitchItem enablePortalShadow;

    /* renamed from: X, reason: from kotlin metadata */
    private FormSwitchItem paralleWorldItem;

    /* renamed from: Y, reason: from kotlin metadata */
    private FormSwitchItem preloadWorldItem;

    /* renamed from: Z, reason: from kotlin metadata */
    private FormSwitchItem gameInMainWorldItem;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private FormSwitchItem gameUseSurfaceViewItem;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private FormSwitchItem chatAioItem;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private EditText avatarBubbleDebugItem;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private FormSwitchItem qzoneConciseDynamicAvatarItem;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private FormSwitchItem aioEmoticon2DGif;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private FormSwitchItem avatarRecordUseClound;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private FormSwitchItem emoticonRecordUseClound;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private FormSwitchItem zplanEnableFilament;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private FormSwitchItem zplanEnableJsFilament;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private FormSwitchItem zplanEnableNativeFilament;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private FormSwitchItem zplanEnableFilamentSaveInSdcard;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private FormSwitchItem zplanForceShowMiniHomeGuidanceBubble;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private FormSwitchItem zplanCleanMiniHomeEntranceBubbleShown;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private FormSwitchItem zplanForceAioDisableMiniHomeEntrance;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private EditText emoticonRecordWidth;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private EditText emoticonRecordHeight;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private EditText emoticonEncodeWidth;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private EditText emoticonEncodeHeight;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private Button emoticonSizeConfirmButton;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private FormSwitchItem msfChannelSaveFile;

    /* renamed from: C, reason: from kotlin metadata */
    private final String TAG = "[zplan]ZPlanDebugFragment";

    /* renamed from: D, reason: from kotlin metadata */
    private final String RESOURCE_SAVE_PATH = "/sdcard/Android/data/com.tencent.mobileqq/cache/zplan/.filament";

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final dc4.a repository = new dc4.b(ZootopiaSource.INSTANCE.g());

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/debug/ZPlanDebugFragment$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lxv4/c;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<xv4.c> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(xv4.c result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QQToast.makeText(ZPlanDebugFragment.this.getContext(), 2, "\u6e05\u7406\u4efb\u52a1\u7cfb\u7edf\u6570\u636e\u6210\u529f", 0).show();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QQToast.makeText(ZPlanDebugFragment.this.getContext(), 1, "\u6e05\u7406\u4efb\u52a1\u7cfb\u7edf\u6570\u636e\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5", 0).show();
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/zplan/debug/ZPlanDebugFragment$c", "Lcom/tencent/mobileqq/zplan/easteregg/t;", "Lcom/tencent/mobileqq/zplan/easteregg/PortraitSource;", "source", "", "", "idList", "", "pathList", "msg", "", "a", "Lcom/tencent/mobileqq/zplan/easteregg/model/e;", "errMsg", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zplan.easteregg.t {
        c() {
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.t
        public void a(PortraitSource source, List<Integer> idList, List<String> pathList, String msg2) {
            Intrinsics.checkNotNullParameter(source, "source");
            QLog.d("saraTest", 1, "ZPlanDebugFragment, onResource, source: " + source + ", id: " + idList + ", path: " + pathList + ", msg: " + msg2);
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.t
        public void b(ErrorMsg errMsg) {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }
    }

    private final void Jh() {
        this.repository.g(new b());
    }

    private final String Kh() {
        return "/sdcard/DCIM/Screenshots/test.png";
    }

    private final void Lh() {
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString("zplan_emoticon_debug_record_encode_size", "");
        Toast.makeText(getContext(), "\u6e05\u9664ZPlan\u8868\u60c5size\u7684MMKV\u5b58\u50a8\u6210\u529f", 1).show();
        QLog.i(this.TAG, 1, "doOnClickEmoticonSizeClear done.");
    }

    private final void Mh() {
        Editable text;
        String obj;
        Editable text2;
        String obj2;
        Editable text3;
        String obj3;
        Editable text4;
        String obj4;
        EditText editText = this.emoticonRecordWidth;
        if (editText == null || (text = editText.getText()) == null || (obj = text.toString()) == null) {
            return;
        }
        int parseInt = Integer.parseInt(obj);
        EditText editText2 = this.emoticonEncodeHeight;
        if (editText2 == null || (text2 = editText2.getText()) == null || (obj2 = text2.toString()) == null) {
            return;
        }
        int parseInt2 = Integer.parseInt(obj2);
        EditText editText3 = this.emoticonEncodeWidth;
        if (editText3 == null || (text3 = editText3.getText()) == null || (obj3 = text3.toString()) == null) {
            return;
        }
        int parseInt3 = Integer.parseInt(obj3);
        EditText editText4 = this.emoticonEncodeHeight;
        if (editText4 == null || (text4 = editText4.getText()) == null || (obj4 = text4.toString()) == null) {
            return;
        }
        int parseInt4 = Integer.parseInt(obj4);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(QzoneCameraConst.Tag.ARG_PARAM_RECORD_WIDTH, parseInt);
        jSONObject.put(QzoneCameraConst.Tag.ARG_PARAM_RECORD_HEIGHT, parseInt2);
        jSONObject.put("encode_width", parseInt3);
        jSONObject.put("encode_height", parseInt4);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ght)\n        }.toString()");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString("zplan_emoticon_debug_record_encode_size", jSONObject2);
        Toast.makeText(getContext(), "\u8bbe\u7f6eZPlan\u8868\u60c5size\u6210\u529f\uff0c\u8bf7\u66f4\u6362\u88c5\u626e\uff0c\u91cd\u65b0\u89e6\u53d1\u8868\u60c5\u5f55\u5236", 1).show();
        QLog.i(this.TAG, 1, "doOnClickEmoticonSizeConfirm setMMKV done, recordWidth: " + parseInt + ", recordHeight: " + parseInt2 + ", encodeWidth: " + parseInt3 + ", encodeHeight: " + parseInt4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(CompoundButton compoundButton, boolean z16) {
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean("zplan_share_card_debug_panel", z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(ZPlanDebugFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        jj3.c.a(this$0.getActivity(), 145, this$0.Kh());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(ZPlanDebugFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        jj3.c.a(this$0.getActivity(), 144, this$0.Kh());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(ZPlanDebugFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.di(this$0.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(ZPlanDebugFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Jh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(ZPlanDebugFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaSource d16 = ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.Demo, ZootopiaSource.SUB_SOURCE_ENTRANCE_PROFILE, null, 4, null);
        QRouteApi api = QRoute.api(IZootopiaApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaApi::class.java)");
        IZootopiaApi iZootopiaApi = (IZootopiaApi) api;
        Context context = this$0.getContext();
        if (context == null) {
            context = BaseApplication.context;
        }
        Context context2 = context;
        Intrinsics.checkNotNullExpressionValue(context2, "context ?: BaseApplication.context");
        IZootopiaApi.a.b(iZootopiaApi, context2, d16, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(View view) {
        PortalStoreSectionPanelPage.INSTANCE.b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(ZPlanDebugFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String uin = this$0.getUin();
        if (uin == null) {
            uin = "1076717903";
        }
        String str = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(uin).appearanceKey;
        String str2 = this$0.TAG;
        String str3 = uin;
        this$0.ii(35, str3, str, 187, 187, str2);
        this$0.ii(38, str3, str, 187, 187, str2);
        this$0.ii(41, str3, str, 187, 187, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(View view) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.debug.j
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanDebugFragment.Wh();
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh() {
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).setZPlanEmoticonGrayTipsMMKV("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(Button button, View view) {
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setLong(currentUin + "_zplan_create_role_guide_click_time", 0L);
        QQToast.makeText(button.getContext(), 2, "\u6e05\u7406\u6210\u529f", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(ZPlanDebugFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(MiniHomeHelperImpl.SAVE_ROOM_KEY, "");
        String uin = this$0.getUin();
        if (uin != null) {
            ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).setTemporaryRoomDesc(uin, null);
            ((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).setStaticImagePath(uin, MiniHomeSceneEnum.SCENE_PROFILE, "", "");
        }
        ZPlanMiniHomeGuidanceBubbleViewController.Companion companion = ZPlanMiniHomeGuidanceBubbleViewController.INSTANCE;
        companion.i(0);
        companion.h(0L);
        ZPlanMiniHomeGuidanceDialog.Companion companion2 = ZPlanMiniHomeGuidanceDialog.INSTANCE;
        companion2.d("");
        companion2.e(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(ZPlanDebugFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
        if (f16 != null) {
            CorountineFunKt.e(f16, this$0.TAG + "_fetchMyAvatarInfo", null, null, null, new ZPlanDebugFragment$doOnCreateView$4$1(this$0, null), 14, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(ZPlanDebugFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            this$0.Mh();
        } catch (Throwable th5) {
            QLog.e(this$0.TAG, 1, "doOnClickEmoticonSizeConfirm failed.", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(ZPlanDebugFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Lh();
    }

    private final void ci() {
        String uin = getUin();
        if (uin == null || uin.length() == 0) {
            QLog.e(this.TAG, 1, "zplanEntrySwitch initSwitchState  uin invalid");
        }
        FormSwitchItem formSwitchItem = this.zplanPreloadProcessItem;
        if (formSwitchItem != null) {
            formSwitchItem.setChecked(j74.a.b(j74.a.f409621a, uin, "zplan_preload_process_enable", false, 4, null));
        }
        FormSwitchItem formSwitchItem2 = this.zplanPreloadSwitchItem;
        if (formSwitchItem2 != null) {
            formSwitchItem2.setChecked(j74.a.b(j74.a.f409621a, uin, "zplan_preload_enable", false, 4, null));
        }
        FormSwitchItem formSwitchItem3 = this.zplanPreloadKillItem;
        if (formSwitchItem3 != null) {
            formSwitchItem3.setChecked(j74.a.b(j74.a.f409621a, uin, "zplan_preload_kill", false, 4, null));
        }
        FormSwitchItem formSwitchItem4 = this.chatAioItem;
        if (formSwitchItem4 != null) {
            formSwitchItem4.setChecked(j74.a.b(j74.a.f409621a, uin, "zplan_chat_aio", false, 4, null));
        }
        EditText editText = this.avatarBubbleDebugItem;
        if (editText != null) {
            editText.setText(j74.a.d(j74.a.f409621a, uin, "zplan_avatar_bubble_debug", null, 4, null));
        }
        FormSwitchItem formSwitchItem5 = this.forceAccessibleItem;
        if (formSwitchItem5 != null) {
            formSwitchItem5.setChecked(uk3.i.f439124a.d());
        }
        FormSwitchItem formSwitchItem6 = this.forceAIGC20AccessibleItem;
        if (formSwitchItem6 != null) {
            formSwitchItem6.setChecked(uk3.i.f439124a.c());
        }
        FormSwitchItem formSwitchItem7 = this.uploadAvatarJsonItem;
        if (formSwitchItem7 != null) {
            formSwitchItem7.setChecked(uk3.i.f439124a.e());
        }
        FormSwitchItem formSwitchItem8 = this.paralleWorldItem;
        if (formSwitchItem8 != null) {
            formSwitchItem8.setChecked(j74.a.f409621a.a(uin, "zplan_paralle_world", false));
        }
        FormSwitchItem formSwitchItem9 = this.preloadWorldItem;
        if (formSwitchItem9 != null) {
            formSwitchItem9.setChecked(j74.a.f409621a.a(uin, "zplan_preload_world", false));
        }
        FormSwitchItem formSwitchItem10 = this.gameInMainWorldItem;
        if (formSwitchItem10 != null) {
            formSwitchItem10.setChecked(j74.a.f409621a.a(uin, "zplan_game_in_main_world", false));
        }
        FormSwitchItem formSwitchItem11 = this.gameUseSurfaceViewItem;
        if (formSwitchItem11 != null) {
            formSwitchItem11.setChecked(j74.a.f409621a.a(uin, "zplan_game_use_surfaceview", true));
        }
        FormSwitchItem formSwitchItem12 = this.qzoneConciseDynamicAvatarItem;
        if (formSwitchItem12 != null) {
            formSwitchItem12.setChecked(j74.a.b(j74.a.f409621a, uin, "zplan_qzone_concise_dynamic_avatar", false, 4, null));
        }
        FormSwitchItem formSwitchItem13 = this.forceCloseZPlan;
        if (formSwitchItem13 != null) {
            formSwitchItem13.setChecked(j74.a.f409621a.a(uin, "zplan_force_close_ue", false));
        }
        FormSwitchItem formSwitchItem14 = this.forceHideLoading;
        if (formSwitchItem14 != null) {
            formSwitchItem14.setChecked(j74.a.f409621a.a(uin, "zplan_force_hide_loading", false));
        }
        FormSwitchItem formSwitchItem15 = this.forceUseFilamentAvatar;
        if (formSwitchItem15 != null) {
            formSwitchItem15.setChecked(j74.a.f409621a.a(uin, "zplan_force_filament_avatar", true));
        }
        FormSwitchItem formSwitchItem16 = this.forceUseUEAvatar;
        if (formSwitchItem16 != null) {
            formSwitchItem16.setChecked(!j74.a.f409621a.a(uin, "zplan_force_filament_avatar", true));
        }
        FormSwitchItem formSwitchItem17 = this.forceUseFilamentRecord;
        if (formSwitchItem17 != null) {
            formSwitchItem17.setChecked(j74.a.f409621a.a(uin, "zplan_force_filament_record", true));
        }
        FormSwitchItem formSwitchItem18 = this.forceUseUERecord;
        if (formSwitchItem18 != null) {
            formSwitchItem18.setChecked(j74.a.f409621a.a(uin, "zplan_force_ue_record", false));
        }
        FormSwitchItem formSwitchItem19 = this.enablePortalShadow;
        if (formSwitchItem19 != null) {
            formSwitchItem19.setChecked(j74.a.f409621a.a(uin, "zplan_portal_enable_shadow", true));
        }
        FormSwitchItem formSwitchItem20 = this.enableUEHotPatch;
        if (formSwitchItem20 != null) {
            formSwitchItem20.setChecked(j74.a.f409621a.a(uin, "zplan_dev_enable_ue_hotpatch", false));
        }
        FormSwitchItem formSwitchItem21 = this.debugForceLowQQVersion;
        if (formSwitchItem21 != null) {
            formSwitchItem21.setChecked(j74.a.f409621a.a(uin, "zplan_dev_force_low_version", false));
        }
        FormSwitchItem formSwitchItem22 = this.showDebugStoreInfo;
        if (formSwitchItem22 != null) {
            formSwitchItem22.setChecked(j74.a.f409621a.a(uin, "zplan_dev_show_store_info", false));
        }
        FormSwitchItem formSwitchItem23 = this.showDebugAllDyeingCloth;
        if (formSwitchItem23 != null) {
            formSwitchItem23.setChecked(j74.a.f409621a.a(uin, "zplan_dev_show_dyeing_clothes", false));
        }
        FormSwitchItem formSwitchItem24 = this.hideOutfitPreviewChangePoseBtn;
        if (formSwitchItem24 != null) {
            formSwitchItem24.setChecked(j74.a.f409621a.a(uin, "zplan_dev_hide_outfit_preview_pose_button", false));
        }
        FormSwitchItem formSwitchItem25 = this.aioEmoticon2DGif;
        if (formSwitchItem25 != null) {
            formSwitchItem25.setChecked(j74.a.f409621a.a(uin, "zplan_aio_emoticon_2d_gif_type", true));
        }
        FormSwitchItem formSwitchItem26 = this.avatarRecordUseClound;
        if (formSwitchItem26 != null) {
            formSwitchItem26.setChecked(j74.a.f409621a.a(uin, "zplan_avatar_record_use_cloud", true));
        }
        FormSwitchItem formSwitchItem27 = this.emoticonRecordUseClound;
        if (formSwitchItem27 != null) {
            formSwitchItem27.setChecked(j74.a.f409621a.a(uin, "zplan_emoticon_record_use_cloud", true));
        }
        FormSwitchItem formSwitchItem28 = this.zplanEnableFilament;
        if (formSwitchItem28 != null) {
            formSwitchItem28.setChecked(j74.a.f409621a.a(uin, "zplan_enable_filament", false));
        }
        FormSwitchItem formSwitchItem29 = this.zplanEnableJsFilament;
        if (formSwitchItem29 != null) {
            formSwitchItem29.setChecked(j74.a.f409621a.a(uin, "zplan_enable_js_filament", false));
        }
        FormSwitchItem formSwitchItem30 = this.zplanEnableNativeFilament;
        if (formSwitchItem30 != null) {
            formSwitchItem30.setChecked(j74.a.f409621a.a(uin, "zplan_enable_native_filament", false));
        }
        FormSwitchItem formSwitchItem31 = this.zplanEnableFilamentSaveInSdcard;
        if (formSwitchItem31 != null) {
            formSwitchItem31.setChecked(j74.a.f409621a.a(uin, "zplan_enable_filament_save_in_sdcard", false));
        }
        FormSwitchItem formSwitchItem32 = this.zplanForceShowMiniHomeGuidanceBubble;
        if (formSwitchItem32 != null) {
            formSwitchItem32.setChecked(ZPlanMiniHomeGuidanceBubbleViewController.INSTANCE.c());
        }
        FormSwitchItem formSwitchItem33 = this.zplanCleanMiniHomeEntranceBubbleShown;
        if (formSwitchItem33 != null) {
            formSwitchItem33.setChecked(AIOMiniHomeConnectedEntranceHelper.INSTANCE.b());
        }
        FormSwitchItem formSwitchItem34 = this.zplanForceAioDisableMiniHomeEntrance;
        if (formSwitchItem34 != null) {
            formSwitchItem34.setChecked(AIOMiniHomeConnectedEntranceHelper.INSTANCE.a());
        }
        FormSwitchItem formSwitchItem35 = this.msfChannelSaveFile;
        if (formSwitchItem35 == null) {
            return;
        }
        formSwitchItem35.setChecked(j74.a.f409621a.a(uin, "msf_channel_save_file", false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(ZPlanDebugFragment this$0, boolean z16, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        j74.a.f409621a.e(this$0.getUin(), z16, "zplan_paralle_world");
        QQAppInterface l3 = bb.f335811a.l();
        if (l3 != null) {
            l3.exit(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final String getUin() {
        return MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(ZPlanDebugFragment this$0, boolean z16, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        j74.a.f409621a.e(this$0.getUin(), z16, "zplan_force_close_ue");
        QQAppInterface l3 = bb.f335811a.l();
        if (l3 != null) {
            l3.exit(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void ii(int id5, String uin, String appearanceKey, int width, int height, String scene) {
        List mutableListOf;
        Integer valueOf = Integer.valueOf(id5);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(35, 38, 41);
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).getEasterEggPortraitResource(new com.tencent.mobileqq.zplan.easteregg.model.d(valueOf, mutableListOf, PortraitQueryType.SINGLE_QUERY, appearanceKey, uin, width, height, scene, false, AppTheme.DAY, null, Priority.HIGH), new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0043 -> B:12:0x0075). Please report as a decompilation issue!!! */
    public final void ji(String content) {
        File file = new File(this.RESOURCE_SAVE_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        BufferedWriter bufferedWriter = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(this.RESOURCE_SAVE_PATH + "/avatar_info.json"), false)));
                try {
                    bufferedWriter2.write(content);
                    bufferedWriter2.close();
                } catch (FileNotFoundException e17) {
                    e = e17;
                    bufferedWriter = bufferedWriter2;
                    QLog.e(this.TAG, 1, "create file failed!");
                    e.printStackTrace();
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                } catch (IOException e18) {
                    e = e18;
                    bufferedWriter = bufferedWriter2;
                    QLog.e(this.TAG, 1, "write file failed!");
                    e.printStackTrace();
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e26) {
                e = e26;
            } catch (IOException e27) {
                e = e27;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126767pn);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        this.zplanPreloadProcessItem = (FormSwitchItem) findViewById;
        View findViewById2 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126777po);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        this.zplanPreloadSwitchItem = (FormSwitchItem) findViewById2;
        View findViewById3 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126757pm);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        this.zplanPreloadKillItem = (FormSwitchItem) findViewById3;
        View findViewById4 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126497ox);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        this.forceCloseZPlan = (FormSwitchItem) findViewById4;
        View findViewById5 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126507oy);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        this.forceHideLoading = (FormSwitchItem) findViewById5;
        View findViewById6 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126537p1);
        Intrinsics.checkNotNull(findViewById6, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        this.forceUseFilamentAvatar = (FormSwitchItem) findViewById6;
        View findViewById7 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126557p3);
        Intrinsics.checkNotNull(findViewById7, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        this.forceUseUEAvatar = (FormSwitchItem) findViewById7;
        View findViewById8 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126547p2);
        Intrinsics.checkNotNull(findViewById8, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        this.forceUseFilamentRecord = (FormSwitchItem) findViewById8;
        View findViewById9 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126567p4);
        Intrinsics.checkNotNull(findViewById9, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        this.forceUseUERecord = (FormSwitchItem) findViewById9;
        View findViewById10 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126417op);
        Intrinsics.checkNotNull(findViewById10, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        this.enablePortalShadow = (FormSwitchItem) findViewById10;
        View findViewById11 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126307oe);
        Intrinsics.checkNotNull(findViewById11, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem = (FormSwitchItem) findViewById11;
        this.enableUEHotPatch = formSwitchItem;
        if (formSwitchItem != null) {
            formSwitchItem.setOnCheckedChangeListener(this);
        }
        FormSwitchItem formSwitchItem2 = this.zplanPreloadProcessItem;
        if (formSwitchItem2 != null) {
            formSwitchItem2.setOnCheckedChangeListener(this);
        }
        FormSwitchItem formSwitchItem3 = this.zplanPreloadSwitchItem;
        if (formSwitchItem3 != null) {
            formSwitchItem3.setOnCheckedChangeListener(this);
        }
        FormSwitchItem formSwitchItem4 = this.zplanPreloadKillItem;
        if (formSwitchItem4 != null) {
            formSwitchItem4.setOnCheckedChangeListener(this);
        }
        View findViewById12 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126517oz);
        Intrinsics.checkNotNull(findViewById12, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem5 = (FormSwitchItem) findViewById12;
        this.debugForceLowQQVersion = formSwitchItem5;
        if (formSwitchItem5 != null) {
            formSwitchItem5.setOnCheckedChangeListener(this);
        }
        View findViewById13 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126857pw);
        Intrinsics.checkNotNull(findViewById13, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem6 = (FormSwitchItem) findViewById13;
        this.showDebugStoreInfo = formSwitchItem6;
        if (formSwitchItem6 != null) {
            formSwitchItem6.setOnCheckedChangeListener(this);
        }
        View findViewById14 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126847pv);
        Intrinsics.checkNotNull(findViewById14, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem7 = (FormSwitchItem) findViewById14;
        this.showDebugAllDyeingCloth = formSwitchItem7;
        if (formSwitchItem7 != null) {
            formSwitchItem7.setOnCheckedChangeListener(this);
        }
        View findViewById15 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126707ph);
        Intrinsics.checkNotNull(findViewById15, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem8 = (FormSwitchItem) findViewById15;
        this.hideOutfitPreviewChangePoseBtn = formSwitchItem8;
        if (formSwitchItem8 != null) {
            formSwitchItem8.setOnCheckedChangeListener(this);
        }
        View findViewById16 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126467ou);
        Intrinsics.checkNotNull(findViewById16, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem9 = (FormSwitchItem) findViewById16;
        this.forceAccessibleItem = formSwitchItem9;
        if (formSwitchItem9 != null) {
            formSwitchItem9.setOnCheckedChangeListener(this);
        }
        View findViewById17 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126477ov);
        Intrinsics.checkNotNull(findViewById17, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem10 = (FormSwitchItem) findViewById17;
        this.forceAIGC20AccessibleItem = formSwitchItem10;
        if (formSwitchItem10 != null) {
            formSwitchItem10.setOnCheckedChangeListener(this);
        }
        View findViewById18 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126297od);
        Intrinsics.checkNotNull(findViewById18, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem11 = (FormSwitchItem) findViewById18;
        this.uploadAvatarJsonItem = formSwitchItem11;
        if (formSwitchItem11 != null) {
            formSwitchItem11.setOnCheckedChangeListener(this);
        }
        View findViewById19 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126717pi);
        Intrinsics.checkNotNull(findViewById19, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        this.paralleWorldItem = (FormSwitchItem) findViewById19;
        View findViewById20 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126787pp);
        Intrinsics.checkNotNull(findViewById20, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem12 = (FormSwitchItem) findViewById20;
        this.preloadWorldItem = formSwitchItem12;
        if (formSwitchItem12 != null) {
            formSwitchItem12.setOnCheckedChangeListener(this);
        }
        View findViewById21 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126607p8);
        Intrinsics.checkNotNull(findViewById21, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem13 = (FormSwitchItem) findViewById21;
        this.gameInMainWorldItem = formSwitchItem13;
        if (formSwitchItem13 != null) {
            formSwitchItem13.setOnCheckedChangeListener(this);
        }
        View findViewById22 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126617p9);
        Intrinsics.checkNotNull(findViewById22, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem14 = (FormSwitchItem) findViewById22;
        this.gameUseSurfaceViewItem = formSwitchItem14;
        if (formSwitchItem14 != null) {
            formSwitchItem14.setOnCheckedChangeListener(this);
        }
        View findViewById23 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126217o6);
        Intrinsics.checkNotNull(findViewById23, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem15 = (FormSwitchItem) findViewById23;
        this.chatAioItem = formSwitchItem15;
        if (formSwitchItem15 != null) {
            formSwitchItem15.setOnCheckedChangeListener(this);
        }
        View findViewById24 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126107nv);
        Intrinsics.checkNotNull(findViewById24, "null cannot be cast to non-null type android.widget.EditText");
        EditText editText = (EditText) findViewById24;
        this.avatarBubbleDebugItem = editText;
        if (editText != null) {
            editText.setOnEditorActionListener(this);
        }
        View findViewById25 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126287oc);
        Intrinsics.checkNotNull(findViewById25, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem16 = (FormSwitchItem) findViewById25;
        this.qzoneConciseDynamicAvatarItem = formSwitchItem16;
        if (formSwitchItem16 != null) {
            formSwitchItem16.setOnCheckedChangeListener(this);
        }
        View findViewById26 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126367ok);
        Intrinsics.checkNotNull(findViewById26, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem17 = (FormSwitchItem) findViewById26;
        this.aioEmoticon2DGif = formSwitchItem17;
        if (formSwitchItem17 != null) {
            formSwitchItem17.setOnCheckedChangeListener(this);
        }
        View findViewById27 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126377ol);
        Intrinsics.checkNotNull(findViewById27, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem18 = (FormSwitchItem) findViewById27;
        this.zplanEnableFilament = formSwitchItem18;
        if (formSwitchItem18 != null) {
            formSwitchItem18.setOnCheckedChangeListener(this);
        }
        View findViewById28 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126397on);
        Intrinsics.checkNotNull(findViewById28, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem19 = (FormSwitchItem) findViewById28;
        this.zplanEnableJsFilament = formSwitchItem19;
        if (formSwitchItem19 != null) {
            formSwitchItem19.setOnCheckedChangeListener(this);
        }
        View findViewById29 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126407oo);
        Intrinsics.checkNotNull(findViewById29, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem20 = (FormSwitchItem) findViewById29;
        this.zplanEnableNativeFilament = formSwitchItem20;
        if (formSwitchItem20 != null) {
            formSwitchItem20.setOnCheckedChangeListener(this);
        }
        View findViewById30 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126387om);
        Intrinsics.checkNotNull(findViewById30, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem21 = (FormSwitchItem) findViewById30;
        this.zplanEnableFilamentSaveInSdcard = formSwitchItem21;
        if (formSwitchItem21 != null) {
            formSwitchItem21.setOnCheckedChangeListener(this);
        }
        View findViewById31 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126817ps);
        Intrinsics.checkNotNull(findViewById31, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem22 = (FormSwitchItem) findViewById31;
        formSwitchItem22.setChecked(((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean("zplan_share_card_debug_panel", false));
        formSwitchItem22.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.zplan.debug.n
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ZPlanDebugFragment.Nh(compoundButton, z16);
            }
        });
        FormSwitchItem formSwitchItem23 = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126527p0);
        this.zplanForceShowMiniHomeGuidanceBubble = formSwitchItem23;
        if (formSwitchItem23 != null) {
            formSwitchItem23.setOnCheckedChangeListener(this);
        }
        ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126227o7).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanDebugFragment.Th(view);
            }
        });
        FormSwitchItem formSwitchItem24 = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126257o_);
        this.zplanCleanMiniHomeEntranceBubbleShown = formSwitchItem24;
        if (formSwitchItem24 != null) {
            formSwitchItem24.setOnCheckedChangeListener(this);
        }
        FormSwitchItem formSwitchItem25 = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126487ow);
        this.zplanForceAioDisableMiniHomeEntrance = formSwitchItem25;
        if (formSwitchItem25 != null) {
            formSwitchItem25.setOnCheckedChangeListener(this);
        }
        FormSwitchItem formSwitchItem26 = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.zfi);
        this.msfChannelSaveFile = formSwitchItem26;
        if (formSwitchItem26 != null) {
            formSwitchItem26.setOnCheckedChangeListener(this);
        }
        ((Button) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126247o9)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanDebugFragment.Yh(ZPlanDebugFragment.this, view);
            }
        });
        ((Button) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126457ot)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanDebugFragment.Zh(ZPlanDebugFragment.this, view);
            }
        });
        View findViewById32 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126117nw);
        Intrinsics.checkNotNull(findViewById32, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem27 = (FormSwitchItem) findViewById32;
        this.avatarRecordUseClound = formSwitchItem27;
        if (formSwitchItem27 != null) {
            formSwitchItem27.setOnCheckedChangeListener(this);
        }
        View findViewById33 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126337oh);
        Intrinsics.checkNotNull(findViewById33, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem28 = (FormSwitchItem) findViewById33;
        this.emoticonRecordUseClound = formSwitchItem28;
        if (formSwitchItem28 != null) {
            formSwitchItem28.setOnCheckedChangeListener(this);
        }
        View findViewById34 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.xot);
        this.emoticonRecordWidth = findViewById34 instanceof EditText ? (EditText) findViewById34 : null;
        View findViewById35 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.xos);
        this.emoticonRecordHeight = findViewById35 instanceof EditText ? (EditText) findViewById35 : null;
        View findViewById36 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.xom);
        this.emoticonEncodeWidth = findViewById36 instanceof EditText ? (EditText) findViewById36 : null;
        View findViewById37 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.xol);
        this.emoticonEncodeHeight = findViewById37 instanceof EditText ? (EditText) findViewById37 : null;
        Button button = (Button) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126357oj);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanDebugFragment.ai(ZPlanDebugFragment.this, view);
            }
        });
        this.emoticonSizeConfirmButton = button;
        Button button2 = (Button) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126347oi);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanDebugFragment.bi(ZPlanDebugFragment.this, view);
            }
        });
        this.emoticonSizeConfirmButton = button2;
        ((FormSimpleItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126197o4)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanDebugFragment.Oh(ZPlanDebugFragment.this, view);
            }
        });
        ((FormSimpleItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126207o5)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanDebugFragment.Ph(ZPlanDebugFragment.this, view);
            }
        });
        ((FormSimpleItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126887pz)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanDebugFragment.Qh(ZPlanDebugFragment.this, view);
            }
        });
        ((FormSimpleItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126277ob)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanDebugFragment.Rh(ZPlanDebugFragment.this, view);
            }
        });
        ((FormSimpleItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126627p_)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanDebugFragment.Sh(ZPlanDebugFragment.this, view);
            }
        });
        ((FormSimpleItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126317of)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanDebugFragment.Uh(ZPlanDebugFragment.this, view);
            }
        });
        ((Button) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126237o8)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanDebugFragment.Vh(view);
            }
        });
        final Button button3 = (Button) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126267oa);
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanDebugFragment.Xh(button3, view);
            }
        });
        ci();
        FormSwitchItem formSwitchItem29 = this.forceCloseZPlan;
        if (formSwitchItem29 != null) {
            formSwitchItem29.setOnCheckedChangeListener(this);
        }
        FormSwitchItem formSwitchItem30 = this.paralleWorldItem;
        if (formSwitchItem30 != null) {
            formSwitchItem30.setOnCheckedChangeListener(this);
        }
        FormSwitchItem formSwitchItem31 = this.forceHideLoading;
        if (formSwitchItem31 != null) {
            formSwitchItem31.setOnCheckedChangeListener(this);
        }
        FormSwitchItem formSwitchItem32 = this.forceUseFilamentAvatar;
        if (formSwitchItem32 != null) {
            formSwitchItem32.setOnCheckedChangeListener(this);
        }
        FormSwitchItem formSwitchItem33 = this.forceUseUEAvatar;
        if (formSwitchItem33 != null) {
            formSwitchItem33.setOnCheckedChangeListener(this);
        }
        FormSwitchItem formSwitchItem34 = this.forceUseFilamentRecord;
        if (formSwitchItem34 != null) {
            formSwitchItem34.setOnCheckedChangeListener(this);
        }
        FormSwitchItem formSwitchItem35 = this.forceUseUERecord;
        if (formSwitchItem35 != null) {
            formSwitchItem35.setOnCheckedChangeListener(this);
        }
        FormSwitchItem formSwitchItem36 = this.enablePortalShadow;
        if (formSwitchItem36 != null) {
            formSwitchItem36.setOnCheckedChangeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i8y;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
        FormSwitchItem formSwitchItem = this.forceAccessibleItem;
        if (Intrinsics.areEqual(buttonView, formSwitchItem != null ? formSwitchItem.getSwitch() : null)) {
            String uin = getUin();
            if (uin == null || uin.length() == 0) {
                QLog.e(this.TAG, 1, "zplanEntrySwitch uin invalid");
            }
            j74.a.f409621a.e(uin, isChecked, "zplan_force_open");
            return;
        }
        FormSwitchItem formSwitchItem2 = this.forceAIGC20AccessibleItem;
        if (Intrinsics.areEqual(buttonView, formSwitchItem2 != null ? formSwitchItem2.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_aigc_20_force_open");
            return;
        }
        FormSwitchItem formSwitchItem3 = this.zplanPreloadProcessItem;
        if (Intrinsics.areEqual(buttonView, formSwitchItem3 != null ? formSwitchItem3.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_preload_process_enable");
            return;
        }
        FormSwitchItem formSwitchItem4 = this.uploadAvatarJsonItem;
        if (Intrinsics.areEqual(buttonView, formSwitchItem4 != null ? formSwitchItem4.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_avatar_upload");
            return;
        }
        FormSwitchItem formSwitchItem5 = this.zplanPreloadSwitchItem;
        if (Intrinsics.areEqual(buttonView, formSwitchItem5 != null ? formSwitchItem5.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_preload_enable");
            return;
        }
        FormSwitchItem formSwitchItem6 = this.zplanPreloadKillItem;
        if (Intrinsics.areEqual(buttonView, formSwitchItem6 != null ? formSwitchItem6.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_preload_kill");
            return;
        }
        FormSwitchItem formSwitchItem7 = this.paralleWorldItem;
        if (Intrinsics.areEqual(buttonView, formSwitchItem7 != null ? formSwitchItem7.getSwitch() : null)) {
            DialogUtil.createCustomDialog(getContext(), 0, (String) null, !isChecked ? "\u5173\u95ed\u591aworld\u6a21\u5f0f\u5e76\u91cd\u542f\u624bQ\u751f\u6548\uff1f" : "\u4f7f\u7528\u591aworld\u6a21\u5f0f\u5e76\u91cd\u542f\u624bQ\u751f\u6548\uff1f", HardCodeUtil.qqStr(R.string.j6l), HardCodeUtil.qqStr(R.string.ket), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ZPlanDebugFragment.ei(ZPlanDebugFragment.this, isChecked, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ZPlanDebugFragment.fi(dialogInterface, i3);
                }
            }).show();
            return;
        }
        FormSwitchItem formSwitchItem8 = this.chatAioItem;
        if (Intrinsics.areEqual(buttonView, formSwitchItem8 != null ? formSwitchItem8.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_chat_aio");
            return;
        }
        FormSwitchItem formSwitchItem9 = this.qzoneConciseDynamicAvatarItem;
        if (Intrinsics.areEqual(buttonView, formSwitchItem9 != null ? formSwitchItem9.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_qzone_concise_dynamic_avatar");
            return;
        }
        FormSwitchItem formSwitchItem10 = this.gameInMainWorldItem;
        if (Intrinsics.areEqual(buttonView, formSwitchItem10 != null ? formSwitchItem10.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_game_in_main_world");
            return;
        }
        FormSwitchItem formSwitchItem11 = this.gameUseSurfaceViewItem;
        if (Intrinsics.areEqual(buttonView, formSwitchItem11 != null ? formSwitchItem11.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_game_use_surfaceview");
            return;
        }
        FormSwitchItem formSwitchItem12 = this.preloadWorldItem;
        if (Intrinsics.areEqual(buttonView, formSwitchItem12 != null ? formSwitchItem12.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_preload_world");
            return;
        }
        FormSwitchItem formSwitchItem13 = this.aioEmoticon2DGif;
        if (Intrinsics.areEqual(buttonView, formSwitchItem13 != null ? formSwitchItem13.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_aio_emoticon_2d_gif_type");
            return;
        }
        FormSwitchItem formSwitchItem14 = this.zplanEnableFilament;
        if (Intrinsics.areEqual(buttonView, formSwitchItem14 != null ? formSwitchItem14.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_enable_filament");
            return;
        }
        FormSwitchItem formSwitchItem15 = this.zplanEnableJsFilament;
        if (Intrinsics.areEqual(buttonView, formSwitchItem15 != null ? formSwitchItem15.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_enable_js_filament");
            return;
        }
        FormSwitchItem formSwitchItem16 = this.zplanEnableNativeFilament;
        if (Intrinsics.areEqual(buttonView, formSwitchItem16 != null ? formSwitchItem16.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_enable_native_filament");
            return;
        }
        FormSwitchItem formSwitchItem17 = this.zplanEnableFilamentSaveInSdcard;
        if (Intrinsics.areEqual(buttonView, formSwitchItem17 != null ? formSwitchItem17.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_enable_filament_save_in_sdcard");
            return;
        }
        FormSwitchItem formSwitchItem18 = this.forceCloseZPlan;
        if (Intrinsics.areEqual(buttonView, formSwitchItem18 != null ? formSwitchItem18.getSwitch() : null)) {
            DialogUtil.createCustomDialog(getContext(), 0, (String) null, !isChecked ? "\u662f\u5426\u6b63\u5e38\u542f\u52a8UE\u5f15\u64ce? (\u91cd\u542f\u624bQ\u751f\u6548)" : "\u662f\u5426\u5f3a\u5236\u5173\u95edUE\u5f15\u64ce\uff1f(\u91cd\u542f\u624bQ\u751f\u6548)", HardCodeUtil.qqStr(R.string.j6l), HardCodeUtil.qqStr(R.string.ket), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ZPlanDebugFragment.gi(ZPlanDebugFragment.this, isChecked, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.debug.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ZPlanDebugFragment.hi(dialogInterface, i3);
                }
            }).show();
            return;
        }
        FormSwitchItem formSwitchItem19 = this.forceHideLoading;
        if (Intrinsics.areEqual(buttonView, formSwitchItem19 != null ? formSwitchItem19.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_force_hide_loading");
            return;
        }
        FormSwitchItem formSwitchItem20 = this.forceUseFilamentAvatar;
        if (Intrinsics.areEqual(buttonView, formSwitchItem20 != null ? formSwitchItem20.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_force_filament_avatar");
            FormSwitchItem formSwitchItem21 = this.forceUseUEAvatar;
            if (formSwitchItem21 == null) {
                return;
            }
            formSwitchItem21.setChecked(!isChecked);
            return;
        }
        FormSwitchItem formSwitchItem22 = this.forceUseUEAvatar;
        if (Intrinsics.areEqual(buttonView, formSwitchItem22 != null ? formSwitchItem22.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), !isChecked, "zplan_force_filament_avatar");
            FormSwitchItem formSwitchItem23 = this.forceUseFilamentAvatar;
            if (formSwitchItem23 == null) {
                return;
            }
            formSwitchItem23.setChecked(!isChecked);
            return;
        }
        FormSwitchItem formSwitchItem24 = this.enableUEHotPatch;
        if (Intrinsics.areEqual(buttonView, formSwitchItem24 != null ? formSwitchItem24.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_dev_enable_ue_hotpatch");
            return;
        }
        FormSwitchItem formSwitchItem25 = this.debugForceLowQQVersion;
        if (Intrinsics.areEqual(buttonView, formSwitchItem25 != null ? formSwitchItem25.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_dev_force_low_version");
            return;
        }
        FormSwitchItem formSwitchItem26 = this.showDebugStoreInfo;
        if (Intrinsics.areEqual(buttonView, formSwitchItem26 != null ? formSwitchItem26.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_dev_show_store_info");
            return;
        }
        FormSwitchItem formSwitchItem27 = this.showDebugAllDyeingCloth;
        if (Intrinsics.areEqual(buttonView, formSwitchItem27 != null ? formSwitchItem27.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_dev_show_dyeing_clothes");
            return;
        }
        FormSwitchItem formSwitchItem28 = this.hideOutfitPreviewChangePoseBtn;
        if (Intrinsics.areEqual(buttonView, formSwitchItem28 != null ? formSwitchItem28.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_dev_hide_outfit_preview_pose_button");
            return;
        }
        FormSwitchItem formSwitchItem29 = this.avatarRecordUseClound;
        if (Intrinsics.areEqual(buttonView, formSwitchItem29 != null ? formSwitchItem29.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_avatar_record_use_cloud");
            return;
        }
        FormSwitchItem formSwitchItem30 = this.emoticonRecordUseClound;
        if (Intrinsics.areEqual(buttonView, formSwitchItem30 != null ? formSwitchItem30.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_emoticon_record_use_cloud");
            return;
        }
        FormSwitchItem formSwitchItem31 = this.forceUseFilamentRecord;
        if (Intrinsics.areEqual(buttonView, formSwitchItem31 != null ? formSwitchItem31.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_force_filament_record");
            return;
        }
        FormSwitchItem formSwitchItem32 = this.forceUseUERecord;
        if (Intrinsics.areEqual(buttonView, formSwitchItem32 != null ? formSwitchItem32.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_force_ue_record");
            return;
        }
        FormSwitchItem formSwitchItem33 = this.enablePortalShadow;
        if (Intrinsics.areEqual(buttonView, formSwitchItem33 != null ? formSwitchItem33.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "zplan_portal_enable_shadow");
            return;
        }
        FormSwitchItem formSwitchItem34 = this.zplanForceShowMiniHomeGuidanceBubble;
        if (Intrinsics.areEqual(buttonView, formSwitchItem34 != null ? formSwitchItem34.getSwitch() : null)) {
            ZPlanMiniHomeGuidanceBubbleViewController.INSTANCE.g(isChecked);
            return;
        }
        FormSwitchItem formSwitchItem35 = this.zplanCleanMiniHomeEntranceBubbleShown;
        if (Intrinsics.areEqual(buttonView, formSwitchItem35 != null ? formSwitchItem35.getSwitch() : null)) {
            AIOMiniHomeConnectedEntranceHelper.INSTANCE.d(isChecked);
            return;
        }
        FormSwitchItem formSwitchItem36 = this.zplanForceAioDisableMiniHomeEntrance;
        if (Intrinsics.areEqual(buttonView, formSwitchItem36 != null ? formSwitchItem36.getSwitch() : null)) {
            AIOMiniHomeConnectedEntranceHelper.INSTANCE.c(isChecked);
            return;
        }
        FormSwitchItem formSwitchItem37 = this.msfChannelSaveFile;
        if (Intrinsics.areEqual(buttonView, formSwitchItem37 != null ? formSwitchItem37.getSwitch() : null)) {
            j74.a.f409621a.e(getUin(), isChecked, "msf_channel_save_file");
        }
    }

    private final void di(Activity context) {
        Context applicationContext;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return;
        }
        ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(applicationContext, "mqqapi://zplan/openPage?referer=1001&pageID=9");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3 != null) {
            v3.getId();
        }
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView v3, int actionId, KeyEvent event) {
        if (v3 == null) {
            return false;
        }
        String uin = getUin();
        if (!Intrinsics.areEqual(v3, this.avatarBubbleDebugItem)) {
            return true;
        }
        j74.a.f409621a.f(uin, "zplan_avatar_bubble_debug", v3.getText().toString());
        return true;
    }
}
