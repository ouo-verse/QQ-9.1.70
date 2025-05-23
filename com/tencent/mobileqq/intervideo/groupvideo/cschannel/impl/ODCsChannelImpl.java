package com.tencent.mobileqq.intervideo.groupvideo.cschannel.impl;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ams.mosaic.jsengine.animation.IAnimationFactory;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.jungle.videohub.proto.CommProtocolProto$commRequest;
import com.tencent.jungle.videohub.proto.CommProtocolProto$commResponse;
import com.tencent.jungle.videohub.proto.CommonUserProto$LoginCheckReq;
import com.tencent.jungle.videohub.proto.CommonUserProto$LoginCheckRsp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.groupvideo.cschannel.IODCsChannel;
import com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl;
import com.tencent.mobileqq.newnearby.servlet.ServletObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.e;
import com.tencent.qqnt.kernel.nativeinterface.GroupVideoCmdReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupVideoCmdRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGroupVideoCmdRequestRsp;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ODCsChannelImpl implements IODCsChannel {
    private static final int AVSDK_SERVICE_CMD_LOGIN = 10;
    private static final int DEFAULT_RETRY_TIMES = 0;
    private static final int ERROR_CODE_ACCESS_TOKEN_INVALID = 1008;
    private static final int ERROR_CODE_DATA_PARSE_ERROR = -10;
    private static final int ERROR_CODE_USER_SIG_INVALID = 1006;
    private static final String TAG = "ODCsChannel";
    private static final AtomicLong mCommRequestSequence = new AtomicLong(1);
    private Bundle mAccessToken;
    private String mAppName;
    private String mFromId;
    private long mGroupUin;
    private CommonUserProto$LoginCheckRsp mLoginCheckRsp;
    private QQAppInterface mQQApp;
    private String mServiceName;
    private long mUin;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements IGroupVideoCmdRequestRsp {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IODCsChannel.a f238197a;

        a(IODCsChannel.a aVar) {
            this.f238197a = aVar;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupVideoCmdRequestRsp
        public void onResult(int i3, String str, GroupVideoCmdRsp groupVideoCmdRsp) {
            QLog.d(ODCsChannelImpl.TAG, 1, "startGroupVideoCmdRequestFromAVSDK result " + i3 + ", errMsg: " + str);
            byte[] pbBuf = groupVideoCmdRsp != null ? groupVideoCmdRsp.getPbBuf() : null;
            if (i3 == 0 && pbBuf != null) {
                CommProtocolProto$commResponse commProtocolProto$commResponse = new CommProtocolProto$commResponse();
                try {
                    commProtocolProto$commResponse.mergeFrom(pbBuf);
                } catch (Throwable th5) {
                    commProtocolProto$commResponse.code.set(-10);
                    QLog.e(ODCsChannelImpl.TAG, 2, "sendOIDBRequest result: error", th5);
                }
                QLog.d(ODCsChannelImpl.TAG, 1, "startGroupVideoCmdRequestFromAVSDK commResponse " + commProtocolProto$commResponse.code.get() + ", errMsg: " + commProtocolProto$commResponse.f116932msg.get());
                ODCsChannelImpl.this.notifyResult(i3, commProtocolProto$commResponse, new Bundle(), this.f238197a);
                return;
            }
            QLog.e(ODCsChannelImpl.TAG, 1, "login: fail\uff0cerrorCode=" + i3);
            ODCsChannelImpl.this.notifyResult(i3, null, new Bundle(), this.f238197a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class c extends ServletObserver {
        final /* synthetic */ IODCsChannel.a C;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f238203f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f238204h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ byte[] f238205i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f238206m;

        c(int i3, int i16, byte[] bArr, boolean z16, IODCsChannel.a aVar) {
            this.f238203f = i3;
            this.f238204h = i16;
            this.f238205i = bArr;
            this.f238206m = z16;
            this.C = aVar;
        }

        @Override // com.tencent.mobileqq.newnearby.servlet.ServletObserver
        public void c(int i3, byte[] bArr, Bundle bundle) {
            String bundle2;
            String arrays;
            String str = "is null";
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("sendPBRequest errorCode=");
                sb5.append(i3);
                sb5.append(" bundle=");
                if (bundle == null) {
                    bundle2 = "null";
                } else {
                    bundle2 = bundle.toString();
                }
                sb5.append(bundle2);
                sb5.append(" data=");
                if (bArr == null) {
                    arrays = "is null";
                } else {
                    arrays = Arrays.toString(bArr);
                }
                sb5.append(arrays);
                QLog.d(ODCsChannelImpl.TAG, 2, sb5.toString());
            }
            if (i3 == 0 && bArr != null) {
                CommProtocolProto$commResponse commProtocolProto$commResponse = new CommProtocolProto$commResponse();
                try {
                    commProtocolProto$commResponse.mergeFrom(bArr);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    commProtocolProto$commResponse.code.set(-10);
                    QLog.e(ODCsChannelImpl.TAG, 2, "sendPBRequest: error=" + e16.getMessage());
                }
                if (commProtocolProto$commResponse.code.get() == 1008) {
                    QLog.i(ODCsChannelImpl.TAG, 2, "sendPBRequest: fail\uff0ctoken illegal, errorCode=1008");
                    ODCsChannelImpl.this.getAccessToken(this.f238204h, this.f238205i, this.f238206m, this.f238203f - 1, this.C);
                    return;
                }
                if (commProtocolProto$commResponse.code.get() == 1006) {
                    QLog.i(ODCsChannelImpl.TAG, 2, "sendPBRequest: fail\uff0cuser sig illegal, errorCode=1006");
                    ODCsChannelImpl.this.login(this.f238204h, this.f238205i, this.f238203f - 1, this.C);
                    return;
                } else {
                    if (commProtocolProto$commResponse.code.get() == 0 || this.f238203f <= 0) {
                        ODCsChannelImpl.this.notifyResult(i3, commProtocolProto$commResponse, bundle, this.C);
                        return;
                    }
                    QLog.i(ODCsChannelImpl.TAG, 2, "sendPBRequest: fail\uff0cerrorCode=" + commProtocolProto$commResponse.code.get());
                    ODCsChannelImpl.this.sendPBRequest(this.f238204h, this.f238205i, this.f238206m, this.f238203f + (-1), this.C);
                    return;
                }
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("login: fail\uff0cerrorCode=");
            sb6.append(i3);
            sb6.append(" data=");
            if (bArr != null) {
                str = Arrays.toString(bArr);
            }
            sb6.append(str);
            QLog.i(ODCsChannelImpl.TAG, 2, sb6.toString());
            int i16 = this.f238203f;
            if (i16 > 0) {
                ODCsChannelImpl.this.sendPBRequest(this.f238204h, this.f238205i, this.f238206m, i16 - 1, this.C);
            } else {
                ODCsChannelImpl.this.notifyResult(i3, null, bundle, this.C);
            }
        }
    }

    public ODCsChannelImpl() {
        this.mServiceName = "videohub";
    }

    private CommProtocolProto$commRequest buildCommRequest(int i3) {
        CommProtocolProto$commRequest commProtocolProto$commRequest = new CommProtocolProto$commRequest();
        commProtocolProto$commRequest.cmd.set(i3);
        commProtocolProto$commRequest.network.set(e52.a.a(this.mQQApp.getApp()));
        commProtocolProto$commRequest.seq.set(mCommRequestSequence.getAndAdd(1L));
        commProtocolProto$commRequest.app_name.set(this.mAppName);
        commProtocolProto$commRequest.microtime.set(System.currentTimeMillis());
        commProtocolProto$commRequest.client_release.set(AppSetting.f99551k);
        commProtocolProto$commRequest.from_id.set(this.mFromId);
        commProtocolProto$commRequest.version.set(2);
        commProtocolProto$commRequest.client_type.set(2);
        commProtocolProto$commRequest.auth_appid.set(Long.valueOf("1104763709").longValue());
        commProtocolProto$commRequest.auth_type.set(getAuthType());
        commProtocolProto$commRequest.uin.set(this.mUin);
        commProtocolProto$commRequest.openid.set(getAuthId());
        commProtocolProto$commRequest.auth_key.set(ByteStringMicro.copyFrom(getAuthKey().getBytes()));
        commProtocolProto$commRequest.uid.set(getUid());
        commProtocolProto$commRequest.user_sig.set(getUserSig());
        return commProtocolProto$commRequest;
    }

    private Bundle doGetAccessToken() {
        Bundle bundle;
        String bundle2;
        try {
            bundle = PluginManagerInterfaceImpl.i().f("Od", "1104763709").get();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getAccessToken: error=" + th5.getMessage());
            bundle = null;
        }
        int i3 = bundle != null ? bundle.getInt("code") : -1;
        Bundle bundle3 = bundle != null ? bundle.getBundle("data") : null;
        if (bundle3 != null && i3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getAccessToken: accessToken=" + bundle3.toString());
            }
            return bundle3;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getAccessToken: get access token fail\uff0cerrorCode=");
        sb5.append(i3);
        sb5.append(" accessToken=");
        if (bundle3 == null) {
            bundle2 = "null";
        } else {
            bundle2 = bundle3.toString();
        }
        sb5.append(bundle2);
        QLog.i(TAG, 2, sb5.toString());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAccessToken(final int i3, final byte[] bArr, final boolean z16, final int i16, final IODCsChannel.a aVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.intervideo.groupvideo.cschannel.impl.ODCsChannelImpl.3
            /* JADX WARN: Removed duplicated region for block: B:12:0x0078  */
            /* JADX WARN: Removed duplicated region for block: B:5:0x0055  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Bundle bundle;
                try {
                    bundle = PluginManagerInterfaceImpl.i().f("Od", "1104763709").get();
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                    QLog.e(ODCsChannelImpl.TAG, 2, "getAccessToken: error=" + e16.getMessage());
                    bundle = null;
                    if (bundle == null) {
                    }
                } catch (ExecutionException e17) {
                    e17.printStackTrace();
                    QLog.e(ODCsChannelImpl.TAG, 2, "getAccessToken: error=" + e17.getMessage());
                    bundle = null;
                    if (bundle == null) {
                    }
                }
                if (bundle == null) {
                    QLog.i(ODCsChannelImpl.TAG, 2, "getAccessToken: get access token fail\uff0cbundle = null");
                    int i17 = i16;
                    if (i17 > 0) {
                        ODCsChannelImpl.this.getAccessToken(i3, bArr, z16, i17 - 1, aVar);
                        return;
                    } else {
                        ODCsChannelImpl.this.notifyResult(-1, null, null, aVar);
                        return;
                    }
                }
                int i18 = bundle.getInt("code");
                Bundle bundle2 = bundle.getBundle("data");
                if (bundle2 != null && i18 == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(ODCsChannelImpl.TAG, 2, "getAccessToken: accessToken=" + bundle2.toString());
                    }
                    ODCsChannelImpl.this.mAccessToken = bundle2;
                    ODCsChannelImpl.this.sendRequest(i3, bArr, z16, i16, aVar);
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getAccessToken: get access token fail\uff0cerrorCode=");
                sb5.append(i18);
                sb5.append(" accessToken=");
                sb5.append(bundle2 == null ? "null" : bundle2.toString());
                QLog.i(ODCsChannelImpl.TAG, 2, sb5.toString());
                int i19 = i16;
                if (i19 > 0) {
                    ODCsChannelImpl.this.getAccessToken(i3, bArr, z16, i19 - 1, aVar);
                } else {
                    ODCsChannelImpl.this.notifyResult(i18, null, bundle, aVar);
                }
            }
        }, 128, null, true);
    }

    private String getAuthId() {
        Bundle bundle = this.mAccessToken;
        if (bundle != null) {
            return bundle.getString("authid");
        }
        return "";
    }

    private String getAuthKey() {
        Bundle bundle = this.mAccessToken;
        if (bundle != null) {
            return bundle.getString("authKey");
        }
        return "";
    }

    private int getAuthType() {
        Bundle bundle = this.mAccessToken;
        if (bundle != null) {
            return bundle.getInt("authtype");
        }
        return 1;
    }

    private long getUid() {
        CommonUserProto$LoginCheckRsp commonUserProto$LoginCheckRsp = this.mLoginCheckRsp;
        if (commonUserProto$LoginCheckRsp != null) {
            return commonUserProto$LoginCheckRsp.uid.get();
        }
        return 0L;
    }

    private String getUserSig() {
        CommonUserProto$LoginCheckRsp commonUserProto$LoginCheckRsp = this.mLoginCheckRsp;
        if (commonUserProto$LoginCheckRsp != null) {
            return commonUserProto$LoginCheckRsp.user_sig.get();
        }
        return "";
    }

    private void init(QQAppInterface qQAppInterface, long j3, String str, String str2) {
        this.mQQApp = qQAppInterface;
        this.mGroupUin = j3;
        this.mAppName = str;
        this.mFromId = str2;
        try {
            this.mUin = Long.valueOf(qQAppInterface.getCurrentAccountUin()).longValue();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyResult(int i3, CommProtocolProto$commResponse commProtocolProto$commResponse, Bundle bundle, final IODCsChannel.a aVar) {
        String bundle2;
        Object valueOf;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("notifyResult: errorCode=");
            sb5.append(i3);
            sb5.append(" bundle=");
            String str = "null";
            if (bundle == null) {
                bundle2 = "null";
            } else {
                bundle2 = bundle.toString();
            }
            sb5.append(bundle2);
            sb5.append(" commResponse.code=");
            if (commProtocolProto$commResponse == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(commProtocolProto$commResponse.code.get());
            }
            sb5.append(valueOf);
            sb5.append(" commResponse.msg=");
            if (commProtocolProto$commResponse != null) {
                str = commProtocolProto$commResponse.f116932msg.get();
            }
            sb5.append(str);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (commProtocolProto$commResponse != null) {
            i3 = commProtocolProto$commResponse.code.get();
        }
        final int i16 = i3;
        final byte[] byteArray = commProtocolProto$commResponse == null ? null : commProtocolProto$commResponse.body.get().toByteArray();
        if (bundle == null) {
            bundle = new Bundle();
        }
        final Bundle bundle3 = bundle;
        if (commProtocolProto$commResponse != null) {
            bundle3.putString("msg", commProtocolProto$commResponse.f116932msg.get());
            bundle3.putLong("seq", commProtocolProto$commResponse.seq.get());
            bundle3.putByteArray("data", byteArray);
        }
        if (aVar != null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                aVar.a(i16, byteArray, bundle3);
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.intervideo.groupvideo.cschannel.impl.ODCsChannelImpl.6
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(i16, byteArray, bundle3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPBRequest(int i3, byte[] bArr, boolean z16, int i16, IODCsChannel.a aVar) {
        CommProtocolProto$commRequest buildCommRequest = buildCommRequest(i3);
        if (bArr != null) {
            buildCommRequest.body.set(ByteStringMicro.copyFrom(bArr));
        }
        com.tencent.mobileqq.newnearby.servlet.b.a(new c(i16, i3, bArr, z16, aVar), buildCommRequest.toByteArray(), this.mServiceName + "." + buildCommRequest.cmd);
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.cschannel.IODCsChannel
    public void login(int i3, byte[] bArr, int i16, IODCsChannel.a aVar) {
        CommonUserProto$LoginCheckReq commonUserProto$LoginCheckReq = new CommonUserProto$LoginCheckReq();
        commonUserProto$LoginCheckReq.group_code.set(this.mGroupUin);
        commonUserProto$LoginCheckReq.refresh.set(false);
        commonUserProto$LoginCheckReq.is_test.set(true);
        CommProtocolProto$commRequest buildCommRequest = buildCommRequest(PlayUI.UIType.WEAKEN_MEDIUM_CARD_NG);
        buildCommRequest.body.set(ByteStringMicro.copyFrom(commonUserProto$LoginCheckReq.toByteArray()));
        com.tencent.mobileqq.newnearby.servlet.b.a(new b(i16, i3, bArr, aVar), buildCommRequest.toByteArray(), this.mServiceName + "." + PlayUI.UIType.WEAKEN_MEDIUM_CARD_NG);
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.cschannel.IODCsChannel
    public void sendOIDBRequest(final int i3, final byte[] bArr, final Bundle bundle, final IODCsChannel.a aVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.intervideo.groupvideo.cschannel.impl.ODCsChannelImpl.1
            @Override // java.lang.Runnable
            public void run() {
                ODCsChannelImpl.this.doSendOIDBRequestOnNT(i3, bArr, bundle, aVar);
            }
        }, 128, null, false);
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.cschannel.IODCsChannel
    public void sendRequest(int i3, byte[] bArr, IODCsChannel.a aVar) {
        sendRequest(i3, bArr, true, 0, aVar);
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.cschannel.IODCsChannel
    public void sendRequest(int i3, byte[] bArr, boolean z16, IODCsChannel.a aVar) {
        sendRequest(i3, bArr, z16, 0, aVar);
    }

    public ODCsChannelImpl(QQAppInterface qQAppInterface, long j3) {
        this(qQAppInterface, j3, "OnlineDating", IAnimationFactory.AnimationType.f70702GROUP);
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.cschannel.IODCsChannel
    public ODCsChannelImpl get(AppInterface appInterface, long j3) {
        init((QQAppInterface) appInterface, j3, "OnlineDating", IAnimationFactory.AnimationType.f70702GROUP);
        return this;
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.cschannel.IODCsChannel
    public void sendRequest(int i3, byte[] bArr, boolean z16, int i16, IODCsChannel.a aVar) {
        if (this.mAccessToken == null) {
            getAccessToken(i3, bArr, z16, i16, aVar);
        } else if (this.mLoginCheckRsp == null && z16) {
            login(i3, bArr, i16, aVar);
        } else {
            sendPBRequest(i3, bArr, z16, i16, aVar);
        }
    }

    public ODCsChannelImpl(QQAppInterface qQAppInterface, long j3, String str, String str2) {
        this.mServiceName = "videohub";
        this.mQQApp = qQAppInterface;
        this.mGroupUin = j3;
        this.mAppName = str;
        this.mFromId = str2;
        try {
            this.mUin = Long.valueOf(qQAppInterface.getCurrentAccountUin()).longValue();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.cschannel.IODCsChannel
    public ODCsChannelImpl get(AppInterface appInterface, long j3, String str, String str2) {
        init((QQAppInterface) appInterface, j3, str, str2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSendOIDBRequestOnNT(int i3, byte[] bArr, Bundle bundle, IODCsChannel.a aVar) {
        if (bundle != null && !TextUtils.isEmpty(bundle.getString("authKey"))) {
            this.mAccessToken = bundle;
        } else {
            Bundle doGetAccessToken = doGetAccessToken();
            if (doGetAccessToken == null) {
                notifyResult(-1, null, null, aVar);
                return;
            }
            this.mAccessToken = doGetAccessToken;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        e aVSDKService = peekAppRuntime != null ? ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getAVSDKService() : null;
        if (aVSDKService == null) {
            notifyResult(-1, null, null, aVar);
            return;
        }
        CommProtocolProto$commRequest buildCommRequest = buildCommRequest(i3);
        buildCommRequest.service_cmd.set("videohub." + i3);
        buildCommRequest.encode_type.set(1);
        buildCommRequest.body.set(ByteStringMicro.copyFrom(bArr));
        try {
            aVSDKService.startGroupVideoCmdRequestFromAVSDK(new GroupVideoCmdReq(4752, buildCommRequest.toByteArray()), new a(aVar));
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "doSendOIDBRequest error", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b extends ServletObserver {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f238199f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f238200h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ byte[] f238201i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ IODCsChannel.a f238202m;

        b(int i3, int i16, byte[] bArr, IODCsChannel.a aVar) {
            this.f238199f = i3;
            this.f238200h = i16;
            this.f238201i = bArr;
            this.f238202m = aVar;
        }

        @Override // com.tencent.mobileqq.newnearby.servlet.ServletObserver
        public void c(int i3, byte[] bArr, Bundle bundle) {
            String str;
            String bundle2;
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("login: errorCode=");
                sb5.append(i3);
                sb5.append(" bundle=");
                if (bundle == null) {
                    bundle2 = "null";
                } else {
                    bundle2 = bundle.toString();
                }
                sb5.append(bundle2);
                sb5.append(" data=");
                sb5.append(Arrays.toString(bArr));
                QLog.d(ODCsChannelImpl.TAG, 2, sb5.toString());
            }
            if (i3 == 0 && bArr != null) {
                CommProtocolProto$commResponse commProtocolProto$commResponse = new CommProtocolProto$commResponse();
                try {
                    commProtocolProto$commResponse.mergeFrom(bArr);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    commProtocolProto$commResponse.code.set(-10);
                    QLog.e(ODCsChannelImpl.TAG, 2, "login: error=" + e16.getMessage());
                }
                if (!QLog.isColorLevel()) {
                    str = "login: fail\uff0cerrorCode=";
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(" code=");
                    sb6.append(commProtocolProto$commResponse.code.get());
                    sb6.append(" msg=");
                    sb6.append(commProtocolProto$commResponse.f116932msg.get());
                    sb6.append(" seq=");
                    str = "login: fail\uff0cerrorCode=";
                    sb6.append(commProtocolProto$commResponse.seq.get());
                    sb6.append(" data[]=");
                    sb6.append(Arrays.toString(commProtocolProto$commResponse.body.get().toByteArray()));
                    QLog.d(ODCsChannelImpl.TAG, 2, "MSF.C.NetConnTag", sb6.toString());
                }
                if (commProtocolProto$commResponse.code.get() == 1008) {
                    QLog.i(ODCsChannelImpl.TAG, 2, "sendPBRequest: fail\uff0ctoken illegal, errorCode=1008");
                    ODCsChannelImpl.this.getAccessToken(this.f238200h, this.f238201i, true, this.f238199f - 1, this.f238202m);
                    return;
                }
                if (commProtocolProto$commResponse.code.get() != 0) {
                    QLog.i(ODCsChannelImpl.TAG, 2, str + commProtocolProto$commResponse.code.get() + " data=" + Arrays.toString(bArr));
                    int i16 = this.f238199f;
                    if (i16 <= 0) {
                        ODCsChannelImpl.this.notifyResult(i3, null, bundle, this.f238202m);
                        return;
                    } else {
                        ODCsChannelImpl.this.login(this.f238200h, this.f238201i, i16 - 1, this.f238202m);
                        return;
                    }
                }
                String str2 = str;
                CommonUserProto$LoginCheckRsp commonUserProto$LoginCheckRsp = new CommonUserProto$LoginCheckRsp();
                try {
                    commonUserProto$LoginCheckRsp.mergeFrom(commProtocolProto$commResponse.body.get().toByteArray());
                    ODCsChannelImpl.this.mLoginCheckRsp = commonUserProto$LoginCheckRsp;
                } catch (InvalidProtocolBufferMicroException e17) {
                    e17.printStackTrace();
                    QLog.e(ODCsChannelImpl.TAG, 2, "startGroupVideoOrVoice error=" + e17.getMessage());
                }
                if (ODCsChannelImpl.this.mLoginCheckRsp == null) {
                    QLog.i(ODCsChannelImpl.TAG, 2, str2 + i3 + " data=" + Arrays.toString(bArr));
                    int i17 = this.f238199f;
                    if (i17 <= 0) {
                        ODCsChannelImpl.this.notifyResult(i3, commProtocolProto$commResponse, bundle, this.f238202m);
                        return;
                    } else {
                        ODCsChannelImpl.this.login(this.f238200h, this.f238201i, i17 - 1, this.f238202m);
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ODCsChannelImpl.TAG, 2, "MSF.C.NetConnTag", " uid=" + commonUserProto$LoginCheckRsp.uid.get() + " user_sig=" + commonUserProto$LoginCheckRsp.user_sig.get());
                }
                ODCsChannelImpl.this.sendRequest(this.f238200h, bArr, true, this.f238199f, this.f238202m);
                return;
            }
            QLog.i(ODCsChannelImpl.TAG, 2, "login: fail\uff0cerrorCode=" + i3 + " data=" + Arrays.toString(bArr));
            int i18 = this.f238199f;
            if (i18 <= 0) {
                ODCsChannelImpl.this.notifyResult(i3, null, bundle, this.f238202m);
            } else {
                ODCsChannelImpl.this.login(this.f238200h, this.f238201i, i18 - 1, this.f238202m);
            }
        }
    }
}
