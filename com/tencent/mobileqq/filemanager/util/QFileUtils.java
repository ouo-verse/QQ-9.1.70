package com.tencent.mobileqq.filemanager.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filebrowser.richmedia.TroopFilePreviewLayerFragment;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileassistant.forward.QFileAssistantForwardManager;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.troop.file.api.ITroopFileApi;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vip.d;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import k0.a;
import kotlin.jvm.functions.Function0;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QFileUtils {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements d.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f209201a;

        a(u uVar) {
            this.f209201a = uVar;
        }

        @Override // com.tencent.mobileqq.vip.d.b
        public void callback(int i3) {
            if (i3 == 1 || i3 == 2) {
                this.f209201a.a();
            }
        }
    }

    public static void A(QQAppInterface qQAppInterface, Activity activity, FileManagerEntity fileManagerEntity) {
        B(qQAppInterface, activity, fileManagerEntity, false, null, -1);
    }

    public static void B(QQAppInterface qQAppInterface, final Activity activity, final FileManagerEntity fileManagerEntity, boolean z16, String str, int i3) {
        if (NetworkUtil.getSystemNetwork(activity) == 0) {
            TroopFileError.k(activity, activity.getString(R.string.ers));
            return;
        }
        if (fileManagerEntity == null) {
            return;
        }
        final Intent Z = Z(qQAppInterface, fileManagerEntity);
        Z.putExtra("is_from_file", true);
        com.tencent.mobileqq.filebrowser.toogle.a.c(new Function0() { // from class: com.tencent.mobileqq.filemanager.util.ag
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Object i06;
                i06 = QFileUtils.i0(activity, Z, fileManagerEntity);
                return i06;
            }
        });
        if (z16 && !TextUtils.isEmpty(str) && i3 != -1) {
            Z.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
            Z.putExtra("key_direct_show_uin_type", i3);
            Z.putExtra("key_direct_show_uin", str);
        }
        ForwardBaseOption.startForwardActivityForResult(activity, Z, (Class<?>) ForwardRecentTranslucentActivity.class, 103);
    }

    public static void C(QQAppInterface qQAppInterface, List<com.tencent.mobileqq.troop.data.n> list, Activity activity, long j3) {
        Intent L = L(qQAppInterface, list, j3);
        if (L != null) {
            ForwardBaseOption.startForwardActivityForResult(activity, L, 103);
        }
    }

    public static int D(int i3, int i16) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 3) {
            return 4;
        }
        return 0;
    }

    public static String E(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        if (messageRecord == null) {
            return "";
        }
        return F(qQAppInterface, messageRecord, true);
    }

    public static String F(QQAppInterface qQAppInterface, MessageRecord messageRecord, boolean z16) {
        com.tencent.mobileqq.troop.data.t m3;
        if (messageRecord == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mrUniseq[");
        sb5.append(messageRecord.uniseq);
        sb5.append("] ");
        sb5.append("mrSeq[");
        sb5.append(messageRecord.msgseq);
        sb5.append("] ");
        sb5.append("mrUid[");
        sb5.append(messageRecord.msgUid);
        sb5.append("] ");
        if (z16) {
            if (messageRecord instanceof MessageForFile) {
                FileManagerEntity E = qQAppInterface.getFileManagerDataCenter().E(messageRecord.uniseq, messageRecord.frienduin, messageRecord.istroop);
                if (E != null) {
                    sb5.append("offFileName[");
                    sb5.append(E.fileName);
                    sb5.append("] ");
                    sb5.append("offFileUuid[");
                    sb5.append(E.Uuid);
                    sb5.append("] ");
                }
            } else if ((messageRecord instanceof MessageForTroopFile) && (m3 = TroopFileUtils.m(qQAppInterface, (MessageForTroopFile) messageRecord)) != null) {
                sb5.append("troopFileName[");
                sb5.append(m3.f294987u);
                sb5.append("] ");
                sb5.append("troopFileId");
                sb5.append(m3.f294985s);
                sb5.append("] ");
            }
        }
        return sb5.toString();
    }

    public static int G(int i3) {
        switch (i3) {
            case 0:
                return 7;
            case 1:
                return 9;
            case 2:
                return 8;
            case 3:
                return 1;
            case 4:
                return 6;
            case 5:
            case 8:
            default:
                return 10;
            case 6:
                return 2;
            case 7:
                return 3;
            case 9:
                return 4;
            case 10:
                return 5;
        }
    }

    public static int H(int i3) {
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 == 6) {
                    return 3;
                }
                if (i3 != 7) {
                    if (i3 == 9) {
                        return 4;
                    }
                    return 6;
                }
                return 2;
            }
            return 5;
        }
        return 1;
    }

    @NonNull
    public static ForwardFileInfo I(long j3, com.tencent.mobileqq.troop.data.t tVar) {
        FileManagerEntity newEntityByTroopFileInfo = FileManagerUtil.newEntityByTroopFileInfo(tVar);
        newEntityByTroopFileInfo.status = 2;
        newEntityByTroopFileInfo.nOpType = 24;
        ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
        forwardFileInfo.E(newEntityByTroopFileInfo.nSessionId);
        forwardFileInfo.N(10006);
        if (!TextUtils.isEmpty(newEntityByTroopFileInfo.getFilePath())) {
            forwardFileInfo.C(tVar.f294978l);
        }
        forwardFileInfo.y(tVar.f294987u);
        forwardFileInfo.z(tVar.f294976j);
        forwardFileInfo.B(j3);
        UUID uuid = tVar.f294967a;
        if (uuid != null) {
            forwardFileInfo.M(uuid.toString());
        }
        if (!TextUtils.isEmpty(tVar.f294980n)) {
            forwardFileInfo.G(tVar.f294980n);
        } else if (!TextUtils.isEmpty(tVar.f294981o)) {
            forwardFileInfo.G(tVar.f294981o);
        }
        forwardFileInfo.w(1);
        forwardFileInfo.A(3);
        return forwardFileInfo;
    }

    public static Intent J(QQAppInterface qQAppInterface, final Activity activity, final FileManagerEntity fileManagerEntity) {
        int g06 = ForwardFileOption.g0(fileManagerEntity);
        ForwardFileInfo U = ForwardFileOption.U(fileManagerEntity);
        U.N(g06);
        U.M = fileManagerEntity.fromFile ? 1 : 0;
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 0);
        bundle.putParcelable("fileinfo", U);
        bundle.putBoolean("not_forward", true);
        final Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra("destroy_last_activity", true);
        intent.putExtra("forward_type", 0);
        intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, fileManagerEntity.getFilePath());
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, HardCodeUtil.qqStr(R.string.qaz) + FileManagerUtil.cutLongName(fileManagerEntity.fileName) + HardCodeUtil.qqStr(R.string.qba) + q.g(fileManagerEntity.fileSize) + "\u3002");
        intent.putExtra("k_favorites", FileManagerUtil.isSupportFavorite(fileManagerEntity));
        com.tencent.mobileqq.filebrowser.toogle.a.c(new Function0() { // from class: com.tencent.mobileqq.filemanager.util.af
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Object j06;
                j06 = QFileUtils.j0(activity, intent, fileManagerEntity);
                return j06;
            }
        });
        if (!q.f(fileManagerEntity.getFilePath()) && ((fileManagerEntity.getCloudType() == 6 || fileManagerEntity.getCloudType() == 7) && fileManagerEntity.nFileType == 0)) {
            intent.putExtra("forward_type", 0);
        }
        if (fileManagerEntity.getCloudType() == 8 && fileManagerEntity.nFileType == 0) {
            intent.putExtra("forward_type", 1);
        }
        return intent;
    }

    @NonNull
    public static Intent K(ArrayList<ForwardFileInfo> arrayList, ArrayList<Uri> arrayList2, long j3) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent();
        bundle.putInt("forward_type", 0);
        bundle.putParcelableArrayList("fileinfo_array", arrayList);
        bundle.putBoolean("not_forward", true);
        bundle.putBoolean("support_multi_forward", true);
        intent.putExtra("sendMultiple", true);
        bundle.putParcelableArrayList("android.intent.extra.STREAM", arrayList2);
        intent.putExtras(bundle);
        intent.putExtra("foward_editbar", true);
        intent.putExtra("forward_type", 0);
        String qqStr = HardCodeUtil.qqStr(R.string.f172378qb1);
        if (arrayList.size() == 1) {
            qqStr = HardCodeUtil.qqStr(R.string.qb9) + FileManagerUtil.cutLongName(arrayList.get(0).f()) + HardCodeUtil.qqStr(R.string.qb_) + q.g(arrayList.get(0).g()) + "\u3002";
        } else if (arrayList.size() > 1) {
            qqStr = HardCodeUtil.qqStr(R.string.qb5) + FileManagerUtil.cutLongName(arrayList.get(0).f()) + HardCodeUtil.qqStr(R.string.f172381qb4) + arrayList.size() + HardCodeUtil.qqStr(R.string.qb7) + q.g(j3) + "\u3002";
        }
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, qqStr);
        intent.putExtra("k_favorites", false);
        return intent;
    }

    @Nullable
    private static Intent L(QQAppInterface qQAppInterface, List<com.tencent.mobileqq.troop.data.n> list, long j3) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        long j16 = 0;
        if (j3 == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.tencent.mobileqq.troop.data.n> it = list.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.troop.data.t Y = Y(qQAppInterface, j3, it.next());
            ForwardFileInfo I = I(j3, Y);
            if (FileUtils.fileExistsAndNotEmpty(Y.f294978l)) {
                arrayList2.add(Uri.parse(Y.f294978l));
            } else {
                arrayList2.add(Uri.parse(""));
            }
            j16 += Y.f294976j;
            arrayList.add(I);
        }
        return K(arrayList, arrayList2, j16);
    }

    public static int M(QQAppInterface qQAppInterface, int i3, String str) {
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 3000) {
            return 101;
        }
        if (i3 != 1) {
            return 1;
        }
        TroopInfo B = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).B(str);
        if (B == null || !B.isNewTroop) {
            return 4;
        }
        return 113;
    }

    static IOCRService N() {
        return (IOCRService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOCRService.class, "");
    }

    public static int O() {
        return an.c();
    }

    public static int P(String str) {
        return an.d(str);
    }

    public static int Q(String str) {
        return an.e(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<ShareActionSheetBuilder.ActionSheetItem> R(@NonNull com.tencent.mobileqq.filemanager.fileviewer.data.d dVar) {
        JSONObject jSONObject;
        String jSONObject2;
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList = new ArrayList<>();
        String str = "";
        JSONObject jSONObject3 = null;
        if (com.tencent.mobileqq.qrscan.utils.b.g(dVar.b())) {
            Object obj = dVar.a().get(1);
            if (obj instanceof Pair) {
                Pair pair = (Pair) obj;
                String trim = String.valueOf(pair.second).trim();
                String trim2 = String.valueOf(pair.first).trim();
                try {
                    jSONObject = new JSONObject();
                } catch (JSONException e16) {
                    e = e16;
                    jSONObject = null;
                }
                try {
                    jSONObject.put("scannerType", trim);
                    jSONObject.put("scannerResult", trim2);
                } catch (JSONException e17) {
                    e = e17;
                    e.printStackTrace();
                    if (jSONObject != null) {
                    }
                    ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(55);
                    build.argus = jSONObject2;
                    arrayList.add(build);
                    if (com.tencent.mobileqq.qrscan.utils.b.f(dVar.b())) {
                    }
                    return arrayList;
                }
            } else {
                jSONObject = null;
            }
            if (jSONObject != null) {
                jSONObject2 = "";
            } else {
                jSONObject2 = jSONObject.toString();
            }
            ShareActionSheetBuilder.ActionSheetItem build2 = ShareActionSheetBuilder.ActionSheetItem.build(55);
            build2.argus = jSONObject2;
            arrayList.add(build2);
        }
        if (com.tencent.mobileqq.qrscan.utils.b.f(dVar.b())) {
            Object obj2 = dVar.a().get(2);
            Object obj3 = dVar.a().get(1001);
            if (obj2 instanceof String) {
                String str2 = (String) obj2;
                try {
                    JSONObject jSONObject4 = new JSONObject();
                    try {
                        jSONObject4.put("strMini", str2);
                        if (obj3 instanceof String) {
                            jSONObject4.put("type", obj3);
                        }
                        jSONObject3 = jSONObject4;
                    } catch (JSONException e18) {
                        e = e18;
                        jSONObject3 = jSONObject4;
                        e.printStackTrace();
                        if (jSONObject3 != null) {
                        }
                        ShareActionSheetBuilder.ActionSheetItem build3 = ShareActionSheetBuilder.ActionSheetItem.build(56);
                        build3.argus = str;
                        arrayList.add(build3);
                        return arrayList;
                    }
                } catch (JSONException e19) {
                    e = e19;
                }
            }
            if (jSONObject3 != null) {
                str = jSONObject3.toString();
            }
            ShareActionSheetBuilder.ActionSheetItem build32 = ShareActionSheetBuilder.ActionSheetItem.build(56);
            build32.argus = str;
            arrayList.add(build32);
        }
        return arrayList;
    }

    public static int S(int i3) {
        if (i3 != 13) {
            switch (i3) {
                case 1:
                case 2:
                    return 0;
                case 3:
                case 4:
                    break;
                case 5:
                case 6:
                    return 3000;
                default:
                    return -1;
            }
        }
        return 1;
    }

    public static int T() {
        return an.g();
    }

    public static int U() {
        return an.h();
    }

    public static String V(long j3) {
        if (j3 > 1048576) {
            return HardCodeUtil.qqStr(R.string.f172380qb3) + new DecimalFormat("0.00").format(((float) j3) / 1048576.0f) + "MB/s";
        }
        if (j3 > 1024) {
            return HardCodeUtil.qqStr(R.string.f172379qb2) + new DecimalFormat("0.00").format(((float) j3) / 1024.0f) + "KB/s";
        }
        return HardCodeUtil.qqStr(R.string.qb8) + j3 + "KB/s";
    }

    public static int W(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split("@")) != null && split.length > 0) {
            String str2 = split[0];
            if (!TextUtils.isEmpty(str2)) {
                return Integer.parseInt(str2);
            }
        }
        return -1;
    }

    public static int X(int i3, int i16) {
        if (i3 != 1) {
            if (i3 == 3) {
                return 3;
            }
            if (i3 != 0 && i3 != 2) {
                if (i3 == 4) {
                    return 12;
                }
                return i16;
            }
        }
        return 4;
    }

    public static com.tencent.mobileqq.troop.data.t Y(QQAppInterface qQAppInterface, long j3, com.tencent.mobileqq.troop.data.n nVar) {
        com.tencent.mobileqq.troop.data.t H = TroopFileTransferManager.O(qQAppInterface, j3).H(nVar.f294916b);
        if (H == null) {
            com.tencent.mobileqq.troop.data.t k3 = TroopFileUtils.k(qQAppInterface, j3, nVar.f294915a.toString(), nVar.f294916b, nVar.f294917c, nVar.f294918d, nVar.f294919e);
            k3.f294980n = nVar.f294938x;
            k3.f294981o = nVar.f294939y;
            k3.f294979m = nVar.f294937w;
            return k3;
        }
        return H;
    }

    public static Intent Z(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        String str;
        String filePath;
        FileManagerEntity fileManagerEntity2 = new FileManagerEntity();
        fileManagerEntity2.copyFrom(fileManagerEntity);
        fileManagerEntity2.nSessionId = FileManagerUtil.genSessionId().longValue();
        fileManagerEntity2.status = 2;
        qQAppInterface.getFileManagerDataCenter().v(fileManagerEntity2);
        com.tencent.mobileqq.troop.data.t n3 = TroopFileUtils.n(qQAppInterface, fileManagerEntity2);
        ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
        forwardFileInfo.E(fileManagerEntity2.nSessionId);
        if (!TextUtils.isEmpty(fileManagerEntity2.getFilePath())) {
            if (fileManagerEntity2.cloudType != 15 && fileManagerEntity2.nOpType != 58) {
                filePath = n3.f294978l;
            } else {
                filePath = fileManagerEntity2.getFilePath();
            }
            forwardFileInfo.C(filePath);
        }
        if (fileManagerEntity2.cloudType != 15 && fileManagerEntity2.nOpType != 58) {
            str = n3.f294987u;
        } else {
            str = fileManagerEntity2.fileName;
        }
        forwardFileInfo.y(str);
        forwardFileInfo.z(n3.f294976j);
        forwardFileInfo.B(fileManagerEntity2.TroopUin);
        String str2 = n3.f294981o;
        if (TextUtils.isEmpty(str2)) {
            str2 = n3.f294980n;
        }
        forwardFileInfo.G(str2);
        if (fileManagerEntity2.isZipInnerFile) {
            forwardFileInfo.N(10000);
            forwardFileInfo.w(3);
        } else {
            UUID uuid = n3.f294967a;
            if (uuid != null) {
                forwardFileInfo.M(uuid.toString());
            }
            forwardFileInfo.N(10006);
            forwardFileInfo.w(4);
        }
        forwardFileInfo.A(2);
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 0);
        bundle.putParcelable("fileinfo", forwardFileInfo);
        bundle.putBoolean("not_forward", true);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, n3.f294987u);
        intent.putExtra(AppConstants.Key.FORWARD_FROM_TROOP_FILE, true);
        return intent;
    }

    public static String a0(long j3, int i3, String str) {
        if (i3 == 128) {
            return TroopFileTransferManager.Item.ThumbnailFilePrefix + j3 + "-" + str;
        }
        if (i3 == 383) {
            return "[Thumb]320" + j3 + "-" + str;
        }
        return TroopFileTransferManager.Item.ThumbnailFilePrefix + i3 + j3 + "-" + str;
    }

    public static Rect b0(View view, String str) {
        if (view != null && !TextUtils.isEmpty(str)) {
            int fileType = FileManagerUtil.getFileType(str);
            if (fileType == 2 || fileType == 0) {
                return com.tencent.common.galleryactivity.j.d(view);
            }
            return null;
        }
        return null;
    }

    public static ShareActionSheetBuilder.ActionSheetItem c(int i3, View.OnClickListener onClickListener) {
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(i3);
        build.iconNeedBg = true;
        build.listener = onClickListener;
        build.argus = "";
        return build;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0054 A[Catch: all -> 0x016f, TryCatch #0 {all -> 0x016f, blocks: (B:11:0x003a, B:15:0x004e, B:17:0x0054, B:20:0x0061, B:24:0x006b, B:25:0x0085, B:27:0x0155, B:33:0x0096, B:38:0x00a8, B:40:0x00b1, B:41:0x00c3, B:44:0x00cf, B:46:0x00ec, B:47:0x0109, B:49:0x0112, B:50:0x0124, B:52:0x012a, B:53:0x013e), top: B:10:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0096 A[Catch: all -> 0x016f, TRY_LEAVE, TryCatch #0 {all -> 0x016f, blocks: (B:11:0x003a, B:15:0x004e, B:17:0x0054, B:20:0x0061, B:24:0x006b, B:25:0x0085, B:27:0x0155, B:33:0x0096, B:38:0x00a8, B:40:0x00b1, B:41:0x00c3, B:44:0x00cf, B:46:0x00ec, B:47:0x0109, B:49:0x0112, B:50:0x0124, B:52:0x012a, B:53:0x013e), top: B:10:0x003a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c0(Context context, String str, int i3, boolean z16, String str2, String str3, String str4, String str5, int i16, String str6, String str7, Intent intent) {
        Intent intent2;
        int i17;
        boolean z17;
        String str8;
        int i18;
        String str9;
        String str10;
        String str11;
        if (intent == null) {
            intent2 = new Intent();
        } else {
            intent2 = intent;
        }
        intent2.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
        intent2.putExtra("detectType", i16);
        intent2.putExtra("fromPicQRDecode", true);
        String str12 = null;
        if (i3 != 1 && i3 != 3000) {
            if (z16) {
                i18 = 3;
                str8 = str6;
            } else {
                str8 = str6;
                i18 = 1;
            }
            try {
                if (TextUtils.equals(str2, str8)) {
                    str8 = str7;
                }
            } catch (Throwable unused) {
            }
        } else if (z16) {
            i18 = 4;
            str8 = null;
        } else {
            i17 = 2;
            z17 = true;
            str8 = null;
            if (TextUtils.isEmpty(str4)) {
                int picDownloadPort = BaseDownloadProcessor.getPicDownloadPort();
                if (z17) {
                    str11 = IPicTransFile.GROUP_PIC_DOWNLOAD_DOMAIN;
                } else {
                    str11 = IPicTransFile.C2C_PIC_DOWNLOAD_DOMAIN;
                }
                if (!TextUtils.isEmpty(str11)) {
                    if (picDownloadPort != 80) {
                        str12 = str11 + ":" + picDownloadPort + str4;
                    } else {
                        str12 = str11 + str4;
                    }
                }
            } else if (!TextUtils.isEmpty(str5)) {
                if (i17 != 1) {
                    if (i17 == 2) {
                        String str13 = "gchat.qpic.cn/gchatpic_new";
                        if (!TextUtils.isEmpty(str2)) {
                            str13 = "gchat.qpic.cn/gchatpic_new/" + str2;
                        }
                        if (str5.startsWith("/")) {
                            str9 = str13 + "0-0-" + str5.replace(".jpg", "") + "/0";
                        } else {
                            str9 = str13 + "/0-0-" + str5.replace(".jpg", "") + "/0";
                        }
                    }
                } else {
                    String str14 = "c2cpicdw.qpic.cn/offpic_new";
                    if (!TextUtils.isEmpty(str2)) {
                        str14 = "c2cpicdw.qpic.cn/offpic_new/" + str2;
                    }
                    if (str5.startsWith("/")) {
                        str9 = str14 + str5 + "/0";
                    } else {
                        str9 = str14 + "/" + str5 + "/0";
                    }
                }
                str10 = str9;
                intent2.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(str3, str10, str5, str2, str8, i17));
                RouteUtils.startActivity(context, intent2, "/qrscan/scanner");
            }
            str10 = str12;
            intent2.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(str3, str10, str5, str2, str8, i17));
            RouteUtils.startActivity(context, intent2, "/qrscan/scanner");
        }
        i17 = i18;
        z17 = false;
        if (TextUtils.isEmpty(str4)) {
        }
        str10 = str12;
        intent2.putExtra("report_params", ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(str3, str10, str5, str2, str8, i17));
        RouteUtils.startActivity(context, intent2, "/qrscan/scanner");
    }

    public static boolean d(MessageRecord messageRecord) {
        return an.a(messageRecord);
    }

    public static void d0(Context context, String str, String str2, String str3, int i3) {
        Intent intent = new Intent();
        intent.putExtra("preResult", str2);
        c0(context, Uri.parse("file://" + str).getPath(), -1, false, null, str3, null, null, i3, null, null, intent);
    }

    public static boolean e(QQAppInterface qQAppInterface, String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.equals(((IQFileConfigManager) qQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getDebugDatalineSettingUin());
        }
        return false;
    }

    public static boolean e0(QQAppInterface qQAppInterface) {
        short q16 = ff.q(qQAppInterface, null);
        IQFileConfigManager iQFileConfigManager = (IQFileConfigManager) qQAppInterface.getRuntimeService(IQFileConfigManager.class, "");
        if ((q16 >> 8) == 2) {
            if (((q16 & 15) == 1 && iQFileConfigManager.getTroopVideoFileYearSVIPSwitch()) || iQFileConfigManager.getTroopVideoFileSVIPSwitch()) {
                return true;
            }
            return false;
        }
        if (iQFileConfigManager.getTroopVideoFileSwitch()) {
            return true;
        }
        return false;
    }

    public static boolean f(int i3, int i16, long j3) {
        if (i3 * i16 >= 350000000 || Math.max(i3, i16) > 30000 || j3 >= GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV) {
            return true;
        }
        return false;
    }

    public static boolean f0() {
        int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(true);
        if (activeNetIpFamily == 2 || activeNetIpFamily == 3) {
            return true;
        }
        return false;
    }

    public static void g(@NonNull final Context context, final String str, @NonNull final cc1.b bVar) {
        if (!FileUtils.fileExistsAndNotEmpty(str)) {
            return;
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QFileUtils.2
            @Override // java.lang.Runnable
            public void run() {
                if (context == null || !FileUtils.fileExistsAndNotEmpty(str)) {
                    return;
                }
                final SparseArray<Object> sparseArray = new SparseArray<>(2);
                final int decodeQQCodeFromFile = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQQCodeFromFile(Uri.parse("file://" + str), context, 3, sparseArray);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QFileUtils.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        bVar.a(new com.tencent.mobileqq.filemanager.fileviewer.data.d(str, decodeQQCodeFromFile, sparseArray));
                    }
                });
            }
        });
    }

    public static boolean g0(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null || 6 != fileManagerEntity.getCloudType() || q.f(fileManagerEntity.getFilePath())) {
            return false;
        }
        return true;
    }

    public static boolean h(boolean z16, long j3, String str) {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            return false;
        }
        if (!ah.X0()) {
            QLog.i("QFileUtils", 1, "checkShowFlowDialog. do not show with Wi-Fi.");
            return false;
        }
        long flowDialogSize = ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize();
        ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogTime();
        QLog.i("QFileUtils", 1, "checkShowFlowDialog. fileSize[" + j3 + "] limit[" + flowDialogSize + "]");
        if (j3 < flowDialogSize) {
            return false;
        }
        if (z16) {
            QLog.i("QFileUtils", 1, "checkShowFlowDialog. download so show.");
            return true;
        }
        if (FileUtils.fileExistsAndNotEmpty(str)) {
            QLog.i("QFileUtils", 1, "checkShowFlowDialog. is not local File do not show.");
            return false;
        }
        QLog.i("QFileUtils", 1, "checkShowFlowDialog. show flow dialog");
        return true;
    }

    public static boolean h0(Context context, long j3, com.tencent.mobileqq.troop.data.t tVar, FileManagerEntity fileManagerEntity) {
        RFWLayerItemMediaInfo d16 = mb1.a.f416517a.d(fileManagerEntity);
        if (d16 == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(d16);
        com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
        eVar.g(com.tencent.mobileqq.richmedia.depend.d.class.getName(), (com.tencent.mobileqq.richmedia.depend.c) ((ITroopFileApi) QRoute.api(ITroopFileApi.class)).genMediaDownloadDepend(tVar));
        eVar.g(com.tencent.mobileqq.richmedia.depend.f.class.getName(), (com.tencent.mobileqq.richmedia.depend.c) ((ITroopFileApi) QRoute.api(ITroopFileApi.class)).genMediaShareDepend(j3, tVar, fileManagerEntity));
        eVar.j(arrayList);
        eVar.i(0);
        Bundle bundle = new Bundle();
        Boolean valueOf = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("troop_file_save_name_fix_9170", true));
        if (QLog.isColorLevel()) {
            QLog.i("QFileUtils", 2, "troop_file_save_name:" + valueOf);
        }
        bundle.putBoolean("save_use_origin_name", valueOf.booleanValue());
        RFWLayerLaunchUtil.jumpToGallery(new ImageView(context), arrayList, 0, QQGalleryActivity.class, TroopFilePreviewLayerFragment.class, bundle);
        return true;
    }

    public static String i(QQAppInterface qQAppInterface, long j3) {
        TroopInfo k3;
        long longAccountUin = qQAppInterface.getLongAccountUin();
        com.tencent.mobileqq.troop.utils.aj ajVar = (com.tencent.mobileqq.troop.utils.aj) qQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
        if (ajVar != null) {
            if (ajVar.e(String.valueOf(j3))) {
                return HardCodeUtil.qqStr(R.string.f172377qb0);
            }
            com.tencent.mobileqq.troop.troopgag.data.e b16 = ajVar.b(String.valueOf(j3));
            TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            if (b16 != null && b16.f300239b != 0) {
                if (troopManager != null && (k3 = troopManager.k(String.valueOf(j3))) != null && (k3.isTroopOwner(String.valueOf(longAccountUin)) || k3.isTroopAdmin(String.valueOf(longAccountUin)))) {
                    return "";
                }
                return HardCodeUtil.qqStr(R.string.qbb);
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object i0(Activity activity, Intent intent, FileManagerEntity fileManagerEntity) {
        long[] longArrayExtra = activity.getIntent().getLongArrayExtra("forward_root_msg_ids");
        if (longArrayExtra != null) {
            intent.putExtra("forward_root_msg_ids", longArrayExtra);
            intent.putExtra("forward_cur_msg_id", fileManagerEntity.ntSubMsgID);
            return null;
        }
        return null;
    }

    public static String j(String str) {
        if (!FileUtils.fileExistsAndNotEmpty(str)) {
            return "";
        }
        if (FileManagerUtil.getFileSizes(str) > 3145728) {
            QLog.i("<QFile>", 1, "copyFileToQFileFolder: source file is too big. copy failed");
        }
        String defaultRecvPath = lc1.b.a().getDefaultRecvPath();
        File file = new File(defaultRecvPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String str2 = defaultRecvPath + "/" + System.currentTimeMillis() + "_" + FileManagerUtil.getFileName(str);
        if (!FileUtils.copyFile(str, str2)) {
            return "";
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object j0(Activity activity, Intent intent, FileManagerEntity fileManagerEntity) {
        long[] longArrayExtra = activity.getIntent().getLongArrayExtra("forward_root_msg_ids");
        if (longArrayExtra != null) {
            intent.putExtra("forward_root_msg_ids", longArrayExtra);
            intent.putExtra("forward_cur_msg_id", fileManagerEntity.ntSubMsgID);
            return null;
        }
        return null;
    }

    public static void k(QQAppInterface qQAppInterface, MessageRecord messageRecord, MessageRecord messageRecord2) {
        if (messageRecord != null && FileManagerUtil.isMessageRecordOfFile(messageRecord)) {
            String extInfoFromExtStr = messageRecord2.getExtInfoFromExtStr("_m_ForwardFileType");
            if (TextUtils.isEmpty(extInfoFromExtStr)) {
                return;
            }
            int parseInt = Integer.parseInt(extInfoFromExtStr);
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            String extInfoFromExtStr2 = messageRecord2.getExtInfoFromExtStr("_m_ForwardReceiverUin");
            String extInfoFromExtStr3 = messageRecord2.getExtInfoFromExtStr("_m_ForwardSenderUin");
            if (parseInt == 1) {
                messageRecord.istroop = 0;
                if (!TextUtils.isEmpty(currentAccountUin) && !TextUtils.isEmpty(extInfoFromExtStr2) && currentAccountUin.equals(extInfoFromExtStr2)) {
                    messageRecord.frienduin = extInfoFromExtStr3;
                    return;
                }
                return;
            }
            if (parseInt == 2) {
                messageRecord.istroop = 3000;
            }
        }
    }

    public static void k0(QQAppInterface qQAppInterface, MessageRecord messageRecord, MessageRecord messageRecord2) {
        if (messageRecord != null && FileManagerUtil.isMessageRecordOfFile(messageRecord) && messageRecord2 != null && FileManagerUtil.isMessageRecordOfFile(messageRecord2)) {
            qQAppInterface.getFileManagerEngine().O().u(messageRecord, messageRecord2);
        }
    }

    public static void l(QQAppInterface qQAppInterface, Bundle bundle, Context context) {
        c cVar = new c(context);
        int singleForwardToMyComputer = ((IMyComputerHelpApi) QRoute.api(IMyComputerHelpApi.class)).singleForwardToMyComputer(AppConstants.DATALINE_PC_UIN, bundle, cVar);
        if (!cVar.f411313a || singleForwardToMyComputer == 0) {
            k0.a.j(context, singleForwardToMyComputer);
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X800644B", "0X800644B", 0, 0, "6", "", "", "");
        }
    }

    public static void l0(QQAppInterface qQAppInterface, Context context, FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            return;
        }
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.p(qQAppInterface)) {
            QFileAssistantForwardManager qFileAssistantForwardManager = new QFileAssistantForwardManager(qQAppInterface);
            qFileAssistantForwardManager.c(true);
            qFileAssistantForwardManager.b(fileManagerEntity);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 0);
        bundle.putBoolean("not_forward", true);
        bundle.putInt("dataline_forward_type", 100);
        bundle.putString("dataline_forward_path", fileManagerEntity.getFilePath());
        bundle.putParcelable("fileinfo", ForwardFileOption.U(fileManagerEntity));
        l(qQAppInterface, bundle, context);
    }

    public static void m(boolean z16, QQAppInterface qQAppInterface, SessionInfo sessionInfo, dc1.g gVar, Context context, int i3, Rect rect, int i16, ChatMessage chatMessage) {
        if (z16 && ((ChatMessage) qQAppInterface.getMessageFacade().s0(sessionInfo.f179557e, sessionInfo.f179555d, chatMessage.shmsgseq)) == null) {
            gVar.l(false);
        }
        dc1.d dVar = new dc1.d(context, gVar);
        dVar.m(i3);
        if (rect != null) {
            dVar.r(rect);
        }
        dVar.n(TroopFileDetailBrowserActivity.class);
        dVar.l(e0(qQAppInterface));
        dVar.o(e0(qQAppInterface));
        t(i3, i16, dVar);
    }

    public static void m0(QQAppInterface qQAppInterface, Context context, long j3, String str, String str2, String str3, long j16, int i3) {
        com.tencent.mobileqq.troop.data.t k3;
        if (TroopFileTransferManager.O(qQAppInterface, j3) == null || (k3 = TroopFileUtils.k(qQAppInterface, j3, str, str2, str3, j16, i3)) == null) {
            return;
        }
        if (com.tencent.mobileqq.filemanager.fileassistant.util.h.p(qQAppInterface)) {
            QFileAssistantForwardManager qFileAssistantForwardManager = new QFileAssistantForwardManager(qQAppInterface);
            FileManagerEntity newEntityByTroopFileInfo = FileManagerUtil.newEntityByTroopFileInfo(k3);
            newEntityByTroopFileInfo.TroopUin = j3;
            qFileAssistantForwardManager.c(true);
            qFileAssistantForwardManager.b(newEntityByTroopFileInfo);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("dataline_forward_type", 100);
        if (FileUtils.fileExistsAndNotEmpty(k3.f294978l)) {
            bundle.putString("dataline_forward_path", k3.f294978l);
        } else {
            FileManagerEntity newEntityByTroopFileInfo2 = FileManagerUtil.newEntityByTroopFileInfo(k3);
            newEntityByTroopFileInfo2.status = 2;
            newEntityByTroopFileInfo2.nOpType = 24;
            ForwardFileInfo U = ForwardFileOption.U(newEntityByTroopFileInfo2);
            U.w(1);
            U.N(10006);
            U.A(1);
            U.B(j3);
            UUID uuid = k3.f294967a;
            if (uuid != null) {
                U.M(uuid.toString());
            }
            bundle.putParcelable("fileinfo", U);
        }
        d dVar = new d(context);
        int singleForwardToMyComputer = ((IMyComputerHelpApi) QRoute.api(IMyComputerHelpApi.class)).singleForwardToMyComputer(AppConstants.DATALINE_PC_UIN, bundle, dVar);
        if (!dVar.f411313a || singleForwardToMyComputer == 0) {
            k0.a.j(context, singleForwardToMyComputer);
        }
    }

    public static void n(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, ChatMessage chatMessage, long j3, com.tencent.mobileqq.troop.data.t tVar, String str, long j16, int i3, int i16, Rect rect, boolean z16, boolean z17) {
        o(qQAppInterface, context, sessionInfo, chatMessage, j3, tVar, str, j16, i3, i16, rect, z16, z17, false);
    }

    public static void n0(Context context, TextView textView, String str, String str2, String str3, String str4, String str5, boolean z16, ah.f fVar) {
        an.k(context, textView, str, str2, str3, str4, str5, z16, fVar);
    }

    public static void o(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, ChatMessage chatMessage, long j3, com.tencent.mobileqq.troop.data.t tVar, String str, long j16, int i3, int i16, Rect rect, boolean z16, boolean z17, boolean z18) {
        p(qQAppInterface, context, sessionInfo, chatMessage, j3, tVar, str, j16, i3, i16, rect, z16, z17, z18, true);
    }

    public static int o0(Context context, boolean z16, Bundle bundle, int i3) {
        if (i3 == 3 || i3 == 1) {
            bundle.putBoolean("file_location_pos_entrance_multiseq", z16);
            return 0;
        }
        return 0;
    }

    public static void p(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, ChatMessage chatMessage, long j3, com.tencent.mobileqq.troop.data.t tVar, String str, long j16, int i3, int i16, Rect rect, boolean z16, boolean z17, boolean z18, boolean z19) {
        s(qQAppInterface, context, sessionInfo, chatMessage, j3, tVar, str, j16, i3, i16, rect, z16, z17, z18, z19, 0);
    }

    public static boolean p0(QQAppInterface qQAppInterface, Context context, FileManagerEntity fileManagerEntity, int i3) {
        if (!TextUtils.isEmpty(fileManagerEntity.fileName) && bb.o(qQAppInterface, i3, false, fileManagerEntity.TroopUin, fileManagerEntity.fileName, fileManagerEntity.fileSize, 4)) {
            bb.q(qQAppInterface, context, TroopFileUtils.k(qQAppInterface, fileManagerEntity.TroopUin, fileManagerEntity.strTroopFileID, fileManagerEntity.strTroopFilePath, fileManagerEntity.fileName, fileManagerEntity.fileSize, fileManagerEntity.busId), 3, 4, fileManagerEntity.lastTime, fileManagerEntity.selfUin, true, false, fileManagerEntity.bSend, fileManagerEntity.TroopUin, fileManagerEntity.strFileMd5);
            return true;
        }
        return false;
    }

    public static void q(QQAppInterface qQAppInterface, Context context, com.tencent.mobileqq.troop.data.t tVar, String str, long j3, int i3) {
        r(qQAppInterface, context, tVar, str, j3, i3, 0, false);
    }

    public static void r(QQAppInterface qQAppInterface, Context context, com.tencent.mobileqq.troop.data.t tVar, String str, long j3, int i3, int i16, boolean z16) {
        FileManagerEntity newEntityByTroopFileInfo = FileManagerUtil.newEntityByTroopFileInfo(tVar);
        if (!TextUtils.isEmpty(str)) {
            newEntityByTroopFileInfo.selfUin = str;
        }
        if (j3 != 0) {
            newEntityByTroopFileInfo.lastTime = j3;
        }
        newEntityByTroopFileInfo.bSend = qQAppInterface.getAccount().equals(newEntityByTroopFileInfo.selfUin);
        Bundle bundle = new Bundle();
        if (j3 != 0) {
            bundle.putLong("last_time", j3);
        }
        if (((ITroopFileApi) QRoute.api(ITroopFileApi.class)).useNewBrowserOpenMediaFile()) {
            bundle.putInt("file_enter_file_browser_type", i3);
        }
        com.tencent.mobileqq.filemanager.openbrowser.d dVar = new com.tencent.mobileqq.filemanager.openbrowser.d(qQAppInterface, newEntityByTroopFileInfo, 2);
        dVar.S(bundle);
        com.tencent.mobileqq.filemanager.openbrowser.c f16 = new com.tencent.mobileqq.filemanager.openbrowser.c().d(i3).f(i16);
        if (z16) {
            f16.e(1);
        }
        ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(context, dVar, f16);
    }

    public static void s(QQAppInterface qQAppInterface, Context context, SessionInfo sessionInfo, ChatMessage chatMessage, long j3, com.tencent.mobileqq.troop.data.t tVar, String str, long j16, int i3, int i16, Rect rect, boolean z16, boolean z17, boolean z18, boolean z19, int i17) {
        int i18;
        boolean z26;
        int o06;
        int fileType = FileManagerUtil.getFileType(tVar.f294987u);
        dc1.g gVar = new dc1.g(qQAppInterface, context, j3, tVar, i3);
        gVar.D(str);
        FileManagerEntity w3 = gVar.w();
        if (w3 == null || p0(qQAppInterface, context, w3, tVar.f294972f)) {
            return;
        }
        if (fileType != 0 && fileType != 2) {
            q(qQAppInterface, context, tVar, str, j16, i16);
            return;
        }
        boolean useNewBrowserOpenMediaFile = ((ITroopFileApi) QRoute.api(ITroopFileApi.class)).useNewBrowserOpenMediaFile();
        if (useNewBrowserOpenMediaFile && fileType == 2 && !FileUtils.fileExists(tVar.f294978l)) {
            q(qQAppInterface, context, tVar, str, j16, i16);
            return;
        }
        if (useNewBrowserOpenMediaFile && h0(context, j3, tVar, w3)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("key_source", i17);
        if (z17) {
            o06 = 106;
        } else {
            if (chatMessage == null || chatMessage.isMultiMsg) {
                i18 = i16;
                z26 = true;
            } else {
                z26 = false;
                i18 = i16;
            }
            o06 = o0(context, z26, bundle, i18);
        }
        int i19 = o06;
        if (tVar.f294972f == 7 && q.p(tVar.f294978l)) {
            QLog.w("QFileUtils", 1, "createFileBrowserForTroopSource, status is not download, but file exists! fileId:" + tVar.f294968b + ", LocalPath:" + tVar.f294978l + ", sessionId:" + w3.nSessionId);
        }
        gVar.B(bundle);
        gVar.C(j16);
        gVar.D(str);
        gVar.u(sessionInfo);
        gVar.q(chatMessage);
        gVar.s(z16);
        gVar.r(z19);
        gVar.t(z18);
        m(z17, qQAppInterface, sessionInfo, gVar, context, i16, rect, i19, chatMessage);
    }

    public static void t(int i3, int i16, dc1.d dVar) {
        dVar.d();
    }

    public static boolean u(Context context, boolean z16, u uVar) {
        int i3;
        if (!NetworkUtil.isNetSupportHw(BaseApplication.getContext())) {
            com.tencent.mobileqq.filemanager.util.d.e(R.string.bqf);
            return false;
        }
        Activity activity = (Activity) context;
        if (z16) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        return com.tencent.mobileqq.vip.d.i(activity, i3, new a(uVar), "");
    }

    public static String v(int i3, String str) {
        return i3 + "@" + str;
    }

    public static void w(Context context, Rect rect, ChatMessage chatMessage, SessionInfo sessionInfo, boolean z16, boolean z17, boolean z18, MessageForReplyText messageForReplyText, boolean z19) {
        int i3;
        int i16;
        Bundle bundle = new Bundle();
        if (rect != null) {
            bundle.putParcelable("KEY_THUMBNAL_BOUND", rect);
        }
        bundle.putBoolean(ShortVideoConstants.MUTE_PLAY, z16);
        bundle.putBoolean(ShortVideoConstants.IS_ONE_ITEM, z17);
        bundle.putBoolean(ShortVideoConstants.IS_AUTO_PLAY, z19);
        bundle.putBoolean(r05.a.f430453b, z18);
        if (sessionInfo.f179555d == 1) {
            bundle.putBoolean(RichMediaBrowserConstants.EXTRA_CAN_FORWARD_TO_GROUP_ALBUM, true);
            bundle.putString("extra.GROUP_UIN", sessionInfo.f179557e);
            bundle.putString("extra.GROUP_CODE", sessionInfo.f179559f);
        }
        bundle.putInt(RichMediaBrowserConstants.EXTRA_FORWARD_TO_QZONE_SRC, 1);
        int i17 = sessionInfo.f179555d;
        if (i17 == 1 || i17 == 3000) {
            bundle.putInt(RichMediaBrowserConstants.EXTRA_FORWARD_TO_QZONE_SRC, 2);
        }
        bundle.putBoolean("extra.IS_FROM_MULTI_MSG", chatMessage.isMultiMsg);
        if (messageForReplyText != null) {
            bundle.putBoolean("extra.IS_FROM_MULTI_MSG", messageForReplyText.isMultiMsg);
        }
        bundle.putBoolean("extra.IS_FROM_MULTI_MSG", chatMessage.isMultiMsg);
        bundle.putInt(RichMediaBrowserConstants.EXTRA_MOBILE_QQ_PROCESS_ID, Process.myPid());
        String str = chatMessage.selfuin;
        if (chatMessage.isMultiMsg || chatMessage.isReplySource) {
            try {
                AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                if (waitAppRuntime instanceof QQAppInterface) {
                    str = waitAppRuntime.getAccount();
                }
            } catch (Exception unused) {
            }
        }
        IOCRService N = N();
        boolean isSupportOcr = N.isSupportOcr(BaseApplicationImpl.sApplication.getRuntime().getAccount(), 1);
        bundle.putBoolean(RichMediaBrowserConstants.EXTRA_OCR, isSupportOcr);
        if (isSupportOcr) {
            String aIOText = N.getAIOText(BaseApplicationImpl.sApplication.getRuntime().getAccount());
            if (!TextUtils.isEmpty(aIOText)) {
                bundle.putString("extra.OCR_TEXT", aIOText);
            }
        }
        bundle.putInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, sessionInfo.f179555d);
        bundle.putString("uin", chatMessage.frienduin);
        try {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getAppRuntime(str);
            if (chatMessage instanceof MessageForFile) {
                if (context instanceof SplashActivity) {
                    i16 = 1;
                } else {
                    if (!(context instanceof PublicFragmentActivity) && (context instanceof MultiForwardActivity)) {
                        i3 = 5;
                        i16 = i3;
                    }
                    i3 = -1;
                    i16 = i3;
                }
                bundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
                r05.a.a(context, bundle, new AIOImageProviderService(str, chatMessage.frienduin, chatMessage.istroop, chatMessage), com.tencent.mobileqq.activity.aio.photo.c.o(chatMessage, qQAppInterface), -1, i16);
                return;
            }
            bundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
            r05.a.a(context, bundle, new AIOImageProviderService(str, chatMessage.frienduin, chatMessage.istroop, chatMessage), com.tencent.mobileqq.activity.aio.photo.c.o(chatMessage, qQAppInterface), -1, sessionInfo.P);
        } catch (AccountNotMatchException e16) {
            e16.printStackTrace();
        }
    }

    public static String x(long j3) {
        StringBuilder sb5;
        StringBuilder sb6;
        StringBuilder sb7;
        if (j3 <= 0) {
            return "00:00:00";
        }
        long j16 = j3 / 1000;
        long j17 = j16 / 3600;
        if (j17 > 9) {
            sb5 = new StringBuilder();
            sb5.append(j17);
            sb5.append("");
        } else {
            sb5 = new StringBuilder();
            sb5.append("0");
            sb5.append(j17);
        }
        String sb8 = sb5.toString();
        long j18 = j16 % 3600;
        long j19 = j18 / 60;
        if (j19 > 9) {
            sb6 = new StringBuilder();
            sb6.append(j19);
            sb6.append("");
        } else {
            sb6 = new StringBuilder();
            sb6.append("0");
            sb6.append(j19);
        }
        String sb9 = sb6.toString();
        long j26 = j18 % 60;
        if (j26 > 9) {
            sb7 = new StringBuilder();
            sb7.append(j26);
            sb7.append("");
        } else {
            sb7 = new StringBuilder();
            sb7.append("0");
            sb7.append(j26);
        }
        return sb8 + ":" + sb9 + ":" + sb7.toString();
    }

    public static void y(QQAppInterface qQAppInterface, Activity activity, FileManagerEntity fileManagerEntity) {
        z(qQAppInterface, activity, fileManagerEntity, false, null, -1);
    }

    public static void z(QQAppInterface qQAppInterface, Activity activity, FileManagerEntity fileManagerEntity, boolean z16, String str, int i3) {
        if (qQAppInterface == null || activity == null || fileManagerEntity == null) {
            return;
        }
        FileManagerEntity fileManagerEntity2 = new FileManagerEntity();
        fileManagerEntity2.copyFrom(fileManagerEntity);
        fileManagerEntity2.nSessionId = FileManagerUtil.genSessionId().longValue();
        qQAppInterface.getFileManagerDataCenter().v(fileManagerEntity2);
        Intent J = J(qQAppInterface, activity, fileManagerEntity);
        if (z16 && !TextUtils.isEmpty(str) && i3 != -1) {
            J.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
            J.putExtra("key_direct_show_uin_type", i3);
            J.putExtra("key_direct_show_uin", str);
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            com.tencent.mobileqq.filemanager.util.d.e(R.string.b_o);
        } else if (kc1.a.c(fileManagerEntity2).c(false)) {
            FMDialogUtil.a(activity, R.string.b_v, R.string.f170958ba0, new b(activity, J));
        } else {
            ForwardBaseOption.startForwardActivityForResult(activity, J, (Class<?>) ForwardRecentActivity.class, 103);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c extends a.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f209204b;

        c(Context context) {
            this.f209204b = context;
        }

        @Override // k0.a.c
        public void b(AsyncTask<Integer, Integer, String> asyncTask, int i3) {
            try {
                k0.a.o(this.f209204b, asyncTask, i3, new a());
                super.b(asyncTask, i3);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements FMDialogUtil.c {
            a() {
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                k0.a.j(c.this.f209204b, 0);
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d extends a.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f209206b;

        d(Context context) {
            this.f209206b = context;
        }

        @Override // k0.a.c
        public void a(int i3, Runnable runnable) {
            super.a(i3, runnable);
            k0.a.o(this.f209206b, null, i3, new a(runnable));
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements FMDialogUtil.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f209207a;

            a(Runnable runnable) {
                this.f209207a = runnable;
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                this.f209207a.run();
                k0.a.j(d.this.f209206b, 0);
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f209202a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Intent f209203b;

        b(Activity activity, Intent intent) {
            this.f209202a = activity;
            this.f209203b = intent;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            ForwardBaseOption.startForwardActivityForResult(this.f209202a, this.f209203b, (Class<?>) ForwardRecentActivity.class, 103);
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }
}
