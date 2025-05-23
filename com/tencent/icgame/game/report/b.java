package com.tencent.icgame.game.report;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.icgame.api.room.PlayerConfig;
import com.tencent.mobileqq.icgame.api.room.StreamType;
import com.tencent.mobileqq.icgame.context.QQLiveContext;
import com.tencent.mobileqq.icgame.data.room.EnterRoomInfo;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.icgame.techreport.d;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b extends b32.a {

    /* renamed from: a, reason: collision with root package name */
    private final a f115809a;

    /* renamed from: b, reason: collision with root package name */
    private long f115810b;

    /* renamed from: c, reason: collision with root package name */
    private long f115811c;

    /* renamed from: d, reason: collision with root package name */
    private long f115812d;

    /* renamed from: e, reason: collision with root package name */
    private long f115813e;

    /* renamed from: f, reason: collision with root package name */
    private long f115814f;

    /* renamed from: g, reason: collision with root package name */
    private long f115815g;

    /* renamed from: h, reason: collision with root package name */
    private long f115816h;

    /* renamed from: i, reason: collision with root package name */
    private long f115817i;

    /* renamed from: j, reason: collision with root package name */
    private long f115818j;

    /* renamed from: k, reason: collision with root package name */
    private String f115819k;

    public b(long j3) {
        a aVar = new a();
        this.f115809a = aVar;
        this.f115810b = 0L;
        this.f115811c = 0L;
        this.f115812d = 0L;
        this.f115813e = 0L;
        this.f115814f = 0L;
        this.f115815g = 0L;
        this.f115816h = 0L;
        this.f115817i = 0L;
        this.f115818j = 0L;
        this.f115819k = "h264";
        aVar.f115792c = j3;
        aVar.f115797h = c();
        try {
            IQQLiveSDK l3 = mu0.a.k().l();
            if (l3 != null && l3.getLoginModule() != null && l3.getLoginModule().getUserInfo() != null) {
                LiveUserInfo userInfo = l3.getLoginModule().getUserInfo();
                aVar.f115790a = String.valueOf(userInfo.uid);
                aVar.f115791b = userInfo.nick;
            }
        } catch (Exception e16) {
            QLog.w("ICGameVideoQualityDelegate", 1, "[constructor] ", e16);
        }
    }

    private String a(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[");
        sb5.append(str);
        sb5.append("] ");
        sb5.append("roomId=");
        sb5.append(this.f115809a.f115792c);
        sb5.append(", ");
        sb5.append("playId=");
        sb5.append(this.f115809a.f115797h);
        if (!TextUtils.isEmpty(str2)) {
            sb5.append(", ");
            sb5.append(str2);
        }
        return sb5.toString();
    }

    private String c() {
        return SystemClock.elapsedRealtimeNanos() + "_" + hashCode();
    }

    private String d() {
        QQLiveContext b16 = QQLiveContext.INSTANCE.b("1078");
        if (b16 != null) {
            return b16.getTraceId();
        }
        return "";
    }

    private void e(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("ICGameVideoQualityDelegate", 2, a(str, str2));
        }
    }

    private void f(String str, String str2) {
        QLog.e("ICGameVideoQualityDelegate", 1, a(str, str2));
    }

    private void g(String str, String str2) {
        QLog.i("ICGameVideoQualityDelegate", 1, a(str, str2));
    }

    public void b() {
        if (this.f115812d == 0) {
            this.f115812d = System.currentTimeMillis();
            g("beforeEnterRoom", "");
            HashMap hashMap = new HashMap();
            hashMap.put(AudienceReportConst.ROOM_ID, String.valueOf(this.f115809a.f115792c));
            hashMap.put("room_type", String.valueOf(this.f115809a.f115796g));
            hashMap.put("user_id", String.valueOf(this.f115809a.f115790a));
            hashMap.put(AudienceReportConst.USER_NAME, String.valueOf(this.f115809a.f115791b));
            hashMap.put("ext1", d());
            hashMap.put("ext2", "begin enter video room");
            hashMap.put("ext5", String.valueOf(System.currentTimeMillis()));
            hashMap.put("ext6", this.f115809a.f115797h);
            d.g("ev_icgame_enter_room_step", hashMap);
        }
    }

    public void h(int i3) {
        this.f115810b = System.currentTimeMillis();
        this.f115809a.f115796g = String.valueOf(i3);
        g("onCreateRoom", "roomType=" + i3);
    }

    public void i(LiveInfo liveInfo, long j3) {
        if (liveInfo != null && liveInfo.roomInfo != null) {
            LiveAnchorInfo liveAnchorInfo = liveInfo.anchorInfo;
            if (liveAnchorInfo != null) {
                a aVar = this.f115809a;
                aVar.f115795f = liveAnchorInfo.nickName;
                aVar.f115794e = String.valueOf(liveAnchorInfo.uid);
            }
            this.f115809a.f115798i = liveInfo.roomInfo.programId;
            g("onEnterRoom", "anchorId=" + this.f115809a.f115794e + ", anchorName=" + this.f115809a.f115795f + ", programId=" + this.f115809a.f115798i);
            boolean a16 = gv0.b.f403419a.a(BaseApplication.context);
            HashMap hashMap = new HashMap();
            hashMap.put(AudienceReportConst.ROOM_ID, String.valueOf(this.f115809a.f115792c));
            hashMap.put("room_type", String.valueOf(this.f115809a.f115796g));
            hashMap.put("user_id", String.valueOf(this.f115809a.f115790a));
            hashMap.put(AudienceReportConst.USER_NAME, String.valueOf(this.f115809a.f115791b));
            hashMap.put("cost_time", String.valueOf(j3));
            hashMap.put("ext1", d());
            hashMap.put("ext2", "success");
            hashMap.put("ext5", String.valueOf(System.currentTimeMillis()));
            hashMap.put("ext6", this.f115809a.f115797h);
            hashMap.put("ext7", String.valueOf(a16));
            d.g("ev_icgame_enter_room_step", hashMap);
            a aVar2 = this.f115809a;
            aVar2.f115803n = 0L;
            aVar2.f115802m = 0L;
            return;
        }
        QLog.w("ICGameVideoQualityDelegate", 1, "[onEnterRoom] invalid params, liveInfo=" + liveInfo);
    }

    public void j(int i3, String str, long j3) {
        g("onEnterRoomFail", "errCode=" + i3 + ", errMsg=" + str);
        HashMap hashMap = new HashMap();
        hashMap.put(AudienceReportConst.ROOM_ID, String.valueOf(this.f115809a.f115792c));
        hashMap.put("room_type", String.valueOf(this.f115809a.f115796g));
        hashMap.put("user_id", String.valueOf(this.f115809a.f115790a));
        hashMap.put(AudienceReportConst.USER_NAME, String.valueOf(this.f115809a.f115791b));
        hashMap.put("cost_time", String.valueOf(j3));
        hashMap.put("ext1", d());
        hashMap.put("ext2", "fail");
        hashMap.put("ext5", String.valueOf(System.currentTimeMillis()));
        hashMap.put("ext6", this.f115809a.f115797h);
        d.g("ev_icgame_enter_room_step", hashMap);
        a aVar = this.f115809a;
        aVar.f115803n = 0L;
        aVar.f115802m = 0L;
        this.f115811c = 0L;
        this.f115812d = 0L;
        aVar.f115797h = c();
    }

    public void k() {
        onStopBuffer();
        m();
        HashMap hashMap = new HashMap();
        hashMap.put(AudienceReportConst.ROOM_ID, String.valueOf(this.f115809a.f115792c));
        hashMap.put("room_type", String.valueOf(this.f115809a.f115796g));
        hashMap.put("user_id", String.valueOf(this.f115809a.f115790a));
        hashMap.put(AudienceReportConst.USER_NAME, String.valueOf(this.f115809a.f115791b));
        hashMap.put("ext1", d());
        hashMap.put("ext2", "exit");
        hashMap.put("ext5", String.valueOf(System.currentTimeMillis()));
        hashMap.put("ext6", this.f115809a.f115797h);
        d.g("ev_icgame_enter_room_step", hashMap);
        a aVar = this.f115809a;
        aVar.f115803n = 0L;
        aVar.f115802m = 0L;
        this.f115811c = 0L;
        this.f115812d = 0L;
        aVar.f115797h = c();
    }

    public void l() {
        g("onRoomDestroy", "");
    }

    public void n() {
        if (this.f115811c == 0) {
            this.f115811c = System.currentTimeMillis();
            g("prepareEnterRoom", "");
        }
    }

    @Override // b32.a
    public void onAutoRecover(String str) {
        g("onAutoRecover", "");
        long currentTimeMillis = System.currentTimeMillis();
        this.f115813e = currentTimeMillis;
        this.f115811c = currentTimeMillis;
        this.f115812d = currentTimeMillis;
    }

    @Override // b32.a
    public void onError(int i3, int i16, int i17, String str) {
        f("onError", "module=" + i3 + ", errorType=" + i16 + ", errCode=" + i17 + ", extraInfo=" + str);
    }

    @Override // b32.a
    public void onFirstFrameCome(long j3, long j16) {
        g("onFirstFrameCome", "firstFrameShowCost=");
    }

    @Override // b32.a
    public void onInfo(int i3, long j3, long j16, Object obj) {
        if (i3 != 126 && i3 != 0) {
            e("onInfo", "what=" + i3 + ", arg1=" + j3 + ", arg2=" + j16 + ", extra=" + obj);
            if (i3 == 3) {
                a aVar = this.f115809a;
                long j17 = aVar.f115792c;
                if (j17 > 0) {
                    aVar.f115806q = com.tencent.icgame.game.liveroom.impl.room.definition.b.d(j17, EnterRoomInfo.VideoDefinition.UNKNOWN).level;
                    return;
                }
            }
            if (i3 == 205 && (obj instanceof TPPlayerMsg.TPProtocolInfo)) {
                this.f115809a.f115800k.a(((TPPlayerMsg.TPProtocolInfo) obj).protocolName);
            }
        }
    }

    @Override // b32.a
    public void onPause() {
        g(MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "");
    }

    @Override // b32.a
    public void onPlay() {
        g("onPlay", "");
        this.f115816h = 0L;
    }

    @Override // b32.a
    public void onPlayCompleted() {
        g("onPlayCompleted", "");
    }

    @Override // b32.a
    public void onPreparing(StreamType streamType, String str, PlayerConfig playerConfig) {
        g("onPreparing", "url=" + str);
    }

    @Override // b32.a
    public void onStartBuffer() {
        if (0 == this.f115809a.f115807r) {
            this.f115816h = 0L;
            return;
        }
        g("onStartBuffer", "beginBufferTime=" + this.f115816h);
        this.f115816h = System.currentTimeMillis();
        this.f115818j = 0L;
        this.f115815g = 0L;
        this.f115814f = 0L;
    }

    @Override // b32.a
    public void onSwitchDefinition(EnterRoomInfo.VideoDefinition videoDefinition, String str) {
        g("onSwitchDefinition", "url=" + str);
    }

    @Override // b32.a
    public void onUpdateDownloadInfo(long j3, long j16, long j17, long j18) {
        if (this.f115816h > 0) {
            this.f115818j += j18;
            return;
        }
        if (0 == this.f115814f) {
            this.f115814f = System.currentTimeMillis();
            this.f115815g = 0L;
            return;
        }
        this.f115815g += j18;
        double currentTimeMillis = System.currentTimeMillis() - this.f115814f;
        if (currentTimeMillis >= 5000.0d) {
            this.f115809a.f115805p = (this.f115815g / 1024) / (currentTimeMillis / 1000.0d);
            this.f115815g = 0L;
            this.f115814f = 0L;
        }
    }

    @Override // b32.a
    public void onVideoSizeChanged(int i3, int i16) {
        g("onVideoSizeChanged", "width=" + i3 + ", height=" + i16);
        this.f115809a.f115801l = i3 + HippyTKDListViewAdapter.X + i16 + "-" + this.f115819k;
    }

    private void m() {
    }

    @Override // b32.a
    public void onStopBuffer() {
    }
}
