package com.tencent.mobileqq.zplan.emoticon.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bg\u0018\u0000 \u00152\u00020\u0001:\u0002\u0016\u0017J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/api/IZPlanEmoticonApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "checkCreateRole", "Lcom/tencent/mobileqq/zplan/emoticon/api/IZPlanEmoticonApi$b;", "zPlanEmoticonDetailRequestListener", "", "setZPlanEmoticonDetailView", "Landroid/content/Context;", "context", "", ShortVideoConstants.PARAM_KEY_SESSION_TYPE, "Landroid/widget/RelativeLayout;", "generateZPlanAioPanelLayout", "", "peerUin", "updateVersion", "getVersion", "friendUin", "jumpFromSource", "jumpToEmoticon", "Companion", "a", "b", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanEmoticonApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f333105a;
    public static final int VERSION_CLASSICAL = 1;
    public static final int VERSION_DOUBLE_AIO = 2;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/api/IZPlanEmoticonApi$a;", "", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonApi$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f333105a = new Companion();

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/api/IZPlanEmoticonApi$b;", "", "Landroid/graphics/drawable/Drawable;", "iconDrawable", "", "textString", "jumpTextString", "", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void a(@Nullable Drawable iconDrawable, @NotNull String textString, @NotNull String jumpTextString);
    }

    boolean checkCreateRole();

    @NotNull
    RelativeLayout generateZPlanAioPanelLayout(@NotNull Context context, int sessionType);

    int getVersion(int sessionType);

    void jumpToEmoticon(@NotNull Context context, @NotNull String friendUin, @NotNull String jumpFromSource);

    void setZPlanEmoticonDetailView(@NotNull b zPlanEmoticonDetailRequestListener);

    void updateVersion(int sessionType, @NotNull String peerUin);
}
