package com.tencent.aelight.camera.ae.flashshow;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 J2\u00020\u0001:\u0004KLMNB\u0007\u00a2\u0006\u0004\bH\u0010IJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\fR%\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u00160\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR%\u0010 \u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u001d0\u001d0\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR%\u0010$\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010!0!0\u00158\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001bR%\u0010(\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010%0%0\u00158\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010\u001bR=\u0010-\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0)j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f`*0\u00158\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u0019\u001a\u0004\b,\u0010\u001bR\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158\u0006\u00a2\u0006\f\n\u0004\b.\u0010\u0019\u001a\u0004\b/\u0010\u001bR\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158\u0006\u00a2\u0006\f\n\u0004\b1\u0010\u0019\u001a\u0004\b2\u0010\u001bR\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158\u0006\u00a2\u0006\f\n\u0004\b4\u0010\u0019\u001a\u0004\b5\u0010\u001bRA\u00109\u001a,\u0012(\u0012&\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010)j\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`*0\u00158\u0006\u00a2\u0006\f\n\u0004\b7\u0010\u0019\u001a\u0004\b8\u0010\u001bR\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158\u0006\u00a2\u0006\f\n\u0004\b:\u0010\u0019\u001a\u0004\b;\u0010\u001bR-\u0010@\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\f0=0\u00158\u0006\u00a2\u0006\f\n\u0004\b>\u0010\u0019\u001a\u0004\b?\u0010\u001bR\"\u0010G\u001a\u00020A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u00107\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F\u00a8\u0006O"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ax;", "Landroidx/lifecycle/ViewModel;", "", "c2", "f2", "", "autoEvent", "Lcom/tencent/aelight/camera/ae/view/AECompoundButton;", "button", SemanticAttributes.DbSystemValues.H2, "M1", "N1", "", "tag", "path", "d2", "value", "g2", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "materialLocalPath", "L1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/aelight/camera/ae/camera/ui/topbar/AEVideoStoryTopBarViewModel$Ratio;", "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", "O1", "()Landroidx/lifecycle/MutableLiveData;", "cameraRatioLiveData", "Lcom/tencent/aelight/camera/ae/flashshow/ax$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "P1", "cameraStatusData", "Lcom/tencent/aelight/camera/ae/flashshow/ax$c;", BdhLogUtil.LogTag.Tag_Conn, "Z1", "materialStatusData", "Lcom/tencent/aelight/camera/ae/flashshow/ax$d;", "D", ICustomDataEditor.STRING_ARRAY_PARAM_2, "retryDeviceSupportCheckData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "E", "T1", "mCapturedFilePath", UserInfo.SEX_FEMALE, "X1", "mSwitchCameraLiveData", "G", "S1", "mCaptureLiveData", "H", "Q1", "closeLiveData", "I", "U1", "mNextBtnClickLiveData", "J", "W1", "mSwitchBeautyLiveData", "Lkotlin/Pair;", "K", "R1", "mApplyMaterialLiveData", "", "L", "b2", "()I", "e2", "(I)V", "selectedCamera", "<init>", "()V", "M", "a", "b", "c", "d", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ax extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<AEVideoStoryTopBarViewModel.Ratio> cameraRatioLiveData = new MutableLiveData<>(AEVideoStoryTopBarViewModel.Ratio.R_4_3);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<a> cameraStatusData = new MutableLiveData<>(new a(1, null, -1));

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<c> materialStatusData = new MutableLiveData<>(new c(1));

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<d> retryDeviceSupportCheckData = new MutableLiveData<>(new d(1));

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<HashMap<String, String>> mCapturedFilePath = new MutableLiveData<>();

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> mSwitchCameraLiveData = new MutableLiveData<>();

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> mCaptureLiveData = new MutableLiveData<>();

    /* renamed from: H, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> closeLiveData = new MutableLiveData<>();

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableLiveData<HashMap<String, String>> mNextBtnClickLiveData = new MutableLiveData<>();

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> mSwitchBeautyLiveData = new MutableLiveData<>();

    /* renamed from: K, reason: from kotlin metadata */
    private final MutableLiveData<Pair<String, String>> mApplyMaterialLiveData = new MutableLiveData<>();

    /* renamed from: L, reason: from kotlin metadata */
    private int selectedCamera = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012*\u0010\u000e\u001a&\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bj\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R;\u0010\u000e\u001a&\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bj\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\rR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ax$a;", "", "", "a", "I", "c", "()I", "status", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "result", IPrefRecorder.MILESTONE_ON_SLEECT_CAMERA_IN_FS, "<init>", "(ILjava/util/HashMap;I)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int status;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final HashMap<String, String> result;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int selectCamera;

        public a(int i3, HashMap<String, String> hashMap, int i16) {
            this.status = i3;
            this.result = hashMap;
            this.selectCamera = i16;
        }

        public final HashMap<String, String> a() {
            return this.result;
        }

        /* renamed from: b, reason: from getter */
        public final int getSelectCamera() {
            return this.selectCamera;
        }

        /* renamed from: c, reason: from getter */
        public final int getStatus() {
            return this.status;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ax$c;", "", "", "a", "I", "()I", "status", "<init>", "(I)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int status;

        public c(int i3) {
            this.status = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getStatus() {
            return this.status;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ax$d;", "", "", "a", "I", "()I", "status", "<init>", "(I)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int status;

        public d(int i3) {
            this.status = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getStatus() {
            return this.status;
        }
    }

    public final void L1(String materialId, String materialLocalPath) {
        this.mApplyMaterialLiveData.postValue(new Pair<>(materialId, materialLocalPath));
    }

    public final void M1() {
        this.mCapturedFilePath.postValue(new HashMap<>());
    }

    public final void N1() {
        this.closeLiveData.postValue(Boolean.FALSE);
    }

    public final MutableLiveData<AEVideoStoryTopBarViewModel.Ratio> O1() {
        return this.cameraRatioLiveData;
    }

    public final MutableLiveData<a> P1() {
        return this.cameraStatusData;
    }

    public final MutableLiveData<Boolean> Q1() {
        return this.closeLiveData;
    }

    public final MutableLiveData<Pair<String, String>> R1() {
        return this.mApplyMaterialLiveData;
    }

    public final MutableLiveData<Boolean> S1() {
        return this.mCaptureLiveData;
    }

    public final MutableLiveData<HashMap<String, String>> T1() {
        return this.mCapturedFilePath;
    }

    public final MutableLiveData<HashMap<String, String>> U1() {
        return this.mNextBtnClickLiveData;
    }

    public final MutableLiveData<Boolean> W1() {
        return this.mSwitchBeautyLiveData;
    }

    public final MutableLiveData<Boolean> X1() {
        return this.mSwitchCameraLiveData;
    }

    public final MutableLiveData<c> Z1() {
        return this.materialStatusData;
    }

    public final MutableLiveData<d> a2() {
        return this.retryDeviceSupportCheckData;
    }

    /* renamed from: b2, reason: from getter */
    public final int getSelectedCamera() {
        return this.selectedCamera;
    }

    public final void c2() {
        this.mNextBtnClickLiveData.postValue(this.mCapturedFilePath.getValue());
    }

    public final void d2(String tag, String path) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        HashMap<String, String> value = this.mCapturedFilePath.getValue();
        if (value == null) {
            value = new HashMap<>();
        }
        value.put(tag, path);
        this.mCapturedFilePath.postValue(value);
    }

    public final void e2(int i3) {
        this.selectedCamera = i3;
    }

    public final void f2() {
        this.mCaptureLiveData.postValue(Boolean.TRUE);
    }

    public final void g2(boolean value) {
        this.mSwitchBeautyLiveData.postValue(Boolean.valueOf(value));
    }

    public final void h2(boolean autoEvent, AECompoundButton button) {
        if (!autoEvent) {
            int i3 = this.selectedCamera == 1 ? 2 : 1;
            this.selectedCamera = i3;
            if (button != null) {
                if (i3 != 1) {
                    AccessibilityUtil.p(button, HardCodeUtil.qqStr(R.string.f169905y83));
                } else {
                    AccessibilityUtil.p(button, HardCodeUtil.qqStr(R.string.f169906y84));
                }
            }
        }
        this.mSwitchCameraLiveData.postValue(Boolean.valueOf(autoEvent));
    }

    public static /* synthetic */ void i2(ax axVar, boolean z16, AECompoundButton aECompoundButton, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            aECompoundButton = null;
        }
        axVar.h2(z16, aECompoundButton);
    }
}
