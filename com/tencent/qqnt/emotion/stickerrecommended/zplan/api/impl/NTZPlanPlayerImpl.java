package com.tencent.qqnt.emotion.stickerrecommended.zplan.api.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.data.ZPlanPicExtraData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zplan.emoticon.ZPlanEmoticonInfo;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonInfoHelper;
import com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil;
import com.tencent.mobileqq.zplan.emoticon.recommend.RecommendUtil;
import com.tencent.mobileqq.zplan.meme.a;
import com.tencent.mobileqq.zplan.meme.api.IApolloBrickPlayer;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer;
import com.tencent.qqnt.msg.data.g;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import com.tencent.zplan.meme.action.MemeZPlanEmoticon2DAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import su3.b;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 ?2\u00020\u0001:\u0001@B\u0007\u00a2\u0006\u0004\b=\u0010>J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J(\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\u0017\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\"R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010#R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010#R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u00101R\u0016\u00102\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00103R\u0016\u00107\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00103R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00105R\u0016\u0010<\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00101\u00a8\u0006A"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/zplan/api/impl/NTZPlanPlayerImpl;", "Lcom/tencent/qqnt/emotion/stickerrecommended/zplan/api/INTZPlanPlayer;", "Lorg/json/JSONObject;", "jsonObject", "", "setJsonZPlan", "Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/aio/api/runtime/a;", "baseAIOContext", "onSendZPlan", "Lcom/tencent/zplan/meme/action/MemeAction;", "action", "", "event", "dtReport", "Landroid/content/Context;", "context", "", "width", "height", "init", "aioContext", "setJson", "Landroid/view/View;", "getView", "", "isReady", "isPlaying", "play", "onSend", "pause", "resume", "stop", "Landroid/content/Context;", "Ljava/lang/Integer;", "Lcom/tencent/common/app/AppInterface;", "Lcom/tencent/mobileqq/zplan/meme/api/IApolloBrickPlayer;", "realPlayer", "Lcom/tencent/mobileqq/zplan/meme/api/IApolloBrickPlayer;", "Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "memeZPlanAction", "Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "Lcom/tencent/mobileqq/zplan/model/e;", "zplanActionInfo", "Lcom/tencent/mobileqq/zplan/model/e;", "Lcom/tencent/mobileqq/activity/aio/p;", "sessionInfo", "Lcom/tencent/mobileqq/activity/aio/p;", "Z", "type", "I", "typeStr", "Ljava/lang/String;", "playerNum", "duration", "", "timestamp", "J", "name", "isZPlan", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class NTZPlanPlayerImpl implements INTZPlanPlayer {
    private static final String KEY_ACTION_ID = "actionId";
    private static final String KEY_ACTION_TYPE = "actionType";
    private static final String KEY_DURATION = "duration";
    private static final String KEY_EXT_JSON = "extJson";
    private static final String KEY_ID = "id";
    private static final String KEY_IS_ZPLAN = "iszplan";
    private static final String KEY_NAME = "name";
    private static final String KEY_PLAYER_NUM = "player_number";
    private static final String KEY_STICKER_ID = "sticker_id";
    private static final String KEY_TIMESTAMP = "timestamp";
    private static final String KEY_TYPE = "type";
    private static final String KEY_ZH_NAME = "zh_name";
    private static final String TAG = "[zplan][ZPlanPlayerImpl]";
    private static final int ZPLAN_MODE = 2;
    private AppInterface app;
    private Context context;
    private int duration;
    private boolean isPlaying;
    private boolean isZPlan;
    private MemeZPlanAction memeZPlanAction;
    private IApolloBrickPlayer realPlayer;
    private p sessionInfo;
    private long timestamp;
    private int type;
    private ZPlanActionInfo zplanActionInfo;
    private Integer width = 0;
    private Integer height = 0;
    private String typeStr = "";
    private int playerNum = 1;
    private String name = "";

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    public View getView() {
        IApolloBrickPlayer iApolloBrickPlayer = this.realPlayer;
        if (iApolloBrickPlayer != null) {
            return iApolloBrickPlayer.getView();
        }
        return null;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    public void init(Context context, int width, int height, AppInterface app) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(app, "app");
        this.context = context;
        this.width = Integer.valueOf(width);
        this.height = Integer.valueOf(height);
        this.app = app;
        IApolloBrickPlayer iApolloBrickPlayer = (IApolloBrickPlayer) QRoute.api(IApolloBrickPlayer.class);
        iApolloBrickPlayer.setParams(new a(context, width, height));
        this.realPlayer = iApolloBrickPlayer;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    /* renamed from: isPlaying, reason: from getter */
    public boolean getIsPlaying() {
        return this.isPlaying;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    public boolean isReady() {
        return this.memeZPlanAction != null;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    public void onSend(AppInterface app, com.tencent.aio.api.runtime.a baseAIOContext) {
        Intrinsics.checkNotNullParameter(app, "app");
        QLog.d(TAG, 1, "onSend");
        if (this.isZPlan) {
            onSendZPlan(app, baseAIOContext);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    public void pause() {
        if (!isReady()) {
            QLog.w(TAG, 1, "pause not ready");
            return;
        }
        IApolloBrickPlayer iApolloBrickPlayer = this.realPlayer;
        if (iApolloBrickPlayer != null) {
            iApolloBrickPlayer.pause();
        }
        this.isPlaying = false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    public void play() {
        if (!isReady()) {
            QLog.w(TAG, 1, "play not ready");
            return;
        }
        IApolloBrickPlayer iApolloBrickPlayer = this.realPlayer;
        if (iApolloBrickPlayer != null) {
            iApolloBrickPlayer.start();
        }
        this.isPlaying = true;
        dtReport(this.memeZPlanAction, "expose");
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    public void resume() {
        if (!isReady()) {
            QLog.w(TAG, 1, "resume not ready");
            return;
        }
        IApolloBrickPlayer iApolloBrickPlayer = this.realPlayer;
        if (iApolloBrickPlayer != null) {
            iApolloBrickPlayer.resume();
        }
        this.isPlaying = true;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    public void stop() {
        if (!isReady()) {
            QLog.w(TAG, 1, "stop not ready");
            return;
        }
        IApolloBrickPlayer iApolloBrickPlayer = this.realPlayer;
        if (iApolloBrickPlayer != null) {
            iApolloBrickPlayer.destroy();
        }
        this.memeZPlanAction = null;
        this.isPlaying = false;
    }

    private final void onSendZPlan(AppInterface app, com.tencent.aio.api.runtime.a baseAIOContext) {
        j e16;
        if (this.zplanActionInfo == null || this.sessionInfo == null) {
            return;
        }
        String selfUin = app.getCurrentUin();
        ZPlanEmoticonUtil zPlanEmoticonUtil = ZPlanEmoticonUtil.f333176e;
        ZPlanActionInfo zPlanActionInfo = this.zplanActionInfo;
        Intrinsics.checkNotNull(zPlanActionInfo);
        Intrinsics.checkNotNullExpressionValue(selfUin, "selfUin");
        String A = zPlanEmoticonUtil.A(zPlanActionInfo, selfUin);
        if (TextUtils.isEmpty(A)) {
            return;
        }
        ZPlanActionInfo zPlanActionInfo2 = this.zplanActionInfo;
        Intrinsics.checkNotNull(zPlanActionInfo2);
        int id5 = zPlanActionInfo2.getId();
        ZPlanActionInfo zPlanActionInfo3 = this.zplanActionInfo;
        Intrinsics.checkNotNull(zPlanActionInfo3);
        String name = zPlanActionInfo3.getName();
        ZPlanActionInfo zPlanActionInfo4 = this.zplanActionInfo;
        Intrinsics.checkNotNull(zPlanActionInfo4);
        int playerNumber = zPlanActionInfo4.getPlayerNumber();
        ZPlanActionInfo zPlanActionInfo5 = this.zplanActionInfo;
        Intrinsics.checkNotNull(zPlanActionInfo5);
        int originType = zPlanActionInfo5.getOriginType();
        ZPlanActionInfo zPlanActionInfo6 = this.zplanActionInfo;
        Intrinsics.checkNotNull(zPlanActionInfo6);
        int width = zPlanActionInfo6.getWidth();
        ZPlanActionInfo zPlanActionInfo7 = this.zplanActionInfo;
        Intrinsics.checkNotNull(zPlanActionInfo7);
        ZPlanPicExtraData zPlanPicExtraData = new ZPlanPicExtraData(id5, name, playerNumber, originType, 0L, null, null, width, zPlanActionInfo7.getHeight(), 112, null);
        Intrinsics.checkNotNull(A);
        p pVar = this.sessionInfo;
        Intrinsics.checkNotNull(pVar);
        int i3 = pVar.f179555d;
        p pVar2 = this.sessionInfo;
        Intrinsics.checkNotNull(pVar2);
        String str = pVar2.f179557e;
        p pVar3 = this.sessionInfo;
        Intrinsics.checkNotNull(pVar3);
        String str2 = pVar3.f179559f;
        ZPlanActionInfo zPlanActionInfo8 = this.zplanActionInfo;
        Intrinsics.checkNotNull(zPlanActionInfo8);
        int id6 = zPlanActionInfo8.getId();
        ZPlanActionInfo zPlanActionInfo9 = this.zplanActionInfo;
        Intrinsics.checkNotNull(zPlanActionInfo9);
        String name2 = zPlanActionInfo9.getName();
        ZPlanActionInfo zPlanActionInfo10 = this.zplanActionInfo;
        Intrinsics.checkNotNull(zPlanActionInfo10);
        int originType2 = zPlanActionInfo10.getOriginType();
        ZPlanActionInfo zPlanActionInfo11 = this.zplanActionInfo;
        Intrinsics.checkNotNull(zPlanActionInfo11);
        int playerNumber2 = zPlanActionInfo11.getPlayerNumber();
        ZPlanActionInfo zPlanActionInfo12 = this.zplanActionInfo;
        Intrinsics.checkNotNull(zPlanActionInfo12);
        int width2 = zPlanActionInfo12.getWidth();
        ZPlanActionInfo zPlanActionInfo13 = this.zplanActionInfo;
        Intrinsics.checkNotNull(zPlanActionInfo13);
        g zPlanPicExtBizInfo = ((IZPlanEmoticonInfoHelper) QRoute.api(IZPlanEmoticonInfoHelper.class)).getZPlanPicExtBizInfo(new ZPlanEmoticonInfo(A, i3, selfUin, str, str2, id6, name2, originType2, playerNumber2, width2, zPlanActionInfo13.getHeight(), zPlanPicExtraData));
        dtReport(this.memeZPlanAction, "click");
        if (baseAIOContext == null || (e16 = baseAIOContext.e()) == null) {
            return;
        }
        ZPlanActionInfo zPlanActionInfo14 = this.zplanActionInfo;
        Intrinsics.checkNotNull(zPlanActionInfo14);
        e16.h(new AIOMsgSendEvent.PicEmotionSendEvent(A, 1, "[" + zPlanActionInfo14.getName() + "]", zPlanPicExtBizInfo, null, 16, null));
    }

    private final void dtReport(MemeAction action, String event) {
        if (action == null) {
            return;
        }
        int actionId = action.getActionId();
        QRouteApi api = QRoute.api(IApolloDtReportHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IApolloDtReportHelper::class.java)");
        IApolloDtReportHelper iApolloDtReportHelper = (IApolloDtReportHelper) api;
        rj3.a e16 = new rj3.a().e(2);
        p pVar = this.sessionInfo;
        Intrinsics.checkNotNull(pVar);
        rj3.a d16 = e16.b(iApolloDtReportHelper.getReportSessionType(pVar.f179555d)).c(String.valueOf(actionId)).h(this.playerNum).d(this.name);
        p pVar2 = this.sessionInfo;
        Intrinsics.checkNotNull(pVar2);
        String str = pVar2.f179557e;
        if (str == null) {
            str = null;
        }
        iApolloDtReportHelper.report("aio", "aio_keywords", event, d16.g(str).a());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041 A[Catch: all -> 0x011b, TryCatch #0 {all -> 0x011b, blocks: (B:7:0x001a, B:9:0x0021, B:13:0x0041, B:15:0x0047, B:16:0x0053, B:19:0x0083, B:21:0x009b, B:22:0x00ba, B:24:0x00bf, B:30:0x00cd, B:31:0x0111, B:33:0x0117, B:37:0x0102, B:38:0x00a8, B:40:0x00ae, B:41:0x0027, B:43:0x002d, B:44:0x0032, B:46:0x0038), top: B:6:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setJsonZPlan(JSONObject jsonObject) {
        int i3;
        int optInt;
        MemeZPlanAction memeZPlanAction;
        if (jsonObject == null) {
            return;
        }
        try {
            if (jsonObject.has("sticker_id")) {
                optInt = jsonObject.optInt("sticker_id");
            } else if (jsonObject.has("actionId")) {
                optInt = jsonObject.optInt("actionId");
            } else {
                if (!jsonObject.has("id")) {
                    i3 = -1;
                    if (i3 != -1) {
                        return;
                    }
                    if (jsonObject.has("type")) {
                        String optString = jsonObject.optString("type");
                        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(KEY_TYPE)");
                        this.typeStr = optString;
                    }
                    String senderUin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
                    this.playerNum = jsonObject.optInt(KEY_PLAYER_NUM);
                    this.duration = jsonObject.optInt("duration");
                    this.timestamp = jsonObject.optLong("timestamp");
                    ZPlanActionInfo c16 = RecommendUtil.f333314a.c(i3, jsonObject);
                    if (c16 == null) {
                        return;
                    }
                    this.zplanActionInfo = c16;
                    Intrinsics.checkNotNull(c16);
                    int width = c16.getWidth();
                    ZPlanActionInfo zPlanActionInfo = this.zplanActionInfo;
                    Intrinsics.checkNotNull(zPlanActionInfo);
                    int height = zPlanActionInfo.getHeight();
                    if (jsonObject.has(KEY_ZH_NAME)) {
                        String optString2 = jsonObject.optString(KEY_ZH_NAME);
                        Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(KEY_ZH_NAME)");
                        this.name = optString2;
                    } else if (jsonObject.has("name")) {
                        String optString3 = jsonObject.optString("name");
                        Intrinsics.checkNotNullExpressionValue(optString3, "jsonObject.optString(KEY_NAME)");
                        this.name = optString3;
                    }
                    ZPlanActionInfo zPlanActionInfo2 = this.zplanActionInfo;
                    boolean z16 = false;
                    if (zPlanActionInfo2 != null && zPlanActionInfo2.getOriginType() == 100) {
                        z16 = true;
                    }
                    if (z16) {
                        com.tencent.mobileqq.zplan.emoticon.panel.util.a aVar = com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a;
                        ZPlanActionInfo zPlanActionInfo3 = this.zplanActionInfo;
                        Intrinsics.checkNotNull(zPlanActionInfo3);
                        Intrinsics.checkNotNullExpressionValue(senderUin, "senderUin");
                        String f16 = aVar.f(zPlanActionInfo3, senderUin);
                        ZPlanActionInfo zPlanActionInfo4 = this.zplanActionInfo;
                        Intrinsics.checkNotNull(zPlanActionInfo4);
                        memeZPlanAction = new MemeZPlanEmoticon2DAction(i3, -1, width, height, zPlanActionInfo4.getPic2DMode(), senderUin, null, this.name, null, f16, null, null, null, null, 15616, null);
                    } else {
                        MODE mode = MODE.SHARPP;
                        Intrinsics.checkNotNullExpressionValue(senderUin, "senderUin");
                        memeZPlanAction = new MemeZPlanAction(i3, -1, width, height, mode, senderUin);
                    }
                    this.memeZPlanAction = memeZPlanAction;
                    IApolloBrickPlayer iApolloBrickPlayer = this.realPlayer;
                    if (iApolloBrickPlayer != null) {
                        iApolloBrickPlayer.setAction(memeZPlanAction, jsonObject);
                        return;
                    }
                    return;
                }
                optInt = jsonObject.optInt("id");
            }
            i3 = optInt;
            if (i3 != -1) {
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "setJsonZPlan error", th5);
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer
    public void setJson(JSONObject jsonObject, com.tencent.aio.api.runtime.a aioContext) {
        if (jsonObject == null || aioContext == null) {
            return;
        }
        SessionInfo sessionInfo = new SessionInfo();
        AIOParam g16 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        sessionInfo.f179555d = b.c(g16);
        AIOContact c16 = aioContext.g().r().c();
        sessionInfo.f179559f = c16.j();
        sessionInfo.f179557e = c16.j();
        sessionInfo.f179563i = c16.g();
        this.sessionInfo = sessionInfo;
        boolean z16 = jsonObject.optInt(KEY_IS_ZPLAN) == 1;
        this.isZPlan = z16;
        if (z16) {
            setJsonZPlan(jsonObject);
        }
    }
}
