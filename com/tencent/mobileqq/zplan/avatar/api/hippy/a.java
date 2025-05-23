package com.tencent.mobileqq.zplan.avatar.api.hippy;

import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.NormalDressStrategy;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.List;
import kotlin.Metadata;
import m94.h;
import uv4.az;
import uv4.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH&J2\u0010\u0015\u001a\u00020\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\u001a\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018H&J*\u0010\u001e\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u001cH&J\b\u0010\u001f\u001a\u00020\u0018H&J\b\u0010 \u001a\u00020\tH&J\b\u0010!\u001a\u00020\u0018H&\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/api/hippy/a;", "", "", "Luv4/az;", VideoTemplateParser.ITEM_LIST, "Lqu4/a;", ac.f283467k0, "Lm94/h;", "cb", "", "g", "", "bgPicPath", "f", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "targetGender", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/u;", "requestCb", "Ljava/lang/Runnable;", "taskAfterRequest", "s0", "Lcom/tencent/sqshow/zootopia/nativeui/data/m;", "cameraId", "", "withoutBlend", "a", "storeItemList", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/NormalDressStrategy;", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "b", "d", "e", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface a {
    void a(CameraKey cameraId, boolean withoutBlend);

    void b(List<az> storeItemList, h cb5, NormalDressStrategy strategy);

    boolean c();

    boolean d();

    void e();

    void f(String bgPicPath);

    void g(List<az> itemList, qu4.a ac5, h cb5);

    void s0(UEAvatarGender targetGender, e<u> requestCb, Runnable taskAfterRequest);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.zplan.avatar.api.hippy.a$a, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C9151a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(a aVar, UEAvatarGender uEAvatarGender, e eVar, Runnable runnable, int i3, Object obj) {
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
                aVar.s0(uEAvatarGender, eVar, runnable);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeGender");
        }
    }
}
