package com.tencent.filament.zplan;

import com.tencent.filament.zplan.data.AvatarAIInfo;
import com.tencent.filament.zplan.data.ZPlanPinchFaceModel;
import com.tencent.filament.zplan.view.AVFilamentTextureView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J4\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\rH&J,\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\fH&J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&JC\u0010 \u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001b2\u0006\u0010\u001f\u001a\u00020\u0006H&\u00a2\u0006\u0004\b \u0010!J*\u0010%\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\fH&J8\u0010(\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H&J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\fH&J\u0012\u0010&\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010+H&J(\u0010.\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0006H&J\u0010\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0006H&J\u0010\u00101\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J(\u00106\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u0013H&J\u0018\u00109\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00108\u001a\u000207H&J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020:H&J \u0010>\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020\fH&J\u0010\u0010@\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\fH&J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\fH&\u00a8\u0006B"}, d2 = {"Lcom/tencent/filament/zplan/f;", "Lwk0/b;", "Lcom/tencent/filament/zplan/view/AVFilamentTextureView;", "filamentTextureView", "", "D", "", "isLocal", h.F, DomainData.DOMAIN_NAME, "p", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "resourcePathMap", "j", "isMale", "Lcom/tencent/filament/zplan/a;", "listener", "", "delayFrame", "b", "g", "iblPath", "d", "v", "pinchFaceConfigPath", "", "Lcom/tencent/filament/zplan/data/ZPlanPinchFaceModel;", "pinchFaceModels", "itemIdArray", "isFemale", HippyTKDListViewAdapter.X, "(ZLjava/lang/String;[Lcom/tencent/filament/zplan/data/ZPlanPinchFaceModel;[Ljava/lang/String;Z)V", "slotName", "textureAbsPath", "jsonAbsPath", "e", "r", "a", "f", "lutPath", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/filament/zplan/b;", "animationGltfPath", "animationID", "w", "isDoubleHorizontal", "i", "l", "width", "height", "left", "bottom", "B", "Lcom/tencent/filament/zplan/data/AvatarAIInfo;", "avatarAIInfo", "E", "Luk0/b;", "o", "gltfPath", "imageName", "u", "path", BdhLogUtil.LogTag.Tag_Conn, ReportConstant.COSTREPORT_PREFIX, "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface f extends wk0.b {
    void B(int width, int height, int left, int bottom);

    void C(@NotNull String path);

    void D(@NotNull AVFilamentTextureView filamentTextureView);

    void E(boolean isLocal, @NotNull AvatarAIInfo avatarAIInfo);

    void b(boolean isLocal, boolean isMale, @Nullable a listener, int delayFrame);

    void d(@NotNull String iblPath);

    void e(boolean isLocal, @NotNull String slotName, @NotNull String textureAbsPath, @Nullable String jsonAbsPath);

    void f(boolean isLocal, @NotNull String slotName, int r16, int g16, int b16, int a16);

    void g(boolean isLocal);

    boolean h(boolean isLocal);

    void i(boolean isDoubleHorizontal);

    void j(boolean isLocal, @NotNull HashMap<String, String> resourcePathMap);

    void l(boolean isLocal);

    void m(boolean isLocal, @NotNull String lutPath);

    void n(boolean isLocal);

    void o(@NotNull uk0.b listener);

    boolean p(boolean isLocal);

    void r(@Nullable b listener);

    void s(@NotNull String path);

    void u(boolean isLocal, @NotNull String gltfPath, @NotNull String imageName);

    void v(boolean isLocal);

    void w(boolean isLocal, @NotNull String animationGltfPath, int animationID, boolean isFemale);

    void x(boolean isLocal, @NotNull String pinchFaceConfigPath, @NotNull ZPlanPinchFaceModel[] pinchFaceModels, @NotNull String[] itemIdArray, boolean isFemale);
}
