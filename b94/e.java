package b94;

import android.view.View;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.nativeui.data.AvatarNativeViewInitData;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.nativeui.data.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import m94.h;
import uv4.al;
import uv4.w;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\u000bH&J0\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011H&J0\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011H&J0\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011H&J0\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011H&J\b\u0010\u0017\u001a\u00020\rH&J\b\u0010\u0018\u001a\u00020\rH&J\u001a\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H&J\u0012\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\rH&J\b\u0010\u001d\u001a\u00020\u0019H&J$\u0010 \u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011H&J.\u0010&\u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\r2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0016J\u0012\u0010)\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020'H&J\b\u0010*\u001a\u00020\u0006H&J\b\u0010+\u001a\u00020\u0006H&J$\u0010/\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000fH&J\u0010\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u000200H&J$\u00106\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u00020\r2\b\b\u0002\u00105\u001a\u00020\rH&J\u0010\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u000207H&J\u0010\u0010<\u001a\u00020\u00062\u0006\u0010;\u001a\u00020:H&J\u0010\u0010=\u001a\u00020\u00062\u0006\u0010;\u001a\u00020:H&J\u0018\u0010@\u001a\u00020\u00062\u0006\u0010?\u001a\u00020>2\u0006\u00101\u001a\u000200H&J\b\u0010B\u001a\u00020AH&J\u0010\u0010D\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u000fH&J\"\u0010F\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000f2\b\b\u0002\u00104\u001a\u00020\rH&J\u001c\u0010I\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020G2\b\b\u0002\u0010H\u001a\u00020\rH&J\b\u0010K\u001a\u00020JH&J\u0010\u0010M\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u0019H\u0016\u00a8\u0006N"}, d2 = {"Lb94/e;", "Lcom/tencent/sqshow/zootopia/avatar/c;", "Lcom/tencent/sqshow/zootopia/nativeui/data/d;", "Lcom/tencent/sqshow/zootopia/scene/component/c;", "Lcom/tencent/sqshow/zootopia/nativeui/data/i;", "data", "", "Cf", "Landroid/view/View;", "getView", "destroy", "Lcom/tencent/sqshow/zootopia/nativeui/data/m;", "getCameraId", "", "withAnim", "", "source", "Lkotlin/Function0;", "callback", "eg", "A3", "h3", "X4", "j6", "B2", "", "style", "he", ICustomDataEditor.NUMBER_PARAM_1, "v", "enableFinishActivity", "exitPanelCallback", "l7", "refreshCurrentDress", "clearDressHistory", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/w;", "cb", "c4", "", "delayMillis", "P1", "S2", NowProxyConstants.AccountInfoKey.A2, "groupId", "categoryId", "typeId", "r9", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "gender", "hh", "from", "withoutBlend", "withDelay", "Ya", "Lcom/tencent/sqshow/zootopia/scene/component/d;", "observer", "q0", "Lcom/tencent/sqshow/zootopia/nativeui/data/o;", "l", "qg", ICustomDataEditor.STRING_PARAM_2, "Luv4/al;", "savedAvatarInfo", "O7", "Lb94/d;", ICustomDataEditor.STRING_ARRAY_PARAM_7, "path", "setBackgroundPath", "cameraId", "setCameraId", "Lm94/h;", "waitingUeCallback", "r1", "Lc84/a;", "wc", "orientation", "onOrientationChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public interface e extends com.tencent.sqshow.zootopia.avatar.c, com.tencent.sqshow.zootopia.nativeui.data.d, com.tencent.sqshow.zootopia.scene.component.c {
    void A2();

    void A3(boolean withAnim, String source, Function0<Unit> callback);

    boolean B2();

    void Cf(AvatarNativeViewInitData data);

    void O7(al savedAvatarInfo, UEAvatarGender gender);

    void P1(long delayMillis);

    void S2();

    void X4(boolean withAnim, String source, Function0<Unit> callback);

    void Ya(String from, boolean withoutBlend, boolean withDelay);

    d a7();

    void c4(boolean refreshCurrentDress, boolean clearDressHistory, com.tencent.mobileqq.zootopia.api.e<w> cb5);

    void destroy();

    void eg(boolean withAnim, String source, Function0<Unit> callback);

    CameraKey getCameraId();

    View getView();

    void h3(boolean withAnim, String source, Function0<Unit> callback);

    void he(boolean withAnim, int style);

    void hh(UEAvatarGender gender);

    boolean j6();

    boolean l7(boolean enableFinishActivity, Function0<Unit> exitPanelCallback);

    void n1(boolean withAnim);

    void onOrientationChanged(int orientation);

    void q0(com.tencent.sqshow.zootopia.scene.component.d observer);

    void qg(o l3);

    void r1(h cb5, boolean waitingUeCallback);

    void r9(String groupId, String categoryId, String typeId);

    void s2(o l3);

    void setBackgroundPath(String path);

    void setCameraId(CameraKey cameraId, String from, boolean withoutBlend);

    int v();

    c84.a wc();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class a {
        public static /* synthetic */ void e(e eVar, String str, String str2, String str3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str2 = "";
                }
                if ((i3 & 4) != 0) {
                    str3 = "";
                }
                eVar.r9(str, str2, str3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: jumpToTargetPage");
        }

        public static /* synthetic */ void h(e eVar, long j3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    j3 = 0;
                }
                eVar.P1(j3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showGlobalLoading");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean c(e eVar, boolean z16, Function0 function0, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = true;
                }
                if ((i3 & 2) != 0) {
                    function0 = null;
                }
                return eVar.l7(z16, function0);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleBackEvent");
        }

        public static /* synthetic */ void f(e eVar, String str, boolean z16, boolean z17, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                if ((i3 & 4) != 0) {
                    z17 = false;
                }
                eVar.Ya(str, z16, z17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshCurrentCameraId");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void g(e eVar, boolean z16, boolean z17, com.tencent.mobileqq.zootopia.api.e eVar2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = true;
                }
                if ((i3 & 2) != 0) {
                    z17 = false;
                }
                if ((i3 & 4) != 0) {
                    eVar2 = null;
                }
                eVar.c4(z16, z17, eVar2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshPanelV1");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(e eVar, boolean z16, String str, Function0 function0, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                if ((i3 & 2) != 0) {
                    str = null;
                }
                if ((i3 & 4) != 0) {
                    function0 = null;
                }
                eVar.h3(z16, str, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterPanel");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(e eVar, boolean z16, String str, Function0 function0, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                if ((i3 & 2) != 0) {
                    str = null;
                }
                if ((i3 & 4) != 0) {
                    function0 = null;
                }
                eVar.X4(z16, str, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exitPanel");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void d(e eVar, boolean z16, String str, Function0 function0, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                if ((i3 & 2) != 0) {
                    str = null;
                }
                if ((i3 & 4) != 0) {
                    function0 = null;
                }
                eVar.A3(z16, str, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hidePanel");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void i(e eVar, boolean z16, String str, Function0 function0, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                if ((i3 & 2) != 0) {
                    str = null;
                }
                if ((i3 & 4) != 0) {
                    function0 = null;
                }
                eVar.eg(z16, str, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPanel");
        }
    }
}
