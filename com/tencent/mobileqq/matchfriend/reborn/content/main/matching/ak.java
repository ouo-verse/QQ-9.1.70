package com.tencent.mobileqq.matchfriend.reborn.content.main.matching;

import android.app.Activity;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.a;
import com.tencent.mobileqq.matchfriend.voicechat.RoomInfo;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.gray_ctrl.gray_ctrl.GrayCtrl$GameInfo;
import com.tencent.trpcprotocol.kuolie.voice_match.voice_match.voiceMatch$CancelVoiceMatchReq;
import com.tencent.trpcprotocol.kuolie.voice_match.voice_match.voiceMatch$CheckIfAbleVoiceMatchReq;
import com.tencent.trpcprotocol.kuolie.voice_match.voice_match.voiceMatch$CheckIfAbleVoiceMatchRsp;
import com.tencent.trpcprotocol.kuolie.voice_match.voice_match.voiceMatch$StartVoiceMatchReq;
import com.tencent.trpcprotocol.kuolie.voice_match.voice_match.voiceMatch$StartVoiceMatchRsp;
import com.tencent.trpcprotocol.kuolie.voice_match.voice_match.voice_match$EnterVoiceMatchSessionReq;
import com.tencent.util.QQToastUtil;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 C2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\"\u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u0002J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020\u001fH\u0016J\u0010\u0010%\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010#R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010\tR\u0016\u0010>\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010\tR\u0016\u0010@\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010\t\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/ak;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/a;", "", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "K", "H", "E", UserInfo.SEX_FEMALE, "J", "N", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "", "tmpSeq", "o", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Lcom/tencent/trpcprotocol/kuolie/voice_match/voice_match/voiceMatch$StartVoiceMatchRsp;", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "w", "L", ReportConstant.COSTREPORT_PREFIX, "M", "start", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "", "u", "y", "t", "Landroid/content/Context;", "context", "p", "a", "Landroid/app/Activity;", "Ljava/lang/Runnable;", "b", "Ljava/lang/Runnable;", "dismissLoadingRunnable", "", "c", "I", "state", "d", "Z", "isMatchSuccess", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/t;", "e", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/t;", "fullscreenLoading", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog;", "f", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/QQStrangerMatchDialog;", "failDialog", "g", "maxLoadingTime", tl.h.F, "matchSeq", "i", "queryTime", "<init>", "()V", "j", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ak implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Activity activity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int state;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isMatchSuccess;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long matchSeq;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long queryTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Runnable dismissLoadingRunnable = new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.ad
        @Override // java.lang.Runnable
        public final void run() {
            ak.r(ak.this);
        }
    };

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final t fullscreenLoading = new t();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final QQStrangerMatchDialog failDialog = new QQStrangerMatchDialog(this);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long maxLoadingTime = 10000;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/matching/ak$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f244450a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ak f244451b;

        b(long j3, ak akVar) {
            this.f244450a = j3;
            this.f244451b = akVar;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            if (this.f244450a != this.f244451b.matchSeq) {
                return;
            }
            this.f244451b.N();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(results, "results");
            QLog.e("QQStrangerMatchVoiceManager", 1, "bluetooth permission deny");
            if (this.f244450a != this.f244451b.matchSeq) {
                return;
            }
            this.f244451b.N();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/matching/ak$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f244452a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ak f244453b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f244454c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQPermission f244455d;

        c(long j3, ak akVar, Activity activity, QQPermission qQPermission) {
            this.f244452a = j3;
            this.f244453b = akVar;
            this.f244454c = activity;
            this.f244455d = qQPermission;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            if (this.f244452a != this.f244453b.matchSeq) {
                return;
            }
            this.f244453b.o(this.f244454c, this.f244455d, this.f244452a);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(results, "results");
            QLog.e("QQStrangerMatchVoiceManager", 1, "permission deny");
            if (this.f244452a != this.f244453b.matchSeq) {
                return;
            }
            this.f244453b.Q();
        }
    }

    private final void A() {
        this.queryTime = System.currentTimeMillis();
        B();
    }

    private final void B() {
        if (t()) {
            return;
        }
        QLog.i("QQStrangerMatchVoiceManager", 1, "onMatching");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            Q();
            this.failDialog.z(this.activity, 5000, null);
            return;
        }
        Object businessHandler = qQAppInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        MessageMicro<voiceMatch$StartVoiceMatchReq> messageMicro = new MessageMicro<voiceMatch$StartVoiceMatchReq>() { // from class: com.tencent.trpcprotocol.kuolie.voice_match.voice_match.voiceMatch$StartVoiceMatchReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"open_id"}, new Object[]{""}, voiceMatch$StartVoiceMatchReq.class);
            public final PBStringField open_id = PBField.initString("");
        };
        final long j3 = this.matchSeq;
        ((com.tencent.relation.common.servlet.a) businessHandler).Z0("QQStranger.VoiceMatch.SsoStartVoiceMatch", messageMicro.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.ae
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                ak.C(j3, this, i3, z16, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(final long j3, final ak this$0, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (j3 != this$0.matchSeq || this$0.t()) {
            return;
        }
        QLog.i("QQStrangerMatchVoiceManager", 1, "onMatching,isSuccess=" + z16);
        if (z16 && (obj instanceof byte[])) {
            voiceMatch$StartVoiceMatchRsp voicematch_startvoicematchrsp = new voiceMatch$StartVoiceMatchRsp();
            try {
                voicematch_startvoicematchrsp.mergeFrom((byte[]) obj);
                boolean z17 = System.currentTimeMillis() - this$0.queryTime > this$0.maxLoadingTime;
                if (voicematch_startvoicematchrsp.code.get() == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.i("QQStrangerMatchVoiceManager", 1, "match success,tinyId=" + voicematch_startvoicematchrsp.matched_user.tiny_id + ",jumpAIO");
                    }
                    this$0.z(voicematch_startvoicematchrsp);
                    this$0.isMatchSuccess = true;
                    this$0.P();
                    return;
                }
                if (voicematch_startvoicematchrsp.code.get() == 1002 && !z17) {
                    QLog.i("QQStrangerMatchVoiceManager", 1, "match timeout, require again");
                    ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.ah
                        @Override // java.lang.Runnable
                        public final void run() {
                            ak.D(j3, this$0);
                        }
                    }, 16, null, false, 500L);
                    return;
                }
                this$0.Q();
                if (z17) {
                    this$0.w();
                }
                QQStrangerMatchDialog qQStrangerMatchDialog = this$0.failDialog;
                Activity activity = this$0.activity;
                int i16 = voicematch_startvoicematchrsp.code.get();
                String str = voicematch_startvoicematchrsp.f381588msg.get();
                Intrinsics.checkNotNullExpressionValue(str, "rsp.msg.get()");
                qQStrangerMatchDialog.w(activity, i16, str);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQStrangerMatchVoiceManager", 1, "onMatching,error", e16);
                this$0.Q();
                this$0.failDialog.z(this$0.activity, 5000, null);
                return;
            }
        }
        this$0.Q();
        this$0.failDialog.z(this$0.activity, 5000, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(long j3, ak this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (j3 != this$0.matchSeq) {
            return;
        }
        this$0.B();
    }

    private final void E() {
        QLog.i("QQStrangerMatchVoiceManager", 1, "onNetCheck");
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToastInUiThread(1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5\u3002");
            Q();
        } else {
            P();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(long j3, ak this$0, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (j3 != this$0.matchSeq) {
            return;
        }
        QLog.i("QQStrangerMatchVoiceManager", 1, "onPreCheck,isSuccess=" + z16);
        if (z16 && (obj instanceof byte[])) {
            voiceMatch$CheckIfAbleVoiceMatchRsp voicematch_checkifablevoicematchrsp = new voiceMatch$CheckIfAbleVoiceMatchRsp();
            try {
                voicematch_checkifablevoicematchrsp.mergeFrom((byte[]) obj);
                if (voicematch_checkifablevoicematchrsp.code.get() != 0) {
                    QLog.e("QQStrangerMatchVoiceManager", 1, "onPreCheck,fail,retCode=" + voicematch_checkifablevoicematchrsp.code.get() + ",msg={" + voicematch_checkifablevoicematchrsp.f381585msg.get() + "}");
                    this$0.failDialog.z(this$0.activity, 5000, null);
                    return;
                }
                if (voicematch_checkifablevoicematchrsp.result_type.get() != 0) {
                    QLog.e("QQStrangerMatchVoiceManager", 1, "onPreCheck,fail,retCode=" + voicematch_checkifablevoicematchrsp.code.get() + ",msg={" + voicematch_checkifablevoicematchrsp.f381585msg.get() + "}");
                    this$0.Q();
                    this$0.failDialog.z(this$0.activity, voicematch_checkifablevoicematchrsp.result_type.get(), voicematch_checkifablevoicematchrsp.dialog_config.get());
                    return;
                }
                this$0.P();
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QQStrangerMatchVoiceManager", 1, "onPreCheck,error", e16);
                this$0.Q();
                this$0.failDialog.z(this$0.activity, 5000, null);
                return;
            }
        }
        this$0.Q();
        this$0.failDialog.z(this$0.activity, 5000, null);
    }

    private final void H() {
        QLog.i("QQStrangerMatchVoiceManager", 1, "onRequireAudioFocus");
        String checkAVFocus = AVBizModuleFactory.getModuleByName(Constants.Business.MATCH_FRIEND).checkAVFocus();
        boolean areEqual = Intrinsics.areEqual("true", checkAVFocus);
        QLog.i("QQStrangerMatchVoiceManager", 1, "checkCanAcquireVoiceChatFocus canAcquire=" + areEqual + ",avFocusResult=" + checkAVFocus);
        if (!areEqual) {
            Q();
            QQToastUtil.showQQToastInUiThread(1, "\u901a\u8bdd\u4e2d\uff0c\u8bf7\u7ed3\u675f\u540e\u518d\u8bd5");
        } else {
            final long j3 = this.matchSeq;
            QIPCServerHelper.getInstance().callClient(Constants.Process.MATCH_FRIEND_PROCESS, "MatchFriendVoiceChatIpcClient", "CheckIsInVoiceChat", new Bundle(), new EIPCResultCallback() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.ag
                @Override // eipc.EIPCResultCallback
                public final void onCallback(EIPCResult eIPCResult) {
                    ak.I(j3, this, eIPCResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(long j3, ak this$0, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (j3 != this$0.matchSeq) {
            return;
        }
        if (eIPCResult == null) {
            QLog.i("QQStrangerMatchVoiceManager", 1, "result == null");
            this$0.P();
            return;
        }
        if (!eIPCResult.isSuccess()) {
            QLog.e("QQStrangerMatchVoiceManager", 1, "result error code=" + eIPCResult.code);
            this$0.P();
            return;
        }
        Bundle bundle = eIPCResult.data;
        if (bundle != null) {
            boolean z16 = bundle.getBoolean("is_in_voice_chat", false);
            QLog.i("QQStrangerMatchVoiceManager", 1, "checkCanAcquireVoiceChatFocus inVoiceChat=" + z16);
            if (z16) {
                this$0.Q();
                QQToastUtil.showQQToastInUiThread(1, "\u901a\u8bdd\u4e2d\uff0c\u8bf7\u7ed3\u675f\u540e\u518d\u8bd5");
                return;
            } else {
                this$0.P();
                return;
            }
        }
        this$0.P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N() {
        this.fullscreenLoading.m(this.activity, 2, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.ai
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ak.O(ak.this, view);
            }
        });
        P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(ak this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v();
    }

    private final void P() {
        int i3 = this.state;
        if (i3 + 1 > 6) {
            return;
        }
        int i16 = i3 + 1;
        this.state = i16;
        switch (i16) {
            case 0:
                K();
                return;
            case 1:
                H();
                return;
            case 2:
                E();
                return;
            case 3:
                F();
                return;
            case 4:
                J();
                return;
            case 5:
                A();
                return;
            case 6:
                L();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(Activity activity, QQPermission qqPermission, long tmpSeq) {
        int i3;
        boolean z16;
        boolean z17;
        boolean z18;
        if (AppSetting.m() >= 31 && (i3 = Build.VERSION.SDK_INT) >= 31 && p(activity)) {
            if (i3 >= 31) {
                z17 = false;
                z16 = activity.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_SCAN) == 0;
                z18 = activity.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_CONNECT) == 0;
                if (activity.checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE) == 0) {
                    z17 = true;
                }
            } else {
                z16 = true;
                z17 = true;
                z18 = true;
            }
            ArrayList arrayList = new ArrayList();
            if (!z16) {
                arrayList.add(QQPermissionConstants.Permission.BLUETOOTH_SCAN);
            }
            if (!z18) {
                arrayList.add(QQPermissionConstants.Permission.BLUETOOTH_CONNECT);
            }
            if (!z17) {
                arrayList.add(QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE);
            }
            QLog.d("QQStrangerMatchVoiceManager", 1, "checkBluetoothPermission checkScanResult=" + z16 + " checkConnectResult=" + z18 + " checkAdvertiseResult=" + z17 + " size=" + arrayList.size(), new Throwable());
            if (arrayList.size() > 0 && qqPermission != null) {
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                qqPermission.requestPermissions(strArr, 2, new b(tmpSeq, this));
                return;
            } else {
                if (arrayList.isEmpty() && tmpSeq == this.matchSeq) {
                    N();
                    return;
                }
                return;
            }
        }
        N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(ak this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QQStrangerMatchVoiceManager", 1, "run dismissLoading task.");
        this$0.q();
    }

    private final long s() {
        Object a16 = com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.a("gameInfos");
        GrayCtrl$GameInfo grayCtrl$GameInfo = null;
        List<GrayCtrl$GameInfo> list = a16 instanceof List ? (List) a16 : null;
        if (list == null || list.isEmpty()) {
            return 10000L;
        }
        for (GrayCtrl$GameInfo grayCtrl$GameInfo2 : list) {
            if (grayCtrl$GameInfo2.game_id.get() == 2) {
                grayCtrl$GameInfo = grayCtrl$GameInfo2;
            }
        }
        if (grayCtrl$GameInfo == null) {
            return 10000L;
        }
        long j3 = grayCtrl$GameInfo.max_loading_time.get();
        if (j3 <= 0) {
            return 10000L;
        }
        QLog.i("QQStrangerMatchVoiceManager", 1, "getMaxLoadingTime:" + j3 + ReportConstant.COSTREPORT_PREFIX);
        return j3 * 1000;
    }

    private final void v() {
        if (com.tencent.mobileqq.utils.u.a().b()) {
            return;
        }
        QLog.i("QQStrangerMatchVoiceManager", 1, "onCancel");
        if (t() && this.isMatchSuccess) {
            QQToastUtil.showQQToastInUiThread(0, "\u5339\u914d\u6210\u529f\uff0c\u8df3\u8f6c\u4e2d...");
        } else {
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(int i3, boolean z16, Object obj) {
        QLog.i("QQStrangerMatchVoiceManager", 1, "onCancel,isSuccess=" + z16);
    }

    public void M(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.fullscreenLoading.h(activity, 2);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.matching.a
    public void a() {
        a.C8011a.a(this);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.matching.a
    public void b() {
        a.C8011a.b(this);
    }

    public final void q() {
        this.fullscreenLoading.d(this.activity);
    }

    public boolean t() {
        return this.state >= 6;
    }

    public boolean u() {
        QLog.i("QQStrangerMatchVoiceManager", 1, "onBackEvent");
        if (!this.fullscreenLoading.getIsLoadingState()) {
            return false;
        }
        Q();
        return true;
    }

    private final void F() {
        QLog.i("QQStrangerMatchVoiceManager", 1, "onPreCheck");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            Q();
            this.failDialog.z(this.activity, 5000, null);
            return;
        }
        Object businessHandler = qQAppInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        MessageMicro<voiceMatch$CheckIfAbleVoiceMatchReq> messageMicro = new MessageMicro<voiceMatch$CheckIfAbleVoiceMatchReq>() { // from class: com.tencent.trpcprotocol.kuolie.voice_match.voice_match.voiceMatch$CheckIfAbleVoiceMatchReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], voiceMatch$CheckIfAbleVoiceMatchReq.class);
        };
        final long j3 = this.matchSeq;
        ((com.tencent.relation.common.servlet.a) businessHandler).Z0("QQStranger.VoiceMatch.SsoCheckIfAbleVoiceMatch", messageMicro.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.af
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                ak.G(j3, this, i3, z16, obj);
            }
        });
    }

    private final void J() {
        QLog.i("QQStrangerMatchVoiceManager", 1, "onRequirePermission");
        Activity activity = this.activity;
        if (activity == null) {
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_STRANGER, QQPermissionConstants.Business.SCENE.QQ_STRANGER_FLUTTER_PAGE));
        if (qQPermission == null) {
            Q();
            this.failDialog.z(this.activity, 5000, null);
            return;
        }
        long j3 = this.matchSeq;
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.RECORD_AUDIO) == 0) {
            o(activity, qQPermission, j3);
        } else {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}, 2, new c(j3, this, activity, qQPermission));
        }
    }

    private final void K() {
        QLog.i("QQStrangerMatchVoiceManager", 1, "onStateStart");
        P();
    }

    private final void L() {
        QLog.i("QQStrangerMatchVoiceManager", 1, "onStepEnd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        QLog.i("QQStrangerMatchVoiceManager", 1, "stop");
        this.state = 6;
        q();
    }

    private final void w() {
        QLog.i("QQStrangerMatchVoiceManager", 1, "onCancelInner");
        Q();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        Object businessHandler = qQAppInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
        ((com.tencent.relation.common.servlet.a) businessHandler).Z0("QQStranger.VoiceMatch.SsoCancelMatch", new MessageMicro<voiceMatch$CancelVoiceMatchReq>() { // from class: com.tencent.trpcprotocol.kuolie.voice_match.voice_match.voiceMatch$CancelVoiceMatchReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"open_id"}, new Object[]{""}, voiceMatch$CancelVoiceMatchReq.class);
            public final PBStringField open_id = PBField.initString("");
        }.toByteArray(), new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.aj
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                ak.x(i3, z16, obj);
            }
        });
        q();
    }

    public final void n() {
        QLog.i("QQStrangerMatchVoiceManager", 1, "cancelDismissLoadingRunnable");
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.dismissLoadingRunnable);
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.main.matching.a
    public void start() {
        QLog.i("QQStrangerMatchVoiceManager", 1, "onStart");
        this.state = -1;
        this.isMatchSuccess = false;
        this.queryTime = 0L;
        this.maxLoadingTime = s();
        this.matchSeq = System.currentTimeMillis();
        P();
    }

    public void y() {
        QLog.i("QQStrangerMatchVoiceManager", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        n();
    }

    private final void z(voiceMatch$StartVoiceMatchRsp data) {
        if (!t() && this.activity != null && data.room_id.get() > 0 && data.matched_user != null) {
            voice_match$EnterVoiceMatchSessionReq voice_match_entervoicematchsessionreq = new voice_match$EnterVoiceMatchSessionReq();
            voice_match_entervoicematchsessionreq.room_id.set(data.room_id.get());
            voice_match_entervoicematchsessionreq.sign.set(data.sign.get());
            voice_match_entervoicematchsessionreq.max_waiting_time.set(10000L);
            voice_match_entervoicematchsessionreq.tiny_id.set(data.matched_user.tiny_id.get());
            voice_match_entervoicematchsessionreq.open_id.set(data.matched_user.open_id.get());
            voice_match_entervoicematchsessionreq.avatar.set(data.matched_user.avatar.get());
            voice_match_entervoicematchsessionreq.nickname.set(data.matched_user.nickname.get());
            voice_match_entervoicematchsessionreq.self_tiny_id.set(data.owner.tiny_id.get());
            RoomInfo roomInfo = new RoomInfo(data.room_id.get(), data.owner.tiny_id.get(), data.matched_user.tiny_id.get(), data.sign.get().toByteArray());
            roomInfo.f245600h = data.matched_user.open_id.get();
            roomInfo.f245601i = data.matched_user.nickname.get();
            roomInfo.f245602m = data.matched_user.avatar.get();
            roomInfo.D = 10000L;
            if (!roomInfo.a()) {
                QLog.i("QQStrangerMatchVoiceManager", 1, "onMatchSuccess, roomInfo invalid");
                Q();
                return;
            } else {
                ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterVoiceChat(this.activity, roomInfo);
                ThreadManagerV2.getUIHandlerV2().postDelayed(this.dismissLoadingRunnable, 5000L);
                return;
            }
        }
        QLog.i("QQStrangerMatchVoiceManager", 1, "onMatchSuccess, rspData invalid");
        Q();
        this.failDialog.w(this.activity, 5000, "");
    }

    public final boolean p(Context context) {
        if (context == null) {
            return false;
        }
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        AudioDeviceInfo[] devices = ((AudioManager) systemService).getDevices(2);
        Intrinsics.checkNotNullExpressionValue(devices, "devices");
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            if (audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 7) {
                QLog.d("QQStrangerMatchVoiceManager", 1, "checkHasBluetoothDeviceConnected device: " + ((Object) audioDeviceInfo.getProductName()) + " type: " + audioDeviceInfo.getType());
                return true;
            }
        }
        return false;
    }
}
