package com.tencent.mobileqq.zootopia.qav;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qav.controller.multi.MultiOperatorImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB#\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/qav/g;", "Lcom/tencent/qav/controller/multi/MultiOperatorImpl;", "", "callType", "", "isCalling", "", ReportConstant.COSTREPORT_PREFIX, "exitRoom", BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "roomId", "O", "route", V2TXLiveDefInner.TXLivePropertyKey.kV2SetAudioRoute, "Landroid/content/Context;", "context", "selfUin", "Lcom/tencent/qav/channel/d;", "videoChannel", "<init>", "(Landroid/content/Context;JLcom/tencent/qav/channel/d;)V", "p", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g extends MultiOperatorImpl {
    public g(Context context, long j3, com.tencent.qav.channel.d dVar) {
        super(context, j3, dVar);
    }

    public final void R() {
        QQGAudioCtrl qQGAudioCtrl;
        QLog.d("[RTAudio][ChatRoom][QQAudio]ZPlanMultiOperatorImpl", 2, "startAudioRecv mHasCallExitRoom\uff1a=" + this.f342376m);
        if (this.f342376m || (qQGAudioCtrl = this.f342381c) == null) {
            return;
        }
        qQGAudioCtrl.startAudioRecv();
    }

    public final void S() {
        QQGAudioCtrl qQGAudioCtrl;
        QLog.d("[RTAudio][ChatRoom][QQAudio]ZPlanMultiOperatorImpl", 2, "stopAudioRecv mHasCallExitRoom\uff1a=" + this.f342376m);
        if (this.f342376m || (qQGAudioCtrl = this.f342381c) == null) {
            return;
        }
        qQGAudioCtrl.stopAudioRecv();
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl, com.tencent.qav.controller.multi.a
    public void exitRoom() {
        super.exitRoom();
        this.f342376m = true;
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl
    protected void s(int callType, boolean isCalling) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("checkInterruptCurrentCall callType[%s], enterRoom[%s], isCalling[%s]", Arrays.copyOf(new Object[]{Integer.valueOf(callType), Boolean.valueOf(this.f342375l), Boolean.valueOf(isCalling)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.d("[RTAudio][ChatRoom][QQAudio]ZPlanMultiOperatorImpl", 2, format);
        if (callType == 1) {
            com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 17, Boolean.valueOf(isCalling));
        } else {
            if (callType != 2) {
                return;
            }
            com.tencent.qav.observer.b.f().d(com.tencent.qav.controller.multi.c.class, 16, Boolean.valueOf(isCalling));
        }
    }

    public final void O(long roomId) {
        QLog.d("[RTAudio][ChatRoom][QQAudio]ZPlanMultiOperatorImpl", 2, "getSign called");
        this.f342381c.getSign(this.f342380b, 11, roomId, 14, 6);
    }

    public final void P() {
        QLog.i("[RTAudio][ChatRoom][QQAudio]ZPlanMultiOperatorImpl", 2, "setGameModeAudioScene called");
        this.f342381c.setAudioScene(5);
    }

    public final void Q() {
        QLog.i("[RTAudio][ChatRoom][QQAudio]ZPlanMultiOperatorImpl", 2, "setGameModeOnlyPlayScene called");
        this.f342381c.setAudioScene(6);
    }

    @Override // com.tencent.qav.controller.multi.MultiOperatorImpl, com.tencent.qav.controller.multi.a
    public void setAudioRoute(int route) {
        try {
            if (route == 0) {
                this.f342369f.stopBluetoothSco();
                this.f342369f.setBluetoothScoOn(false);
                this.f342369f.setSpeakerphoneOn(false);
                this.f342369f.setMode(0);
                this.f342372i = route;
            } else if (route == 1) {
                this.f342369f.stopBluetoothSco();
                this.f342369f.setBluetoothScoOn(false);
                this.f342369f.setSpeakerphoneOn(true);
                this.f342369f.setMode(0);
                this.f342372i = route;
            } else {
                if (route != 2) {
                    return;
                }
                this.f342369f.startBluetoothSco();
                this.f342369f.setBluetoothScoOn(true);
                this.f342369f.setSpeakerphoneOn(false);
                this.f342369f.setMode(0);
                this.f342372i = route;
            }
        } catch (Exception e16) {
            QLog.e("[RTAudio][ChatRoom][QQAudio]ZPlanMultiOperatorImpl", 1, "setAudioRoute fail.", e16);
        }
    }
}
