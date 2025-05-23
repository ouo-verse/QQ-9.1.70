package com.tencent.mobileqq.dt.kuikly.module;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.inputmethod.InputMethodManager;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.util.ex.FromScene;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingFragment;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.dt.api.JubaoMsgData;
import com.tencent.mobileqq.dt.kuikly.ui.HRQUSHalfScreenFloatingView;
import com.tencent.mobileqq.dt.web.O3BusinessHandler;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.sdk.JsonORM;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.profilecard.api.IProfileCardFeatureApi;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.IRelationBlacklistApi;
import com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.nt.adapter.session.f;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqnt.aio.adapter.api.ITroopApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msgselect.api.IMsgSelectFragmentApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.utils.i;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import cooperation.qzone.QzoneIPCModule;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$BlockRsp;
import tencent.im.oidb.cmdBlacklist.RelationBlacklist$CheckRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u0000 @2\u00020\u0001:\u0001bB\u0007\u00a2\u0006\u0004\b`\u0010aJ?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J?\u0010\u000f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J?\u0010\u0016\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0017\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0018\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0019\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\u0012\u0010\u001a\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J?\u0010\u001b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\u001a\u0010 \u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0002H\u0002J\u0018\u0010'\u001a\u00020\u00022\u0006\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020!H\u0002J\u001a\u0010)\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\b\b\u0002\u0010(\u001a\u00020\u0002H\u0002J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020*H\u0002J\u0010\u0010,\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020*H\u0002J?\u0010-\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J \u00102\u001a\u00020\u00022\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020/0.j\b\u0012\u0004\u0012\u00020/`0H\u0002J?\u00103\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u00104\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\u0010\u00106\u001a\u00020\u001c2\u0006\u00105\u001a\u00020*H\u0002J\u0010\u00107\u001a\u00020\t2\u0006\u00105\u001a\u00020*H\u0002J\u0010\u00108\u001a\u00020\t2\u0006\u00105\u001a\u00020*H\u0002J0\u0010?\u001a\u00020\t2\u0006\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020=H\u0002J\u0010\u0010@\u001a\u00020\u001c2\u0006\u00105\u001a\u00020*H\u0002J\b\u0010A\u001a\u00020\tH\u0002J\b\u0010B\u001a\u00020\tH\u0002J\"\u0010F\u001a\u00020\t2\u0006\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020!2\b\u0010(\u001a\u0004\u0018\u00010EH\u0002J\u001a\u0010H\u001a\u00020\t2\b\u0010G\u001a\u0004\u0018\u00010E2\u0006\u0010D\u001a\u00020!H\u0002J\u001a\u0010I\u001a\u00020\t2\b\u0010G\u001a\u0004\u0018\u00010E2\u0006\u0010D\u001a\u00020!H\u0002J?\u0010J\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010K\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010L\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010M\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JI\u0010O\u001a\u0004\u0018\u00010\u00052\u0006\u0010N\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016J\b\u0010P\u001a\u00020\tH\u0016R\u0018\u0010S\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR;\u0010V\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR;\u0010X\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010UR;\u0010Z\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010UR;\u0010\\\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010UR\u0016\u0010]\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010\u001aR\u0016\u0010_\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010^\u00a8\u0006c"}, d2 = {"Lcom/tencent/mobileqq/dt/kuikly/module/O3Module;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "G", "M", "X", "c0", "", "bytes", "W", "input", "V", "B", "N", "E", BdhLogUtil.LogTag.Tag_Conn, "r", "Z", "a0", "", "isSuccess", "Landroid/os/Bundle;", "bundle", ExifInterface.LATITUDE_SOUTH, "", "code", "uuid", "w", h.f248218g, "isBlock", "t", "data", "u", "Lorg/json/JSONObject;", "H", BdhLogUtil.LogTag.Tag_Req, HippyTKDListViewAdapter.X, "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "K", "U", "T", "param", "L", "J", "I", "uinType", "uin", "nick", "extra", "Landroid/app/Activity;", EventKey.ACT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "D", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "onActivityResult", "intent", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "p", "o", "O", "Y", "method", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lorg/json/JSONObject;", "postData", "e", "Lkotlin/jvm/functions/Function1;", "selectMsgsCallback", "f", "uploadMsgsCallback", tl.h.F, "quitGroupCallback", "i", "puzzleVerifyCallback", "isAddLifeCallback", "Ljava/lang/String;", "mCurrentChannelId", "<init>", "()V", "a", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class O3Module extends i01.e {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String mCurrentChannelId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JSONObject postData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> selectMsgsCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> uploadMsgsCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> quitGroupCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> puzzleVerifyCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isAddLifeCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/dt/kuikly/module/O3Module$b", "Lcom/tencent/kuikly/core/render/android/c;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b implements com.tencent.kuikly.core.render.android.c {
        b() {
        }

        @Override // com.tencent.kuikly.core.render.android.c
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            O3Module.this.onActivityResult(requestCode, resultCode, data);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/dt/kuikly/module/O3Module$c", "Lcom/tencent/mobileqq/profilecard/listener/RelationBlacklistListener;", "", "success", "", "data", "", "onResult", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class c implements RelationBlacklistListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f203787a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ O3Module f203788b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f203789c;

        c(Function1<Object, Unit> function1, O3Module o3Module, String str) {
            this.f203787a = function1;
            this.f203788b = o3Module;
            this.f203789c = str;
        }

        @Override // com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener
        public void onResult(boolean success, @Nullable Object data) {
            if (success && data != null) {
                RelationBlacklist$BlockRsp relationBlacklist$BlockRsp = (RelationBlacklist$BlockRsp) data;
                if (relationBlacklist$BlockRsp.code.get() == 0) {
                    i.c().m(this.f203789c, true);
                    ((IProfileCardFeatureApi) QRoute.api(IProfileCardFeatureApi.class)).updateUserIsBlacklistUinFlag(this.f203789c, true);
                    Function1<Object, Unit> function1 = this.f203787a;
                    if (function1 != null) {
                        function1.invoke(O3Module.v(this.f203788b, 0, null, 2, null));
                        return;
                    }
                    return;
                }
                if (relationBlacklist$BlockRsp.code.get() == 10001) {
                    Function1<Object, Unit> function12 = this.f203787a;
                    if (function12 != null) {
                        function12.invoke(O3Module.v(this.f203788b, 10001, null, 2, null));
                        return;
                    }
                    return;
                }
                String str = relationBlacklist$BlockRsp.f436002msg.get();
                Intrinsics.checkNotNullExpressionValue(str, "rsp.msg.get()");
                Function1<Object, Unit> function13 = this.f203787a;
                if (function13 != null) {
                    function13.invoke(this.f203788b.u((int) relationBlacklist$BlockRsp.code.get(), str));
                    return;
                }
                return;
            }
            Function1<Object, Unit> function14 = this.f203787a;
            if (function14 != null) {
                function14.invoke(O3Module.v(this.f203788b, -1, null, 2, null));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/dt/kuikly/module/O3Module$d", "Lcom/tencent/biz/pubaccount/api/IPublicAccountObserver$c;", "", "isSuccess", "", "uin", "", "onFollowPublicAccount", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class d extends IPublicAccountObserver.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f203790a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f203791b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ O3Module f203792c;

        d(String str, Function1<Object, Unit> function1, O3Module o3Module) {
            this.f203790a = str;
            this.f203791b = function1;
            this.f203792c = o3Module;
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onFollowPublicAccount(boolean isSuccess, @Nullable String uin) {
            int i3;
            if (!this.f203790a.equals(uin)) {
                return;
            }
            if (isSuccess) {
                i3 = 0;
            } else {
                i3 = -1;
            }
            Function1<Object, Unit> function1 = this.f203791b;
            if (function1 != null) {
                function1.invoke(O3Module.v(this.f203792c, i3, null, 2, null));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/dt/kuikly/module/O3Module$e", "Lcom/tencent/mobileqq/dt/web/a;", "", "code", "", "data", "", "b", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class e extends com.tencent.mobileqq.dt.web.a {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f203793f;

        e(Function1<Object, Unit> function1) {
            this.f203793f = function1;
        }

        @Override // com.tencent.mobileqq.dt.web.a
        public void b(int code, @NotNull byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", code);
            jSONObject.put("data", new String(data, Charsets.UTF_8));
            Function1<Object, Unit> function1 = this.f203793f;
            if (function1 != null) {
                function1.invoke(jSONObject);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/dt/kuikly/module/O3Module$f", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class f implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f203794a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ O3Module f203795b;

        f(Function1<Object, Unit> function1, O3Module o3Module) {
            this.f203794a = function1;
            this.f203795b = o3Module;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException e16) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e16, "e");
            QLog.e("O3KuiklyModule", 1, "upload pic fail " + e16);
            Function1<Object, Unit> function1 = this.f203794a;
            if (function1 != null) {
                function1.invoke(O3Module.v(this.f203795b, -1, null, 2, null));
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            Function1<Object, Unit> function1 = this.f203794a;
            if (function1 != null) {
                function1.invoke(O3Module.v(this.f203795b, response.code(), null, 2, null));
            }
        }
    }

    private final void A() {
        InputMethodManager inputMethodManager;
        Activity activity = getActivity();
        if (activity != null) {
            Object systemService = activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (systemService instanceof InputMethodManager) {
                inputMethodManager = (InputMethodManager) systemService;
            } else {
                inputMethodManager = null;
            }
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
            }
        }
    }

    private final String B(String params) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "";
        }
        JSONObject jSONObject = new JSONObject(params);
        String key = jSONObject.optString("key");
        String data = jSONObject.optString("content");
        Intrinsics.checkNotNullExpressionValue(key, "key");
        Charset charset = Charsets.UTF_8;
        byte[] bytes = key.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA1);
        Mac mac = Mac.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA1);
        mac.init(secretKeySpec);
        Intrinsics.checkNotNullExpressionValue(data, "data");
        byte[] bytes2 = data.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        byte[] doFinal = mac.doFinal(bytes2);
        Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal(data.toByteArray())");
        return W(doFinal);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C(String params, Function1<Object, Unit> callback) {
        byte b16;
        AppInterface appInterface;
        if (params != null) {
            if (params.length() == 0) {
                b16 = true;
            } else {
                b16 = false;
            }
            if (b16 == false) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof AppInterface) {
                    appInterface = (AppInterface) peekAppRuntime;
                } else {
                    appInterface = null;
                }
                if (appInterface == null) {
                    QLog.e("O3KuiklyModule", 1, "followOfficialAccounts app emtpy");
                    if (callback != null) {
                        callback.invoke(v(this, 0, null, 2, null));
                        return;
                    }
                    return;
                }
                boolean isFollowUin = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isFollowUin(appInterface, new JSONObject(params).optString("uin"));
                if (callback != null) {
                    callback.invoke(v(this, isFollowUin ? 1 : 0, null, 2, null));
                    return;
                }
                return;
            }
        }
        QLog.e("O3KuiklyModule", 1, "followOfficialAccounts params emtpy");
        if (callback != null) {
            callback.invoke(v(this, 0, null, 2, null));
        }
    }

    private final boolean D(JSONObject param) {
        JSONObject jSONObject;
        int optInt = param.optInt("chattype", 0);
        String optString = param.optString("groupcode", "");
        if ((optInt == 10014 && TextUtils.isEmpty(optString)) || (jSONObject = this.postData) == null || jSONObject.optInt("isdirectmsg") != 1) {
            return false;
        }
        return true;
    }

    private final void E(String params, final Function1<Object, Unit> callback) {
        boolean z16;
        if (!((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).isEnableBlackList()) {
            QLog.e("O3KuiklyModule", 1, "isInBlackList enable false");
            if (callback != null) {
                callback.invoke(t(0, 0));
                return;
            }
            return;
        }
        if (params != null) {
            if (params.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                String optString = new JSONObject(params).optString("eviluin");
                if (TextUtils.isEmpty(optString)) {
                    QLog.e("O3KuiklyModule", 1, "isInBlackList but friendUin emtpy");
                    if (callback != null) {
                        callback.invoke(t(1, 0));
                        return;
                    }
                    return;
                }
                ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendBlacklistCheckRequest(optString, new RelationBlacklistListener() { // from class: com.tencent.mobileqq.dt.kuikly.module.b
                    @Override // com.tencent.mobileqq.profilecard.listener.RelationBlacklistListener
                    public final void onResult(boolean z17, Object obj) {
                        O3Module.F(Function1.this, this, z17, obj);
                    }
                });
                return;
            }
        }
        QLog.e("O3KuiklyModule", 1, "isInBlackList params emtpy");
        if (callback != null) {
            callback.invoke(t(1, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Function1 function1, O3Module this$0, boolean z16, Object obj) {
        RelationBlacklist$CheckRsp relationBlacklist$CheckRsp;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = 0;
        if (!z16) {
            QLog.e("O3KuiklyModule", 1, "sendBlacklistCheckRequest result error");
            if (function1 != null) {
                function1.invoke(this$0.t(1, 0));
                return;
            }
            return;
        }
        if (obj instanceof RelationBlacklist$CheckRsp) {
            relationBlacklist$CheckRsp = (RelationBlacklist$CheckRsp) obj;
        } else {
            relationBlacklist$CheckRsp = null;
        }
        if (relationBlacklist$CheckRsp == null) {
            QLog.e("O3KuiklyModule", 1, "sendBlacklistCheckRequest data error");
            if (function1 != null) {
                function1.invoke(this$0.t(1, 0));
                return;
            }
            return;
        }
        if (relationBlacklist$CheckRsp.is_block.get() || relationBlacklist$CheckRsp.is_blocked.get()) {
            i3 = 1;
        }
        if (function1 != null) {
            function1.invoke(this$0.t(1, i3));
        }
    }

    private final void G(String params, Function1<Object, Unit> callback) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (callback != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("result", -1);
                callback.invoke(jSONObject.toString());
                return;
            }
            return;
        }
        String troopUin = new JSONObject(params).optString("troopUin");
        ITroopApi iTroopApi = (ITroopApi) QRoute.api(ITroopApi.class);
        Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
        boolean isTroopMember = iTroopApi.isTroopMember(troopUin);
        if (callback != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("result", isTroopMember ? 1 : 0);
            callback.invoke(jSONObject2.toString());
        }
    }

    private final boolean H(JSONObject params) {
        if (params.optInt("chattype", 0) != 10014) {
            return false;
        }
        return true;
    }

    private final void I(JSONObject param) {
        boolean z16;
        String str;
        String uinName;
        String openChatUin;
        int collectionSizeOrDefault;
        long[] longArray;
        String str2;
        List list;
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        String str3 = "";
        String optString = param.optString("chatuin", "");
        String optString2 = param.optString("groupcode", "");
        int optInt = param.optInt("chattype", 0);
        int optInt2 = param.optInt("topicid", 0);
        String optString3 = param.optString("uinname", "");
        String msgsData = param.optString("msgs");
        Intrinsics.checkNotNullExpressionValue(msgsData, "msgsData");
        if (msgsData.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            str = "";
        } else {
            str = new JSONObject(msgsData).optString("msgs");
            Intrinsics.checkNotNullExpressionValue(str, "JSONObject(msgsData).optString(KEY_CHAT_MSG_LIST)");
        }
        boolean D = D(param);
        if (!TextUtils.isEmpty(optString)) {
            optString = com.tencent.mobileqq.dt.util.a.a(optString);
        }
        if (!TextUtils.isEmpty(optString3)) {
            byte[] decode = Base64.decode(optString3, 0);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(uinName, Base64.DEFAULT)");
            uinName = new String(decode, Charsets.UTF_8);
        } else {
            uinName = optString3;
        }
        if (QLog.isColorLevel()) {
            QLog.i("O3KuiklyModule", 2, "jumpChatMsg [" + optString + ", " + optInt + ", " + optString2 + ", " + optInt2 + ", " + uinName + ']');
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            Object[] parseFrom = JsonORM.parseFrom(new JSONArray(str), JubaoMsgData.class);
            Intrinsics.checkNotNullExpressionValue(parseFrom, "parseFrom(jsonArray, JubaoMsgData::class.java)");
            list = ArraysKt___ArraysKt.toList(parseFrom);
            arrayList.addAll(list);
        }
        if (optInt != 1 && optInt != 3000) {
            openChatUin = optString;
        } else {
            openChatUin = optString2;
        }
        if (TextUtils.isEmpty(openChatUin)) {
            QLog.e("O3KuiklyModule", 1, "jumpChatMsg openChatUin is null");
            return;
        }
        Bundle bundle = new Bundle();
        if (optInt == 10014) {
            String name = com.tencent.guild.aio.factory.a.class.getName();
            if (D) {
                name = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getDirectFactoryName();
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("msgs", str);
            bundle2.putBoolean("entrance_from_jubao", true);
            bundle2.putString("penetrate_to_chat_activity", param.toString());
            bundle2.putInt("AIOParam_FromScene", FromScene.JUBAO.ordinal());
            activity.startActivityForResult(((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatActivityIntent(activity, new com.tencent.mobileqq.guild.api.i().f(optString2).b(openChatUin).d(name).c(false).e(bundle2).a()), 0);
            return;
        }
        if (optInt == 10007) {
            JSONObject jSONObject = this.postData;
            String str4 = null;
            if (jSONObject != null) {
                str2 = jSONObject.optString("friendroleid");
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            JSONObject jSONObject2 = this.postData;
            if (jSONObject2 != null) {
                str4 = jSONObject2.optString("myroleid");
            }
            if (str4 != null) {
                str3 = str4;
            }
            bundle.putString(AppConstants.Key.KEY_GAME_MSG_FRIEND_ROLEID, str2);
            bundle.putString(AppConstants.Key.KEY_GAME_MSG_MY_ROLEID, str3);
        }
        bundle.putString("uin", openChatUin);
        bundle.putInt("uintype", optInt);
        if (!TextUtils.isEmpty(uinName)) {
            if (optInt != 1033 && optInt != 1034) {
                bundle.putString("uinname", uinName);
            } else {
                bundle.putString(ConfessInfo.KEY_CONFESSOR_NICK, uinName);
            }
        }
        bundle.putInt(ConfessInfo.KEY_CONFESS_TOPICID, optInt2);
        if (arrayList.size() > 0) {
            bundle.putSerializable("msgs", arrayList);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(Long.valueOf(((JubaoMsgData) it.next()).msgID));
            }
            longArray = CollectionsKt___CollectionsKt.toLongArray(arrayList2);
            bundle.putLongArray("key_selected_msg_id", longArray);
        }
        bundle.putString("penetrate_to_chat_activity", param.toString());
        Intrinsics.checkNotNullExpressionValue(openChatUin, "openChatUin");
        Intrinsics.checkNotNullExpressionValue(uinName, "uinName");
        q(optInt, openChatUin, uinName, bundle, activity);
    }

    private final void J(JSONObject param) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        String optString = param.optString("eviluin", "");
        JSONObject jSONObject = this.postData;
        boolean z16 = false;
        if (jSONObject != null && jSONObject.optInt("is_need_open_channel_select_fragment") == 1) {
            z16 = true;
        }
        if (z16) {
            optString = param.optString("groupcode", "");
        }
        if (!TextUtils.isEmpty(optString)) {
            Intent intent = new Intent();
            intent.setClass(activity, QPublicFragmentActivity.class);
            intent.putExtra("public_fragment_class", ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).getQQGuildSelectChannelFragmentClass().getName());
            intent.putExtra("extra_guild_id", optString);
            intent.putExtra("extra_select_channel_origin_param", param.toString());
            activity.startActivityForResult(intent, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String K(ArrayList<MsgRecord> msgList) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("msgCount", msgList.size());
        JSONArray jSONArray = new JSONArray();
        for (MsgRecord msgRecord : msgList) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("msgRandom", msgRecord.msgRandom);
            jSONObject2.put("msgSeq", msgRecord.msgSeq);
            jSONObject2.put("msgTime", msgRecord.msgTime);
            jSONObject2.put("result", 0);
            jSONArray.mo162put(jSONObject2);
        }
        jSONObject.put("msgs", jSONArray);
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "data.toString()");
        return jSONObject3;
    }

    private final boolean L(JSONObject param) {
        boolean z16;
        int optInt = param.optInt("chattype", 0);
        String optString = param.optString("groupcode", "");
        Intrinsics.checkNotNullExpressionValue(optString, "param.optString(KEY_GROUP_CODE, \"\")");
        if (optInt == 10014 && TextUtils.isEmpty(optString)) {
            return true;
        }
        JSONObject jSONObject = this.postData;
        if (jSONObject != null && jSONObject.optInt("is_need_open_channel_select_fragment") == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    private final void M(String params) {
        HRQUSHalfScreenFloatingView hRQUSHalfScreenFloatingView;
        if (params != null) {
            JSONObject jSONObject = new JSONObject(params);
            String callbackId = jSONObject.optString("callbackId");
            int optInt = jSONObject.optInt("reportStatus");
            Activity activity = getActivity();
            if (activity != null && (hRQUSHalfScreenFloatingView = (HRQUSHalfScreenFloatingView) activity.findViewById(R.id.yak)) != null) {
                Intrinsics.checkNotNullExpressionValue(callbackId, "callbackId");
                hRQUSHalfScreenFloatingView.setMCallbackId(callbackId);
                hRQUSHalfScreenFloatingView.setMReportStatus(optInt);
            }
        }
    }

    private final void N(String params, Function1<Object, Unit> callback) {
        boolean z16;
        if (params != null) {
            boolean z17 = false;
            if (params.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                String url = new JSONObject(params).optString("url");
                Intrinsics.checkNotNullExpressionValue(url, "url");
                if (url.length() == 0) {
                    z17 = true;
                }
                if (z17) {
                    QLog.e("O3KuiklyModule", 1, "puzzleVerify url empty");
                    if (callback != null) {
                        callback.invoke(v(this, -2, null, 2, null));
                        return;
                    }
                    return;
                }
                m();
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserActivity"));
                intent.putExtra("url", url);
                this.puzzleVerifyCallback = callback;
                Activity activity = getActivity();
                if (activity != null) {
                    activity.startActivityForResult(intent, 2);
                    return;
                }
                return;
            }
        }
        QLog.e("O3KuiklyModule", 1, "puzzleVerify params empty");
        if (callback != null) {
            callback.invoke(v(this, -2, null, 2, null));
        }
    }

    private final void O(String params, Function1<Object, Unit> callback) {
        boolean z16;
        AppInterface appInterface;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (callback != null) {
                callback.invoke(v(this, -2, null, 2, null));
                return;
            }
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            if (callback != null) {
                callback.invoke(v(this, -5, null, 2, null));
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString("groupcode");
        if (TextUtils.isEmpty(optString)) {
            if (callback != null) {
                callback.invoke(v(this, -2, null, 2, null));
            }
        } else {
            boolean optBoolean = jSONObject.optBoolean("clearHistory", true);
            this.quitGroupCallback = callback;
            ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).quitGroup(optString, !optBoolean, null, "O3KuiklyModule", new com.tencent.qqnt.troop.i() { // from class: com.tencent.mobileqq.dt.kuikly.module.c
                @Override // com.tencent.qqnt.troop.i
                public final void onResult(boolean z17, int i3, String str) {
                    O3Module.P(O3Module.this, z17, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(final O3Module this$0, boolean z16, final int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i("O3KuiklyModule", 1, "[quitGroup] isSuccess:" + z16 + ". result:" + i3 + ", errMsg:" + errMsg);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.dt.kuikly.module.d
            @Override // java.lang.Runnable
            public final void run() {
                O3Module.Q(O3Module.this, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(O3Module this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<Object, Unit> function1 = this$0.quitGroupCallback;
        if (function1 != null) {
            function1.invoke(v(this$0, i3, null, 2, null));
        }
    }

    private final void R(JSONObject params) {
        if (TextUtils.isEmpty(this.mCurrentChannelId)) {
            return;
        }
        String str = this.mCurrentChannelId;
        String a16 = com.tencent.mobileqq.dt.util.a.a(params.optString("chatuin", ""));
        QLog.i("O3KuiklyModule", 1, "replaceChatuin originChannelId=" + a16 + ",currentChannelId=" + str);
        if (!TextUtils.equals(a16, str)) {
            String c16 = com.tencent.mobileqq.dt.util.a.c(str);
            Intrinsics.checkNotNullExpressionValue(c16, "encrypt(currentChannelId)");
            params.put("chatuin", c16);
        }
    }

    private final void S(boolean isSuccess, Bundle bundle) {
        int i3;
        int i16;
        String str;
        QLog.i("O3KuiklyModule", 1, "receiver msgServer resp  isSucesss =  " + isSuccess);
        ReportController.o(null, "dc00898", "", "", "0x800A851", "0x800A851", 3, 0, "", "", "", "");
        if (isSuccess && bundle != null) {
            str = bundle.getString("jubao_uuid");
            if (str == null) {
                str = "";
            }
            i3 = bundle.getInt("jubao_result_code", 1);
            i16 = 0;
        } else {
            if (bundle != null) {
                i3 = bundle.getInt("jubao_result_code", 1);
                i16 = 1;
            } else {
                i3 = 1;
                i16 = 1;
            }
            str = "";
        }
        Function1<Object, Unit> function1 = this.uploadMsgsCallback;
        if (function1 != null) {
            function1.invoke(w(i3, str));
        }
        QLog.i("O3KuiklyModule", 1, "upload resp uuid = " + str + ",result = " + i3);
        ReportController.o(null, "dc00898", "", "", "0x800A851", "0x800A851", 2, 0, "" + i16, "" + i3, "" + (!TextUtils.isEmpty(str) ? 1 : 0), "");
    }

    private final void T(String params, Function1<Object, Unit> callback) {
        String str;
        Intent intent;
        if (params != null && callback != null) {
            m();
            this.selectMsgsCallback = callback;
            Activity activity = getActivity();
            if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("safePostData")) == null) {
                str = "";
            }
            this.postData = new JSONObject(str);
            A();
            JSONObject jSONObject = new JSONObject(params);
            if (L(jSONObject)) {
                J(jSONObject);
            } else {
                I(jSONObject);
            }
            ReportController.o(null, "dc00898", "", "", "0x800A851", "0x800A851", 0, 0, "0", "", "", "");
            return;
        }
        QLog.e("O3KuiklyModule", 1, "selectChatMsg error params " + params + " callback " + callback);
    }

    private final void U(String params, Function1<Object, Unit> callback) {
        AppInterface appInterface;
        if (params != null) {
            JSONObject jSONObject = new JSONObject(params);
            String optString = jSONObject.optString("cmd");
            String optString2 = jSONObject.optString("data");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            O3BusinessHandler o3BusinessHandler = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                BusinessHandler businessHandler = appInterface.getBusinessHandler(O3BusinessHandler.class.getName());
                if (businessHandler instanceof O3BusinessHandler) {
                    o3BusinessHandler = (O3BusinessHandler) businessHandler;
                }
                if (o3BusinessHandler == null) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("cmd", optString);
                jSONObject2.put("data", optString2);
                String jSONObject3 = jSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "JSONObject().apply {\n   \u2026\n            }.toString()");
                o3BusinessHandler.D2("sendRequest", jSONObject3, new e(callback));
            }
        }
    }

    private final String V(String input) {
        if (input != null) {
            byte[] bytes = input.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            if (bytes != null) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = byteArrayInputStream.read(bArr);
                        if (read > 0) {
                            messageDigest.update(bArr, 0, read);
                        } else {
                            byte[] digest = messageDigest.digest();
                            Intrinsics.checkNotNullExpressionValue(digest, "digest.digest()");
                            String W = W(digest);
                            CloseableKt.closeFinally(byteArrayInputStream, null);
                            return W;
                        }
                    }
                } catch (Throwable th5) {
                    try {
                        throw th5;
                    } catch (Throwable th6) {
                        CloseableKt.closeFinally(byteArrayInputStream, th5);
                        throw th6;
                    }
                }
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

    private final String W(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b16 : bytes) {
            formatter.format("%02x", Byte.valueOf(b16));
        }
        String formatter2 = formatter.toString();
        Intrinsics.checkNotNullExpressionValue(formatter2, "formatter.toString()");
        return formatter2;
    }

    private final void X() {
        VideoReport.traverseExposure();
    }

    private final void Y(String params, final Function1<Object, Unit> callback) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (callback != null) {
                callback.invoke(v(this, -2, null, 2, null));
            }
        } else {
            JSONObject jSONObject = new JSONObject(params);
            String uid = jSONObject.optString("uid");
            final int optInt = jSONObject.optInt("chatType");
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            com.tencent.nt.adapter.session.c.h(uid, com.tencent.nt.adapter.session.c.l(optInt), new Function2<Boolean, com.tencent.nt.adapter.session.f, Unit>() { // from class: com.tencent.mobileqq.dt.kuikly.module.O3Module$uidToUin$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, f fVar) {
                    invoke(bool.booleanValue(), fVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z17, @Nullable f fVar) {
                    if (z17 && fVar != null) {
                        Function1<Object, Unit> function1 = callback;
                        if (function1 != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            int i3 = optInt;
                            jSONObject2.put("uin", fVar.a());
                            jSONObject2.put("encryptUin", com.tencent.mobileqq.dt.util.a.c(fVar.a()));
                            if (i3 == 0) {
                                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                if ((peekAppRuntime instanceof AppInterface) && ProfileUtils.isFriend((AppInterface) peekAppRuntime, fVar.a())) {
                                    jSONObject2.put(IProfileProtocolConst.PARAM_IS_FRIEND, true);
                                }
                            }
                            function1.invoke(jSONObject2.toString());
                            return;
                        }
                        return;
                    }
                    Function1<Object, Unit> function12 = callback;
                    if (function12 != null) {
                        function12.invoke(O3Module.v(this, -1, null, 2, null));
                    }
                }
            });
        }
    }

    private final void Z(String params) {
        HRQUSHalfScreenFloatingView hRQUSHalfScreenFloatingView;
        Activity activity;
        HRQUSHalfScreenFloatingView hRQUSHalfScreenFloatingView2;
        HRQUSHalfScreenFloatingView hRQUSHalfScreenFloatingView3;
        Activity activity2;
        HRQUSHalfScreenFloatingView hRQUSHalfScreenFloatingView4;
        if (params != null) {
            JSONObject jSONObject = new JSONObject(params);
            if (jSONObject.has("enableDefaultHeight") && (activity2 = getActivity()) != null && (hRQUSHalfScreenFloatingView4 = (HRQUSHalfScreenFloatingView) activity2.findViewById(R.id.yak)) != null) {
                hRQUSHalfScreenFloatingView4.setEnableDefault(jSONObject.optBoolean("enableDefaultHeight", true));
            }
            if (jSONObject.has("contentDraggable")) {
                Activity activity3 = getActivity();
                if (activity3 != null) {
                    hRQUSHalfScreenFloatingView3 = (HRQUSHalfScreenFloatingView) activity3.findViewById(R.id.yak);
                } else {
                    hRQUSHalfScreenFloatingView3 = null;
                }
                if (hRQUSHalfScreenFloatingView3 != null) {
                    hRQUSHalfScreenFloatingView3.setIsContentDraggable(jSONObject.optBoolean("contentDraggable", false));
                }
            }
            int optInt = jSONObject.optInt("heightType");
            if (optInt != 1) {
                if (optInt == 2 && (activity = getActivity()) != null && (hRQUSHalfScreenFloatingView2 = (HRQUSHalfScreenFloatingView) activity.findViewById(R.id.yak)) != null) {
                    hRQUSHalfScreenFloatingView2.P(0);
                    return;
                }
                return;
            }
            Activity activity4 = getActivity();
            if (activity4 != null && (hRQUSHalfScreenFloatingView = (HRQUSHalfScreenFloatingView) activity4.findViewById(R.id.yak)) != null) {
                hRQUSHalfScreenFloatingView.N(0);
            }
        }
    }

    private final void a0(String params, Function1<Object, Unit> callback) {
        boolean z16;
        boolean z17;
        List list;
        if (params != null) {
            if (params.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (!NetworkUtil.isNetworkAvailable()) {
                    if (callback != null) {
                        callback.invoke(w(-6, ""));
                        return;
                    }
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(params);
                    if (H(jSONObject)) {
                        R(jSONObject);
                    }
                    QLog.i("O3KuiklyModule", 1, "uploadChatMsg(), " + params);
                    String optString = jSONObject.optString("eviluin", "");
                    String optString2 = jSONObject.optString("chatuin", "");
                    String optString3 = jSONObject.optString("groupcode", "");
                    int optInt = jSONObject.optInt("chattype", 0);
                    if (!TextUtils.isEmpty(optString2)) {
                        optString2 = com.tencent.mobileqq.dt.util.a.a(optString2);
                    }
                    Object[] parseFrom = JsonORM.parseFrom(new JSONArray(new JSONObject(jSONObject.optString("msgs")).optString("msgs")), JubaoMsgData.class);
                    Intrinsics.checkNotNullExpressionValue(parseFrom, "parseFrom(JSONArray(msgs\u2026JubaoMsgData::class.java)");
                    JubaoMsgData[] jubaoMsgDataArr = (JubaoMsgData[]) parseFrom;
                    if (jubaoMsgDataArr.length == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        QLog.e("O3KuiklyModule", 1, "ipc upload  to msgServer msg size = 0 ");
                        if (callback != null) {
                            callback.invoke(w(-3, ""));
                            return;
                        }
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("jubao_evil_uin", optString);
                    bundle.putString("jubao_chat_uin", optString2);
                    bundle.putString("jubao_group_code", optString3);
                    bundle.putInt("jubao_chat_type", optInt);
                    list = ArraysKt___ArraysKt.toList(jubaoMsgDataArr);
                    bundle.putSerializable("jubao_msg_list", new ArrayList(list));
                    String str = null;
                    if (optInt != 119) {
                        if (optInt != 1001) {
                            if (optInt != 1046) {
                                if (optInt == 10007) {
                                    JSONObject jSONObject2 = this.postData;
                                    if (jSONObject2 != null) {
                                        str = jSONObject2.optString("jubao_game_sig");
                                    }
                                    if (str == null) {
                                        str = "";
                                    }
                                    bundle.putString("jubao_game_sig", str);
                                    if (QLog.isColorLevel()) {
                                        QLog.i("O3KuiklyModule", 2, "gameSig = " + str);
                                    }
                                }
                            } else {
                                JSONObject jSONObject3 = this.postData;
                                if (jSONObject3 != null) {
                                    str = jSONObject3.optString("jubao_matchfriend_sig");
                                }
                                bundle.putString("jubao_matchfriend_sig", str);
                            }
                        } else {
                            JSONObject jSONObject4 = this.postData;
                            if (jSONObject4 != null) {
                                str = jSONObject4.optString("jubao_nearby_sig");
                            }
                            bundle.putString("jubao_nearby_sig", str);
                        }
                    } else {
                        JSONObject jSONObject5 = this.postData;
                        if (jSONObject5 != null) {
                            str = jSONObject5.optString("jubao_nearbypro_sig");
                        }
                        bundle.putString("jubao_nearbypro_sig", str);
                    }
                    this.uploadMsgsCallback = callback;
                    QIPCClientHelper.getInstance().callServer("JubaoIPCServer", "", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.dt.kuikly.module.a
                        @Override // eipc.EIPCResultCallback
                        public final void onCallback(EIPCResult eIPCResult) {
                            O3Module.b0(O3Module.this, eIPCResult);
                        }
                    });
                    ReportController.o(null, "dc00898", "", "", "0x800A851", "0x800A851", 2, 0, "", "", "", "");
                    return;
                } catch (JsonORM.JsonParseException e16) {
                    if (callback != null) {
                        callback.invoke(w(-4, ""));
                    }
                    QLog.e("O3KuiklyModule", 1, e16, new Object[0]);
                    return;
                } catch (JSONException e17) {
                    if (callback != null) {
                        callback.invoke(w(-4, ""));
                    }
                    QLog.e("O3KuiklyModule", 1, e17, new Object[0]);
                    return;
                }
            }
        }
        if (callback != null) {
            callback.invoke(w(-2, ""));
        }
        QLog.e("O3KuiklyModule", 1, "uploadChatMsg params empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(O3Module this$0, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (eIPCResult.code == 0) {
            this$0.S(eIPCResult.data.getBoolean("receive_success"), eIPCResult.data);
        }
    }

    private final void c0(String params, Function1<Object, Unit> callback) {
        boolean z16;
        Iterator keys;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (callback != null) {
                callback.invoke(v(this, -1, null, 2, null));
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        File file = new File(jSONObject.optString("filePath"));
        String url = jSONObject.optString("url");
        JSONObject optJSONObject = jSONObject.optJSONObject("httpHeads");
        RequestBody create$default = RequestBody.Companion.create$default(RequestBody.INSTANCE, file, (MediaType) null, 1, (Object) null);
        Request.Builder addHeader = new Request.Builder().addHeader("Content-Length", String.valueOf(file.length()));
        Intrinsics.checkNotNullExpressionValue(url, "url");
        Request.Builder put = addHeader.url(url).put(create$default);
        if (optJSONObject != null && (keys = optJSONObject.keys()) != null) {
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                String optString = optJSONObject.optString(key);
                Intrinsics.checkNotNullExpressionValue(optString, "httpHeads.optString(key)");
                put.addHeader(key, optString);
            }
        }
        new OkHttpClient.Builder().retryOnConnectionFailure(true).build().newCall(put.build()).enqueue(new f(callback, this));
    }

    private final void m() {
        if (!this.isAddLifeCallback) {
            this.isAddLifeCallback = true;
            addKuiklyRenderLifecycleCallback(new b());
        }
    }

    private final void o(String params, Function1<Object, Unit> callback) {
        boolean z16;
        if (params != null) {
            if (params.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                String optString = new JSONObject(params).optString("eviluin");
                ((IRelationBlacklistApi) QRoute.api(IRelationBlacklistApi.class)).sendAddBlacklistRequest(optString, new c(callback, this, optString));
                return;
            }
        }
        if (callback != null) {
            callback.invoke(v(this, -2, null, 2, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        String stringExtra;
        String str;
        String str2;
        if (requestCode != 0) {
            if (requestCode != 1) {
                if (requestCode == 2) {
                    y(data, resultCode);
                    return;
                }
                return;
            }
            z(data, resultCode);
            return;
        }
        String str3 = "";
        if (resultCode == -1) {
            if (data == null || (str = data.getStringExtra("msgs")) == null) {
                str = "";
            }
            if (data != null) {
                str2 = data.getStringExtra("chatuin");
            } else {
                str2 = null;
            }
            if (str2 != null) {
                str3 = str2;
            }
            this.mCurrentChannelId = str3;
            if (QLog.isColorLevel()) {
                QLog.d("O3KuiklyModule", 1, "onActivityResult msgs= " + str + ", mCurrentChannelId == " + this.mCurrentChannelId);
            }
            if (TextUtils.isEmpty(str)) {
                str = new JSONObject().toString();
                Intrinsics.checkNotNullExpressionValue(str, "JSONObject().toString()");
            }
            Function1<Object, Unit> function1 = this.selectMsgsCallback;
            if (function1 != null) {
                function1.invoke(str);
                return;
            }
            return;
        }
        if (data != null && (stringExtra = data.getStringExtra("penetrate_to_chat_activity")) != null) {
            str3 = stringExtra;
        }
        if (QLog.isColorLevel()) {
            QLog.i("O3KuiklyModule", 1, "onActivityResult user cancel select msg = " + str3);
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str3);
        if (L(jSONObject)) {
            J(jSONObject);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p(String params, Function1<Object, Unit> callback) {
        byte b16;
        AppInterface appInterface;
        if (params != null) {
            if (params.length() == 0) {
                b16 = true;
            } else {
                b16 = false;
            }
            if (b16 == false) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof AppInterface) {
                    appInterface = (AppInterface) peekAppRuntime;
                } else {
                    appInterface = null;
                }
                if (appInterface == null) {
                    if (callback != null) {
                        callback.invoke(v(this, -5, null, 2, null));
                        return;
                    }
                    return;
                }
                JSONObject jSONObject = new JSONObject(params);
                String optString = jSONObject.optString("eviluin");
                int i3 = 1 ^ (jSONObject.optBoolean("shouldShield", false) ? 1 : 0);
                ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", appInterface.getCurrentAccountUin(), "friendlist.delFriend");
                toServiceMsg.extraData.putString("uin", optString);
                toServiceMsg.extraData.putByte(PictureConst.KEY_DEL_TYPE, (byte) 2);
                toServiceMsg.extraData.putInt("not_shield_tmp_session", i3);
                appInterface.sendToService(toServiceMsg);
                int i16 = ChatActivity.f175053a0;
                MqqHandler handler = appInterface.getHandler(ChatActivity.class);
                if (handler != null) {
                    handler.sendMessage(handler.obtainMessage(16711681, optString));
                }
                int i17 = ChatSettingFragment.Z1;
                MqqHandler handler2 = appInterface.getHandler(ChatSettingFragment.class);
                if (handler2 != null) {
                    handler2.sendMessage(handler2.obtainMessage(16711681, optString));
                }
                if (callback != null) {
                    callback.invoke(v(this, 0, null, 2, null));
                    return;
                }
                return;
            }
        }
        if (callback != null) {
            callback.invoke(v(this, -2, null, 2, null));
        }
    }

    private final void q(int uinType, String uin, String nick, Bundle extra, Activity act) {
        Intent intent = new Intent();
        int l3 = com.tencent.nt.adapter.session.c.l(uinType);
        if (uinType == 119) {
            l3 = 119;
        }
        if (uinType == 1003) {
            l3 = 1;
        }
        if (com.tencent.nt.adapter.session.c.e(uinType) || uinType == 1003) {
            uin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
            Intrinsics.checkNotNullExpressionValue(uin, "api(IRelationNTUinAndUid\u2026.java).getUidFromUin(uin)");
            if (TextUtils.isEmpty(uin)) {
                QQToast makeText = QQToast.makeText(BaseApplication.context, R.string.f1359202r, 1);
                makeText.show(makeText.getTitleBarHeight());
                return;
            }
        }
        intent.putExtra("key_peerId", uin);
        intent.putExtra("key_chat_type", l3);
        if (!TextUtils.isEmpty(nick)) {
            intent.putExtra("key_chat_name", nick);
        }
        intent.putExtra("key_from", 1001);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.setClass(act, QPublicFragmentActivity.class);
        intent.putExtra("public_fragment_class", ((IMsgSelectFragmentApi) QRoute.api(IMsgSelectFragmentApi.class)).getFragmentClass().getName());
        intent.putExtras(extra);
        act.startActivityForResult(intent, 0);
        QLog.i("O3KuiklyModule", 1, "doJumpChatMsg chatType:" + l3 + " uid:" + uin + " nick:" + nick);
    }

    private final void r(String params, Function1<Object, Unit> callback) {
        boolean z16;
        AppInterface appInterface;
        if (params != null) {
            if (params.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof AppInterface) {
                    appInterface = (AppInterface) peekAppRuntime;
                } else {
                    appInterface = null;
                }
                if (appInterface == null) {
                    QLog.e("O3KuiklyModule", 1, "followOfficialAccounts app emtpy");
                    if (callback != null) {
                        callback.invoke(v(this, -5, null, 2, null));
                        return;
                    }
                    return;
                }
                String optString = new JSONObject(params).optString("uin");
                QRouteApi api = QRoute.api(IPublicAccountObserver.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IPublicAccountObserver::class.java)");
                IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) api;
                iPublicAccountObserver.setOnCallback(new d(optString, callback, this));
                ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).followUin(appInterface, getActivity(), optString, iPublicAccountObserver);
                return;
            }
        }
        QLog.e("O3KuiklyModule", 1, "followOfficialAccounts params emtpy");
        if (callback != null) {
            callback.invoke(v(this, -2, null, 2, null));
        }
    }

    private final String t(int isOpen, int isBlock) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(h.f248218g, isOpen);
        jSONObject.put("isBlock", isBlock);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ock)\n        }.toString()");
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String u(int code, String data) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", code);
        jSONObject.put("data", data);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ata)\n        }.toString()");
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String v(O3Module o3Module, int i3, String str, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = "";
        }
        return o3Module.u(i3, str);
    }

    private final String w(int code, String uuid) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", code);
        jSONObject.put("uuid", uuid);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026uid)\n        }.toString()");
        return jSONObject2;
    }

    private final void x(String params, Function1<Object, Unit> callback) {
        if (params != null) {
            JSONObject jSONObject = new JSONObject(params);
            String chatUin = com.tencent.mobileqq.dt.util.a.a(jSONObject.optString("chatUin", ""));
            int optInt = jSONObject.optInt("chatType");
            int optInt2 = jSONObject.optInt("msgCount");
            Intrinsics.checkNotNullExpressionValue(chatUin, "chatUin");
            com.tencent.nt.adapter.session.c.j(chatUin, optInt, new O3Module$getChatMsg$1$1(optInt2, callback, this));
        }
    }

    private final void y(Intent intent, int resultCode) {
        String str;
        if (resultCode != -1) {
            Function1<Object, Unit> function1 = this.puzzleVerifyCallback;
            if (function1 != null) {
                function1.invoke(v(this, -7, null, 2, null));
                return;
            }
            return;
        }
        if (intent == null || (str = intent.getStringExtra("data")) == null) {
            str = "";
        }
        Function1<Object, Unit> function12 = this.puzzleVerifyCallback;
        if (function12 != null) {
            function12.invoke(u(0, str));
        }
    }

    private final void z(Intent intent, int resultCode) {
        String str;
        String stringExtra;
        if (resultCode == -1) {
            String str2 = "";
            if (intent == null || (str = intent.getStringExtra("extra_key_return_selected_channel_id")) == null) {
                str = "";
            }
            if (intent != null && (stringExtra = intent.getStringExtra("extra_key_return_selected_channel_old_param")) != null) {
                str2 = stringExtra;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                jSONObject.put("chatuin", com.tencent.mobileqq.dt.util.a.c(str));
                I(jSONObject);
            } catch (Throwable th5) {
                QLog.e("O3KuiklyModule", 1, "handleSelectChannelResult error " + th5);
            }
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Activity activity;
        HRQUSHalfScreenFloatingView hRQUSHalfScreenFloatingView;
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1905475162:
                if (method.equals("selectChatMsgs")) {
                    T(params, callback);
                    return null;
                }
                return null;
            case -1134342103:
                if (method.equals("deleteFriend")) {
                    p(params, callback);
                    return null;
                }
                return null;
            case -936075689:
                if (method.equals("puzzleVerify")) {
                    N(params, callback);
                    return null;
                }
                return null;
            case -779869696:
                if (method.equals("getChatMsgs")) {
                    x(params, callback);
                    return null;
                }
                return null;
            case -607132305:
                if (method.equals("uidToUin")) {
                    Y(params, callback);
                    return null;
                }
                return null;
            case -483027815:
                if (method.equals("traverseExposure")) {
                    X();
                    return null;
                }
                return null;
            case -293997310:
                if (method.equals("isTroopMember")) {
                    G(params, callback);
                    return null;
                }
                return null;
            case 3206119:
                if (method.equals("hmac")) {
                    return B(params);
                }
                return null;
            case 3528965:
                if (method.equals("sha1")) {
                    return V(params);
                }
                return null;
            case 45108093:
                if (method.equals("blackFriend")) {
                    o(params, callback);
                    return null;
                }
                return null;
            case 241482636:
                if (method.equals("isFollowOfficialAccounts")) {
                    C(params, callback);
                    return null;
                }
                return null;
            case 774938050:
                if (method.equals("followOfficialAccounts")) {
                    r(params, callback);
                    return null;
                }
                return null;
            case 832221671:
                if (method.equals("sendRequest")) {
                    U(params, callback);
                    return null;
                }
                return null;
            case 903792043:
                if (method.equals("uploadChatMsgs")) {
                    a0(params, callback);
                    ReportController.o(null, "dc00898", "", "", "0x800A851", "0x800A851", 1, 0, "0", "", "", "");
                    return null;
                }
                return null;
            case 1193339700:
                if (method.equals("updateFloatingView")) {
                    Z(params);
                    return null;
                }
                return null;
            case 1239080905:
                if (method.equals("uploadPic")) {
                    c0(params, callback);
                    return null;
                }
                return null;
            case 1469315227:
                if (method.equals("notifyStatus")) {
                    M(params);
                    return null;
                }
                return null;
            case 1671672458:
                if (method.equals("dismiss") && (activity = getActivity()) != null && (hRQUSHalfScreenFloatingView = (HRQUSHalfScreenFloatingView) activity.findViewById(R.id.yak)) != null) {
                    hRQUSHalfScreenFloatingView.t();
                    return null;
                }
                return null;
            case 1755118960:
                if (method.equals("quitGroup")) {
                    O(params, callback);
                    return null;
                }
                return null;
            case 2083014158:
                if (method.equals("isInBlackList")) {
                    E(params, callback);
                    return null;
                }
                return null;
            default:
                return null;
        }
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        this.selectMsgsCallback = null;
        this.uploadMsgsCallback = null;
        this.quitGroupCallback = null;
    }
}
