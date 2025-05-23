package com.tencent.mobileqq.gamecenter.msginfo;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameCenterSessionInfo implements Comparable<GameCenterSessionInfo>, Parcelable {
    public static final Parcelable.Creator<GameCenterSessionInfo> CREATOR = new a();
    String C;
    String D;
    String E;
    String F;
    long G;
    int H;
    String I;
    long J;
    int K;
    int L;
    String M;
    String N;
    String P;
    String Q;
    long R;
    long S;
    SimpleMessage[] T = new SimpleMessage[0];

    /* renamed from: d, reason: collision with root package name */
    int f212215d;

    /* renamed from: e, reason: collision with root package name */
    String f212216e;

    /* renamed from: f, reason: collision with root package name */
    int f212217f;

    /* renamed from: h, reason: collision with root package name */
    String f212218h;

    /* renamed from: i, reason: collision with root package name */
    String f212219i;

    /* renamed from: m, reason: collision with root package name */
    String f212220m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Parcelable.Creator<GameCenterSessionInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GameCenterSessionInfo createFromParcel(Parcel parcel) {
            GameCenterSessionInfo gameCenterSessionInfo = new GameCenterSessionInfo();
            gameCenterSessionInfo.f212215d = parcel.readInt();
            gameCenterSessionInfo.f212216e = parcel.readString();
            gameCenterSessionInfo.f212217f = parcel.readInt();
            gameCenterSessionInfo.f212218h = parcel.readString();
            gameCenterSessionInfo.f212219i = parcel.readString();
            gameCenterSessionInfo.f212220m = parcel.readString();
            gameCenterSessionInfo.C = parcel.readString();
            gameCenterSessionInfo.D = parcel.readString();
            gameCenterSessionInfo.E = parcel.readString();
            gameCenterSessionInfo.F = parcel.readString();
            gameCenterSessionInfo.G = parcel.readLong();
            gameCenterSessionInfo.H = parcel.readInt();
            gameCenterSessionInfo.I = parcel.readString();
            gameCenterSessionInfo.J = parcel.readLong();
            gameCenterSessionInfo.K = parcel.readInt();
            gameCenterSessionInfo.L = parcel.readInt();
            gameCenterSessionInfo.M = parcel.readString();
            gameCenterSessionInfo.N = parcel.readString();
            gameCenterSessionInfo.P = parcel.readString();
            gameCenterSessionInfo.Q = parcel.readString();
            gameCenterSessionInfo.R = parcel.readLong();
            gameCenterSessionInfo.S = parcel.readLong();
            Parcelable[] readParcelableArray = parcel.readParcelableArray(SimpleMessage.class.getClassLoader());
            if (readParcelableArray != null) {
                gameCenterSessionInfo.T = new SimpleMessage[readParcelableArray.length];
                for (int i3 = 0; i3 < readParcelableArray.length; i3++) {
                    gameCenterSessionInfo.T[i3] = (SimpleMessage) readParcelableArray[i3];
                }
            }
            return gameCenterSessionInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GameCenterSessionInfo[] newArray(int i3) {
            return new GameCenterSessionInfo[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements IGameMsgNtApi.b {
        b() {
        }

        @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi.b
        public void onSuccess(@NonNull ArrayList<MsgRecord> arrayList) {
            if (arrayList.size() > 0) {
                synchronized (this) {
                    GameCenterSessionInfo.this.T = new SimpleMessage[arrayList.size()];
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        MsgRecord msgRecord = arrayList.get(i3);
                        GameCenterSessionInfo.this.T[i3] = new SimpleMessage(msgRecord.getMsgTime(), hd1.a.b(msgRecord));
                    }
                }
                return;
            }
            synchronized (this) {
                GameCenterSessionInfo gameCenterSessionInfo = GameCenterSessionInfo.this;
                SimpleMessage[] simpleMessageArr = gameCenterSessionInfo.T;
                if (simpleMessageArr != null && simpleMessageArr.length != 0) {
                    gameCenterSessionInfo.T = new SimpleMessage[0];
                }
            }
        }
    }

    public List<SimpleMessage> A() {
        List<SimpleMessage> asList;
        synchronized (this) {
            asList = Arrays.asList(this.T);
        }
        return asList;
    }

    public void B() {
        this.H++;
    }

    public void C(int i3) {
        this.f212217f = i3;
    }

    public void D(String str) {
        this.f212220m = str;
    }

    public void E(String str) {
        this.F = str;
    }

    public void F(long j3) {
        this.G = j3;
    }

    public void G(long j3) {
        this.R = j3;
    }

    public void M(String str) {
        this.Q = str;
    }

    public void N(String str) {
        this.f212218h = str;
    }

    public void V(String str) {
        this.f212219i = str;
    }

    public void Z(String str) {
        this.I = str;
    }

    public void a0(long j3) {
        this.J = j3;
    }

    public void b0(String str) {
        this.N = str;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(@android.support.annotation.NonNull GameCenterSessionInfo gameCenterSessionInfo) {
        long j3 = gameCenterSessionInfo.J;
        long j16 = this.J;
        if (j3 > j16) {
            return 1;
        }
        if (j3 < j16) {
            return -1;
        }
        return 0;
    }

    public void c0(String str) {
        this.C = str;
    }

    public void d0(String str) {
        this.P = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e0(int i3) {
        this.L = i3;
    }

    public void f0(String str) {
        this.E = str;
    }

    public void g0(String str) {
        this.D = str;
    }

    public void h0(int i3) {
        this.H = i3;
    }

    public void i0(String str) {
        this.M = str;
    }

    public String j() {
        return this.f212220m;
    }

    public void j0(String str) {
        this.f212216e = str;
    }

    public long k() {
        return this.R;
    }

    public void k0(int i3) {
        this.f212215d = i3;
    }

    public String l() {
        return this.Q;
    }

    public void l0(long j3) {
        this.S = j3;
    }

    public String m() {
        return this.f212218h;
    }

    public void m0(int i3) {
        this.K = i3;
    }

    public String n() {
        if (TextUtils.isEmpty(this.f212219i)) {
            this.f212219i = "QQ\u624b\u6e38";
        }
        return this.f212219i;
    }

    public void n0(AppInterface appInterface) {
        if (appInterface == null) {
            return;
        }
        ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getMsgList(this.f212216e, this.f212217f, this.K, new b());
    }

    public JSONObject o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, this.f212215d);
            jSONObject.put("sessionId", this.f212216e);
            jSONObject.put("conversationType", this.f212217f);
            jSONObject.put(VirtualAppProxy.KEY_GAME_ID, this.f212218h);
            jSONObject.put("gameName", n());
            jSONObject.put("faceUrl", this.f212220m);
            jSONObject.put("nickName", s());
            jSONObject.put("firstMsg", new QQText(this.F, 6, 32, -1).toPlainText());
            jSONObject.put("firstMsgTime", this.G);
            jSONObject.put("requestCount", this.H);
            jSONObject.put("lastMsg", new QQText(this.I, 6, 32, -1).toPlainText());
            jSONObject.put("lastMsgTime", this.J);
            jSONObject.put("unreadMsg", this.K);
            jSONObject.put("onlineType", this.L);
            jSONObject.put("onlineDesc", this.P);
            jSONObject.put("gameIcon", this.Q);
            jSONObject.put("fromTinyId", this.R);
            jSONObject.put("toTinyId", this.S);
            jSONObject.put("fromRoleId", this.M);
            jSONObject.put("toRoleId", this.N);
            jSONObject.put("qqUin", this.D);
            jSONObject.put("qqNick", this.E);
        } catch (JSONException e16) {
            QLog.e("GameCenterSessionInfo", 1, e16.getMessage());
        }
        return jSONObject;
    }

    public String p() {
        return this.I;
    }

    public long q() {
        return this.J;
    }

    public String r() {
        return this.N;
    }

    public String s() {
        if (TextUtils.isEmpty(this.C)) {
            this.C = "\u6e38\u620f\u597d\u53cb";
        }
        return this.C;
    }

    public String t() {
        return ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).createUidFromTinyId(this.S, this.R);
    }

    public String toString() {
        return "GameCenterSessionInfo{sessionType=" + this.f212215d + ", sessionId='" + this.f212216e + "', gameId='" + this.f212218h + "', gameName='" + this.f212219i + "', faceUrl='" + this.f212220m + "', nickName='" + this.C + "', firstMsg='" + this.F + "', firstMsgTime=" + this.G + ", requestCount=" + this.H + ", lastMsg='" + this.I + "', lastMsgTime=" + this.J + ", unreadMsg=" + this.K + ", onlienType=" + this.L + ", roleId='" + this.M + "', myRoleId='" + this.N + "', onLineDesc='" + this.P + "', gameIcon='" + this.Q + "', fromTinyId='" + this.R + "', toTinyId='" + this.S + "', qqUin='" + this.D + "', qqNick='" + this.E + "'}";
    }

    public int u() {
        return this.H;
    }

    public String v() {
        return this.M;
    }

    public String w() {
        return this.f212216e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f212215d);
        parcel.writeString(this.f212216e);
        parcel.writeInt(this.f212217f);
        parcel.writeString(this.f212218h);
        parcel.writeString(this.f212219i);
        parcel.writeString(this.f212220m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeLong(this.G);
        parcel.writeInt(this.H);
        parcel.writeString(this.I);
        parcel.writeLong(this.J);
        parcel.writeInt(this.K);
        parcel.writeInt(this.L);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
        parcel.writeString(this.P);
        parcel.writeString(this.Q);
        parcel.writeLong(this.R);
        parcel.writeLong(this.S);
        synchronized (this) {
            parcel.writeParcelableArray(this.T, 0);
        }
    }

    public int x() {
        return this.f212215d;
    }

    public long y() {
        return this.S;
    }

    public int z() {
        return this.K;
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class SimpleMessage implements Parcelable {
        public static final Parcelable.Creator<SimpleMessage> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public final long f212221d;

        /* renamed from: e, reason: collision with root package name */
        public final String f212222e;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements Parcelable.Creator<SimpleMessage> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SimpleMessage createFromParcel(Parcel parcel) {
                return new SimpleMessage(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SimpleMessage[] newArray(int i3) {
                return new SimpleMessage[i3];
            }
        }

        public SimpleMessage(long j3, String str) {
            this.f212221d = j3;
            this.f212222e = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeLong(this.f212221d);
            parcel.writeString(this.f212222e);
        }

        protected SimpleMessage(Parcel parcel) {
            this.f212221d = parcel.readLong();
            this.f212222e = parcel.readString();
        }
    }
}
