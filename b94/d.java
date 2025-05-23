package b94;

import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zplan.api.IZplanHandleApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.NormalDressStrategy;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.List;
import kotlin.Metadata;
import m94.DressControllerInitData;
import m94.h;
import m94.k;
import qu4.j;
import uv4.ak;
import uv4.al;
import uv4.az;
import uv4.u;
import uv4.w;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&J,\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\tH'J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0012\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0011H&J$\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u0016H'J4\u0010\u001d\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u00192\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001bH'J\u0012\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0011H'J\u0012\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0011H'J$\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H'J$\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010\"\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H'J\b\u0010'\u001a\u00020$H&J\u0012\u0010(\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0011H'J\u0012\u0010)\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0011H'J\u0012\u0010*\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0011H'J\u0012\u0010+\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0011H'J\u0012\u0010,\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0011H'J\u001a\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H'J\u001a\u00100\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H'J\u001c\u00102\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u00101\u001a\u00020\tH'J&\u00103\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u00101\u001a\u00020\t2\b\b\u0002\u0010\"\u001a\u00020\tH'J0\u00109\u001a\u00020\u00042\u0006\u00105\u001a\u0002042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00140\u00192\u0006\u00108\u001a\u0002072\b\b\u0002\u0010\u0012\u001a\u00020\u0011H'J2\u0010@\u001a\u00020\u00042\n\b\u0002\u0010:\u001a\u0004\u0018\u0001042\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>H\u0017J2\u0010B\u001a\u00020\u00042\n\b\u0002\u0010:\u001a\u0004\u0018\u0001042\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010;2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>H\u0017J\u001e\u0010F\u001a\u0002072\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010E\u001a\u00020DH&J\u0018\u0010I\u001a\u00020\u00042\u0006\u0010H\u001a\u00020G2\u0006\u00105\u001a\u000204H&J\u0010\u0010J\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H&J\b\u0010K\u001a\u00020\u0004H&J\u0010\u0010M\u001a\u00020\u00042\u0006\u0010L\u001a\u00020-H'J\u0018\u0010N\u001a\u00020\u00042\u0006\u0010E\u001a\u00020D2\u0006\u0010\"\u001a\u00020\tH'J\b\u0010O\u001a\u00020\u0004H&\u00a8\u0006P"}, d2 = {"Lb94/d;", "Lcom/tencent/sqshow/zootopia/avatar/c;", "Lm94/d;", "initData", "", "c8", "getInitData", "Luv4/ak;", "avatarData", "", "clearDressHistory", "skipUpdateDataCenter", "refreshCurrentDress", UinConfigManager.KEY_HB, "Lm94/k;", "l", "v9", "Lm94/h;", "cb", "ce", "Luv4/az;", "storeItem", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/NormalDressStrategy;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "Lf", "", "storeItemList", "", "extInfo", "J9", "Y6", "E9", "Lqu4/j;", "faceInfo", "addToHistory", "F6", "Lqu4/c;", "colorInfo", "Q8", "pb", "J8", "B8", "ve", "v8", "Ob", "", "targetSlot", "q9", "ke", "waitingUeCallback", "O6", "Gg", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "gender", VideoTemplateParser.ITEM_LIST, "Lqu4/a;", ac.f283467k0, "Bg", "targetGender", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/u;", "requestCb", "Ljava/lang/Runnable;", "taskAfterRequest", "s0", "Luv4/w;", "L4", "itemUniqueIds", "Lm94/a;", IZplanHandleApi.BUSINESS_DRESS_INFO, "E4", "Luv4/al;", "avatarInfo", "Mc", "Kf", "j1", "targetHistoryIndex", ICustomDataEditor.NUMBER_PARAM_5, "Nc", "destroy", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public interface d extends com.tencent.sqshow.zootopia.avatar.c {
    void B8(h cb5);

    void Bg(UEAvatarGender gender, List<az> itemList, qu4.a ac5, h cb5);

    qu4.a E4(List<String> itemUniqueIds, m94.a dressInfo);

    void E9(h cb5);

    void F6(j faceInfo, boolean addToHistory, h cb5);

    void Gg(h cb5, boolean waitingUeCallback, boolean addToHistory);

    void J8(h cb5);

    void J9(List<az> storeItemList, h cb5, NormalDressStrategy strategy, String extInfo);

    boolean Kf(az storeItem);

    void L4(UEAvatarGender targetGender, com.tencent.mobileqq.zootopia.api.e<w> requestCb, Runnable taskAfterRequest);

    void Lf(az storeItem, h cb5, NormalDressStrategy strategy);

    void Mc(al avatarInfo, UEAvatarGender gender);

    void Nc(m94.a dressInfo, boolean addToHistory);

    void O6(h cb5, boolean waitingUeCallback);

    void Ob(h cb5);

    void Q8(qu4.c colorInfo, boolean addToHistory, h cb5);

    void Y6(h cb5);

    void c8(DressControllerInitData initData);

    void ce(h cb5);

    void destroy();

    DressControllerInitData getInitData();

    void hb(ak avatarData, boolean clearDressHistory, boolean skipUpdateDataCenter, boolean refreshCurrentDress);

    void j1();

    void ke(int targetSlot, h cb5);

    void n5(int targetHistoryIndex);

    qu4.c pb();

    void q9(int targetSlot, h cb5);

    void s0(UEAvatarGender targetGender, com.tencent.mobileqq.zootopia.api.e<u> requestCb, Runnable taskAfterRequest);

    void v8(h cb5);

    void v9(k l3);

    void ve(h cb5);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class a {
        public static /* synthetic */ void d(d dVar, List list, h hVar, NormalDressStrategy normalDressStrategy, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    hVar = m94.b.f416465a;
                }
                if ((i3 & 4) != 0) {
                    normalDressStrategy = NormalDressStrategy.ONLY_ON;
                }
                if ((i3 & 8) != 0) {
                    str = "";
                }
                dVar.J9(list, hVar, normalDressStrategy, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dressOnOrOffClothes");
        }

        public static /* synthetic */ void e(d dVar, az azVar, h hVar, NormalDressStrategy normalDressStrategy, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    hVar = m94.b.f416465a;
                }
                if ((i3 & 4) != 0) {
                    normalDressStrategy = NormalDressStrategy.ONLY_ON;
                }
                dVar.Lf(azVar, hVar, normalDressStrategy);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dressOnOrOffClothes");
        }

        public static /* synthetic */ void h(d dVar, h hVar, boolean z16, boolean z17, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    hVar = m94.b.f416465a;
                }
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                if ((i3 & 4) != 0) {
                    z17 = false;
                }
                dVar.Gg(hVar, z16, z17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshCurrentDress");
        }

        public static /* synthetic */ void i(d dVar, h hVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    hVar = m94.b.f416465a;
                }
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                dVar.O6(hVar, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetAvatarToSaved");
        }

        public static /* synthetic */ void f(d dVar, qu4.c cVar, boolean z16, h hVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                if ((i3 & 4) != 0) {
                    hVar = m94.b.f416465a;
                }
                dVar.Q8(cVar, z16, hVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modifyColorInfo");
        }

        public static /* synthetic */ void g(d dVar, j jVar, boolean z16, h hVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                if ((i3 & 4) != 0) {
                    hVar = m94.b.f416465a;
                }
                dVar.F6(jVar, z16, hVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modifyFaceInfo");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(d dVar, UEAvatarGender uEAvatarGender, com.tencent.mobileqq.zootopia.api.e eVar, Runnable runnable, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    uEAvatarGender = null;
                }
                if ((i3 & 2) != 0) {
                    eVar = null;
                }
                if ((i3 & 4) != 0) {
                    runnable = null;
                }
                dVar.s0(uEAvatarGender, eVar, runnable);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeGender");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void c(d dVar, UEAvatarGender uEAvatarGender, com.tencent.mobileqq.zootopia.api.e eVar, Runnable runnable, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    uEAvatarGender = null;
                }
                if ((i3 & 2) != 0) {
                    eVar = null;
                }
                if ((i3 & 4) != 0) {
                    runnable = null;
                }
                dVar.L4(uEAvatarGender, eVar, runnable);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeGenderV1");
        }

        public static void a(d dVar, UEAvatarGender uEAvatarGender, com.tencent.mobileqq.zootopia.api.e<u> eVar, Runnable runnable) {
        }
    }
}
