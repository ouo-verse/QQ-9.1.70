package com.tencent.mobileqq.minigame.publicaccount;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi;
import com.tencent.mobileqq.minigame.publicaccount.hippy.module.MiniGamePANativeModule;
import com.tencent.mobileqq.minigame.publicaccount.model.QQGameMsgInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IGetAioFirstViewLatestMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.f;
import common.config.service.QzoneConfig;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J'\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0002\u00a2\u0006\u0002\u0010\fJ\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\"\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0014H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/minigame/publicaccount/MiniGamePublicAccountIPCModule;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getArkModel", "Lorg/json/JSONObject;", "arkMetaJson", "keys", "", "(Lorg/json/JSONObject;[Ljava/lang/String;)Lorg/json/JSONObject;", "handleGetMiniGameAioMsgList", "", "appInterface", "Lcom/tencent/mobileqq/app/QQAppInterface;", "params", "Landroid/os/Bundle;", "callbackId", "", "handleGetMiniGamePublicAccountMsg", "onCall", "Leipc/EIPCResult;", "action", "parseTianShuReportInfo", QQPermissionConstants.Permission.AUIDO_GROUP, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgInfo", "Lcom/tencent/mobileqq/minigame/publicaccount/model/QQGameMsgInfo;", "uin", "position", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGamePublicAccountIPCModule extends QIPCModule {
    public static final String ACTION_DO_ON_RESUME = "action_do_on_resume";
    public static final String ACTION_GET_MINI_GAME_AIO_ARK_MSG_LIST = "action_get_mini_game_aio_ark_msg_list";
    public static final String ACTION_GET_MINI_GAME_PUBLIC_MSG = "action_get_mini_game_public_account_msg";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_MSG_JSON_STRING = "key_msg_json_string";
    public static final String KEY_MSG_LIST = "key_msg_list";
    public static final String MODULE_NAME = "MiniGamePublicAccountIPCModule";
    private static final String TAG = "MiniGamePublicAccountIPCModule";
    private static volatile MiniGamePublicAccountIPCModule instance;
    private final String name;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/minigame/publicaccount/MiniGamePublicAccountIPCModule$Companion;", "", "()V", "ACTION_DO_ON_RESUME", "", "ACTION_GET_MINI_GAME_AIO_ARK_MSG_LIST", "ACTION_GET_MINI_GAME_PUBLIC_MSG", "KEY_MSG_JSON_STRING", "KEY_MSG_LIST", "MODULE_NAME", "TAG", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/minigame/publicaccount/MiniGamePublicAccountIPCModule;", "getInstance", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MiniGamePublicAccountIPCModule getInstance() {
            if (MiniGamePublicAccountIPCModule.instance == null) {
                synchronized (MiniGamePublicAccountIPCModule.class) {
                    if (MiniGamePublicAccountIPCModule.instance == null) {
                        MiniGamePublicAccountIPCModule.instance = new MiniGamePublicAccountIPCModule("MiniGamePublicAccountIPCModule");
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return MiniGamePublicAccountIPCModule.instance;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniGamePublicAccountIPCModule(String name) {
        super(name);
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    @JvmStatic
    public static final MiniGamePublicAccountIPCModule getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0013, code lost:
    
        r8 = kotlin.collections.CollectionsKt___CollectionsKt.reversed(r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void handleGetMiniGameAioMsgList$lambda$5(MiniGamePublicAccountIPCModule this$0, int i3, QQAppInterface appInterface, int i16, String str, ArrayList arrayList, boolean z16) {
        List listOf;
        Object obj;
        JSONObject optJSONObject;
        List<MsgRecord> reversed;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appInterface, "$appInterface");
        ArrayList<QQGameMsgInfo> arrayList2 = new ArrayList();
        if (arrayList != null && reversed != null) {
            for (MsgRecord msgRecord : reversed) {
                QQGameMsgInfo parseMsgRecord = QQGameMsgInfo.parseMsgRecord(msgRecord);
                if (parseMsgRecord != null) {
                    Intrinsics.checkNotNullExpressionValue(parseMsgRecord, "parseMsgRecord(msgRecord)");
                    String uin = appInterface.getAccount();
                    Intrinsics.checkNotNullExpressionValue(msgRecord, "msgRecord");
                    Intrinsics.checkNotNullExpressionValue(uin, "uin");
                    this$0.parseTianShuReportInfo(msgRecord, parseMsgRecord, uin, arrayList2.size());
                    arrayList2.add(parseMsgRecord);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        for (QQGameMsgInfo qQGameMsgInfo : arrayList2) {
            try {
                if (!TextUtils.isEmpty(qQGameMsgInfo.arkMetaList)) {
                    JSONObject jSONObject = new JSONObject(qQGameMsgInfo.arkMetaList);
                    if (!TextUtils.isEmpty(qQGameMsgInfo.arkAppConfig)) {
                        long optLong = new JSONObject(qQGameMsgInfo.arkAppConfig).optLong("ctime", -1L);
                        if (optLong != -1) {
                            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"xmodal", "qqgame_model"});
                            Iterator it = listOf.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    obj = it.next();
                                    if (jSONObject.has((String) obj)) {
                                        break;
                                    }
                                } else {
                                    obj = null;
                                    break;
                                }
                            }
                            String str2 = (String) obj;
                            if (str2 != null && (optJSONObject = jSONObject.optJSONObject(str2)) != null) {
                                optJSONObject.put("msgTime", optLong);
                            }
                        }
                    }
                    jSONArray.mo162put(jSONObject);
                }
            } catch (JSONException e16) {
                QLog.e("MiniGamePublicAccountIPCModule", 1, "format metaJson throw: ", e16);
            }
        }
        String jSONArray2 = jSONArray.toString();
        if (QLog.isColorLevel()) {
            QLog.i(MiniGamePANativeModule.CLASSNAME, 2, "handleGetMiniGameAioMsgList models=" + jSONArray2);
        }
        Bundle bundle = new Bundle();
        bundle.putString(KEY_MSG_JSON_STRING, jSONArray2);
        this$0.callbackResult(i3, EIPCResult.createSuccessResult(bundle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0013, code lost:
    
        r9 = kotlin.collections.CollectionsKt___CollectionsKt.reversed(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
    
        r9 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void handleGetMiniGamePublicAccountMsg$lambda$11(MiniGamePublicAccountIPCModule this$0, int i3, QQAppInterface appInterface, int i16, String str, ArrayList arrayList) {
        List listOf;
        Object obj;
        JSONObject optJSONObject;
        List reversed;
        List<MsgRecord> filterNotNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appInterface, "$appInterface");
        ArrayList<QQGameMsgInfo> arrayList2 = new ArrayList();
        if (arrayList != null && reversed != null && filterNotNull != null) {
            for (MsgRecord msgRecord : filterNotNull) {
                QQGameMsgInfo parseMsgRecord = QQGameMsgInfo.parseMsgRecord(msgRecord);
                if (parseMsgRecord != null) {
                    Intrinsics.checkNotNullExpressionValue(parseMsgRecord, "parseMsgRecord(msgRecord)");
                    String uin = appInterface.getAccount();
                    Intrinsics.checkNotNullExpressionValue(uin, "uin");
                    this$0.parseTianShuReportInfo(msgRecord, parseMsgRecord, uin, arrayList2.size());
                    arrayList2.add(parseMsgRecord);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        for (QQGameMsgInfo qQGameMsgInfo : arrayList2) {
            try {
                if (!TextUtils.isEmpty(qQGameMsgInfo.arkMetaList)) {
                    JSONObject jSONObject = new JSONObject(qQGameMsgInfo.arkMetaList);
                    if (!TextUtils.isEmpty(qQGameMsgInfo.arkAppConfig)) {
                        long optLong = new JSONObject(qQGameMsgInfo.arkAppConfig).optLong("ctime", -1L);
                        if (optLong != -1) {
                            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"xmodal", "qqgame_model"});
                            Iterator it = listOf.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    obj = it.next();
                                    if (jSONObject.has((String) obj)) {
                                        break;
                                    }
                                } else {
                                    obj = null;
                                    break;
                                }
                            }
                            String str2 = (String) obj;
                            if (str2 != null && (optJSONObject = jSONObject.optJSONObject(str2)) != null) {
                                optJSONObject.put("msgTime", optLong);
                            }
                        }
                    }
                    jSONArray.mo162put(jSONObject);
                }
            } catch (JSONException e16) {
                QLog.e("MiniGamePublicAccountIPCModule", 1, "format metaJson throw: ", e16);
            }
        }
        String jSONArray2 = jSONArray.toString();
        if (QLog.isColorLevel()) {
            QLog.i(MiniGamePANativeModule.CLASSNAME, 2, "getMiniGameArkModels models=" + jSONArray2);
        }
        Bundle bundle = new Bundle();
        bundle.putString(KEY_MSG_JSON_STRING, jSONArray2);
        this$0.callbackResult(i3, EIPCResult.createSuccessResult(bundle));
    }

    private final void parseTianShuReportInfo(MsgRecord record, QQGameMsgInfo msgInfo, String uin, int position) {
        JSONObject jSONObject;
        JSONObject arkModel;
        String busiIdExtra = ((IPublicAccountMsgExtMrg) QRoute.api(IPublicAccountMsgExtMrg.class)).getBusiIdExtra(record);
        if (TextUtils.isEmpty(busiIdExtra)) {
            return;
        }
        try {
            Bundle e16 = PublicAccountEventReport.e(busiIdExtra);
            if (e16 == null || TextUtils.isEmpty(msgInfo.arkMetaList) || (arkModel = getArkModel((jSONObject = new JSONObject(msgInfo.arkMetaList)), new String[]{"xmodal", "notification", "qqgame_model"})) == null) {
                return;
            }
            arkModel.put("isFromPublicLandingPage", true);
            arkModel.put("msgExposePosition", position);
            JSONObject jSONObject2 = new JSONObject();
            String str = msgInfo.advId;
            if (str == null) {
                str = e16.getString("ad_id");
            }
            jSONObject2.put("adId", str);
            jSONObject2.put("appid", "vab_push");
            jSONObject2.put("traceId", uin + "_" + (System.currentTimeMillis() / 1000));
            jSONObject2.put(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, busiIdExtra);
            arkModel.put("tianshuAdData", jSONObject2);
            msgInfo.arkMetaList = jSONObject.toString();
        } catch (Exception e17) {
            QLog.e("MiniGamePublicAccountIPCModule", 1, "parseTianshuReportInfo error ", e17);
        }
    }

    public final String getName() {
        return this.name;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String action, Bundle params, int callbackId) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
        if (qQAppInterface == null) {
            return null;
        }
        if (Intrinsics.areEqual(ACTION_GET_MINI_GAME_PUBLIC_MSG, action)) {
            handleGetMiniGamePublicAccountMsg(qQAppInterface, params, callbackId);
        } else if (Intrinsics.areEqual(ACTION_GET_MINI_GAME_AIO_ARK_MSG_LIST, action)) {
            handleGetMiniGameAioMsgList(qQAppInterface, params, callbackId);
        } else if (Intrinsics.areEqual(ACTION_DO_ON_RESUME, action)) {
            qQAppInterface.getMessageFacade().R0(AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN, 1008, true, true);
        }
        return null;
    }

    private final void handleGetMiniGameAioMsgList(final QQAppInterface appInterface, Bundle params, final int callbackId) {
        int i3 = params != null ? params.getInt("count") : 0;
        QLog.i("MiniGamePublicAccountIPCModule", 1, "handleGetMiniGameAioMsgList listCount=" + i3);
        Contact contact = new Contact(103, IMiniGamePublicAccountApi.PEER_UID_MINI_GAME, "");
        w e16 = f.e();
        if (e16 != null) {
            e16.getAioFirstViewLatestMsgs(contact, i3, new IGetAioFirstViewLatestMsgCallback() { // from class: com.tencent.mobileqq.minigame.publicaccount.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetAioFirstViewLatestMsgCallback
                public final void onResult(int i16, String str, ArrayList arrayList, boolean z16) {
                    MiniGamePublicAccountIPCModule.handleGetMiniGameAioMsgList$lambda$5(MiniGamePublicAccountIPCModule.this, callbackId, appInterface, i16, str, arrayList, z16);
                }
            });
        }
    }

    private final void handleGetMiniGamePublicAccountMsg(final QQAppInterface appInterface, Bundle params, final int callbackId) {
        int i3 = params != null ? params.getInt("count") : 0;
        if (i3 <= 0) {
            i3 = QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.SECONDARY_KEY_MINI_GAME_PUBLIC_ACCOUNT_MSG_LIST_COUNT, 4);
        }
        int i16 = i3;
        QLog.i("MiniGamePublicAccountIPCModule", 1, "handleGetMiniGamePublicAccountMsg listCount=" + i16);
        Contact contact = new Contact(103, IMiniGamePublicAccountApi.PEER_UID_MINI_GAME, "");
        w e16 = f.e();
        if (e16 != null) {
            e16.getMsgs(contact, 0L, i16, true, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.minigame.publicaccount.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i17, String str, ArrayList arrayList) {
                    MiniGamePublicAccountIPCModule.handleGetMiniGamePublicAccountMsg$lambda$11(MiniGamePublicAccountIPCModule.this, callbackId, appInterface, i17, str, arrayList);
                }
            });
        }
    }

    private final JSONObject getArkModel(JSONObject arkMetaJson, String[] keys) {
        if (arkMetaJson == null) {
            return null;
        }
        for (String str : keys) {
            JSONObject optJSONObject = arkMetaJson.optJSONObject(str);
            if (optJSONObject != null) {
                return optJSONObject;
            }
        }
        return null;
    }
}
