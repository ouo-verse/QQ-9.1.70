package com.tencent.mobileqq.wink.schema;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.model.WinkUserInfo;
import com.tencent.mobileqq.wink.editor.util.WinkUserInfoDataManager;
import com.tencent.mobileqq.wink.launcher.ui.WinkLoadingDialogHelperFragment;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.open.base.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.smtt.sdk.stat.MttLoader;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import h83.TargetTask;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import y53.a;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001?B\t\b\u0002\u00a2\u0006\u0004\b=\u0010>JC\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJP\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007Jn\u0010\u0018\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00162\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002JG\u0010\u0019\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJK\u0010\u001b\u001a\u00020\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00162\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002H\u0002J\"\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\"2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0016H\u0002J\u0016\u0010%\u001a\u00020\u00022\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\"H\u0002Jc\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\"2\u0006\u0010\n\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(J?\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020&2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+J?\u0010,\u001a\u00020\u00072\u0006\u0010)\u001a\u00020&2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010+JE\u0010.\u001a\u00020\u00072\f\u0010-\u001a\b\u0012\u0004\u0012\u00020&0\"2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010/JK\u00100\u001a\u00020\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00162\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u0010\u001cJ\u0015\u00102\u001a\u0004\u0018\u000101H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u00103J$\u00105\u001a\u00020\u00112\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00162\u0006\u00104\u001a\u000201H\u0002J\u001c\u00109\u001a\u00020\u0007*\u0002062\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u0001H\u0002J\u0010\u0010;\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\u0002H\u0002J,\u0010<\u001a\u00020\u00112\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u0005H\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/wink/schema/WinkSchemaPreCheck;", "", "", "agentType", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "costCollector", "", "p", "(Ljava/lang/String;Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "jumpTarget", MttLoader.ENTRY_ID, "Landroid/os/Bundle;", "args", "keyAttrs", "Lcom/tencent/mobileqq/wink/schema/WinkSchemaPreCheck$a;", "callback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/content/Intent;", "intent", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/concurrent/ConcurrentHashMap;", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "D", "B", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", UserInfo.SEX_FEMALE, "(Ljava/util/concurrent/ConcurrentHashMap;Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "targetUrl", "targetPath", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", HippyTKDListViewAdapter.X, "", "t", "paths", "v", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "H", "(Ljava/lang/String;Ljava/util/concurrent/ConcurrentHashMap;Ljava/lang/String;Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", WadlProxyConsts.KEY_MATERIAL, "r", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "materials", "E", "(Ljava/util/List;Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "G", "Lcom/tencent/mobileqq/wink/editor/model/c;", "u", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ITVKPlayerEventListener.KEY_USER_INFO, "y", "Lorg/json/JSONObject;", "key", "value", "I", "filePath", "w", "J", "<init>", "()V", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkSchemaPreCheck {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkSchemaPreCheck f326271a = new WinkSchemaPreCheck();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H&J\b\u0010\t\u001a\u00020\u0007H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/schema/WinkSchemaPreCheck$a;", "", "Landroid/os/Bundle;", "args", "Ljava/util/concurrent/ConcurrentHashMap;", "", "keyAttrs", "", "a", "onFailed", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void a(@NotNull Bundle args, @NotNull ConcurrentHashMap<String, String> keyAttrs);

        void onFailed();
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/schema/WinkSchemaPreCheck$f", "Lcom/tencent/mobileqq/wink/schema/WinkSchemaPreCheck$a;", "Landroid/os/Bundle;", "args", "Ljava/util/concurrent/ConcurrentHashMap;", "", "keyAttrs", "", "a", "onFailed", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResultReceiver f326289a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap<String, Object> f326290b;

        f(ResultReceiver resultReceiver, HashMap<String, Object> hashMap) {
            this.f326289a = resultReceiver;
            this.f326290b = hashMap;
        }

        @Override // com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck.a
        public void a(@NotNull Bundle args, @NotNull ConcurrentHashMap<String, String> keyAttrs) {
            Intrinsics.checkNotNullParameter(args, "args");
            Intrinsics.checkNotNullParameter(keyAttrs, "keyAttrs");
            try {
                Bundle bundle = new Bundle();
                HashMap<String, Object> hashMap = this.f326290b;
                bundle.putBundle("result_key_args", args);
                bundle.putSerializable("result_key_attrs", new HashMap(keyAttrs));
                bundle.putSerializable("result_key_cost_time", hashMap);
                bundle.putSerializable(QQWinkConstants.KEY_SCHEME_MATE_MATERIALS, args.getSerializable(QQWinkConstants.KEY_SCHEME_MATE_MATERIALS));
                ResultReceiver resultReceiver = this.f326289a;
                if (resultReceiver != null) {
                    resultReceiver.send(-1, bundle);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                onFailed();
            }
        }

        @Override // com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck.a
        public void onFailed() {
            ResultReceiver resultReceiver = this.f326289a;
            if (resultReceiver != null) {
                resultReceiver.send(0, null);
            }
        }
    }

    WinkSchemaPreCheck() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(final String tasId, final a aVar, String jumpTarget, String entryId, Bundle args, HashMap keyAttrs) {
        Intrinsics.checkNotNullParameter(tasId, "$tasId");
        Intrinsics.checkNotNullParameter(jumpTarget, "$jumpTarget");
        Intrinsics.checkNotNullParameter(entryId, "$entryId");
        Intrinsics.checkNotNullParameter(args, "$args");
        Intrinsics.checkNotNullParameter(keyAttrs, "$keyAttrs");
        final long currentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPeakServiceClass());
        intent.putExtra(AECameraConstants.INTENT_KEY_ACTION, 14);
        intent.putExtra(AECameraConstants.INTENT_KEY_ALIVE, true);
        final Handler handler = new Handler();
        ResultReceiver resultReceiver = new ResultReceiver(handler) { // from class: com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck$preCheck$1$resultReceiver$1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
                Serializable serializable;
                HashMap hashMap;
                Bundle bundle;
                Serializable serializable2;
                boolean z16;
                ConcurrentHashMap<String, String> concurrentHashMap = null;
                if (resultData != null) {
                    serializable = resultData.getSerializable("result_key_cost_time");
                } else {
                    serializable = null;
                }
                if (serializable instanceof HashMap) {
                    hashMap = (HashMap) serializable;
                } else {
                    hashMap = null;
                }
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                WinkLoadingDialogHelperFragment.Companion companion = WinkLoadingDialogHelperFragment.INSTANCE;
                if (companion.d(tasId) == null) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    hashMap.put(VasPerfReportUtils.WHILE_COST_TOTAL, Long.valueOf(currentTimeMillis2));
                    hashMap.put(VirtualAppProxy.KEY_DOWNLOAD_STATUS, 3);
                    w53.b.f("TAG_WinkSchemaPreCheck", "preCheck finish user canceled. costTime = " + currentTimeMillis2);
                    WinkSchemaPreCheck.f326271a.J(hashMap);
                    return;
                }
                if (resultData == null || (bundle = resultData.getBundle("result_key_args")) == null) {
                    bundle = new Bundle();
                }
                if (resultData != null) {
                    serializable2 = resultData.getSerializable("result_key_attrs");
                } else {
                    serializable2 = null;
                }
                if (serializable2 instanceof ConcurrentHashMap) {
                    concurrentHashMap = (ConcurrentHashMap) serializable2;
                }
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap<>();
                }
                companion.b(tasId);
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                hashMap.put(VasPerfReportUtils.WHILE_COST_TOTAL, Long.valueOf(currentTimeMillis3));
                if (resultCode == -1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                w53.b.f("TAG_WinkSchemaPreCheck", "preCheck finish result = " + z16 + ". costTime = " + currentTimeMillis3);
                if (resultCode == -1) {
                    hashMap.put(VirtualAppProxy.KEY_DOWNLOAD_STATUS, 1);
                    WinkSchemaPreCheck.f326271a.J(hashMap);
                    WinkSchemaPreCheck.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(bundle, concurrentHashMap);
                        return;
                    }
                    return;
                }
                hashMap.put(VirtualAppProxy.KEY_DOWNLOAD_STATUS, 2);
                WinkSchemaPreCheck.f326271a.J(hashMap);
                WinkSchemaPreCheck.a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.onFailed();
                }
            }
        };
        Bundle bundle = new Bundle();
        bundle.putString("key_jump_target", jumpTarget);
        bundle.putString("key_entry_id", entryId);
        bundle.putBundle("key_args", args);
        bundle.putSerializable("key_attrs", keyAttrs);
        bundle.putParcelable("key_result_receiver", resultReceiver);
        try {
            bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, WinkContext.INSTANCE.d().k().a());
        } catch (Throwable th5) {
            w53.b.c("TAG_WinkSchemaPreCheck", "preCheck error: " + th5);
        }
        intent.putExtra(AECameraConstants.INTENT_KEY_SCHEMA_PRECHECK_ARGS, bundle);
        BaseApplication.getContext().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object B(String str, String str2, HashMap<String, Object> hashMap, Continuation<? super Boolean> continuation) {
        return SupervisorKt.supervisorScope(new WinkSchemaPreCheck$preCheckBaseBundle$2(str, str2, hashMap, null), continuation);
    }

    @JvmStatic
    public static final void C(@NotNull Intent intent) {
        String str;
        String str2;
        HashMap hashMap;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle bundleExtra = intent.getBundleExtra(AECameraConstants.INTENT_KEY_SCHEMA_PRECHECK_ARGS);
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        String string = bundleExtra.getString("key_jump_target");
        if (string == null) {
            str = "";
        } else {
            str = string;
        }
        String string2 = bundleExtra.getString("key_entry_id");
        if (string2 == null) {
            str2 = "";
        } else {
            str2 = string2;
        }
        Bundle bundle = bundleExtra.getBundle("key_args");
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        Serializable serializable = bundleExtra.getSerializable("key_attrs");
        if (serializable instanceof HashMap) {
            hashMap = (HashMap) serializable;
        } else {
            hashMap = null;
        }
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        ResultReceiver resultReceiver = (ResultReceiver) bundleExtra.getParcelable("key_result_receiver");
        String string3 = bundleExtra.getString(QQWinkConstants.ENTRY_BUSINESS_NAME);
        HashMap<String, Object> hashMap2 = new HashMap<>();
        f326271a.D(str, str2, bundle2, new ConcurrentHashMap<>(hashMap), hashMap2, string3, new f(resultReceiver, hashMap2));
    }

    private final void D(String jumpTarget, String entryId, Bundle args, ConcurrentHashMap<String, String> keyAttrs, HashMap<String, Object> costCollector, String businessName, a callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.e()), null, null, new WinkSchemaPreCheck$preCheckInner$1(args, keyAttrs, callback, jumpTarget, entryId, costCollector, businessName, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object E(List<MetaMaterial> list, HashMap<String, Object> hashMap, Continuation<? super Boolean> continuation) {
        return SupervisorKt.supervisorScope(new WinkSchemaPreCheck$preCheckMaterialEssentialBundle$2(list, hashMap, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object F(ConcurrentHashMap<String, String> concurrentHashMap, HashMap<String, Object> hashMap, Continuation<? super Boolean> continuation) {
        return SupervisorKt.supervisorScope(new WinkSchemaPreCheck$preCheckOnlineMedia$2(concurrentHashMap, hashMap, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object G(ConcurrentHashMap<String, String> concurrentHashMap, HashMap<String, Object> hashMap, Continuation<? super Boolean> continuation) {
        return SupervisorKt.supervisorScope(new WinkSchemaPreCheck$preCheckUserInfo$2(concurrentHashMap, hashMap, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object H(String str, ConcurrentHashMap<String, String> concurrentHashMap, String str2, HashMap<String, Object> hashMap, Continuation<? super List<MetaMaterial>> continuation) {
        return SupervisorKt.supervisorScope(new WinkSchemaPreCheck$preDownloadMaterial$2(str, concurrentHashMap, str2, hashMap, null), continuation);
    }

    private final boolean I(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject.opt(str) == null) {
            jSONObject.put(str, obj);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(HashMap<String, Object> costCollector) {
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportWinkCommonEvents(WinkDengtaReportConstant.Action.XSJ_SCHEMA_JUMP_PRE_CHECK, costCollector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object q(MetaMaterial metaMaterial, HashMap<String, Object> hashMap, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        ArrayList arrayListOf;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        long currentTimeMillis = System.currentTimeMillis();
        String[] T0 = WinkEditorResourceManager.a1().T0(metaMaterial);
        if (T0 == null) {
            T0 = new String[0];
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Arrays.copyOf(T0, T0.length));
        if (arrayListOf.isEmpty()) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(true)));
        } else {
            WinkEditorResourceManager.a1().h0(metaMaterial, new c(metaMaterial, currentTimeMillis, hashMap, arrayListOf, safeContinuation));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object r(MetaMaterial metaMaterial, HashMap<String, Object> hashMap, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        long currentTimeMillis = System.currentTimeMillis();
        if (WinkEditorResourceManager.a1().q(metaMaterial)) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            String str = metaMaterial.f30533id;
            Intrinsics.checkNotNullExpressionValue(str, "material.id");
            hashMap.put(str, Boxing.boxLong(currentTimeMillis2));
            w53.b.f("TAG_WinkSchemaPreCheck", "downloadSingleMaterial id = " + metaMaterial.f30533id + " finish, material already exist. cost " + currentTimeMillis2);
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(true)));
        } else {
            WinkEditorResourceManager.a1().f(metaMaterial, new d(currentTimeMillis, hashMap, metaMaterial, safeContinuation));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object s(String str, String str2, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        long currentTimeMillis = System.currentTimeMillis();
        if (new File(str2).exists()) {
            w53.b.f("TAG_WinkSchemaPreCheck", "downloadSingleOnlineMedia targetUrl = " + str + ", targetPath = " + str2 + " finish, file already exist. cost " + (System.currentTimeMillis() - currentTimeMillis));
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(true)));
        } else {
            y53.a.c().a(str, str2, new e(str, str2, currentTimeMillis, safeContinuation));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> t(ConcurrentHashMap<String, String> keyAttrs) {
        List<String> split$default;
        String str = keyAttrs.get("mediapath");
        if (str == null) {
            str = "";
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null);
        return split$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object u(Continuation<? super WinkUserInfo> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        final long currentTimeMillis = System.currentTimeMillis();
        WinkUserInfoDataManager.INSTANCE.b().e(new Function1<WinkUserInfo, Unit>() { // from class: com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck$fetchUserInfo$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WinkUserInfo winkUserInfo) {
                invoke2(winkUserInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable WinkUserInfo winkUserInfo) {
                boolean z16 = winkUserInfo != null;
                w53.b.f("TAG_WinkSchemaPreCheck", "fetchUserInfo finish result = " + z16 + ". cost " + (System.currentTimeMillis() - currentTimeMillis));
                safeContinuation.resumeWith(Result.m476constructorimpl(winkUserInfo));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String v(List<String> paths) {
        String joinToString$default;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(paths, ",", null, null, 0, null, null, 62, null);
        return joinToString$default;
    }

    private final String w(String filePath) {
        int indexOf$default;
        int lastIndexOf$default;
        int lastIndexOf$default2;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) filePath, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            filePath = filePath.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(filePath, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) filePath, '.', 0, false, 6, (Object) null);
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        lastIndexOf$default2 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) filePath, separator, 0, false, 6, (Object) null);
        if (lastIndexOf$default != -1 && lastIndexOf$default2 < lastIndexOf$default) {
            String substring = filePath.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String x(String targetUrl) {
        String d16 = g.d(targetUrl);
        String w3 = w(targetUrl);
        return u53.a.f438368i + File.separator + d16 + "." + w3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(ConcurrentHashMap<String, String> keyAttrs, WinkUserInfo userInfo) {
        JSONObject jSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        String str = keyAttrs.get("key_template_asset");
        if (str == null) {
            str = "{}";
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        I(jSONObject, "nickName", userInfo.getNickName());
        I(jSONObject, "settlementTimeLabel", userInfo.getSettlementTimeLabel());
        I(jSONObject, "gender", userInfo.getGender());
        I(jSONObject, "locationLabel", userInfo.getLocationLabel());
        I(jSONObject, "describeLabel", userInfo.getDescribeLabel());
        I(jSONObject, "monthLabel", userInfo.getMonthLabel());
        I(jSONObject, "dayLabel", userInfo.getDayLabel());
        I(jSONObject, "ageLabel", userInfo.getAgeLabel());
        I(jSONObject, "constellationLabel", userInfo.getConstellationLabel());
        String v16 = WinkEditorResourceManager.a1().v1();
        Intrinsics.checkNotNullExpressionValue(v16, "getInstance().qqNickName");
        I(jSONObject, "nickNameForQQ", v16);
        I(jSONObject, "QQLogo", userInfo.getLogoLocalPath());
        I(jSONObject, "yearNumber", Integer.valueOf(Calendar.getInstance().get(1)));
        I(jSONObject, "monthNumber", Integer.valueOf(Calendar.getInstance().get(2)));
        I(jSONObject, "dayNumber", Integer.valueOf(Calendar.getInstance().get(5)));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "alreadyExistUserInfo.toString()");
        keyAttrs.put("key_template_asset", jSONObject2);
        w53.b.f("TAG_WinkSchemaPreCheck", "mergeUserInfo finish userInfoStr = " + jSONObject2 + ". cost " + (System.currentTimeMillis() - currentTimeMillis));
    }

    @JvmStatic
    public static final void z(@NotNull final String jumpTarget, @NotNull final String entryId, @NotNull final Bundle args, @NotNull final HashMap<String, String> keyAttrs, @Nullable final a callback) {
        Intrinsics.checkNotNullParameter(jumpTarget, "jumpTarget");
        Intrinsics.checkNotNullParameter(entryId, "entryId");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(keyAttrs, "keyAttrs");
        final String str = "WinkSchemaPreCheck#preCheck#" + System.currentTimeMillis();
        WinkLoadingDialogHelperFragment.INSTANCE.e(new TargetTask(new Runnable() { // from class: com.tencent.mobileqq.wink.schema.c
            @Override // java.lang.Runnable
            public final void run() {
                WinkSchemaPreCheck.A(str, callback, jumpTarget, entryId, args, keyAttrs);
            }
        }, str), "\u52a0\u8f7d\u4e2d");
    }

    @Nullable
    public final Object p(@NotNull String str, @Nullable HashMap<String, Object> hashMap, @NotNull Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ((IAEResUtil) QRoute.api(IAEResUtil.class)).fetchSingleBundle(str, new b(str, System.currentTimeMillis(), hashMap, safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/schema/WinkSchemaPreCheck$c", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "progress", "", "onProgressUpdate", "", "isSuccess", "onDownloadFinish", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f326276a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f326277b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ HashMap<String, Object> f326278c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList<String> f326279d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f326280e;

        /* JADX WARN: Multi-variable type inference failed */
        c(MetaMaterial metaMaterial, long j3, HashMap<String, Object> hashMap, ArrayList<String> arrayList, Continuation<? super Boolean> continuation) {
            this.f326276a = metaMaterial;
            this.f326277b = j3;
            this.f326278c = hashMap;
            this.f326279d = arrayList;
            this.f326280e = continuation;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            if (isSuccess) {
                WinkEditorResourceManager.a1().i0(this.f326276a);
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f326277b;
            this.f326278c.put("font", Long.valueOf(currentTimeMillis));
            w53.b.f("TAG_WinkSchemaPreCheck", "downloadSingleFont id = " + this.f326279d + " result = " + isSuccess + " finish. cost " + currentTimeMillis);
            this.f326280e.resumeWith(Result.m476constructorimpl(Boolean.valueOf(isSuccess)));
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/schema/WinkSchemaPreCheck$d", "Lcom/tencent/mobileqq/wink/edit/manager/WinkEditorResourceDownloader$d;", "", "progress", "", "onProgressUpdate", "", "isSuccess", "onDownloadFinish", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements WinkEditorResourceDownloader.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f326281a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap<String, Object> f326282b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f326283c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f326284d;

        /* JADX WARN: Multi-variable type inference failed */
        d(long j3, HashMap<String, Object> hashMap, MetaMaterial metaMaterial, Continuation<? super Boolean> continuation) {
            this.f326281a = j3;
            this.f326282b = hashMap;
            this.f326283c = metaMaterial;
            this.f326284d = continuation;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onDownloadFinish(boolean isSuccess) {
            long currentTimeMillis = System.currentTimeMillis() - this.f326281a;
            HashMap<String, Object> hashMap = this.f326282b;
            String str = this.f326283c.f30533id;
            Intrinsics.checkNotNullExpressionValue(str, "material.id");
            hashMap.put(str, Long.valueOf(currentTimeMillis));
            w53.b.f("TAG_WinkSchemaPreCheck", "downloadSingleMaterial id = " + this.f326283c.f30533id + " result = " + isSuccess + " finish. cost " + currentTimeMillis);
            this.f326284d.resumeWith(Result.m476constructorimpl(Boolean.valueOf(isSuccess)));
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceDownloader.d
        public void onProgressUpdate(int progress) {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/schema/WinkSchemaPreCheck$e", "Ly53/a$a;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "a", "", "progress", "onProgressUpdate", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements a.InterfaceC11592a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f326285a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f326286b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f326287c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f326288d;

        /* JADX WARN: Multi-variable type inference failed */
        e(String str, String str2, long j3, Continuation<? super Boolean> continuation) {
            this.f326285a = str;
            this.f326286b = str2;
            this.f326287c = j3;
            this.f326288d = continuation;
        }

        @Override // y53.a.InterfaceC11592a
        public void a(@Nullable NetResp resp) {
            boolean z16 = false;
            if (resp != null && resp.mResult == 0) {
                z16 = true;
            }
            w53.b.f("TAG_WinkSchemaPreCheck", "downloadSingleOnlineMedia targetUrl = " + this.f326285a + ", targetPath = " + this.f326286b + " finish result = " + z16 + ". cost " + (System.currentTimeMillis() - this.f326287c));
            this.f326288d.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
        }

        @Override // y53.a.InterfaceC11592a
        public void onProgressUpdate(int progress) {
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J,\u0010\u000f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/wink/schema/WinkSchemaPreCheck$b", "Lcom/tencent/aelight/camera/download/api/a;", "Lcom/tencent/aelight/camera/download/api/AEResInfo;", "aeResInfo", "", "currentOffset", "totalLength", "", "onAEProgressUpdate", "", "localFilePath", "", "downloaded", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "onAEDownloadFinish", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements com.tencent.aelight.camera.download.api.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f326272d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f326273e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ HashMap<String, Object> f326274f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f326275h;

        /* JADX WARN: Multi-variable type inference failed */
        b(String str, long j3, HashMap<String, Object> hashMap, Continuation<? super Boolean> continuation) {
            this.f326272d = str;
            this.f326273e = j3;
            this.f326274f = hashMap;
            this.f326275h = continuation;
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEDownloadFinish(@Nullable AEResInfo aeResInfo, @Nullable String localFilePath, boolean downloaded, int errorType) {
            String str;
            String str2;
            boolean equals$default;
            String str3 = this.f326272d;
            if (aeResInfo != null) {
                str = aeResInfo.agentType;
            } else {
                str = null;
            }
            w53.b.f("TAG_WinkSchemaPreCheck", "downloadSingleBundle " + str3 + " " + str);
            if (aeResInfo != null) {
                str2 = aeResInfo.agentType;
            } else {
                str2 = null;
            }
            boolean z16 = false;
            equals$default = StringsKt__StringsJVMKt.equals$default(str2, this.f326272d, false, 2, null);
            if (equals$default) {
                if (aeResInfo != null && (errorType == 0 || errorType == 1)) {
                    z16 = true;
                }
                long currentTimeMillis = System.currentTimeMillis() - this.f326273e;
                w53.b.f("TAG_WinkSchemaPreCheck", "downloadSingleBundle " + this.f326272d + " finish result = " + z16 + ". cost " + currentTimeMillis);
                HashMap<String, Object> hashMap = this.f326274f;
                if (hashMap != null) {
                    hashMap.put(this.f326272d, Long.valueOf(currentTimeMillis));
                }
                ((IAEResUtil) QRoute.api(IAEResUtil.class)).removeAEDownloadCallBack(this);
                this.f326275h.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z16)));
            }
        }

        @Override // com.tencent.aelight.camera.download.api.a
        public void onAEProgressUpdate(@Nullable AEResInfo aeResInfo, long currentOffset, long totalLength) {
        }
    }
}
