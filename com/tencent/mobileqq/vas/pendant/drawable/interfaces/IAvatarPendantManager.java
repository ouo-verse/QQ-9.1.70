package com.tencent.mobileqq.vas.pendant.drawable.interfaces;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.vas.pendant.drawable.bean.AvatarInPendantHeadportraitInfo;
import com.tencent.mobileqq.vas.pendant.drawable.bean.AvatarPendantShopSeriesInfo;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u0000 '2\u00020\u0001:\u0001'J\b\u0010\u0002\u001a\u00020\u0003H&JX\u0010\u0004\u001a\u00020\u00032.\u0010\u0005\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0006j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\t2\u001e\u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000bj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\fH&J\b\u0010\r\u001a\u00020\u000eH&J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0019H&J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0010H&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0015H&J\b\u0010\u001f\u001a\u00020\u0003H&J\u0016\u0010 \u001a\u00020\u00032\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&J\b\u0010\"\u001a\u00020\u0003H&J\b\u0010#\u001a\u00020\u0003H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0015H&J\b\u0010&\u001a\u00020\u0019H&\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/drawable/interfaces/IAvatarPendantManager;", "", QCircleLpReportDc05507.KEY_CLEAR, "", "deletePendants", "map", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "excludeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAvatarPendantBaseResouceDir", "Ljava/io/File;", "getFaceCache", "", "Lcom/tencent/mobileqq/vas/pendant/drawable/bean/AvatarInPendantHeadportraitInfo;", "getPendantInfo", "Lcom/tencent/mobileqq/vas/pendant/drawable/interfaces/IPendantInfo;", "pendantId", "", "callAnim", "", "getPendantLocalVersionInfo", "Lorg/json/JSONArray;", "getPendantShopSeriesCache", "Lcom/tencent/mobileqq/vas/pendant/drawable/bean/AvatarPendantShopSeriesInfo;", "getPendentBaseDir", "isShowPendant", "msgSeq", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "setFaceCache", "faceCache", "setPlayAnimatinDelay", "setPlayAnimatinImmediately", "setUnShowMsgId", "id", "updateAllPendantLocalVersionInfo", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface IAvatarPendantManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String PENDANT_INFO_DIR = "pendant_info";

    @NotNull
    public static final String PENDANT_LOCAL_INFO = "pendant_local.cfg";

    @NotNull
    public static final String PENDANT_PASTER_DIR = "pendant_paster";

    @NotNull
    public static final String P_ID = "id";

    @NotNull
    public static final String P_VERSION = "version";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/drawable/interfaces/IAvatarPendantManager$Companion;", "", "()V", "PENDANT_INFO_DIR", "", "PENDANT_LOCAL_INFO", "PENDANT_PASTER_DIR", "P_ID", "P_VERSION", "sHasAvatarPendant", "", "getSHasAvatarPendant", "()Z", "setSHasAvatarPendant", "(Z)V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {

        @NotNull
        public static final String PENDANT_INFO_DIR = "pendant_info";

        @NotNull
        public static final String PENDANT_LOCAL_INFO = "pendant_local.cfg";

        @NotNull
        public static final String PENDANT_PASTER_DIR = "pendant_paster";

        @NotNull
        public static final String P_ID = "id";

        @NotNull
        public static final String P_VERSION = "version";
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static boolean sHasAvatarPendant = true;

        Companion() {
        }

        public final boolean getSHasAvatarPendant() {
            return sHasAvatarPendant;
        }

        public final void setSHasAvatarPendant(boolean z16) {
            sHasAvatarPendant = z16;
        }
    }

    void clear();

    void deletePendants(@Nullable HashMap<String, Integer> map, @Nullable ArrayList<String> excludeList);

    @NotNull
    File getAvatarPendantBaseResouceDir();

    @NotNull
    List<AvatarInPendantHeadportraitInfo> getFaceCache();

    @NotNull
    IPendantInfo getPendantInfo(long pendantId);

    @NotNull
    IPendantInfo getPendantInfo(long pendantId, boolean callAnim);

    @NotNull
    JSONArray getPendantLocalVersionInfo();

    @NotNull
    List<AvatarPendantShopSeriesInfo> getPendantShopSeriesCache();

    @Nullable
    File getPendentBaseDir();

    boolean isShowPendant(long msgSeq);

    void onDestroy();

    void setFaceCache(@NotNull List<? extends AvatarInPendantHeadportraitInfo> faceCache);

    void setPlayAnimatinDelay();

    void setPlayAnimatinImmediately();

    void setUnShowMsgId(long id5);

    @NotNull
    JSONArray updateAllPendantLocalVersionInfo();
}
