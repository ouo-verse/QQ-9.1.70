package com.tencent.mobileqq.zplan.cc;

import android.graphics.Bitmap;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.IZplanAPI;
import com.tencent.qcircle.tavcut.util.BitmapUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.LightConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qshadow.AIFacePtaData$ZPlanV2Reply;
import qshadow.AIFacePtaData$ZPlanV2Result;
import qshadow.AIFacePtaData$ZplanFaceStyle;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007R\u001f\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\"\u0010\u001b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/c;", "Landroidx/lifecycle/ViewModel;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "L1", "", "byteArray", "", "gender", "", "P1", "Landroidx/lifecycle/MutableLiveData;", "Lqshadow/AIFacePtaData$ZPlanV2Reply;", "i", "Landroidx/lifecycle/MutableLiveData;", "N1", "()Landroidx/lifecycle/MutableLiveData;", "faceDataResponse", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "M1", "faceDataError", BdhLogUtil.LogTag.Tag_Conn, "I", "O1", "()I", "Q1", "(I)V", "seqId", "<init>", "()V", "D", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private int seqId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<AIFacePtaData$ZPlanV2Reply> faceDataResponse = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Unit> faceDataError = new MutableLiveData<>();

    public final Bitmap L1(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        boolean e16 = com.tencent.mobileqq.zplan.cc.util.q.e(BitmapUtil.scaleBitmap(bitmap, 512));
        com.tencent.mobileqq.zplan.cc.util.p c16 = com.tencent.mobileqq.zplan.cc.util.q.c();
        if (e16) {
            if ((c16 != null ? c16.f332570a : null) != null) {
                return c16.f332570a;
            }
        }
        return null;
    }

    public final MutableLiveData<Unit> M1() {
        return this.faceDataError;
    }

    public final MutableLiveData<AIFacePtaData$ZPlanV2Reply> N1() {
        return this.faceDataResponse;
    }

    /* renamed from: O1, reason: from getter */
    public final int getSeqId() {
        return this.seqId;
    }

    public final void P1(byte[] byteArray, int gender) {
        String str;
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(BaseApplication.getContext(), 1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
            this.faceDataError.setValue(Unit.INSTANCE);
            return;
        }
        if (gender == 1) {
            str = LightConstants.MALE;
        } else if (gender != 2) {
            str = "unset";
        } else {
            str = LightConstants.FEMALE;
        }
        ((IZplanAPI) QRoute.api(IZplanAPI.class)).requestAIFace(byteArray, str, this.seqId, new b());
    }

    public final void Q1(int i3) {
        this.seqId = i3;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/cc/c$b", "Li83/f;", "Lqshadow/AIFacePtaData$ZPlanV2Reply;", "data", "", "b", "", "errCode", "", "errMsg", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements i83.f<AIFacePtaData$ZPlanV2Reply> {
        b() {
        }

        @Override // i83.f
        public void a(long errCode, String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.i("_FilamentAIFace", 1, "requestFaces = onFailed\uff0c errCode = " + errCode + ", errMsg = " + errMsg);
            if (errCode == 2114) {
                QQToast.makeText(BaseApplication.getContext(), 1, "\u8bc6\u522b\u5931\u8d25", 0).show();
            } else {
                QQToast.makeText(BaseApplication.getContext(), 1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
            }
            c.this.M1().setValue(Unit.INSTANCE);
        }

        @Override // i83.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(AIFacePtaData$ZPlanV2Reply data) {
            AIFacePtaData$ZPlanV2Result aIFacePtaData$ZPlanV2Result;
            PBRepeatMessageField<AIFacePtaData$ZplanFaceStyle> pBRepeatMessageField;
            List<AIFacePtaData$ZplanFaceStyle> list;
            QLog.i("_FilamentAIFace", 1, "requestFaces = success, data = " + ((data == null || (aIFacePtaData$ZPlanV2Result = data.zplan) == null || (pBRepeatMessageField = aIFacePtaData$ZPlanV2Result.face_styles) == null || (list = pBRepeatMessageField.get()) == null) ? null : Integer.valueOf(list.size())));
            c cVar = c.this;
            cVar.Q1(cVar.getSeqId() + 1);
            c.this.N1().setValue(data);
        }
    }
}
