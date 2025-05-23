package com.tencent.biz.troop;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.bh;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.webview.URLCheckParams;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5$GroupInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: p, reason: collision with root package name */
    protected static b f96744p;

    /* renamed from: q, reason: collision with root package name */
    private static String f96745q;

    /* renamed from: r, reason: collision with root package name */
    static int f96746r;

    /* renamed from: h, reason: collision with root package name */
    kx.a f96754h;

    /* renamed from: i, reason: collision with root package name */
    kx.c f96755i;

    /* renamed from: l, reason: collision with root package name */
    com.tencent.mobileqq.app.c f96758l;

    /* renamed from: o, reason: collision with root package name */
    private ITroopMemberApiClientApi.a f96761o;

    /* renamed from: a, reason: collision with root package name */
    final Messenger f96747a = new Messenger(new HandlerC0980b());

    /* renamed from: b, reason: collision with root package name */
    Messenger f96748b = null;

    /* renamed from: c, reason: collision with root package name */
    AtomicInteger f96749c = new AtomicInteger(0);

    /* renamed from: d, reason: collision with root package name */
    List<BusinessObserver> f96750d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    List<Message> f96751e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    AtomicInteger f96752f = new AtomicInteger(0);

    /* renamed from: g, reason: collision with root package name */
    Map<Integer, ITroopMemberApiClientApi.a> f96753g = new ConcurrentHashMap();

    /* renamed from: j, reason: collision with root package name */
    protected ServiceConnection f96756j = new a();

    /* renamed from: k, reason: collision with root package name */
    SparseArray<BusinessObserver> f96757k = new SparseArray<>();

    /* renamed from: m, reason: collision with root package name */
    private HashMap<String, Integer> f96759m = new HashMap<>();

    /* renamed from: n, reason: collision with root package name */
    private HashMap<String, Integer> f96760n = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ArrayList arrayList;
            try {
                Messenger messenger = new Messenger(iBinder);
                if (QLog.isColorLevel()) {
                    QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "ServiceConnection Attached.");
                }
                Message obtain = Message.obtain((Handler) null, 1);
                obtain.replyTo = b.this.f96747a;
                Bundle bundle = new Bundle();
                bundle.putString("processName", b.y());
                obtain.obj = bundle;
                messenger.send(obtain);
                synchronized (b.this) {
                    b.this.f96748b = messenger;
                    arrayList = new ArrayList(b.this.f96751e);
                    b.this.f96751e.clear();
                }
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        messenger.send((Message) it.next());
                    }
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("com.tencent.biz.troop.TroopMemberApiClient", 2, e16.getMessage());
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b bVar = b.this;
            bVar.f96748b = null;
            bVar.f96753g.clear();
            if (QLog.isColorLevel()) {
                QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "Disconnected.");
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.troop.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class HandlerC0980b extends Handler {
        public HandlerC0980b() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r8v3, types: [com.tencent.mobileqq.app.BusinessObserver, java.lang.Object] */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data;
            String str;
            ITroopMemberApiClientApi.a remove;
            ITroopMemberApiClientApi.a remove2;
            ITroopMemberApiClientApi.a remove3;
            ITroopMemberApiClientApi.a remove4;
            ITroopMemberApiClientApi.a remove5;
            ITroopMemberApiClientApi.a remove6;
            ITroopMemberApiClientApi.a remove7;
            ITroopMemberApiClientApi.a aVar;
            ITroopMemberApiClientApi.a remove8;
            ITroopMemberApiClientApi.a remove9;
            ITroopMemberApiClientApi.a remove10;
            ITroopMemberApiClientApi.a remove11;
            ITroopMemberApiClientApi.a remove12;
            int intValue;
            ITroopMemberApiClientApi.a aVar2;
            int intValue2;
            ITroopMemberApiClientApi.a remove13;
            ITroopMemberApiClientApi.a remove14;
            ITroopMemberApiClientApi.a remove15;
            if (message == null || (data = message.getData()) == null) {
                return;
            }
            data.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
            int i3 = data.getInt("seq", -1);
            int i16 = message.what;
            if (i16 != 3) {
                if (i16 != 5) {
                    if (i16 != 7) {
                        if (i16 != 8) {
                            if (i16 != 28 && i16 != 29 && i16 != 41 && i16 != 42) {
                                if (i16 != 78) {
                                    if (i16 != 79 && i16 != 84 && i16 != 85) {
                                        if (i16 != 88) {
                                            if (i16 != 89) {
                                                if (i16 != 99) {
                                                    if (i16 != 100) {
                                                        switch (i16) {
                                                            case 5:
                                                                break;
                                                            case 11:
                                                            case 13:
                                                            case 14:
                                                            case 15:
                                                            case 19:
                                                            case 20:
                                                            case 44:
                                                            case 70:
                                                            case 74:
                                                            case 82:
                                                            case 106:
                                                            case 107:
                                                            case 108:
                                                            case 150:
                                                            case 151:
                                                            case 160:
                                                            case 164:
                                                                break;
                                                            case 16:
                                                            case 17:
                                                            case 18:
                                                                BusinessObserver businessObserver = b.this.f96757k.get(data.getInt("req_seq"));
                                                                if (businessObserver != null) {
                                                                    b.this.f96757k.remove(data.getInt("req_seq"));
                                                                    businessObserver.onUpdate(message.what, true, data);
                                                                    return;
                                                                }
                                                                return;
                                                            case 33:
                                                                ITroopMemberApiClientApi.a remove16 = b.this.f96753g.remove(Integer.valueOf(i3));
                                                                if (i3 != -1 && remove16 != null) {
                                                                    remove16.callback(data);
                                                                    return;
                                                                }
                                                                return;
                                                            case 50:
                                                                int i17 = data.getInt("seq", -1);
                                                                if (i17 != -1 && (remove3 = b.this.f96753g.remove(Integer.valueOf(i17))) != null) {
                                                                    remove3.callback(data);
                                                                    return;
                                                                }
                                                                return;
                                                            case 64:
                                                                if (i3 != -1 && (remove4 = b.this.f96753g.remove(Integer.valueOf(i3))) != null) {
                                                                    remove4.callback(data);
                                                                    return;
                                                                }
                                                                return;
                                                            case 105:
                                                                if (i3 != -1) {
                                                                    int i18 = data.getInt("retCode", -1);
                                                                    int i19 = data.getInt("rate", -1);
                                                                    ITroopMemberApiClientApi.a aVar3 = b.this.f96753g.get(Integer.valueOf(i3));
                                                                    if (aVar3 != null) {
                                                                        aVar3.callback(data);
                                                                        if (i18 != 0 || i19 == 100) {
                                                                            QLog.d("ReadInJoy", 4, "download finish:" + data);
                                                                            b.this.f96753g.remove(Integer.valueOf(i3));
                                                                        }
                                                                        if (QLog.isColorLevel()) {
                                                                            QLog.d(ProcessConstant.READINJOY, 4, "client MSG_READINJOY_LOAD_SKIN retCode=" + i18 + ",rate=" + i19);
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    if (QLog.isColorLevel()) {
                                                                        QLog.d(ProcessConstant.READINJOY, 4, "client MSG_READINJOY_LOAD_SKIN callback null");
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                if (QLog.isColorLevel()) {
                                                                    QLog.d(ProcessConstant.READINJOY, 4, "client MSG_READINJOY_LOAD_SKIN seq=" + i3);
                                                                    return;
                                                                }
                                                                return;
                                                            case 110:
                                                                if (i3 != -1 && (remove5 = b.this.f96753g.remove(Integer.valueOf(i3))) != null) {
                                                                    data.putString("type", "troopCreateOpenAIO");
                                                                    remove5.callback(data);
                                                                    return;
                                                                }
                                                                return;
                                                            case 111:
                                                                if (i3 != -1 && (remove6 = b.this.f96753g.remove(Integer.valueOf(i3))) != null) {
                                                                    remove6.callback(data);
                                                                    return;
                                                                }
                                                                return;
                                                            case 119:
                                                                if (i3 != -1 && (remove7 = b.this.f96753g.remove(Integer.valueOf(i3))) != null) {
                                                                    data.putBoolean("isSuccess", data.getBoolean("isSuccess"));
                                                                    remove7.callback(data);
                                                                    return;
                                                                }
                                                                return;
                                                            case 131:
                                                            case 132:
                                                            case 133:
                                                            case 134:
                                                                if (i3 != -1 && (aVar = b.this.f96753g.get(Integer.valueOf(i3))) != null) {
                                                                    aVar.callback(data);
                                                                    return;
                                                                }
                                                                return;
                                                            case 135:
                                                                if (i3 != -1) {
                                                                    b.this.f96753g.remove(Integer.valueOf(i3));
                                                                    return;
                                                                }
                                                                return;
                                                            case 144:
                                                                b.this.N().c(data);
                                                                return;
                                                            case 162:
                                                                ITroopMemberApiClientApi.a aVar4 = b.this.f96753g.get(Integer.valueOf(i3));
                                                                if (aVar4 != null) {
                                                                    aVar4.callback(data);
                                                                    return;
                                                                }
                                                                return;
                                                            case 171:
                                                            case 174:
                                                            case 176:
                                                                ITroopMemberApiClientApi.a aVar5 = b.this.f96753g.get(Integer.valueOf(i3));
                                                                if (aVar5 != null) {
                                                                    aVar5.callback(data);
                                                                    return;
                                                                }
                                                                return;
                                                            default:
                                                                switch (i16) {
                                                                    case 23:
                                                                        int i26 = data.getInt("seq1", -1);
                                                                        if (i26 != -1 && (remove8 = b.this.f96753g.remove(Integer.valueOf(i26))) != null) {
                                                                            remove8.callback(data);
                                                                            return;
                                                                        }
                                                                        return;
                                                                    case 24:
                                                                        int i27 = data.getInt("seq", -1);
                                                                        if (i27 != -1 && (remove9 = b.this.f96753g.remove(Integer.valueOf(i27))) != null) {
                                                                            remove9.callback(data);
                                                                            return;
                                                                        }
                                                                        return;
                                                                    case 25:
                                                                        int i28 = data.getInt("seq1", -1);
                                                                        if (i28 != -1 && (remove10 = b.this.f96753g.remove(Integer.valueOf(i28))) != null) {
                                                                            remove10.callback(data);
                                                                            return;
                                                                        }
                                                                        return;
                                                                    case 26:
                                                                        int i29 = data.getInt("seq", -1);
                                                                        if (i29 != -1 && (remove11 = b.this.f96753g.remove(Integer.valueOf(i29))) != null) {
                                                                            remove11.callback(data);
                                                                            return;
                                                                        }
                                                                        return;
                                                                    default:
                                                                        switch (i16) {
                                                                            case 53:
                                                                            case 57:
                                                                            case 58:
                                                                                break;
                                                                            case 54:
                                                                                if (i3 != -1 && (remove12 = b.this.f96753g.remove(Integer.valueOf(i3))) != null) {
                                                                                    remove12.callback(data);
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            case 55:
                                                                                String string = data.getString("FileName");
                                                                                int i36 = data.getInt("Status");
                                                                                if (b.this.f96759m != null && string != null && b.this.f96759m.get(string) != null && (intValue = ((Integer) b.this.f96759m.get(string)).intValue()) != -1 && (aVar2 = b.this.f96753g.get(Integer.valueOf(intValue))) != null) {
                                                                                    aVar2.callback(data);
                                                                                    if (i36 == 11) {
                                                                                        b.this.f96753g.remove(Integer.valueOf(intValue));
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            case 56:
                                                                                String string2 = data.getString("FilePath");
                                                                                String str2 = string2 + "/" + data.getInt("size");
                                                                                if (b.this.f96760n != null && string2 != null && b.this.f96760n.get(str2) != null && (intValue2 = ((Integer) b.this.f96760n.get(str2)).intValue()) != -1 && (remove13 = b.this.f96753g.remove(Integer.valueOf(intValue2))) != null) {
                                                                                    remove13.callback(data);
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            case 59:
                                                                                if (i3 != -1 && (remove14 = b.this.f96753g.remove(Integer.valueOf(i3))) != null) {
                                                                                    remove14.callback(data);
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            default:
                                                                                if (i3 != -1 && (remove15 = b.this.f96753g.remove(Integer.valueOf(i3))) != null) {
                                                                                    remove15.callback(data);
                                                                                    return;
                                                                                }
                                                                                return;
                                                                        }
                                                                }
                                                        }
                                                    }
                                                } else {
                                                    if (i3 != -1 && (remove2 = b.this.f96753g.remove(Integer.valueOf(i3))) != null) {
                                                        remove2.callback(data);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else {
                                                if (b.this.f96761o != null) {
                                                    b.this.f96761o.callback(data);
                                                    return;
                                                }
                                                return;
                                            }
                                        } else {
                                            if (b.this.f96761o != null) {
                                                b.this.f96761o.callback(data);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                } else {
                                    ITroopMemberApiClientApi.a remove17 = b.this.f96753g.remove(Integer.valueOf(i3));
                                    if (remove17 != null) {
                                        remove17.callback(data);
                                        return;
                                    }
                                    return;
                                }
                            }
                        } else {
                            b.this.E().d(data);
                            return;
                        }
                    }
                    if (i3 != -1 && (remove = b.this.f96753g.remove(Integer.valueOf(i3))) != null) {
                        remove.callback(data);
                        return;
                    }
                    return;
                }
                if (b.this.f96758l != null) {
                    b.this.f96758l.onUpdate(data.getInt("type"), true, new Object[]{data.getString(VasWebviewConstants.KEY_PAGE_URL), data.getStringArrayList("lstVideoUrl"), Integer.valueOf(data.getInt("totalTime", 0))});
                    return;
                }
                return;
            }
            int i37 = data.getInt("type");
            boolean z16 = data.getBoolean("isSuccess", false);
            ?? serializable = data.getSerializable("data");
            int i38 = data.getInt("observer_type", -1);
            String string3 = data.getString("observerClassName");
            for (BusinessObserver businessObserver2 : b.this.f96750d) {
                if ((i38 == 1 && (businessObserver2 instanceof bh)) || (i38 == 2 && (businessObserver2 instanceof ar))) {
                    if (28 == i37) {
                        byte[] byteArray = data.getByteArray("groupInfo");
                        MessageMicro<cmd0x7f5$GroupInfo> messageMicro = new MessageMicro<cmd0x7f5$GroupInfo>() { // from class: tencent.im.oidb.cmd0x7f5.cmd0x7f5$GroupInfo
                            static final MessageMicro.FieldMap __fieldMap__;
                            public final PBBytesField bytes_location;
                            public cmd0x7f5$LabelRspInfo label_info;
                            public final PBBytesField string_group_finger_memo;
                            public final PBBytesField string_group_name;
                            public final PBStringField string_join_auth_key;
                            public final PBUInt32Field uint32_extflag;
                            public final PBUInt32Field uint32_group_createtime;
                            public final PBUInt32Field uint32_group_member_num;
                            public final PBUInt64Field uint64_group_owner;
                            public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
                            public final PBUInt32Field uint32_accuracy = PBField.initUInt32(0);
                            public final PBInt32Field int32_ilat = PBField.initInt32(0);
                            public final PBInt32Field int32_ilon = PBField.initInt32(0);

                            static {
                                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 64, 80, 88, 106, 114, 122, 130}, new String[]{"uint64_group_code", "uint32_accuracy", "int32_ilat", "int32_ilon", "bytes_location", "uint32_extflag", "uint32_group_member_num", "uint64_group_owner", "uint32_group_createtime", "string_group_name", "string_group_finger_memo", "label_info", "string_join_auth_key"}, new Object[]{0L, 0, 0, 0, byteStringMicro, 0, 0, 0L, 0, byteStringMicro, byteStringMicro, null, ""}, cmd0x7f5$GroupInfo.class);
                            }

                            /* JADX WARN: Type inference failed for: r0v5, types: [tencent.im.oidb.cmd0x7f5.cmd0x7f5$LabelRspInfo] */
                            {
                                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                                this.bytes_location = PBField.initBytes(byteStringMicro);
                                this.uint32_extflag = PBField.initUInt32(0);
                                this.uint32_group_member_num = PBField.initUInt32(0);
                                this.uint64_group_owner = PBField.initUInt64(0L);
                                this.uint32_group_createtime = PBField.initUInt32(0);
                                this.string_group_name = PBField.initBytes(byteStringMicro);
                                this.string_group_finger_memo = PBField.initBytes(byteStringMicro);
                                this.label_info = new MessageMicro<cmd0x7f5$LabelRspInfo>() { // from class: tencent.im.oidb.cmd0x7f5.cmd0x7f5$LabelRspInfo
                                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_error", "rpt_label_info"}, new Object[]{ByteStringMicro.EMPTY, null}, cmd0x7f5$LabelRspInfo.class);
                                    public final PBBytesField bytes_error = PBField.initBytes(ByteStringMicro.EMPTY);
                                    public final PBRepeatMessageField<cmd0x7f5$LabelInfo> rpt_label_info = PBField.initRepeatMessage(cmd0x7f5$LabelInfo.class);
                                };
                                this.string_join_auth_key = PBField.initString("");
                            }
                        };
                        if (byteArray != null) {
                            try {
                                messageMicro.mergeFrom(byteArray);
                            } catch (InvalidProtocolBufferMicroException e16) {
                                e16.printStackTrace();
                                messageMicro = null;
                            }
                        }
                        serializable = new Object[]{Integer.valueOf(data.getInt("count")), messageMicro};
                    }
                    businessObserver2.onUpdate(i37, z16, serializable);
                } else if (i38 == 6 && (businessObserver2 instanceof uo4.e)) {
                    businessObserver2.onUpdate(i37, z16, serializable);
                } else {
                    try {
                        str = businessObserver2.getClass().getSuperclass().getName();
                    } catch (Exception e17) {
                        e17.printStackTrace();
                        str = "";
                    }
                    if (string3 != null && string3.equals(str)) {
                        businessObserver2.onUpdate(i37, z16, serializable);
                    }
                }
            }
        }
    }

    b() {
    }

    public static b A() {
        if (f96744p == null) {
            synchronized (b.class) {
                if (f96744p == null) {
                    f96744p = new b();
                }
            }
        }
        return f96744p;
    }

    public static String y() {
        String str = f96745q;
        if (str != null) {
            return str;
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    String str2 = runningAppProcessInfo.processName;
                    f96745q = str2;
                    return str2;
                }
            }
        }
        return null;
    }

    public void A0(String str, String str2, int i3, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("path", str);
        bundle.putString("troopUin", str2);
        bundle.putInt("msgTailType", i3);
        bundle.putInt("seq", d(aVar));
        y0(85, bundle);
    }

    public void B(String str, String str2, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("groupCode", str);
        bundle.putString("groupMemberUin", str2);
        bundle.putInt("seq", d(aVar));
        y0(70, bundle);
    }

    public void B0(int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("fontSize", i3);
        y0(51, bundle);
    }

    public void C(String str, String str2, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("troopUin", str);
        bundle.putString("rewardId", str2);
        bundle.putInt("seq", d(aVar));
        y0(53, bundle);
    }

    public void C0(String str, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putString("troopUin", str);
        bundle.putBoolean("isChecked", z16);
        y0(152, bundle);
    }

    public void D(String str, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("seq", d(aVar));
        bundle.putString("hashName", str);
        if (QLog.isColorLevel()) {
            QLog.d("allen", 2, "\u6b64\u65f6\u53d1\u9001\u8bf7\u6c42");
        }
        y0(64, bundle);
    }

    public void D0(long j3, int i3) {
        Bundle bundle = new Bundle();
        bundle.putLong("followUin", j3);
        bundle.putInt("followInfo", i3);
        y0(117, bundle);
    }

    public kx.a E() {
        if (this.f96754h == null) {
            this.f96754h = new kx.a(this);
        }
        return this.f96754h;
    }

    public void E0(int i3, int i16) {
        Bundle bundle = new Bundle();
        bundle.putInt("topicId", i3);
        bundle.putInt("followInfo", i16);
        y0(104, bundle);
    }

    public void F(ITroopMemberApiClientApi.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("getReadinjoyShareToWxConfig", 2, "get config");
        }
        x0(111, null, aVar);
    }

    public void F0(ITroopMemberApiClientApi.a aVar) {
        this.f96761o = aVar;
    }

    public void G(short s16, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("seq", d(aVar));
        bundle.putShort("tmpPushType", s16);
        y0(148, bundle);
    }

    public void G0(short s16, boolean z16, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("seq", d(aVar));
        bundle.putShort("tmpPushType", s16);
        bundle.putBoolean("enable", z16);
        y0(149, bundle);
    }

    public void H(String str, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("seq", d(aVar));
        bundle.putString("troopAvatarData", str);
        bundle.putString("processName", y());
        y0(171, bundle);
    }

    public void H0(Bundle bundle) {
        y0(112, bundle);
    }

    public void I(ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("seq", d(aVar));
        bundle.putString("processName", y());
        y0(79, bundle);
    }

    public void I0(String str, String str2, byte[] bArr, String str3, @Nullable HashMap<String, String> hashMap, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("seq", d(aVar));
        bundle.putString("service", str);
        bundle.putString("method", str2);
        bundle.putByteArray("param", bArr);
        bundle.putString("refer", str3);
        if (hashMap != null && !hashMap.isEmpty()) {
            bundle.putSerializable("extData", hashMap);
        }
        bundle.putString("processName", y());
        y0(164, bundle);
    }

    public void J(long j3, String str, String str2, long j16, int i3, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putLong(IProfileProtocolConst.PARAM_TROOP_CODE, j3);
        bundle.putString("filePath", str);
        bundle.putString(WadlProxyConsts.PARAM_FILENAME, str2);
        bundle.putLong("fileSize", j16);
        bundle.putInt("busid", i3);
        bundle.putString("processName", y());
        bundle.putInt("seq", d(aVar));
        y0(20, bundle);
    }

    public void J0() {
        y0(91, new Bundle());
    }

    public void K(String str, String str2, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("seq", d(aVar));
        bundle.putString("processName", y());
        bundle.putString("troopUin", str);
        bundle.putString("memberUin", str2);
        y0(176, bundle);
    }

    public void K0(String str, ITroopMemberApiClientApi.a aVar) {
        x0(154, new Bundle(), aVar);
    }

    public void L(Integer num, String str, String str2, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("seq", d(aVar));
        bundle.putInt("appid", num.intValue());
        bundle.putString("openId", str);
        bundle.putString("token", str2);
        y0(58, bundle);
    }

    public void L0(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("uin", str);
        bundle.putString("nick", str2);
        y0(140, bundle);
    }

    public void M(String str, String str2, String str3, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("appid", str);
        bundle.putString("openid", str2);
        bundle.putString("troopuin", str3);
        x0(143, bundle, aVar);
    }

    public void M0(Bundle bundle) {
        y0(145, bundle);
    }

    public kx.c N() {
        if (this.f96755i == null) {
            this.f96755i = new kx.c(this);
        }
        return this.f96755i;
    }

    public void N0(String str, String str2, byte[] bArr, String str3, @Nullable HashMap<String, String> hashMap, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("seq", d(aVar));
        bundle.putString("service", str);
        bundle.putString("method", str2);
        bundle.putByteArray("param", bArr);
        bundle.putString("refer", str3);
        if (hashMap != null && !hashMap.isEmpty()) {
            bundle.putSerializable("extData", hashMap);
        }
        bundle.putString("processName", y());
        y0(168, bundle);
    }

    public void O(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        bundle.putString("groupAutoApproval", jSONObject.toString());
        bundle.putString("processName", y());
        y0(173, bundle);
    }

    public void O0() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("register", false);
        y0(167, bundle);
    }

    public void P(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("force_install_new", z16);
        y0(89, bundle);
    }

    public void P0(long j3, long[] jArr) {
        Bundle bundle = new Bundle();
        bundle.putLongArray("troopUinList", jArr);
        bundle.putLong("troopPubAccountUin", j3);
        y0(43, bundle);
    }

    public void Q(ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("seq", d(aVar));
        y0(78, bundle);
    }

    public void Q0(String str, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putString("troopUin", str);
        bundle.putBoolean(com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, z16);
        y0(142, bundle);
    }

    public void R(String str, int i3, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("troopUin", str);
        bundle.putInt("statOption", i3);
        bundle.putString("authKey", str2);
        bundle.putString("authSig", str3);
        y0(67, bundle);
    }

    public void R0(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putString("processName", y());
        bundle.putBoolean(com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, z16);
        y0(177, bundle);
    }

    public void S(long j3) {
        Bundle bundle = new Bundle();
        bundle.putLong("roomId", j3);
        y0(86, bundle);
    }

    public void S0(String str, int i3, String str2, boolean z16, ITroopMemberApiClientApi.a aVar, ITroopMemberApiClientApi.a aVar2) {
        Bundle bundle = new Bundle();
        bundle.putString(IPublicAccountH5AbilityPlugin.PICLOCALPATH, str);
        bundle.putInt(IPublicAccountH5AbilityPlugin.PICISSHOWPRO, i3);
        bundle.putString(IPublicAccountH5AbilityPlugin.PICPUIN, str2);
        bundle.putInt("seq1", d(aVar2));
        bundle.putInt("seq", d(aVar));
        bundle.putBoolean(IPublicAccountH5AbilityPlugin.ISPICORVOICE, z16);
        y0(21, bundle);
    }

    public void T(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("groupCode", str);
        bundle.putString("appID", str2);
        bundle.putString("url", str3);
        bundle.putString("source", str4);
        y0(147, bundle);
    }

    public void U(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isTroopAppListChanged", z16);
        y0(30, bundle);
    }

    public void V(String str, String str2, String str3, String str4, String str5, String str6, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("troopUin", str);
        bundle.putString("chatType", str2);
        bundle.putString("packageId", str3);
        bundle.putString("callback", str6);
        bundle.putString("appChannel", str4);
        bundle.putString("pginSource", str5);
        bundle.putInt("seq", d(aVar));
        y0(109, bundle);
    }

    public void W(ArrayList<Integer> arrayList, int i3, int i16, int i17, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("subCmd", 1);
        bundle.putIntegerArrayList("groupCodeList", arrayList);
        bundle.putInt("effectId", i3);
        bundle.putInt("svipLevel", i16);
        bundle.putInt("svipType", i17);
        bundle.putString("effectName", str);
        y0(83, bundle);
    }

    public void X(ArrayList<String> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putInt("subCmd", 2);
        bundle.putStringArrayList("statusList", arrayList);
        y0(83, bundle);
    }

    public void Y(boolean z16, String str) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isTroopProfileAppListChanged", z16);
        bundle.putString("profileAppListChangedTroopUin", str);
        y0(103, bundle);
    }

    public void Z(String str, int i3, String str2, String str3, String str4, String str5, String str6) {
        Bundle bundle = new Bundle();
        bundle.putString("roomId", str);
        bundle.putInt("isGroupCode", i3);
        bundle.putString("action", str2);
        bundle.putString("fromId", str3);
        bundle.putString("backType", str4);
        bundle.putString("openType", str5);
        bundle.putString("extra", str6);
        y0(92, bundle);
    }

    public void a0(String str, String str2, String str3, String str4, String str5, String str6) {
        Bundle bundle = new Bundle();
        bundle.putString("appType", str);
        bundle.putString("openType", str2);
        bundle.putString(LayoutAttrDefine.CLICK_URI, str3);
        bundle.putString("action", str4);
        bundle.putString("pluginPackageName", str5);
        bundle.putString("pluginParams", str6);
        y0(65, bundle);
    }

    public void b0(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("localFilePath", str);
        bundle.putString("fileDisPlayName", str2);
        y0(45, bundle);
    }

    public void c0(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("troopUin", str);
        bundle.putString("opn", str2);
        y0(31, bundle);
    }

    public int d(ITroopMemberApiClientApi.a aVar) {
        int addAndGet = this.f96752f.addAndGet(1);
        this.f96753g.put(Integer.valueOf(addAndGet), aVar);
        return addAndGet;
    }

    public void d0(int i3, long j3, String str, String str2, int i16) {
        Bundle bundle = new Bundle();
        bundle.putLong("roomid", j3);
        bundle.putInt("roomType", i3);
        bundle.putString("vasname", str);
        bundle.putString("userdata", str2);
        bundle.putInt("fromid", i16);
        y0(32, bundle);
    }

    public void e(ArrayList<String> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("preloadList", arrayList);
        y0(101, bundle);
    }

    public void e0(String str, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("seq", d(aVar));
        bundle.putString("troopUin", str);
        bundle.putString("processName", y());
        y0(57, bundle);
    }

    public void f(BusinessObserver businessObserver) {
        if (businessObserver == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "RegisterObserver key:" + businessObserver.hashCode());
        }
        if (!this.f96750d.contains(businessObserver)) {
            this.f96750d.add(businessObserver);
        }
    }

    public void f0(JSONObject jSONObject) {
        QLog.d("TroopMemberApiService", 1, "openTroopQRPage");
        Bundle bundle = new Bundle();
        bundle.putString("openTroopQRPageData", jSONObject.toString());
        bundle.putString("processName", y());
        y0(169, bundle);
    }

    public void g(int i3, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("appId", i3);
        bundle.putInt("seq", d(aVar));
        y0(42, bundle);
    }

    public void g0() {
        y0(146, null);
    }

    public void h(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("gcode", str);
            bundle.putString("anId", str2);
            y0(7, bundle);
        }
    }

    public void h0(Bundle bundle) {
        y0(90, bundle);
    }

    public void i(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("pluginPackageName", str);
        bundle.putString("appType", str2);
        y0(69, bundle);
    }

    public void i0() {
        y0(170, new Bundle());
    }

    public void j() {
        y0(27, new Bundle());
    }

    public void j0() {
        y0(6, null);
    }

    public void k(String str, long j3, int i3, String str2, int i16, String str3, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("troopUin", str);
        bundle.putLong("bubbleId", j3);
        bundle.putInt("headId", i3);
        bundle.putString("nickName", str2);
        bundle.putInt("expireTime", i16);
        bundle.putString("rankColor", str3);
        bundle.putInt("seq", d(aVar));
        y0(13, bundle);
    }

    public void k0() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("register", true);
        y0(167, bundle);
    }

    public int l(URLCheckParams uRLCheckParams, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("param", uRLCheckParams);
        return x0(118, bundle, aVar);
    }

    public ITroopMemberApiClientApi.a l0(int i3) {
        return this.f96753g.remove(Integer.valueOf(i3));
    }

    public void m(String str, ITroopMemberApiClientApi.a aVar) {
        if (aVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("callback", str);
        }
        bundle.putInt("seq", d(aVar));
        y0(15, bundle);
    }

    public void m0() {
        this.f96761o = null;
    }

    public void n(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("troopUin", str);
        bundle.putString("type", str2);
        y0(113, bundle);
    }

    public void n0(BusinessObserver businessObserver) {
        if (businessObserver == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "unRegisterObserver key:" + businessObserver.hashCode());
        }
        if (this.f96750d.contains(businessObserver)) {
            this.f96750d.remove(businessObserver);
        }
    }

    public void o() {
        y0(102, new Bundle());
    }

    public void o0(int i3, String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("uploadType", i3);
        bundle.putString("url", str);
        bundle.putString("originUrl", str2);
        y0(139, bundle);
    }

    public void p() {
        if (this.f96749c.getAndAdd(1) == 0) {
            BaseApplication context = BaseApplication.getContext();
            context.bindService(new Intent(context, (Class<?>) TroopMemberApiService.class), this.f96756j, 1);
            if (QLog.isColorLevel()) {
                QLog.d("com.tencent.biz.troop.TroopMemberApiClient", 2, "Binding...");
            }
        }
    }

    public void p0(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("reportData", bundle);
        y0(115, bundle2);
    }

    public void q() {
        if (this.f96749c.get() == 0) {
            QLog.e("com.tencent.biz.troop.TroopMemberApiClient", 1, "call unbind but didn't bind", new Throwable());
            return;
        }
        if (this.f96749c.addAndGet(-1) == 0) {
            BaseApplication context = BaseApplication.getContext();
            if (this.f96748b != null) {
                try {
                    Message obtain = Message.obtain((Handler) null, 2);
                    obtain.replyTo = this.f96747a;
                    Bundle bundle = new Bundle();
                    bundle.putString("processName", y());
                    obtain.obj = bundle;
                    this.f96748b.send(obtain);
                } catch (RemoteException unused) {
                }
            }
            context.unbindService(this.f96756j);
            this.f96748b = null;
            synchronized (this) {
                this.f96751e.clear();
                this.f96753g.clear();
                N().b();
            }
            if (QLog.isColorLevel()) {
                QLog.i("com.tencent.biz.troop.TroopMemberApiClient", 2, "Unbinding...");
            }
        }
        if (this.f96749c.get() < 0) {
            this.f96749c.set(0);
            QLog.e("com.tencent.biz.troop.TroopMemberApiClient", 1, "call unbind but didn't bind", new Throwable());
        }
    }

    public void q0(Bundle bundle) {
        y0(163, bundle);
    }

    public void r() {
        y0(75, new Bundle());
    }

    public void r0() {
        y0(87, null);
    }

    public void s(String str, int i3, String str2, boolean z16, ITroopMemberApiClientApi.a aVar, ITroopMemberApiClientApi.a aVar2) {
        Bundle bundle = new Bundle();
        bundle.putString(IPublicAccountH5AbilityPlugin.PICSERVERID, str);
        bundle.putInt(IPublicAccountH5AbilityPlugin.PICISSHOWPRO, i3);
        bundle.putString(IPublicAccountH5AbilityPlugin.PICPUIN, str2);
        bundle.putBoolean(IPublicAccountH5AbilityPlugin.ISPICORVOICE, z16);
        bundle.putInt("seq1", d(aVar2));
        bundle.putInt("seq", d(aVar));
        y0(22, bundle);
    }

    public void s0(String str, String str2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("troopUin", str);
        bundle.putString("memberUin", str2);
        bundle.putInt("titleId", i3);
        y0(29, bundle);
    }

    public void t(ITroopMemberApiClientApi.a aVar) {
        x0(138, new Bundle(), aVar);
        AdAnalysisHelperForUtil.reportForAPIInvoked((Context) BaseApplicationImpl.getApplication(), true, "com.tencent.biz.troop.TroopMemberApiClient#gdtGetCurrentUserInfo(Callback)", "");
    }

    public void t0(String str, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putLong("troopUin", Long.parseLong(str));
        bundle.putBoolean("needPrivilege", z16);
        y0(49, bundle);
    }

    public void u(JSONObject jSONObject, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("seq", d(aVar));
        bundle.putString("processName", y());
        bundle.putString("ALD_CONFIG_RESULT", jSONObject.toString());
        y0(151, bundle);
    }

    public void u0(String str, String str2, int i3, String str3, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("callback", str3);
        bundle.putInt("seq", d(aVar));
        bundle.putString("troopUin", str);
        bundle.putString("troopName", str2);
        bundle.putInt("troopTypeId", i3);
        y0(19, bundle);
    }

    public void v(String str, String str2, String str3, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("seq", d(aVar));
        bundle.putString("processName", y());
        bundle.putString("troop_uin", str);
        bundle.putString("troopUinList", str2);
        bundle.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, str3);
        y0(174, bundle);
    }

    public void v0(int i3, String str, String str2, String str3, String str4, ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putString("callback", str4);
        bundle.putInt("seq", d(aVar));
        bundle.putInt("appid", i3);
        bundle.putString("openGroupId", str);
        bundle.putString("token", str2);
        bundle.putString("url", str3);
        y0(28, bundle);
    }

    public int w(ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        int d16 = d(aVar);
        bundle.putInt("seq", d16);
        y0(50, bundle);
        return d16;
    }

    public void w0() {
        y0(165, new Bundle());
    }

    public void x(ITroopMemberApiClientApi.a aVar) {
        x0(125, new Bundle(), aVar);
    }

    public int x0(int i3, Bundle bundle, ITroopMemberApiClientApi.a aVar) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        int d16 = d(aVar);
        bundle.putInt("seq", d16);
        bundle.putString("processName", y());
        y0(i3, bundle);
        return d16;
    }

    public void y0(int i3, Bundle bundle) {
        Message obtain = Message.obtain((Handler) null, i3);
        obtain.replyTo = this.f96747a;
        obtain.setData(bundle);
        Messenger messenger = this.f96748b;
        if (messenger == null) {
            synchronized (this) {
                this.f96751e.add(obtain);
            }
            return;
        }
        try {
            messenger.send(obtain);
        } catch (RemoteException e16) {
            QLog.e("com.tencent.biz.troop.TroopMemberApiClient", 1, "sendToService error:" + e16.getMessage());
        }
    }

    public void z(ITroopMemberApiClientApi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("seq", d(aVar));
        bundle.putString("processName", y());
        y0(172, bundle);
    }

    public void z0(int i3, Bundle bundle, BusinessObserver businessObserver) {
        SparseArray<BusinessObserver> sparseArray = this.f96757k;
        int i16 = f96746r + 1;
        f96746r = i16;
        sparseArray.append(i16, businessObserver);
        bundle.putString("processName", y());
        bundle.putInt("req_seq", f96746r);
        y0(i3, bundle);
    }
}
