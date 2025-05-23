package com.tencent.square.debugger;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.record.SquareFilamentNativeAppRecorder;
import com.tencent.filament.zplan.scene.square.SquareAvatarData;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqlive.data.common.QQLiveError;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.state.VasBaseSubFragment;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.api.RecordSuccessListener;
import com.tencent.state.square.avatar.filament.SquareActionHelper;
import com.tencent.state.square.data.BaseResourceInfo;
import com.tencent.state.square.data.MultiResourceInfo;
import com.tencent.state.square.data.PanelCategoryInfo;
import com.tencent.state.square.data.PanelInfo;
import com.tencent.state.square.data.RecordResourceInfo;
import com.tencent.state.square.data.RecordSource;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.StatusActionInfo;
import com.tencent.state.square.media.MediaSource;
import com.tencent.state.square.media.SquarePlayerPool;
import com.tencent.state.square.media.SquareVideoView;
import com.tencent.state.square.record.RecordIdentifier;
import com.tencent.state.square.record.RecordType;
import com.tencent.state.square.record.UserIdentifier;
import com.tencent.state.square.resource.FilamentCoverRecorder;
import com.tencent.state.status.SquareStatusViewModel;
import com.tencent.state.status.SquareStatusViewModelFactory;
import com.tencent.state.view.SquareImageView;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.cloud.impl.CloudRecordApiImpl;
import com.tencent.zplan.encode.EncodeType;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.a;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.meme.model.MemeResult;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.Constants;
import oicq.wlogin_sdk.tools.util;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u008d\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u008e\u0001\u008f\u0001\u0090\u0001B\t\u00a2\u0006\u0006\b\u008c\u0001\u0010\u0088\u0001J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u001a\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0013\u0010\u0010\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u0011J\u0016\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0006J\"\u0010#\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J*\u0010*\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010'H\u0016J*\u0010+\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010'H\u0016J*\u0010,\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010'H\u0016J(\u0010/\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020%H\u0016J \u00101\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u00100\u001a\u00020%H\u0016J\u0012\u00104\u001a\u00020\f2\b\u00103\u001a\u0004\u0018\u000102H\u0002J\b\u00105\u001a\u00020\fH\u0002J\b\u00106\u001a\u00020\fH\u0002J\u0012\u00109\u001a\u0004\u0018\u00010\u00062\u0006\u00108\u001a\u000207H\u0002J\b\u0010:\u001a\u00020\u0012H\u0002J\u0010\u0010;\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0018H\u0002J4\u0010@\u001a\u00020\u00062\b\b\u0002\u0010<\u001a\u0002022\b\b\u0002\u0010=\u001a\u0002022\u0006\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J4\u0010A\u001a\u00020\u00062\b\b\u0002\u0010<\u001a\u0002022\b\b\u0002\u0010=\u001a\u0002022\u0006\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u0018\u0010B\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u0018\u0010C\u001a\u00020\f2\u0006\u0010<\u001a\u0002022\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u0010\u0010F\u001a\u0002022\u0006\u0010E\u001a\u00020DH\u0002J \u0010I\u001a\u0002022\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020D2\u0006\u0010H\u001a\u000202H\u0002J\b\u0010J\u001a\u00020\fH\u0002J\b\u0010K\u001a\u00020\fH\u0002J\u001a\u0010O\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020N0M0LH\u0002R\u0016\u0010R\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010QR\u0016\u0010>\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010?\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010^\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010_\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010]R\u0016\u0010a\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010VR\u0016\u0010d\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010cR\u0016\u0010h\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010VR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0014\u0010p\u001a\u00020m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u001c\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00140q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010x\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010z\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010`R\u0014\u0010~\u001a\u00020{8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b|\u0010}R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001b\u0010\u0085\u0001\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R \u0010\u0089\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u000f\n\u0005\b\u0086\u0001\u0010V\u0012\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0016\u0010\u0017\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0091\u0001"}, d2 = {"Lcom/tencent/square/debugger/DemoRecordMp4Fragment;", "Lcom/tencent/state/VasBaseSubFragment;", "Lcom/tencent/zplan/meme/a;", "Lcom/tencent/state/square/api/RecordSuccessListener;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "onDestroyView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "ci", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "success", "Lcom/tencent/zplan/meme/model/MemeResult;", "result", "l9", "useFilament", "Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "Yh", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bi", HippyNestedScrollComponent.PRIORITY_PARENT, "Vh", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "actionId", "Lcom/tencent/state/square/record/RecordIdentifier;", "recordIdentifier", "Lcom/tencent/state/square/data/RecordSource;", "cover", "mp4", "onLocalRecordSuccess", "onCloudRecordSuccess", "onUploadSuccess", "type", "errorCode", "onRecordError", IECDtReport.ACTION_IDENTIFIER, "onRecordDone", "", "dirStr", "ai", "ii", "di", "Lcom/tencent/zplan/meme/action/MemeAction;", "action", "ei", "Zh", "gi", "url", "path", "width", "height", "Qh", "Sh", "Uh", "Ph", "", "length", "fi", "anchor", "postFix", "Xh", "initListener", "checkPermission", "", "Lkotlin/Pair;", "Lcom/tencent/state/square/data/Resource;", "Wh", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "uin", "D", "uin2", "E", "I", UserInfo.SEX_FEMALE, "Lcom/tencent/zplan/meme/action/MODE;", "G", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "H", "Ljava/lang/Integer;", "aaType", "aaLevel", "J", "encodeType", "K", "Z", "isDebug", "L", "useV2", "M", "actionStyle", "Lwc4/a;", "N", "Lwc4/a;", "binding", "Lcom/tencent/square/debugger/DemoRecordMp4Fragment$b;", "P", "Lcom/tencent/square/debugger/DemoRecordMp4Fragment$b;", "handler", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/List;", "playList", "Lcom/tencent/zplan/cloud/record/api/a;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/zplan/cloud/record/api/a;", "cloudApi", ExifInterface.LATITUDE_SOUTH, "openUrlLastClickTime", "Lcom/tencent/state/square/media/SquarePlayerPool;", "T", "Lcom/tencent/state/square/media/SquarePlayerPool;", "squarePlayerPool", "Lcom/tencent/state/status/SquareStatusViewModel;", "U", "Lcom/tencent/state/status/SquareStatusViewModel;", "viewModel", "V", "Lcom/tencent/state/square/data/Resource;", "selectedResource", "W", "getEncodeMode$annotations", "()V", "encodeMode", "hi", "()Z", "<init>", "X", "a", "b", "c", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class DemoRecordMp4Fragment extends VasBaseSubFragment implements com.tencent.zplan.meme.a, RecordSuccessListener {

    /* renamed from: X, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: H, reason: from kotlin metadata */
    private Integer aaType;

    /* renamed from: I, reason: from kotlin metadata */
    private Integer aaLevel;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isDebug;

    /* renamed from: N, reason: from kotlin metadata */
    private wc4.a binding;

    /* renamed from: R, reason: from kotlin metadata */
    private com.tencent.zplan.cloud.record.api.a cloudApi;

    /* renamed from: U, reason: from kotlin metadata */
    private SquareStatusViewModel viewModel;

    /* renamed from: V, reason: from kotlin metadata */
    private Resource selectedResource;

    /* renamed from: W, reason: from kotlin metadata */
    private int encodeMode;

    /* renamed from: C, reason: from kotlin metadata */
    private String uin = "";

    /* renamed from: D, reason: from kotlin metadata */
    private String uin2 = "";

    /* renamed from: E, reason: from kotlin metadata */
    private int width = 608;

    /* renamed from: F, reason: from kotlin metadata */
    private int height = 608;

    /* renamed from: G, reason: from kotlin metadata */
    private MODE mode = MODE.MP4;

    /* renamed from: J, reason: from kotlin metadata */
    private int encodeType = EncodeType.SOFTWARE.ordinal();

    /* renamed from: L, reason: from kotlin metadata */
    private boolean useV2 = true;

    /* renamed from: M, reason: from kotlin metadata */
    private int actionStyle = 2;

    /* renamed from: P, reason: from kotlin metadata */
    private final b handler = new b(new WeakReference(this));

    /* renamed from: Q, reason: from kotlin metadata */
    private List<MemeResult> playList = new ArrayList();

    /* renamed from: S, reason: from kotlin metadata */
    private long openUrlLastClickTime = -1;

    /* renamed from: T, reason: from kotlin metadata */
    private final SquarePlayerPool squarePlayerPool = new SquarePlayerPool(null, 1, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/square/debugger/DemoRecordMp4Fragment$a;", "", "", "FILE_SELECTOR_CODE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.square.debugger.DemoRecordMp4Fragment$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/square/debugger/DemoRecordMp4Fragment$b;", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/square/debugger/DemoRecordMp4Fragment;", "a", "Ljava/lang/ref/WeakReference;", "fragment", "<init>", "(Ljava/lang/ref/WeakReference;)V", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class b extends Handler {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<DemoRecordMp4Fragment> fragment;

        public b(WeakReference<DemoRecordMp4Fragment> fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.fragment = fragment;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            super.handleMessage(msg2);
            int i3 = msg2.what;
            if (i3 != 0) {
                if (i3 != 1) {
                    return;
                }
                ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                DemoRecordMp4Fragment demoRecordMp4Fragment = this.fragment.get();
                squareCommon.showToastSafely(demoRecordMp4Fragment != null ? demoRecordMp4Fragment.requireContext() : null, "\u5f55\u5236\u6210\u529f", 0);
                Object obj = msg2.obj;
                if (!(obj instanceof RecordDoneMessageInfo)) {
                    obj = null;
                }
                RecordDoneMessageInfo recordDoneMessageInfo = (RecordDoneMessageInfo) obj;
                if (recordDoneMessageInfo != null) {
                    if (recordDoneMessageInfo.getParent() == null) {
                        ICommonUtils squareCommon2 = SquareBaseKt.getSquareCommon();
                        DemoRecordMp4Fragment demoRecordMp4Fragment2 = this.fragment.get();
                        squareCommon2.showToastSafely(demoRecordMp4Fragment2 != null ? demoRecordMp4Fragment2.requireContext() : null, "\u5f55\u5236\u6210\u529f,\u4f46\u662f\u5c55\u793a\u5931\u8d25\uff0c\u518d\u70b9\u51fb\u4e00\u6b21\u5f55\u5236\u4f1a\u5c55\u793a", 0);
                        return;
                    } else {
                        DemoRecordMp4Fragment demoRecordMp4Fragment3 = this.fragment.get();
                        if (demoRecordMp4Fragment3 != null) {
                            demoRecordMp4Fragment3.Vh(recordDoneMessageInfo.getResult(), recordDoneMessageInfo.getParent());
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            ICommonUtils squareCommon3 = SquareBaseKt.getSquareCommon();
            DemoRecordMp4Fragment demoRecordMp4Fragment4 = this.fragment.get();
            squareCommon3.showToastSafely(demoRecordMp4Fragment4 != null ? demoRecordMp4Fragment4.requireContext() : null, "\u5f55\u5236\u5931\u8d25", 0);
            Object obj2 = msg2.obj;
            if (!(obj2 instanceof RecordDoneMessageInfo)) {
                obj2 = null;
            }
            RecordDoneMessageInfo recordDoneMessageInfo2 = (RecordDoneMessageInfo) obj2;
            if (recordDoneMessageInfo2 != null) {
                MemeAction action = recordDoneMessageInfo2.getResult().getAction();
                if (recordDoneMessageInfo2.getParent() == null) {
                    ICommonUtils squareCommon4 = SquareBaseKt.getSquareCommon();
                    DemoRecordMp4Fragment demoRecordMp4Fragment5 = this.fragment.get();
                    squareCommon4.showToastSafely(demoRecordMp4Fragment5 != null ? demoRecordMp4Fragment5.requireContext() : null, "\u5f55\u5236\u5931\u8d25, \u4f46\u662f\u66f4\u65b0view\u5931\u8d25", 0);
                    return;
                }
                TextView textView = (TextView) recordDoneMessageInfo2.getParent().findViewById(R.id.qg5);
                if (textView != null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(action.getActionId());
                    sb5.append(util.base64_pad_url);
                    sb5.append(action.getWidth());
                    sb5.append('x');
                    sb5.append(action.getHeight());
                    sb5.append("\u5f55\u5236\u5931\u8d25_");
                    wx4.d i16 = recordDoneMessageInfo2.getResult().i();
                    sb5.append(i16 != null ? Integer.valueOf(i16.getErrCode()) : null);
                    sb5.append(util.base64_pad_url);
                    wx4.d i17 = recordDoneMessageInfo2.getResult().i();
                    sb5.append(i17 != null ? Integer.valueOf(i17.getScriptErrorCode()) : null);
                    sb5.append("!(");
                    sb5.append(action.getMode());
                    sb5.append(')');
                    textView.setText(sb5.toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_LONG_CLICK, "com/tencent/square/debugger/DemoRecordMp4Fragment$addCloudRecordInfoView$1$2"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class d implements View.OnLongClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f373505d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f373506e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ WeakReference f373507f;

        d(TextView textView, String str, WeakReference weakReference) {
            this.f373505d = textView;
            this.f373506e = str;
            this.f373507f = weakReference;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            Object systemService = this.f373505d.getContext().getSystemService("clipboard");
            if (systemService != null) {
                ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText("url", this.f373506e));
                SquareBaseKt.getSquareCommon().showToastSafely((Context) this.f373507f.get(), "\u5df2\u590d\u5236url", 0);
                return true;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/square/debugger/DemoRecordMp4Fragment$e", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "", UploadQualityReportBuilder.STATE_CONNECT, "", "serviceConnected", "success", "engineInitFinish", "engineFirstFrame", "engineDestroy", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class e implements ZPlanEngineStatusUpdateListener {
        e() {
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineDestroy() {
            Log.d("DemoRecordMp4Fragment", "engineDestroy");
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineFirstFrame() {
            Log.d("DemoRecordMp4Fragment", "engineFirstFrame");
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInitFinish(boolean success) {
            Log.d("DemoRecordMp4Fragment", "engineInitFinish " + success);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInversePurged() {
            ZPlanEngineStatusUpdateListener.a.d(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurged() {
            ZPlanEngineStatusUpdateListener.a.e(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurging() {
            ZPlanEngineStatusUpdateListener.a.f(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineSuspended() {
            ZPlanEngineStatusUpdateListener.a.g(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void hotPatchDownloadFailed(int i3, String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            ZPlanEngineStatusUpdateListener.a.h(this, i3, errorMessage);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void serviceConnected(boolean connect) {
            Log.d("DemoRecordMp4Fragment", "serviceConnected " + connect);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    static final class g implements CompoundButton.OnCheckedChangeListener {
        g() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            DemoRecordMp4Fragment.this.isDebug = z16;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    static final class h implements CompoundButton.OnCheckedChangeListener {
        h() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            DemoRecordMp4Fragment.this.useV2 = z16;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    static final class i implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: d, reason: collision with root package name */
        public static final i f373513d = new i();

        i() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            com.tencent.square.debugger.b.f373562c.e(z16);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    static final class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            xc4.c cVar = xc4.c.f447785a;
            Context requireContext = DemoRecordMp4Fragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            cVar.g(requireContext, DemoRecordMp4Fragment.this.playList);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    static final class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("*/*");
            intent.addCategory("android.intent.category.OPENABLE");
            DemoRecordMp4Fragment.this.startActivityForResult(intent, 999);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    static final class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            if (DemoRecordMp4Fragment.this.openUrlLastClickTime == -1 || currentTimeMillis - DemoRecordMp4Fragment.this.openUrlLastClickTime >= 1500) {
                DemoRecordMp4Fragment.this.openUrlLastClickTime = currentTimeMillis;
                DemoRecordMp4Fragment.this.di();
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    static final class n implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ wc4.a f373519e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ WeakReference f373520f;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/square/debugger/DemoRecordMp4Fragment$n$a", "Lcom/tencent/state/square/resource/FilamentCoverRecorder$IRecordCallback;", "Lcom/tencent/state/square/resource/FilamentCoverRecorder$RecordRequest;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/state/square/data/RecordSource;", "cover", "", "onRecordSuccess", "", "type", "errorCode", "onRecordError", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes34.dex */
        public static final class a implements FilamentCoverRecorder.IRecordCallback {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Resource f373522b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f373523c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f373524d;

            a(Resource resource, String str, String str2) {
                this.f373522b = resource;
                this.f373523c = str;
                this.f373524d = str2;
            }

            @Override // com.tencent.state.square.resource.FilamentCoverRecorder.IRecordCallback
            public void onRecordError(int type, FilamentCoverRecorder.RecordRequest request, int errorCode) {
                Intrinsics.checkNotNullParameter(request, "request");
                SquareBaseKt.getSquareLog().d("DemoRecordMp4Fragment", "recordGuestCover onRecordError: actionId=" + this.f373522b.getActionId() + ", uin=" + this.f373523c + ", coverPath=" + this.f373524d);
                SquareBaseKt.getSquareCommon().showToastSafely((Context) n.this.f373520f.get(), "\u5f55\u5236\u5931\u8d25", 0);
            }

            @Override // com.tencent.state.square.resource.FilamentCoverRecorder.IRecordCallback
            public void onRecordSuccess(FilamentCoverRecorder.RecordRequest request, RecordSource cover) {
                Intrinsics.checkNotNullParameter(request, "request");
                Intrinsics.checkNotNullParameter(cover, "cover");
                SquareBaseKt.getSquareLog().d("DemoRecordMp4Fragment", "recordGuestCover onRecordSuccess: actionId=" + this.f373522b.getActionId() + ", uin=" + this.f373523c + ", coverPath=" + this.f373524d);
                SquareBaseKt.getSquareCommon().showToastSafely((Context) n.this.f373520f.get(), "\u5f55\u5236\u6210\u529f", 0);
                DemoRecordMp4Fragment demoRecordMp4Fragment = DemoRecordMp4Fragment.this;
                String path = cover.getPath();
                int i3 = DemoRecordMp4Fragment.this.width;
                int i16 = DemoRecordMp4Fragment.this.height;
                LinearLayout linearLayout = n.this.f373519e.f445405f;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.container");
                demoRecordMp4Fragment.Sh("", path, i3, i16, linearLayout);
            }
        }

        n(wc4.a aVar, WeakReference weakReference) {
            this.f373519e = aVar;
            this.f373520f = weakReference;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            boolean isBlank;
            Resource resource = DemoRecordMp4Fragment.this.selectedResource;
            if (resource != null) {
                EditText editText = this.f373519e.f445421v;
                Intrinsics.checkNotNullExpressionValue(editText, "binding.uin");
                String obj = editText.getText().toString();
                EditText editText2 = this.f373519e.f445422w;
                Intrinsics.checkNotNullExpressionValue(editText2, "binding.uin2");
                String obj2 = editText2.getText().toString();
                StringBuilder sb5 = new StringBuilder();
                Context requireContext = DemoRecordMp4Fragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                File externalCacheDir = requireContext.getExternalCacheDir();
                sb5.append(externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null);
                sb5.append("/guest_");
                sb5.append(System.currentTimeMillis());
                sb5.append(".png");
                String sb6 = sb5.toString();
                SquareBaseKt.getSquareLog().d("DemoRecordMp4Fragment", "recordGuestCover: actionId=" + resource.getActionId() + ", uin=" + obj + ", coverPath=" + sb6);
                StringBuilder sb7 = new StringBuilder();
                sb7.append(obj);
                sb7.append(util.base64_pad_url);
                sb7.append(obj2);
                sb7.append(util.base64_pad_url);
                sb7.append(resource.getActionId());
                String sb8 = sb7.toString();
                UserIdentifier userIdentifier = new UserIdentifier(obj, null, 2, null);
                isBlank = StringsKt__StringsJVMKt.isBlank(obj2);
                new FilamentCoverRecorder().startRecord(new FilamentCoverRecorder.RecordRequest(sb8, userIdentifier, isBlank ? null : new UserIdentifier(obj2, null, 2, null), resource, sb6, false, RecordType.FILAMENT_SQUARE), new a(resource, obj, sb6));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/state/square/data/PanelInfo;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/state/square/data/PanelInfo;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    static final class o<T> implements Observer<PanelInfo> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ wc4.a f373525d;

        o(wc4.a aVar) {
            this.f373525d = aVar;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(PanelInfo panelInfo) {
            Spinner spinner = this.f373525d.f445417r;
            Intrinsics.checkNotNullExpressionValue(spinner, "binding.selector");
            SpinnerAdapter adapter = spinner.getAdapter();
            if (!(adapter instanceof BaseAdapter)) {
                adapter = null;
            }
            BaseAdapter baseAdapter = (BaseAdapter) adapter;
            if (baseAdapter != null) {
                baseAdapter.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    static final class s implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ wc4.a f373532e;

        s(wc4.a aVar) {
            this.f373532e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f373532e.f445405f.removeAllViews();
            DemoRecordMp4Fragment.this.playList.clear();
            DemoRecordMp4Fragment.this.ai(String.valueOf(SquareBase.INSTANCE.getConfig().getRootCacheDir()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph(String url, ViewGroup parent) {
        WeakReference weakReference = new WeakReference(requireContext());
        TextView textView = new TextView(requireContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("# url:\n");
        sb5.append("# " + url);
        Unit unit = Unit.INSTANCE;
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        textView.setText(sb6);
        textView.setOnLongClickListener(new d(textView, url, weakReference));
        parent.addView(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh(MemeResult result, ViewGroup parent) {
        CheckBox checkBox;
        String dVar;
        wc4.a aVar = this.binding;
        if (aVar == null || (checkBox = aVar.f445419t) == null || !checkBox.isChecked()) {
            return;
        }
        TextView textView = new TextView(requireContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("# mode: " + result.getAction().getMode() + '\n');
        sb5.append("# statisticInfo:\n");
        StringBuilder sb6 = new StringBuilder();
        sb6.append(TokenParser.SP);
        wx4.d i3 = result.i();
        sb6.append((i3 == null || (dVar = i3.toString()) == null) ? null : StringsKt__StringsJVMKt.replace$default(dVar, ",", ",\n", false, 4, (Object) null));
        sb6.append('\n');
        sb5.append(sb6.toString());
        sb5.append("# fileInfo:\n");
        sb5.append(" size:" + fi(new File(result.getRecordPath()).length()) + '\n');
        StringBuilder sb7 = new StringBuilder();
        sb7.append(" path:");
        sb7.append(result.getRecordPath());
        sb5.append(sb7.toString());
        Unit unit = Unit.INSTANCE;
        String sb8 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb8, "StringBuilder().apply(builderAction).toString()");
        textView.setText(sb8);
        parent.addView(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Pair<String, Resource>> Wh() {
        MutableLiveData<PanelInfo> panelInfo;
        PanelInfo value;
        List<PanelCategoryInfo> categoryList;
        Object firstOrNull;
        RecordResourceInfo displayResource;
        ArrayList arrayList = new ArrayList();
        SquareStatusViewModel squareStatusViewModel = this.viewModel;
        if (squareStatusViewModel != null && (panelInfo = squareStatusViewModel.getPanelInfo()) != null && (value = panelInfo.getValue()) != null && (categoryList = value.getCategoryList()) != null) {
            Iterator<T> it = categoryList.iterator();
            while (it.hasNext()) {
                for (StatusActionInfo statusActionInfo : ((PanelCategoryInfo) it.next()).getPanelData()) {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) statusActionInfo.getActionList());
                    BaseResourceInfo baseResourceInfo = (BaseResourceInfo) firstOrNull;
                    if (baseResourceInfo != null) {
                        RecordResourceInfo singleMotionResource = baseResourceInfo.getSingleMotionResource();
                        if (singleMotionResource != null) {
                            arrayList.add(new Pair("[\u5355\u4eba] " + singleMotionResource.getResource().getActionId() + TokenParser.SP + statusActionInfo.getStatusInfo().getTitle(), singleMotionResource.getResource()));
                        }
                        if (!(baseResourceInfo instanceof MultiResourceInfo)) {
                            baseResourceInfo = null;
                        }
                        MultiResourceInfo multiResourceInfo = (MultiResourceInfo) baseResourceInfo;
                        if (multiResourceInfo != null && (displayResource = multiResourceInfo.getDisplayResource(null, null, null, null)) != null) {
                            arrayList.add(new Pair("[\u53cc\u4eba] " + displayResource.getResource().getActionId() + TokenParser.SP + statusActionInfo.getStatusInfo().getTitle(), displayResource.getResource()));
                        }
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((Resource) ((Pair) obj).getSecond()).getFilament().getUrl().length() > 0) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    private final String Xh(long length, long anchor, String postFix) {
        return (length / anchor) + postFix;
    }

    private final boolean Zh() {
        Integer intOrNull;
        Integer intOrNull2;
        Resource resource = this.selectedResource;
        if (resource == null) {
            SquareBaseKt.getSquareCommon().showToastSafely(requireContext(), "\u8bf7\u5148\u9009\u62e9\u52a8\u4f5c", 0);
            return false;
        }
        boolean z16 = resource != null && resource.isMultiAction();
        wc4.a aVar = this.binding;
        if (aVar == null) {
            return false;
        }
        EditText editText = aVar.f445421v;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.uin");
        String obj = editText.getText().toString();
        this.uin = obj;
        if (obj.length() == 0) {
            SquareBaseKt.getSquareCommon().showToastSafely(requireContext(), "\u8bf7\u586b\u5165uin1", 0);
            return false;
        }
        EditText editText2 = aVar.f445422w;
        Intrinsics.checkNotNullExpressionValue(editText2, "binding.uin2");
        String obj2 = editText2.getText().toString();
        this.uin2 = obj2;
        if (z16) {
            if (obj2.length() == 0) {
                SquareBaseKt.getSquareCommon().showToastSafely(requireContext(), "\u53cc\u4eba\u52a8\u4f5c\u8bf7\u586b\u5165uin2", 0);
                return false;
            }
        }
        EditText editText3 = aVar.A;
        Intrinsics.checkNotNullExpressionValue(editText3, "binding.width");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(editText3.getText().toString());
        this.width = intOrNull != null ? intOrNull.intValue() : 600;
        EditText editText4 = aVar.f445413n;
        Intrinsics.checkNotNullExpressionValue(editText4, "binding.height");
        intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(editText4.getText().toString());
        this.height = intOrNull2 != null ? intOrNull2.intValue() : 600;
        return true;
    }

    private final void checkPermission() {
        if (requireContext().checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void di() {
        wc4.a aVar = this.binding;
        if (aVar != null) {
            EditText editText = aVar.f445416q;
            Intrinsics.checkNotNullExpressionValue(editText, "binding.recordUrl");
            String obj = editText.getText().toString();
            if (obj.length() == 0) {
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            File externalCacheDir = requireContext.getExternalCacheDir();
            sb5.append(externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null);
            sb5.append('/');
            sb5.append(System.currentTimeMillis());
            String sb6 = sb5.toString();
            int i3 = this.width;
            int i16 = this.height;
            LinearLayout linearLayout = aVar.f445405f;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.container");
            Qh(obj, sb6, i3, i16, linearLayout);
        }
    }

    private final ViewGroup ei(MemeAction action) {
        ViewGroup viewGroup;
        LinearLayout linearLayout;
        wc4.a aVar = this.binding;
        if (aVar == null || (linearLayout = aVar.f445405f) == null) {
            viewGroup = null;
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(action.getTaskId());
            sb5.append('-');
            sb5.append(action.getActionId());
            sb5.append('-');
            sb5.append(action.getMode().ordinal());
            viewGroup = (ViewGroup) linearLayout.findViewWithTag(sb5.toString());
        }
        if (viewGroup instanceof ViewGroup) {
            return viewGroup;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewGroup gi(MemeZPlanAction action) {
        LinearLayout linearLayout;
        FrameLayout frameLayout = new FrameLayout(requireContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        frameLayout.setLayoutParams(layoutParams);
        TextView textView = new TextView(requireContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        textView.setLayoutParams(layoutParams2);
        textView.setText(action.getActionId() + util.base64_pad_url + action.getWidth() + 'x' + action.getHeight() + "\u5f55\u5236\u4e2d...(" + action.getMode() + ')');
        textView.setId(R.id.qg5);
        frameLayout.addView(textView);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(action.getTaskId());
        sb5.append('-');
        sb5.append(action.getPortraitId());
        sb5.append('-');
        sb5.append(action.getMode().ordinal());
        frameLayout.setTag(sb5.toString());
        wc4.a aVar = this.binding;
        if (aVar != null && (linearLayout = aVar.f445405f) != null) {
            linearLayout.addView(frameLayout, 0);
        }
        return frameLayout;
    }

    private final boolean hi() {
        CheckBox checkBox;
        wc4.a aVar = this.binding;
        if (aVar == null || (checkBox = aVar.f445424y) == null) {
            return false;
        }
        return checkBox.isChecked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r0.isMultiAction() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void ii() {
        boolean z16;
        LinearLayout linearLayout;
        Resource resource = this.selectedResource;
        if (resource != null) {
            z16 = true;
        }
        z16 = false;
        wc4.a aVar = this.binding;
        if (aVar == null || (linearLayout = aVar.f445423x) == null) {
            return;
        }
        linearLayout.setVisibility(z16 ? 0 : 8);
    }

    private final void initListener() {
        try {
            ZPlanServiceHelper.I.E0(new e());
        } catch (Exception e16) {
            Log.e("DemoRecordMp4Fragment", "registerZPlanEngineStatusUpdateListener throw e: " + e16);
        }
    }

    public final void Vh(final MemeResult result, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(parent, "parent");
        String recordPath = result.getRecordPath();
        if (TextUtils.isEmpty(recordPath)) {
            SquareBaseKt.getSquareCommon().showToastSafely(requireContext(), "\u5f55\u5236\u4ea7\u7269\u8def\u5f84\u5f02\u5e38 " + recordPath, 0);
            return;
        }
        this.playList.add(result);
        int i3 = c.f373563a[result.getAction().getMode().ordinal()];
        if (i3 == 1) {
            Intrinsics.checkNotNull(recordPath);
            final ViewGroup Rh = Rh(this, null, recordPath, result.getAction().getWidth(), result.getAction().getHeight(), parent, 1, null);
            com.tencent.square.debugger.b.f373562c.c(new Function0<Unit>() { // from class: com.tencent.square.debugger.DemoRecordMp4Fragment$addView$1
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
                    DemoRecordMp4Fragment.this.Uh(result, Rh);
                }
            });
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(recordPath);
            final ViewGroup Th = Th(this, null, recordPath, result.getAction().getWidth(), result.getAction().getHeight(), parent, 1, null);
            com.tencent.square.debugger.b.f373562c.c(new Function0<Unit>() { // from class: com.tencent.square.debugger.DemoRecordMp4Fragment$addView$2
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
                    DemoRecordMp4Fragment.this.Uh(result, Th);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object bi(Continuation<? super Unit> continuation) {
        DemoRecordMp4Fragment$doCloudRecord$1 demoRecordMp4Fragment$doCloudRecord$1;
        Object coroutine_suspended;
        int i3;
        DemoRecordMp4Fragment demoRecordMp4Fragment;
        MemeZPlanAction memeZPlanAction;
        if (continuation instanceof DemoRecordMp4Fragment$doCloudRecord$1) {
            demoRecordMp4Fragment$doCloudRecord$1 = (DemoRecordMp4Fragment$doCloudRecord$1) continuation;
            int i16 = demoRecordMp4Fragment$doCloudRecord$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                demoRecordMp4Fragment$doCloudRecord$1.label = i16 - Integer.MIN_VALUE;
                Object obj = demoRecordMp4Fragment$doCloudRecord$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = demoRecordMp4Fragment$doCloudRecord$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    boolean hi5 = hi();
                    demoRecordMp4Fragment$doCloudRecord$1.L$0 = this;
                    demoRecordMp4Fragment$doCloudRecord$1.label = 1;
                    obj = Yh(hi5, demoRecordMp4Fragment$doCloudRecord$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    demoRecordMp4Fragment = this;
                } else if (i3 == 1) {
                    demoRecordMp4Fragment = (DemoRecordMp4Fragment) demoRecordMp4Fragment$doCloudRecord$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                memeZPlanAction = (MemeZPlanAction) obj;
                if (memeZPlanAction == null) {
                    SquareBaseKt.getSquareThread().postOnUi(new DemoRecordMp4Fragment$doCloudRecord$2(demoRecordMp4Fragment, memeZPlanAction, new WeakReference(demoRecordMp4Fragment.requireContext())));
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
        demoRecordMp4Fragment$doCloudRecord$1 = new DemoRecordMp4Fragment$doCloudRecord$1(this, continuation);
        Object obj2 = demoRecordMp4Fragment$doCloudRecord$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = demoRecordMp4Fragment$doCloudRecord$1.label;
        if (i3 != 0) {
        }
        memeZPlanAction = (MemeZPlanAction) obj2;
        if (memeZPlanAction == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object ci(Continuation<? super Unit> continuation) {
        DemoRecordMp4Fragment$doLocalRecord$1 demoRecordMp4Fragment$doLocalRecord$1;
        Object coroutine_suspended;
        int i3;
        final DemoRecordMp4Fragment demoRecordMp4Fragment;
        final MemeZPlanAction memeZPlanAction;
        if (continuation instanceof DemoRecordMp4Fragment$doLocalRecord$1) {
            demoRecordMp4Fragment$doLocalRecord$1 = (DemoRecordMp4Fragment$doLocalRecord$1) continuation;
            int i16 = demoRecordMp4Fragment$doLocalRecord$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                demoRecordMp4Fragment$doLocalRecord$1.label = i16 - Integer.MIN_VALUE;
                Object obj = demoRecordMp4Fragment$doLocalRecord$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = demoRecordMp4Fragment$doLocalRecord$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    boolean hi5 = hi();
                    demoRecordMp4Fragment$doLocalRecord$1.L$0 = this;
                    demoRecordMp4Fragment$doLocalRecord$1.label = 1;
                    obj = Yh(hi5, demoRecordMp4Fragment$doLocalRecord$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    demoRecordMp4Fragment = this;
                } else if (i3 == 1) {
                    demoRecordMp4Fragment = (DemoRecordMp4Fragment) demoRecordMp4Fragment$doLocalRecord$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                memeZPlanAction = (MemeZPlanAction) obj;
                if (memeZPlanAction == null) {
                    SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.square.debugger.DemoRecordMp4Fragment$doLocalRecord$2
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
                            ViewGroup gi5;
                            File o16 = Meme.f385754h.o(memeZPlanAction.getKey());
                            gi5 = DemoRecordMp4Fragment.this.gi(memeZPlanAction);
                            if (o16 != null && o16.exists()) {
                                DemoRecordMp4Fragment demoRecordMp4Fragment2 = DemoRecordMp4Fragment.this;
                                String absolutePath = o16.getAbsolutePath();
                                Intrinsics.checkNotNullExpressionValue(absolutePath, "cacheFile.absolutePath");
                                demoRecordMp4Fragment2.Qh("", absolutePath, DemoRecordMp4Fragment.this.width, DemoRecordMp4Fragment.this.height, gi5);
                                return;
                            }
                            SquareBase.INSTANCE.getConfig().getRecorder().simpleRecordAction(memeZPlanAction, true);
                        }
                    });
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
        demoRecordMp4Fragment$doLocalRecord$1 = new DemoRecordMp4Fragment$doLocalRecord$1(this, continuation);
        Object obj2 = demoRecordMp4Fragment$doLocalRecord$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = demoRecordMp4Fragment$doLocalRecord$1.label;
        if (i3 != 0) {
        }
        memeZPlanAction = (MemeZPlanAction) obj2;
        if (memeZPlanAction == null) {
        }
    }

    @Override // com.tencent.zplan.meme.a
    public void d3(MemeAction action, float f16) {
        Intrinsics.checkNotNullParameter(action, "action");
        a.C10066a.a(this, action, f16);
    }

    @Override // com.tencent.zplan.meme.a
    public void l9(boolean success, MemeResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Log.d("DemoRecordMp4Fragment", "success:" + success + " id:" + result.getAction().getActionId() + " path:" + result.getRecordPath() + ", " + result.getAction().getActionStatus().toInt());
        b bVar = this.handler;
        Message message = new Message();
        message.what = success ? 1 : 0;
        ViewGroup ei5 = ei(result.getAction());
        if (ei5 != null) {
            message.obj = new RecordDoneMessageInfo(ei5, result);
        }
        Unit unit = Unit.INSTANCE;
        bVar.sendMessage(message);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        wc4.a aVar;
        boolean endsWith$default;
        boolean endsWith$default2;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == -1 && (aVar = this.binding) != null) {
            xc4.c cVar = xc4.c.f447785a;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            String c16 = cVar.c(requireContext, data != null ? data.getData() : null);
            if (c16 != null) {
                Log.d("DemoRecordMp4Fragment", "choose path:" + c16);
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(c16, ".mp4", false, 2, null);
                if (!endsWith$default) {
                    endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(c16, ".png", false, 2, null);
                    if (endsWith$default2) {
                        int i3 = this.width;
                        int i16 = this.height;
                        LinearLayout linearLayout = aVar.f445405f;
                        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.container");
                        Th(this, null, c16, i3, i16, linearLayout, 1, null);
                        return;
                    }
                    return;
                }
                int i17 = this.width;
                int i18 = this.height;
                LinearLayout linearLayout2 = aVar.f445405f;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.container");
                Rh(this, null, c16, i17, i18, linearLayout2, 1, null);
            }
        }
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public void onCloudRecordSuccess(int actionId, RecordIdentifier recordIdentifier, RecordSource cover, RecordSource mp42) {
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        Intrinsics.checkNotNullParameter(cover, "cover");
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        wc4.a g16 = wc4.a.g(getLayoutInflater());
        this.binding = g16;
        Intrinsics.checkNotNullExpressionValue(g16, "ActivityDemoRecordMp4Bin\u2026 binding = this\n        }");
        ScrollView root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "ActivityDemoRecordMp4Bin\u2026ing = this\n        }.root");
        return root;
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        SquareBase.INSTANCE.getConfig().getRecorder().removeRecordDoneCallback(this);
        super.onDestroyView();
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public void onLocalRecordSuccess(int actionId, RecordIdentifier recordIdentifier, RecordSource cover, RecordSource mp42) {
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        Intrinsics.checkNotNullParameter(cover, "cover");
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public void onRecordDone(boolean success, MemeResult result, RecordIdentifier identifier) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Log.i("DemoRecordMp4Fragment", "onRecordDone success:" + success + " id:" + result.getAction().getActionId() + " path:" + result.getRecordPath() + ", " + result.getAction().getActionStatus().toInt());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onRecordDone ");
        sb5.append(String.valueOf(result.i()));
        sb5.append(" - ");
        sb5.append(result.getAction());
        Log.i("DemoRecordMp4Fragment", sb5.toString());
        b bVar = this.handler;
        Message message = new Message();
        message.what = success ? 1 : 0;
        ViewGroup ei5 = ei(result.getAction());
        if (ei5 != null) {
            message.obj = new RecordDoneMessageInfo(ei5, result);
        }
        Unit unit = Unit.INSTANCE;
        bVar.sendMessage(message);
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public void onRecordError(int actionId, int type, int errorCode, RecordIdentifier recordIdentifier) {
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
    }

    @Override // com.tencent.state.square.api.RecordSuccessListener
    public void onUploadSuccess(int actionId, RecordIdentifier recordIdentifier, RecordSource cover, RecordSource mp42) {
        Intrinsics.checkNotNullParameter(recordIdentifier, "recordIdentifier");
        Intrinsics.checkNotNullParameter(cover, "cover");
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        MutableLiveData<PanelInfo> panelInfo;
        List<Long> emptyList;
        Intrinsics.checkNotNullParameter(view, "view");
        wc4.a aVar = this.binding;
        if (aVar != null) {
            SquareBase.INSTANCE.getConfig().getRecorder().addRecordDoneCallback(this);
            this.cloudApi = new CloudRecordApiImpl();
            aVar.f445407h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.square.debugger.DemoRecordMp4Fragment$onViewCreated$1

                /* compiled from: P */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
                @DebugMetadata(c = "com.tencent.square.debugger.DemoRecordMp4Fragment$onViewCreated$1$1", f = "DemoRecordMp4Fragment.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.square.debugger.DemoRecordMp4Fragment$onViewCreated$1$1, reason: invalid class name */
                /* loaded from: classes34.dex */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;

                    AnonymousClass1(Continuation continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
                        Intrinsics.checkNotNullParameter(completion, "completion");
                        return new AnonymousClass1(completion);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended;
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i3 = this.label;
                        if (i3 == 0) {
                            ResultKt.throwOnFailure(obj);
                            DemoRecordMp4Fragment demoRecordMp4Fragment = DemoRecordMp4Fragment.this;
                            this.label = 1;
                            if (demoRecordMp4Fragment.ci(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
                }
            });
            SquareStatusViewModel squareStatusViewModel = (SquareStatusViewModel) new ViewModelProvider(this, new SquareStatusViewModelFactory()).get(SquareStatusViewModel.class);
            this.viewModel = squareStatusViewModel;
            if (squareStatusViewModel != null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                squareStatusViewModel.loadStatusListData(true, 11, 1000, emptyList);
            }
            SquareStatusViewModel squareStatusViewModel2 = this.viewModel;
            if (squareStatusViewModel2 != null && (panelInfo = squareStatusViewModel2.getPanelInfo()) != null) {
                panelInfo.observe(getViewLifecycleOwner(), new o(aVar));
            }
            Spinner spinner = aVar.f445417r;
            Intrinsics.checkNotNullExpressionValue(spinner, "binding.selector");
            spinner.setAdapter((SpinnerAdapter) new p());
            Spinner spinner2 = aVar.f445417r;
            Intrinsics.checkNotNullExpressionValue(spinner2, "binding.selector");
            spinner2.setOnItemSelectedListener(new q());
            aVar.A.setText(String.valueOf(this.width));
            aVar.f445413n.setText(String.valueOf(this.height));
            aVar.f445411l.setSelection(0);
            Spinner spinner3 = aVar.f445411l;
            Intrinsics.checkNotNullExpressionValue(spinner3, "binding.encodeMode");
            spinner3.setOnItemSelectedListener(new r());
            aVar.f445404e.setOnClickListener(new s(aVar));
            Spinner spinner4 = aVar.f445420u;
            Intrinsics.checkNotNullExpressionValue(spinner4, "binding.type");
            spinner4.setOnItemSelectedListener(new t());
            aVar.f445402c.setSelection(5);
            Spinner spinner5 = aVar.f445402c;
            Intrinsics.checkNotNullExpressionValue(spinner5, "binding.aaType");
            spinner5.setOnItemSelectedListener(new u());
            aVar.f445401b.setSelection(4);
            Spinner spinner6 = aVar.f445401b;
            Intrinsics.checkNotNullExpressionValue(spinner6, "binding.aaLevel");
            spinner6.setOnItemSelectedListener(new v());
            aVar.f445412m.setSelection(0);
            Spinner spinner7 = aVar.f445412m;
            Intrinsics.checkNotNullExpressionValue(spinner7, "binding.encodeType");
            spinner7.setOnItemSelectedListener(new f());
            CheckBox checkBox = aVar.f445414o;
            Intrinsics.checkNotNullExpressionValue(checkBox, "binding.isDebug");
            checkBox.setChecked(this.isDebug);
            aVar.f445414o.setOnCheckedChangeListener(new g());
            CheckBox checkBox2 = aVar.f445425z;
            Intrinsics.checkNotNullExpressionValue(checkBox2, "binding.useV2");
            checkBox2.setChecked(this.useV2);
            aVar.f445425z.setOnCheckedChangeListener(new h());
            CheckBox checkBox3 = aVar.f445418s;
            Intrinsics.checkNotNullExpressionValue(checkBox3, "binding.shaderUseMulti");
            com.tencent.square.debugger.b bVar = com.tencent.square.debugger.b.f373562c;
            checkBox3.setChecked(bVar.b());
            aVar.f445418s.setOnCheckedChangeListener(i.f373513d);
            aVar.f445410k.setOnClickListener(new j());
            aVar.f445408i.setOnClickListener(new k());
            aVar.f445406g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.square.debugger.DemoRecordMp4Fragment$onViewCreated$16

                /* compiled from: P */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
                @DebugMetadata(c = "com.tencent.square.debugger.DemoRecordMp4Fragment$onViewCreated$16$1", f = "DemoRecordMp4Fragment.kt", i = {}, l = {QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_EXTERNAL_COMMENT_TYPE}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.square.debugger.DemoRecordMp4Fragment$onViewCreated$16$1, reason: invalid class name */
                /* loaded from: classes34.dex */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;

                    AnonymousClass1(Continuation continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
                        Intrinsics.checkNotNullParameter(completion, "completion");
                        return new AnonymousClass1(completion);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended;
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i3 = this.label;
                        if (i3 == 0) {
                            ResultKt.throwOnFailure(obj);
                            DemoRecordMp4Fragment demoRecordMp4Fragment = DemoRecordMp4Fragment.this;
                            this.label = 1;
                            if (demoRecordMp4Fragment.bi(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i3 == 1) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
                }
            });
            aVar.f445409j.setOnClickListener(new l());
            aVar.f445421v.setText(bVar.a());
            aVar.f445422w.setText(this.uin2);
            aVar.f445403d.setSelection(this.actionStyle);
            Spinner spinner8 = aVar.f445403d;
            Intrinsics.checkNotNullExpressionValue(spinner8, "binding.actionStyle");
            spinner8.setOnItemSelectedListener(new m());
            aVar.f445415p.setOnClickListener(new n(aVar, new WeakReference(requireContext())));
            ii();
            initListener();
            checkPermission();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/square/debugger/DemoRecordMp4Fragment$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "()Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/zplan/meme/model/MemeResult;", "b", "Lcom/tencent/zplan/meme/model/MemeResult;", "()Lcom/tencent/zplan/meme/model/MemeResult;", "result", "<init>", "(Landroid/view/ViewGroup;Lcom/tencent/zplan/meme/model/MemeResult;)V", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.square.debugger.DemoRecordMp4Fragment$c, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class RecordDoneMessageInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final ViewGroup parent;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final MemeResult result;

        public RecordDoneMessageInfo(ViewGroup viewGroup, MemeResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.parent = viewGroup;
            this.result = result;
        }

        /* renamed from: a, reason: from getter */
        public final ViewGroup getParent() {
            return this.parent;
        }

        /* renamed from: b, reason: from getter */
        public final MemeResult getResult() {
            return this.result;
        }

        public int hashCode() {
            ViewGroup viewGroup = this.parent;
            int hashCode = (viewGroup != null ? viewGroup.hashCode() : 0) * 31;
            MemeResult memeResult = this.result;
            return hashCode + (memeResult != null ? memeResult.hashCode() : 0);
        }

        public String toString() {
            return "RecordDoneMessageInfo(parent=" + this.parent + ", result=" + this.result + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RecordDoneMessageInfo)) {
                return false;
            }
            RecordDoneMessageInfo recordDoneMessageInfo = (RecordDoneMessageInfo) other;
            return Intrinsics.areEqual(this.parent, recordDoneMessageInfo.parent) && Intrinsics.areEqual(this.result, recordDoneMessageInfo.result);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/square/debugger/DemoRecordMp4Fragment$q", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "view", "", "position", "", "id", "", "onItemSelected", "onNothingSelected", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class q implements AdapterView.OnItemSelectedListener {
        q() {
        }

        /* JADX WARN: Type inference failed for: r1v8, types: [android.widget.Adapter] */
        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id5) {
            ?? adapter;
            Object item = (parent == null || (adapter = parent.getAdapter()) == 0) ? null : adapter.getItem(position);
            if (item != null) {
                Object component2 = ((Pair) item).component2();
                Resource resource = (Resource) (component2 instanceof Resource ? component2 : null);
                if (resource != null) {
                    DemoRecordMp4Fragment.this.selectedResource = resource;
                    DemoRecordMp4Fragment.this.ii();
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Pair<*, *>");
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewGroup Qh(final String url, final String path, final int width, final int height, final ViewGroup parent) {
        Log.d("DemoRecordMp4Fragment", "addMp4 view url:" + url);
        TextView textView = (TextView) parent.findViewById(R.id.qg5);
        if (textView != null) {
            textView.setVisibility(8);
        }
        xc4.d dVar = xc4.d.f447786a;
        int i3 = width / 2;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        int a16 = dVar.a(i3, requireContext);
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a16, dVar.a(height / 2, requireContext2));
        layoutParams.gravity = 17;
        final LinearLayout linearLayout = new LinearLayout(requireContext());
        Context requireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dVar.a(i3, requireContext3), -2);
        layoutParams2.gravity = 17;
        Unit unit = Unit.INSTANCE;
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOrientation(1);
        final FrameLayout frameLayout = new FrameLayout(requireContext());
        frameLayout.setLayoutParams(layoutParams);
        final WeakReference weakReference = new WeakReference(requireContext());
        Context requireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext4, "requireContext()");
        final SquareVideoView squareVideoView = new SquareVideoView(requireContext4, null, 0, null, 14, null);
        squareVideoView.setLayoutParams(layoutParams);
        squareVideoView.setPlayerPool(this.squarePlayerPool);
        squareVideoView.start(new MediaSource(url, path, null, null, false, 28, null));
        squareVideoView.setListener(new com.tencent.square.debugger.d() { // from class: com.tencent.square.debugger.DemoRecordMp4Fragment$addMp4View$$inlined$apply$lambda$1
            @Override // com.tencent.state.square.media.ISquarePlayer.Listener
            public void onVideoError(final int code, final String message) {
                wc4.a aVar;
                LinearLayout linearLayout2;
                Intrinsics.checkNotNullParameter(message, "message");
                Log.d("DemoRecordMp4Fragment", "onVideoError " + code + ", " + message);
                aVar = DemoRecordMp4Fragment.this.binding;
                if (aVar != null && (linearLayout2 = aVar.f445405f) != null) {
                    linearLayout2.removeView(linearLayout);
                }
                final ViewGroup Sh = DemoRecordMp4Fragment.this.Sh(url, path, width, height, parent);
                b.f373562c.c(new Function0<Unit>() { // from class: com.tencent.square.debugger.DemoRecordMp4Fragment$addMp4View$$inlined$apply$lambda$1.1
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
                        SquareBaseKt.getSquareCommon().showToastSafely((Context) weakReference.get(), "onVideoError " + code + ", " + message, 0);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("addCloudRecordInfoView view url:");
                        sb5.append(url);
                        Log.d("DemoRecordMp4Fragment", sb5.toString());
                        DemoRecordMp4Fragment$addMp4View$$inlined$apply$lambda$1 demoRecordMp4Fragment$addMp4View$$inlined$apply$lambda$1 = DemoRecordMp4Fragment$addMp4View$$inlined$apply$lambda$1.this;
                        DemoRecordMp4Fragment.this.Ph(url, Sh);
                    }
                });
            }
        });
        squareVideoView.setLoopPlay(true);
        com.tencent.square.debugger.b.f373562c.c(new Function0<Unit>() { // from class: com.tencent.square.debugger.DemoRecordMp4Fragment$addMp4View$1
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
                frameLayout.addView(squareVideoView);
                linearLayout.addView(frameLayout);
                parent.addView(linearLayout, 0);
            }
        });
        return linearLayout;
    }

    static /* synthetic */ ViewGroup Rh(DemoRecordMp4Fragment demoRecordMp4Fragment, String str, String str2, int i3, int i16, ViewGroup viewGroup, int i17, Object obj) {
        return demoRecordMp4Fragment.Qh((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? "" : str2, i3, i16, viewGroup);
    }

    static /* synthetic */ ViewGroup Th(DemoRecordMp4Fragment demoRecordMp4Fragment, String str, String str2, int i3, int i16, ViewGroup viewGroup, int i17, Object obj) {
        return demoRecordMp4Fragment.Sh((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? "" : str2, i3, i16, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai(String dirStr) {
        if (dirStr != null) {
            int length = dirStr.length() - 1;
            int i3 = 0;
            boolean z16 = false;
            while (i3 <= length) {
                boolean z17 = Intrinsics.compare((int) dirStr.charAt(!z16 ? i3 : length), 32) <= 0;
                if (z16) {
                    if (!z17) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z17) {
                    i3++;
                } else {
                    z16 = true;
                }
            }
            if (dirStr.subSequence(i3, length + 1).toString().length() == 0) {
                return;
            }
            File file = new File(dirStr);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    if (true ^ (listFiles.length == 0)) {
                        int length2 = listFiles.length;
                        for (int i16 = 0; i16 < length2; i16++) {
                            File file2 = listFiles[i16];
                            Intrinsics.checkNotNullExpressionValue(file2, "childDirList[i]");
                            if (file2.isDirectory()) {
                                File file3 = listFiles[i16];
                                Intrinsics.checkNotNullExpressionValue(file3, "childDirList[i]");
                                ai(file3.getAbsolutePath());
                            } else {
                                listFiles[i16].delete();
                            }
                        }
                    }
                }
                file.delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewGroup Sh(final String url, final String path, int width, int height, final ViewGroup parent) {
        TextView textView = (TextView) parent.findViewById(R.id.qg5);
        if (textView != null) {
            textView.setVisibility(8);
        }
        xc4.d dVar = xc4.d.f447786a;
        int i3 = width / 2;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        int a16 = dVar.a(i3, requireContext);
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a16, dVar.a(height / 2, requireContext2));
        layoutParams.gravity = 17;
        final LinearLayout linearLayout = new LinearLayout(requireContext());
        Context requireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dVar.a(i3, requireContext3), -2);
        layoutParams2.gravity = 17;
        Unit unit = Unit.INSTANCE;
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOrientation(1);
        com.tencent.square.debugger.b.f373562c.c(new Function0<Unit>() { // from class: com.tencent.square.debugger.DemoRecordMp4Fragment$addPngView$1
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
                FrameLayout frameLayout = new FrameLayout(DemoRecordMp4Fragment.this.requireContext());
                frameLayout.setLayoutParams(layoutParams);
                SquareImageView squareImageView = new SquareImageView(DemoRecordMp4Fragment.this.requireContext());
                squareImageView.setLayoutParams(layoutParams);
                squareImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                if (!TextUtils.isEmpty(url)) {
                    squareImageView.setImageDrawable(URLDrawable.getDrawable(url, SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null)));
                } else if (!TextUtils.isEmpty(path)) {
                    squareImageView.setImageDrawable(URLDrawable.getFileDrawable(path, SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null)));
                }
                frameLayout.addView(squareImageView);
                linearLayout.addView(frameLayout);
                parent.addView(linearLayout, 0);
            }
        });
        return linearLayout;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J$\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/square/debugger/DemoRecordMp4Fragment$p", "Landroid/widget/BaseAdapter;", "", "getCount", "position", "Lkotlin/Pair;", "", "Lcom/tencent/state/square/data/Resource;", "a", "", "getItemId", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class p extends BaseAdapter {
        p() {
        }

        @Override // android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Pair<String, Resource> getItem(int position) {
            Object orNull;
            orNull = CollectionsKt___CollectionsKt.getOrNull(DemoRecordMp4Fragment.this.Wh(), position);
            return (Pair) orNull;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return DemoRecordMp4Fragment.this.Wh().size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(parent != null ? parent.getContext() : null).inflate(android.R.layout.simple_spinner_item, parent, false);
                convertView.setPadding(ViewExtensionsKt.dip(convertView, 16), ViewExtensionsKt.dip(convertView, 8), ViewExtensionsKt.dip(convertView, 16), ViewExtensionsKt.dip(convertView, 8));
            }
            Pair<String, Resource> item = getItem(position);
            if (item != null) {
                View findViewById = convertView.findViewById(android.R.id.text1);
                Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById<an\u2026View>(android.R.id.text1)");
                ((TextView) findViewById).setText(item.getFirst());
            }
            Intrinsics.checkNotNullExpressionValue(convertView, "itemView");
            return convertView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object Yh(boolean z16, Continuation<? super MemeZPlanAction> continuation) {
        DemoRecordMp4Fragment$buildMemeZPlanAction$1 demoRecordMp4Fragment$buildMemeZPlanAction$1;
        Object coroutine_suspended;
        int i3;
        Resource resource;
        DemoRecordMp4Fragment demoRecordMp4Fragment;
        Resource resource2;
        long j3;
        Long l3;
        EnumUserGender gender;
        if (continuation instanceof DemoRecordMp4Fragment$buildMemeZPlanAction$1) {
            demoRecordMp4Fragment$buildMemeZPlanAction$1 = (DemoRecordMp4Fragment$buildMemeZPlanAction$1) continuation;
            int i16 = demoRecordMp4Fragment$buildMemeZPlanAction$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                demoRecordMp4Fragment$buildMemeZPlanAction$1.label = i16 - Integer.MIN_VALUE;
                DemoRecordMp4Fragment$buildMemeZPlanAction$1 demoRecordMp4Fragment$buildMemeZPlanAction$12 = demoRecordMp4Fragment$buildMemeZPlanAction$1;
                Object obj = demoRecordMp4Fragment$buildMemeZPlanAction$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = demoRecordMp4Fragment$buildMemeZPlanAction$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (Zh() && (resource = this.selectedResource) != null) {
                        boolean isMultiAction = resource.isMultiAction();
                        long parseLong = Long.parseLong(this.uin);
                        Long boxLong = isMultiAction ? Boxing.boxLong(Long.parseLong(this.uin2)) : null;
                        if (z16) {
                            SquareActionHelper squareActionHelper = SquareActionHelper.INSTANCE;
                            String url = resource.getFilament().getUrl();
                            demoRecordMp4Fragment$buildMemeZPlanAction$12.L$0 = this;
                            demoRecordMp4Fragment$buildMemeZPlanAction$12.L$1 = resource;
                            demoRecordMp4Fragment$buildMemeZPlanAction$12.L$2 = boxLong;
                            demoRecordMp4Fragment$buildMemeZPlanAction$12.J$0 = parseLong;
                            demoRecordMp4Fragment$buildMemeZPlanAction$12.label = 1;
                            Object loadPlayParams = squareActionHelper.loadPlayParams(parseLong, boxLong, url, demoRecordMp4Fragment$buildMemeZPlanAction$12);
                            if (loadPlayParams == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            demoRecordMp4Fragment = this;
                            resource2 = resource;
                            obj = loadPlayParams;
                            j3 = parseLong;
                            l3 = boxLong;
                        } else {
                            int actionId = resource.getActionId();
                            int i17 = this.width;
                            int i18 = this.height;
                            MODE mode = this.mode;
                            String valueOf = String.valueOf(parseLong);
                            String valueOf2 = boxLong != null ? String.valueOf(boxLong.longValue()) : null;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(parseLong);
                            sb5.append(util.base64_pad_url);
                            sb5.append(boxLong);
                            sb5.append(util.base64_pad_url);
                            sb5.append(resource.getActionId());
                            String c16 = com.tencent.zplan.common.utils.d.c(sb5.toString());
                            Intrinsics.checkNotNullExpressionValue(c16, "MD5.toMD5(\"${selectedUin\u20262}_${resource.actionId}\")");
                            MemeZPlanAction memeZPlanAction = new MemeZPlanAction(actionId, -1, i17, i18, mode, valueOf, valueOf2, c16, null, null, null, null, null, null, 16128, null);
                            memeZPlanAction.getConfig().C(BusinessConfig.FrameType.PNG);
                            memeZPlanAction.getConfig().w(this.aaType);
                            memeZPlanAction.getConfig().v(this.aaLevel);
                            memeZPlanAction.getConfig().getMp4Config().l(this.encodeType);
                            memeZPlanAction.getConfig().getMp4Config().k(this.isDebug);
                            memeZPlanAction.getConfig().M(this.useV2);
                            memeZPlanAction.getConfig().getMp4Config().m(this.encodeMode);
                            memeZPlanAction.getConfig().x(this.actionStyle);
                            return memeZPlanAction;
                        }
                    }
                    return null;
                }
                if (i3 == 1) {
                    j3 = demoRecordMp4Fragment$buildMemeZPlanAction$12.J$0;
                    l3 = (Long) demoRecordMp4Fragment$buildMemeZPlanAction$12.L$2;
                    resource2 = (Resource) demoRecordMp4Fragment$buildMemeZPlanAction$12.L$1;
                    demoRecordMp4Fragment = (DemoRecordMp4Fragment) demoRecordMp4Fragment$buildMemeZPlanAction$12.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                SquareAvatarData squareAvatarData = (SquareAvatarData) ((Triple) obj).component2();
                SquareBaseKt.getSquareLog().i("DemoRecordMp4Fragment", "filament record playData:" + squareAvatarData.toJson());
                int actionId2 = resource2.getActionId();
                int i19 = demoRecordMp4Fragment.width;
                int i26 = demoRecordMp4Fragment.height;
                MODE mode2 = demoRecordMp4Fragment.mode;
                String valueOf3 = String.valueOf(j3);
                String valueOf4 = l3 == null ? String.valueOf(l3.longValue()) : null;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(j3);
                sb6.append(util.base64_pad_url);
                sb6.append(l3);
                sb6.append(util.base64_pad_url);
                sb6.append(resource2.getActionId());
                String c17 = com.tencent.zplan.common.utils.d.c(sb6.toString());
                Intrinsics.checkNotNullExpressionValue(c17, "MD5.toMD5(\"${selectedUin\u20262}_${resource.actionId}\")");
                Integer boxInt = Boxing.boxInt(squareAvatarData.getHost().getGender().getValue());
                SquareAvatarData.AvatarData guest = squareAvatarData.getGuest();
                MemeZPlanAction memeZPlanAction2 = new MemeZPlanAction(actionId2, -1, i19, i26, mode2, valueOf3, valueOf4, c17, null, boxInt, (guest != null || (gender = guest.getGender()) == null) ? null : Boxing.boxInt(gender.getValue()), null, null, squareAvatarData.toJson(), QQLiveError.ANCHOR_ISOLATE_CLOSE_SDK_NOT_READY, null);
                memeZPlanAction2.getConfig().C(BusinessConfig.FrameType.PNG);
                memeZPlanAction2.getConfig().w(demoRecordMp4Fragment.aaType);
                memeZPlanAction2.getConfig().v(demoRecordMp4Fragment.aaLevel);
                memeZPlanAction2.getConfig().getMp4Config().l(demoRecordMp4Fragment.encodeType);
                memeZPlanAction2.getConfig().getMp4Config().k(demoRecordMp4Fragment.isDebug);
                memeZPlanAction2.getConfig().M(demoRecordMp4Fragment.useV2);
                memeZPlanAction2.getConfig().getMp4Config().m(demoRecordMp4Fragment.encodeMode);
                memeZPlanAction2.getConfig().x(demoRecordMp4Fragment.actionStyle);
                memeZPlanAction2.getConfig().G(new EngineType.Filament(SquareFilamentNativeAppRecorder.class));
                return memeZPlanAction2;
            }
        }
        demoRecordMp4Fragment$buildMemeZPlanAction$1 = new DemoRecordMp4Fragment$buildMemeZPlanAction$1(this, continuation);
        DemoRecordMp4Fragment$buildMemeZPlanAction$1 demoRecordMp4Fragment$buildMemeZPlanAction$122 = demoRecordMp4Fragment$buildMemeZPlanAction$1;
        Object obj2 = demoRecordMp4Fragment$buildMemeZPlanAction$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = demoRecordMp4Fragment$buildMemeZPlanAction$122.label;
        if (i3 != 0) {
        }
        SquareAvatarData squareAvatarData2 = (SquareAvatarData) ((Triple) obj2).component2();
        SquareBaseKt.getSquareLog().i("DemoRecordMp4Fragment", "filament record playData:" + squareAvatarData2.toJson());
        int actionId22 = resource2.getActionId();
        int i192 = demoRecordMp4Fragment.width;
        int i262 = demoRecordMp4Fragment.height;
        MODE mode22 = demoRecordMp4Fragment.mode;
        String valueOf32 = String.valueOf(j3);
        if (l3 == null) {
        }
        StringBuilder sb62 = new StringBuilder();
        sb62.append(j3);
        sb62.append(util.base64_pad_url);
        sb62.append(l3);
        sb62.append(util.base64_pad_url);
        sb62.append(resource2.getActionId());
        String c172 = com.tencent.zplan.common.utils.d.c(sb62.toString());
        Intrinsics.checkNotNullExpressionValue(c172, "MD5.toMD5(\"${selectedUin\u20262}_${resource.actionId}\")");
        Integer boxInt2 = Boxing.boxInt(squareAvatarData2.getHost().getGender().getValue());
        SquareAvatarData.AvatarData guest2 = squareAvatarData2.getGuest();
        MemeZPlanAction memeZPlanAction22 = new MemeZPlanAction(actionId22, -1, i192, i262, mode22, valueOf32, valueOf4, c172, null, boxInt2, (guest2 != null || (gender = guest2.getGender()) == null) ? null : Boxing.boxInt(gender.getValue()), null, null, squareAvatarData2.toJson(), QQLiveError.ANCHOR_ISOLATE_CLOSE_SDK_NOT_READY, null);
        memeZPlanAction22.getConfig().C(BusinessConfig.FrameType.PNG);
        memeZPlanAction22.getConfig().w(demoRecordMp4Fragment.aaType);
        memeZPlanAction22.getConfig().v(demoRecordMp4Fragment.aaLevel);
        memeZPlanAction22.getConfig().getMp4Config().l(demoRecordMp4Fragment.encodeType);
        memeZPlanAction22.getConfig().getMp4Config().k(demoRecordMp4Fragment.isDebug);
        memeZPlanAction22.getConfig().M(demoRecordMp4Fragment.useV2);
        memeZPlanAction22.getConfig().getMp4Config().m(demoRecordMp4Fragment.encodeMode);
        memeZPlanAction22.getConfig().x(demoRecordMp4Fragment.actionStyle);
        memeZPlanAction22.getConfig().G(new EngineType.Filament(SquareFilamentNativeAppRecorder.class));
        return memeZPlanAction22;
    }

    private final String fi(long length) {
        if (length >= 1073741824) {
            return Xh(length, 1073741824L, "GB");
        }
        if (length >= 1048576) {
            return Xh(length, 1073741824L, "MB");
        }
        if (length >= 1024) {
            return Xh(length, 1024L, "KB");
        }
        return length + " B";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/square/debugger/DemoRecordMp4Fragment$f", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "view", "", "position", "", "id", "", "onItemSelected", "onNothingSelected", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class f implements AdapterView.OnItemSelectedListener {
        f() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id5) {
            int ordinal;
            DemoRecordMp4Fragment demoRecordMp4Fragment = DemoRecordMp4Fragment.this;
            if (position != 0) {
                ordinal = EncodeType.HARDWARE.ordinal();
            } else {
                ordinal = EncodeType.SOFTWARE.ordinal();
            }
            demoRecordMp4Fragment.encodeType = ordinal;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/square/debugger/DemoRecordMp4Fragment$m", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "view", "", "position", "", "id", "", "onItemSelected", "onNothingSelected", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class m implements AdapterView.OnItemSelectedListener {
        m() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id5) {
            DemoRecordMp4Fragment.this.actionStyle = position - 1;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/square/debugger/DemoRecordMp4Fragment$r", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "view", "", "position", "", "id", "", "onItemSelected", "onNothingSelected", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class r implements AdapterView.OnItemSelectedListener {
        r() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id5) {
            DemoRecordMp4Fragment.this.encodeMode = position;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/square/debugger/DemoRecordMp4Fragment$t", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "view", "", "position", "", "id", "", "onItemSelected", "onNothingSelected", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class t implements AdapterView.OnItemSelectedListener {
        t() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id5) {
            MODE mode;
            DemoRecordMp4Fragment demoRecordMp4Fragment = DemoRecordMp4Fragment.this;
            if (position == 0) {
                mode = MODE.MP4;
            } else if (position == 1) {
                mode = MODE.FRAME;
            } else if (position == 2) {
                mode = MODE.SHARPP;
            } else if (position == 3) {
                mode = MODE.APNG;
            } else if (position != 4) {
                mode = MODE.MP4;
            } else {
                mode = MODE.GIF;
            }
            demoRecordMp4Fragment.mode = mode;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/square/debugger/DemoRecordMp4Fragment$u", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "view", "", "position", "", "id", "", "onItemSelected", "onNothingSelected", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class u implements AdapterView.OnItemSelectedListener {
        u() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id5) {
            DemoRecordMp4Fragment.this.aaType = position != 0 ? Integer.valueOf(position - 1) : null;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u000b\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/square/debugger/DemoRecordMp4Fragment$v", "Landroid/widget/AdapterView$OnItemSelectedListener;", "Landroid/widget/AdapterView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "view", "", "position", "", "id", "", "onItemSelected", "onNothingSelected", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes34.dex */
    public static final class v implements AdapterView.OnItemSelectedListener {
        v() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id5) {
            DemoRecordMp4Fragment.this.aaLevel = position != 0 ? Integer.valueOf(position - 1) : null;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }
}
