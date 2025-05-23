package ph4;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.timi.game.databasecore.impl.livedata.LoadDataWrapper;
import com.tencent.timi.game.ui.widget.e;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import fm4.k;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.SafeOuterClass$SafeCheckResult;
import trpc.yes.common.YoloRoomOuterClass$DoYoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomCmdRsp;
import ug4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J,\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\u001c\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0006\u0010\u001d\u001a\u00020\bJ\u0006\u0010\u001e\u001a\u00020\bJ(\u0010\"\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\tR\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\tR\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\tR\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lph4/e;", "Lfm4/k;", "Ltrpc/yes/common/YoloRoomOuterClass$DoYoloRoomCmdRsp;", "doYoloRoomCmdRsp", "", "M", "", "roomId", "", "J", "Lcom/tencent/timi/game/ui/widget/e;", "dialog", UserInfo.SEX_FEMALE, "I", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, ExifInterface.LATITUDE_SOUTH, "Landroid/content/Context;", "context", "uid", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "listener", "E", "P", BdhLogUtil.LogTag.Tag_Req, "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "applyTime", "d", "H", "G", "inviterUid", "invitedUid", "expireTimeStamp", "t", "b", "mLastApplyTimeStamp", "c", "mApplyGap", "mMicApplyClearTimeStamp", "e", "Z", "mShowInviteSpeakingDialog", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class e extends k {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long mLastApplyTimeStamp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean mShowInviteSpeakingDialog;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f426246a = new e();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long mApplyGap = 60000;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long mMicApplyClearTimeStamp = rm4.a.d("key_mic_clear_time_stamp", 0);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"ph4/e$a", "Lfm4/a;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "cmdRsp", "Ltrpc/yes/common/YoloRoomOuterClass$DoYoloRoomCmdRsp;", "doYoloRoomCmdRsp", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements fm4.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> f426251a;

        a(IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> iResultListener) {
            this.f426251a = iResultListener;
        }

        @Override // fm4.a
        public void a(@Nullable YoloRoomOuterClass$YoloRoomCmdRsp cmdRsp, @Nullable YoloRoomOuterClass$DoYoloRoomCmdRsp doYoloRoomCmdRsp) {
            if (!e.f426246a.M(doYoloRoomCmdRsp)) {
                e.mLastApplyTimeStamp = NetConnInfoCenter.getServerTimeMillis();
                this.f426251a.onSuccess(cmdRsp);
            } else {
                this.f426251a.onError(-1, "need auth");
            }
        }

        @Override // fm4.a
        public void onError(int errorCode, @Nullable String errorMessage) {
            this.f426251a.onError(errorCode, errorMessage);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"ph4/e$b", "Lph4/h;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "result", "", "c", "", "errorCode", "", "errorMessage", "onError", "", "permissionEnable", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements h {
        b() {
        }

        @Override // nl4.a
        public void a(boolean permissionEnable) {
            l.b("MicApplyManager_", "onSuccess onChecked");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomCmdRsp result) {
            l.b("MicApplyManager_", "onSuccess onMic");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            l.b("MicApplyManager_", "onSuccess onError");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"ph4/e$c", "Lph4/h;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomCmdRsp;", "result", "", "c", "", "errorCode", "", "errorMessage", "onError", "", "permissionEnable", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements h {
        c() {
        }

        @Override // nl4.a
        public void a(boolean permissionEnable) {
            l.b("MicApplyManager_", "onSuccess onChecked\u9080\u8bf7\u4e0a\u9ea6");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable YoloRoomOuterClass$YoloRoomCmdRsp result) {
            l.b("MicApplyManager_", "onSuccess\u9080\u8bf7\u4e0a\u9ea6\u6210\u529f");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            l.b("MicApplyManager_", "onError\u9080\u8bf7\u4e0a\u9ea6\u5931\u8d25errorCode=" + errorCode + " errMsg = " + errorMessage);
        }
    }

    e() {
    }

    private final void F(com.tencent.timi.game.ui.widget.e dialog) {
        gh4.d mReporterHelper;
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 != null && (mReporterHelper = I0.getMReporterHelper()) != null) {
            ((ug4.b) mm4.b.b(ug4.b.class)).b(dialog.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), mReporterHelper.C(), mReporterHelper.D());
            mm4.a b16 = mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
            b.a.a((ug4.b) b16, dialog.getNegativeButton(), false, null, mReporterHelper.x(), mReporterHelper.E(), 6, null);
            mm4.a b17 = mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNullExpressionValue(b17, "getService(IReportService::class.java)");
            b.a.a((ug4.b) b17, dialog.getPositiveButton(), false, null, mReporterHelper.y(), mReporterHelper.E(), 6, null);
        }
    }

    private final void J(final long roomId) {
        QBaseActivity activity = vf4.a.b();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        e.a aVar = new e.a(activity);
        aVar.j("\u4e0a\u9ea6\u7533\u8bf7\u5df2\u901a\u8fc7\uff0c\u73b0\u5728\u4e0a\u9ea6\uff1f");
        aVar.k(17);
        aVar.n("\u53d6\u6d88");
        aVar.m(new DialogInterface.OnClickListener() { // from class: ph4.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                e.K(dialogInterface, i3);
            }
        });
        aVar.p("\u786e\u5b9a");
        aVar.o(new DialogInterface.OnClickListener() { // from class: ph4.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                e.L(roomId, dialogInterface, i3);
            }
        });
        com.tencent.timi.game.ui.widget.e c16 = aVar.c();
        c16.show();
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 == null) {
            return;
        }
        gh4.d mReporterHelper = I0.getMReporterHelper();
        HashMap<String, String> E = mReporterHelper.E();
        ((ug4.b) mm4.b.b(ug4.b.class)).b(c16.getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String(), mReporterHelper.C(), mReporterHelper.D());
        mm4.a b16 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
        b.a.a((ug4.b) b16, c16.getNegativeButton(), false, null, mReporterHelper.z(), E, 6, null);
        mm4.a b17 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b17, "getService(IReportService::class.java)");
        b.a.a((ug4.b) b17, c16.getPositiveButton(), false, null, mReporterHelper.A(), E, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(long j3, DialogInterface dialogInterface, int i3) {
        g.f426260a.b(0, j3, false, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean M(YoloRoomOuterClass$DoYoloRoomCmdRsp doYoloRoomCmdRsp) {
        SafeOuterClass$SafeCheckResult safeOuterClass$SafeCheckResult;
        PBStringField pBStringField;
        String str = null;
        if (doYoloRoomCmdRsp != null) {
            safeOuterClass$SafeCheckResult = doYoloRoomCmdRsp.safe_check_result;
        } else {
            safeOuterClass$SafeCheckResult = null;
        }
        if (safeOuterClass$SafeCheckResult != null && doYoloRoomCmdRsp.safe_check_result.has()) {
            SafeOuterClass$SafeCheckResult safeOuterClass$SafeCheckResult2 = doYoloRoomCmdRsp.safe_check_result;
            if (safeOuterClass$SafeCheckResult2 != null && (pBStringField = safeOuterClass$SafeCheckResult2.verify_url) != null) {
                str = pBStringField.get();
            }
            if (str != null && !TextUtils.isEmpty(str)) {
                com.tencent.timi.game.room.impl.util.b.f379321a.c(str);
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(DialogInterface dialogInterface, int i3) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(long j3, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        g.f426260a.b(0, j3, true, new c());
    }

    public final void E(long roomId, @NotNull Context context, long uid, @NotNull IResultListener<YoloRoomOuterClass$YoloRoomCmdRsp> listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (NetConnInfoCenter.getServerTimeMillis() - mLastApplyTimeStamp < mApplyGap) {
            QQToast.makeText(context, "\u4f60\u5df2\u7ecf\u7533\u8bf7\u8fc7\u4e86\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85", 0).show();
            return;
        }
        a aVar = new a(listener);
        gm4.b A = ((fm4.g) mm4.b.b(fm4.g.class)).A(roomId);
        P(roomId);
        A.u(aVar);
    }

    public final void G() {
        mShowInviteSpeakingDialog = false;
    }

    public final void H() {
        mShowInviteSpeakingDialog = true;
    }

    public final long I() {
        l.h("MicApplyManager_", 1, "getMicApplyClearTimeStamp " + mMicApplyClearTimeStamp);
        return mMicApplyClearTimeStamp;
    }

    public final void P(long roomId) {
        l.b("MicApplyManager_", ">>registerApplyResultListener");
        ((fm4.g) mm4.b.b(fm4.g.class)).k(roomId).y(this);
    }

    public final void Q(long timeStamp) {
        mMicApplyClearTimeStamp = timeStamp;
        rm4.a.j("key_mic_clear_time_stamp", timeStamp);
    }

    public final void R(long roomId) {
        l.b("MicApplyManager_", ">>unRegisterApplyResultListener");
        ((fm4.g) mm4.b.b(fm4.g.class)).k(roomId).Q(this);
    }

    public final void S(long roomId) {
        int i3 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(roomId).Y().yolo_room_community_conf.wuji_yolo_room_community_conf.apply_speaking_time_interval.get();
        if (i3 < 1) {
            i3 = 1;
        }
        mApplyGap = i3 * 1000;
        l.h("MicApplyManager_", 1, "updateApplySpeakingGap new gap:" + i3 + ReportConstant.COSTREPORT_PREFIX);
    }

    @Override // fm4.k, fm4.q
    public void d(long roomId, @NotNull CommonOuterClass$QQUserId uid, long applyTime) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        l.b("MicApplyManager_", "onAgreeSpeaking uid:" + MobileQQ.getShortUinStr(uid.toString()) + ", applyTime: " + applyTime);
        if (!ll4.b.a(((ll4.a) mm4.b.b(ll4.a.class)).E(), uid)) {
            l.m("MicApplyManager_", "onAgreeSpeaking not self!");
        } else {
            J(roomId);
        }
    }

    @Override // fm4.k, fm4.q
    public void t(@NotNull CommonOuterClass$QQUserId inviterUid, @NotNull CommonOuterClass$QQUserId invitedUid, long expireTimeStamp, final long roomId) {
        IUserInfo b16;
        Intrinsics.checkNotNullParameter(inviterUid, "inviterUid");
        Intrinsics.checkNotNullParameter(invitedUid, "invitedUid");
        l.b("MicApplyManager_", ">>\u6536\u5230\u4e0a\u9ea6\u9080\u8bf7\uff0cmShowInviteSpeakingDialog=" + mShowInviteSpeakingDialog);
        if (mShowInviteSpeakingDialog && invitedUid.uid.get() == ((ll4.a) mm4.b.b(ll4.a.class)).h()) {
            bo4.d dVar = (bo4.d) mm4.b.b(bo4.d.class);
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = inviterUid.get();
            Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "inviterUid.get()");
            LoadDataWrapper<? extends IUserInfo> value = dVar.D3(commonOuterClass$QQUserId).getValue();
            if (value != null && (b16 = value.b()) != null) {
                QBaseActivity b17 = vf4.a.b();
                Intrinsics.checkNotNullExpressionValue(b17, "getTopQActivity()");
                com.tencent.timi.game.ui.widget.e c16 = new e.a(b17).j("\u4e3b\u6301\u4eba" + b16.i(inviterUid) + "\u9080\u8bf7\u4f60\u4e0a\u9ea6\u804a\u5929\uff0c\u662f\u5426\u540c\u610f").n("\u59d4\u5a49\u62d2\u7edd").m(new DialogInterface.OnClickListener() { // from class: ph4.c
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        e.N(dialogInterface, i3);
                    }
                }).p("\u786e\u8ba4\u4e0a\u9ea6").o(new DialogInterface.OnClickListener() { // from class: ph4.d
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        e.O(roomId, dialogInterface, i3);
                    }
                }).c();
                f426246a.F(c16);
                c16.show();
            }
        }
    }
}
