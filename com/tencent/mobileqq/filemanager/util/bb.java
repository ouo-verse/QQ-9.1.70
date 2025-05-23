package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.docs.TroopDocsPreviewConfigProcessor;
import com.tencent.mobileqq.filemanager.fileviewer.docs.TroopDocsPreviewFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dc1.d;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b?\u0010@J@\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J \u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nH\u0002J\"\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0002Jj\u0010+\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010\nH\u0007Jr\u0010-\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010\nH\u0007J\u0094\u0001\u00102\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010\n2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u00104\u001a\u00020\n2\u0006\u00103\u001a\u00020\nH\u0002J(\u00105\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\nH\u0002R#\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004068\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R \u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u00108\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/filemanager/util/bb;", "", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "status", "", "isFolder", "", "troopUin", "", WadlProxyConsts.PARAM_FILENAME, "fileSize", "fileEntrance", "o", "isOnlinePreviewSupport", "entranceType", "", "w", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/filemanager/fileviewer/docs/b;", "bean", "e", "g", "d", "j", DomainData.DOMAIN_NAME, "needConvert", "k", "i", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/data/t;", "fileStatusInfo", IProfileCardConst.KEY_FROM_TYPE, "deadTime", "uploaderUin", "isFromTroopPlugin", "isC2cType", "isSend", "sendId", "md5", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "source", "r", "sessionId", "cloudType", "opType", "url", ReportConstant.COSTREPORT_PREFIX, "filePath", tl.h.F, "f", "", "b", "Ljava/util/Map;", "getSupportEntrancesMap", "()Ljava/util/Map;", "supportEntrancesMap", "", "c", "entranceIdToSourceTagForAttaReport", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class bb {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bb f209374a = new bb();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Integer> supportEntrancesMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, String> entranceIdToSourceTagForAttaReport;

    static {
        Map<Integer, String> mapOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(3, 1);
        linkedHashMap.put(4, 2);
        linkedHashMap.put(13, 3);
        supportEntrancesMap = linkedHashMap;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, "s_qq_grp_aio"), TuplesKt.to(2, "s_qq_grpfile_list"), TuplesKt.to(3, "s_qq_grpfile_history"), TuplesKt.to(4, "s_qqfile_preview-button_grp"), TuplesKt.to(5, "s_qqfile_preview-button_c2c"));
        entranceIdToSourceTagForAttaReport = mapOf;
    }

    bb() {
    }

    private final boolean d(com.tencent.mobileqq.filemanager.fileviewer.docs.b bean, long fileSize, String fileName) {
        if (!AppNetConnInfo.isMobileConn()) {
            return false;
        }
        String g16 = g(fileName);
        Long l3 = bean.f().get(g16);
        Long l16 = bean.h().get(g16);
        Intrinsics.checkNotNull(l3);
        if (fileSize >= l3.longValue()) {
            return false;
        }
        Intrinsics.checkNotNull(l16);
        if (fileSize <= l16.longValue()) {
            return false;
        }
        return true;
    }

    private final boolean e(com.tencent.mobileqq.filemanager.fileviewer.docs.b bean, long fileSize, String fileName) {
        if (!AppNetConnInfo.isWifiConn()) {
            return false;
        }
        String g16 = g(fileName);
        Long l3 = bean.e().get(g16);
        Long l16 = bean.g().get(g16);
        Intrinsics.checkNotNull(l3);
        if (fileSize >= l3.longValue()) {
            return false;
        }
        Intrinsics.checkNotNull(l16);
        if (fileSize <= l16.longValue()) {
            return false;
        }
        return true;
    }

    private final int f(QQAppInterface app, com.tencent.mobileqq.troop.data.t fileStatusInfo, long deadTime, String uploaderUin) {
        boolean z16;
        FileManagerEntity newEntityByTroopFileInfo = FileManagerUtil.newEntityByTroopFileInfo(fileStatusInfo);
        if (uploaderUin.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            newEntityByTroopFileInfo.selfUin = uploaderUin;
        }
        if (deadTime != 0) {
            newEntityByTroopFileInfo.lastTime = deadTime;
        }
        newEntityByTroopFileInfo.bSend = Intrinsics.areEqual(app.getAccount(), newEntityByTroopFileInfo.selfUin);
        return ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).putFileModel(new com.tencent.mobileqq.filemanager.openbrowser.d(app, newEntityByTroopFileInfo, 2));
    }

    private final String g(String fileName) {
        boolean startsWith$default;
        String extension = FileUtils.getExtension(fileName);
        Intrinsics.checkNotNullExpressionValue(extension, "getExtension(fileName)");
        String lowerCase = extension.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        boolean z16 = false;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(lowerCase, ".", false, 2, null);
        if (startsWith$default) {
            if (lowerCase.length() > 0) {
                z16 = true;
            }
            if (z16) {
                String substring = lowerCase.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                return substring;
            }
            return lowerCase;
        }
        return lowerCase;
    }

    private final String h(String filePath) {
        boolean startsWith$default;
        String str = null;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(filePath, "/", false, 2, null);
        if (startsWith$default) {
            str = filePath;
        }
        if (str == null) {
            return "/" + filePath;
        }
        return str;
    }

    private final boolean i(int fileEntrance) {
        ExpEntityInfo b16 = com.tencent.relation.common.abtest.a.b("exp_qq_docs_aio_file_toolbar_2");
        Intrinsics.checkNotNullExpressionValue(b16, "getExpEntityWithReport(\"\u2026docs_aio_file_toolbar_2\")");
        String str = b16.getTabParams().get("group_aio_enable");
        if (str == null) {
            str = "";
        }
        if (fileEntrance == 3 && Intrinsics.areEqual(str, "true")) {
            return true;
        }
        return false;
    }

    private final boolean j(com.tencent.mobileqq.filemanager.fileviewer.docs.b bean, String fileName) {
        return bean.d().contains(g(fileName));
    }

    private final boolean k(com.tencent.mobileqq.filemanager.fileviewer.docs.b bean, int fileEntrance, boolean needConvert) {
        int i3;
        if (needConvert) {
            Integer num = supportEntrancesMap.get(Integer.valueOf(fileEntrance));
            if (num == null) {
                return false;
            }
            i3 = num.intValue();
        } else {
            i3 = fileEntrance;
        }
        if (!bean.c().contains(Integer.valueOf(i3)) && !i(fileEntrance)) {
            return false;
        }
        return true;
    }

    static /* synthetic */ boolean l(bb bbVar, com.tencent.mobileqq.filemanager.fileviewer.docs.b bVar, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = true;
        }
        return bbVar.k(bVar, i3, z16);
    }

    private final boolean m(int status) {
        if (status != 7 && status != 8 && status != 9 && status != 10) {
            return false;
        }
        return true;
    }

    private final boolean n(com.tencent.mobileqq.filemanager.fileviewer.docs.b bean, String troopUin) {
        boolean endsWith$default;
        if (!bean.i()) {
            return true;
        }
        Set<String> b16 = bean.b();
        if (b16 != null) {
            for (String it : b16) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(troopUin, it, false, 2, null);
                if (endsWith$default) {
                    return true;
                }
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean o(@NotNull QQAppInterface app, int status, boolean isFolder, long troopUin, @NotNull String fileName, long fileSize, int fileEntrance) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        boolean p26 = ea.p2(app.getCurrentAccountUin());
        bb bbVar = f209374a;
        bbVar.w(p26, fileEntrance);
        if (isFolder || !bbVar.m(status) || !p26) {
            return false;
        }
        com.tencent.mobileqq.filemanager.fileviewer.docs.b c16 = TroopDocsPreviewConfigProcessor.c();
        Intrinsics.checkNotNullExpressionValue(c16, "this");
        if (!bbVar.j(c16, fileName) || !bbVar.n(c16, String.valueOf(troopUin)) || !l(bbVar, c16, fileEntrance, false, 4, null)) {
            return false;
        }
        if (bbVar.e(c16, fileSize, fileName)) {
            return true;
        }
        return bbVar.d(c16, fileSize, fileName);
    }

    @JvmStatic
    public static final boolean p(@NotNull QQAppInterface app, int fileEntrance, @NotNull String fileName) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        boolean p26 = ea.p2(app.getCurrentAccountUin());
        bb bbVar = f209374a;
        bbVar.w(p26, fileEntrance);
        com.tencent.mobileqq.filemanager.fileviewer.docs.b c16 = TroopDocsPreviewConfigProcessor.c();
        Intrinsics.checkNotNullExpressionValue(c16, "loadConfig()");
        if (!bbVar.j(c16, fileName)) {
            return false;
        }
        com.tencent.mobileqq.filemanager.fileviewer.docs.b c17 = TroopDocsPreviewConfigProcessor.c();
        Intrinsics.checkNotNullExpressionValue(c17, "loadConfig()");
        if (!bbVar.k(c17, fileEntrance, false)) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final void q(@NotNull QQAppInterface app, @NotNull Context context, @NotNull com.tencent.mobileqq.troop.data.t fileStatusInfo, int fromType, int entranceType, long deadTime, @NotNull String uploaderUin, boolean isFromTroopPlugin, boolean isC2cType, boolean isSend, long sendId, @Nullable String md5) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileStatusInfo, "fileStatusInfo");
        Intrinsics.checkNotNullParameter(uploaderUin, "uploaderUin");
        r(app, context, fileStatusInfo, fromType, entranceType, deadTime, uploaderUin, isFromTroopPlugin, isC2cType, isSend, sendId, 0, md5);
    }

    @JvmStatic
    public static final void r(@NotNull QQAppInterface app, @NotNull Context context, @NotNull com.tencent.mobileqq.troop.data.t fileStatusInfo, int fromType, int entranceType, long deadTime, @NotNull String uploaderUin, boolean isFromTroopPlugin, boolean isC2cType, boolean isSend, long sendId, int source, @Nullable String md5) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileStatusInfo, "fileStatusInfo");
        Intrinsics.checkNotNullParameter(uploaderUin, "uploaderUin");
        s(app, context, fileStatusInfo, fromType, entranceType, deadTime, uploaderUin, isFromTroopPlugin, isC2cType, isSend, sendId, source, md5, 0L, -1, -1, "");
    }

    @JvmStatic
    public static final void s(@NotNull final QQAppInterface app, @NotNull Context context, @NotNull final com.tencent.mobileqq.troop.data.t fileStatusInfo, int fromType, int entranceType, long deadTime, @NotNull String uploaderUin, boolean isFromTroopPlugin, boolean isC2cType, boolean isSend, long sendId, int source, @Nullable final String md5, long sessionId, int cloudType, int opType, @Nullable String url) {
        boolean z16;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileStatusInfo, "fileStatusInfo");
        Intrinsics.checkNotNullParameter(uploaderUin, "uploaderUin");
        if (isC2cType) {
            z16 = true;
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.ay
                @Override // java.lang.Runnable
                public final void run() {
                    bb.u(com.tencent.mobileqq.troop.data.t.this, md5, app);
                }
            }, 128, null, false);
            z16 = false;
        }
        boolean z17 = z16;
        dc1.g gVar = new dc1.g(app, context, fileStatusInfo.f294971e, fileStatusInfo, fromType, sessionId, cloudType, opType);
        gVar.C(deadTime);
        gVar.D(uploaderUin);
        dc1.d dVar = new dc1.d(context, gVar);
        dVar.m(entranceType);
        dVar.q(opType);
        QLog.d("TroopDocsPreviewUtils", 1, "openTroopDocsPreviewSource source: " + source);
        Bundle g16 = dVar.g();
        if (g16 != null) {
            bb bbVar = f209374a;
            boolean z18 = true;
            String str = fileStatusInfo.f294985s;
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "fileStatusInfo.FilePath ?: \"\"");
            }
            g16.putString("key_troop_file_id", bbVar.h(str));
            g16.putString("key_troop_file_md5", md5 != null ? md5 : "");
            g16.putInt("key_troop_bus_id", fileStatusInfo.f294988v);
            g16.putBoolean("key_from_troop_plugin", isFromTroopPlugin);
            g16.putInt("key_preview_entrance", entranceType);
            g16.putBoolean("key_is_c2c_type", isC2cType);
            g16.putBoolean("key_is_send", isSend);
            g16.putLong("key_send_uin", sendId);
            g16.putInt(IFileBrowserService.STRING_BROWSE_ID, bbVar.f(app, fileStatusInfo, deadTime, uploaderUin));
            if (source != 1) {
                z18 = false;
            }
            g16.putBoolean("hide_more_button", z18);
            g16.putBoolean("key_need_report", z17);
            g16.putString("key_url", url);
        }
        dVar.n(QQTranslucentBrowserActivity.class);
        dVar.f(new d.c() { // from class: com.tencent.mobileqq.filemanager.util.az
            @Override // dc1.d.c
            public final void a(Intent intent) {
                bb.t(intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Intent intent) {
        intent.putExtra("fragmentClass", TroopDocsPreviewFragment.class);
        intent.putExtra("big_brother_source_key", "biz_src_xl_docs");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(com.tencent.mobileqq.troop.data.t fileStatusInfo, String str, QQAppInterface app) {
        Object obj;
        Intrinsics.checkNotNullParameter(fileStatusInfo, "$fileStatusInfo");
        Intrinsics.checkNotNullParameter(app, "$app");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("gc", String.valueOf(fileStatusInfo.f294971e));
            jSONObject.put("ver", String.valueOf(BaseApplication.getContext().getAppId()));
            jSONObject.put("comeFrom", "3");
            jSONObject.put("busId", "102");
            bb bbVar = f209374a;
            String str2 = fileStatusInfo.f294985s;
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("filePath", bbVar.h(str2));
            jSONObject.put(WadlProxyConsts.PARAM_FILENAME, fileStatusInfo.f294987u);
            jSONObject.put("fileSize", String.valueOf(fileStatusInfo.f294976j));
            jSONObject.put("fileMd5", str);
            AppRuntime appRuntime = app.getAppRuntime("modular_web");
            Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            IRuntimeService runtimeService = ((AppInterface) appRuntime).getRuntimeService(ITroopInfoService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface.getRuntimeS\u2026AIN\n                    )");
            jSONObject.put("groupName", ((ITroopInfoService) runtimeService).getTroopNameByID(String.valueOf(fileStatusInfo.f294971e)));
            String str3 = "1";
            if (VasUtil.getSignedService(app).getVipStatus().isVip()) {
                obj = "1";
            } else {
                obj = "0";
            }
            jSONObject.put("isQqYearVip", obj);
            if (!VasUtil.getSignedService(app).getVipStatus().isSVip()) {
                str3 = "0";
            }
            jSONObject.put("isQqSuperVip", str3);
            jSONObject.put("user_ip", com.dataline.util.a.a(false));
        } catch (JSONException e16) {
            QLog.e("TroopDocsPreviewUtils", 2, "put fileid exception: " + e16);
        }
        ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost(new JSONObject().put("report", jSONObject), app.getCurrentAccountUin(), ITeamWorkHandler.URL_ONLINE_PREVIEW_REPORT, ITeamWorkHandler.DOCS_DOMAIN, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.filemanager.util.ba
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj2) {
                bb.v(obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Object obj) {
        Object obj2;
        Object m476constructorimpl;
        if (obj != null) {
            if (obj instanceof String) {
                obj2 = obj;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    JSONObject jSONObject = new JSONObject((String) obj);
                    if (jSONObject.optInt("retcode", 0) != 0) {
                        QLog.e("TroopDocsPreviewUtils", 2, "faile to report: " + jSONObject.optInt("retcode", 0));
                    }
                    m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null && QLog.isColorLevel()) {
                    QLog.e("TroopDocsPreviewUtils", 2, m479exceptionOrNullimpl, new Object[0]);
                }
            }
        }
    }

    private final void w(boolean isOnlinePreviewSupport, int entranceType) {
        String str;
        HashMap hashMap = new HashMap();
        if (isOnlinePreviewSupport) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("ver5", str);
        String str2 = entranceIdToSourceTagForAttaReport.get(Integer.valueOf(entranceType));
        if (str2 == null) {
            str2 = "unknown";
        }
        hashMap.put("source3", str2);
        ((ITDocAttaReporterApi) QRoute.api(ITDocAttaReporterApi.class)).report("qqfile_android", "online_preview_switch", "status", hashMap);
    }
}
