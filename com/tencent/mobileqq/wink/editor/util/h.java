package com.tencent.mobileqq.wink.editor.util;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.xweb.FileReaderHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0014\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ,\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0007J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0018\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0010R\u0011\u0010\u001a\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u001c\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0010\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/h;", "", "", "abTestName", "expTagName", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "reportExport", "j", HippyControllerProps.STRING, "a", "", "b", "Ljava/util/Map;", "experimentExportResult", "g", "()Z", "enableQZoneMagicStudioShare", "f", "enableQZoneImageAITemplate", "e", "enableQZoneAlbumRecommendNew", "c", "enableMagicStudioNewResultPage", "enableBeautyImprovement", "d", "enableOpeningEnding", tl.h.F, "enableRemoveTabs", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f322638a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Boolean> experimentExportResult = new LinkedHashMap();

    h() {
    }

    public static /* synthetic */ boolean k(h hVar, String str, String str2, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        if ((i3 & 8) != 0) {
            z17 = true;
        }
        return hVar.j(str, str2, z16, z17);
    }

    @NotNull
    public final String a(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return string + "_B";
    }

    public final boolean b() {
        return k(this, "exp_qqshortvideo_camera_beautyeffect_improvement_v9035", a("exp_qqshortvideo_camera_beautyeffect_improvement_v9035"), false, false, 12, null);
    }

    public final boolean c() {
        return k(this, "exp_qzone_publisher_magicstudio_resultpage_1", a("exp_qzone_publisher_magicstudio_resultpage_1"), true, false, 8, null);
    }

    public final boolean d() {
        return k(this, "exp_piantou_zhengshi", a("exp_piantou_zhengshi"), false, false, 12, null);
    }

    public final boolean e() {
        return k(this, "exp_qzone_album_recommend_new_1", a("exp_qzone_album_recommend_new_1"), true, false, 8, null);
    }

    public final boolean f() {
        return k(this, "exp_qzone_publisher_magicstudio_editor_1", a("exp_qzone_publisher_magicstudio_editor_1"), true, false, 8, null);
    }

    public final boolean g() {
        return k(this, "exp_qzone_publisher_inspiration_magicstudio_directsharing", a("exp_qzone_publisher_inspiration_magicstudio_directsharing"), true, false, 8, null);
    }

    public final boolean h() {
        return k(this, "exp_AIOremove_tab", a("exp_AIOremove_tab"), true, false, 8, null);
    }

    @JvmOverloads
    public final boolean i(@NotNull String abTestName, @NotNull String expTagName, boolean z16) {
        Intrinsics.checkNotNullParameter(abTestName, "abTestName");
        Intrinsics.checkNotNullParameter(expTagName, "expTagName");
        return k(this, abTestName, expTagName, z16, false, 8, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean j(@NotNull String abTestName, @NotNull String expTagName, boolean force, boolean reportExport) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(abTestName, "abTestName");
        Intrinsics.checkNotNullParameter(expTagName, "expTagName");
        w53.b.a("WinkEditorFeatureConfig", "queryAB begin ==>> " + abTestName + MsgSummary.STR_COLON + expTagName);
        if (!force && !g.f322634a.g()) {
            w53.b.a("WinkEditorFeatureConfig", "queryAB not in xsj, return false");
            return false;
        }
        String c16 = q53.a.d().c(abTestName);
        if (TextUtils.isEmpty(c16)) {
            ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(abTestName);
            Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance()\n          \u2026.getExpEntity(abTestName)");
            String assignment = expEntity.getAssignment();
            if (assignment != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(assignment);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        w53.b.c("WinkEditorFeatureConfig", "queryAB error bucket is null");
                        return false;
                    }
                    q53.a.d().f(abTestName, assignment);
                    q53.a.d().g(abTestName, expEntity);
                    if (reportExport) {
                        Map<String, Boolean> map = experimentExportResult;
                        if (!Intrinsics.areEqual(map.get(abTestName), Boolean.TRUE)) {
                            w53.b.a("WinkEditorFeatureConfig", "queryAB reportExperimentExport ==>> " + abTestName + MsgSummary.STR_COLON + assignment);
                            map.put(abTestName, Boolean.valueOf(yt.b.g(abTestName)));
                        }
                    }
                    c16 = assignment;
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        w53.b.a("WinkEditorFeatureConfig", "queryAB result ==>> " + abTestName + MsgSummary.STR_COLON + c16);
        return Intrinsics.areEqual(expTagName, c16);
    }
}
