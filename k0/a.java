package k0;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.s;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.utils.cg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    static String f411305b = "DirectForwarder";

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f411306a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: k0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class AsyncTaskC10622a extends AsyncTask<Integer, Integer, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f411307a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f411308b;

        AsyncTaskC10622a(ArrayList arrayList, int i3) {
            this.f411307a = arrayList;
            this.f411308b = i3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(Integer... numArr) {
            c(this.f411307a, numArr[0].intValue());
            return null;
        }

        DataLineMsgRecord b(DataLineHandler dataLineHandler, String str, int i3, int i16, int i17, int i18) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (i3 == 0) {
                int fileType = FileManagerUtil.getFileType(str);
                if (fileType != 1) {
                    if (fileType != 2) {
                        i3 = 0;
                    } else {
                        i3 = 2;
                    }
                } else {
                    i3 = 3;
                }
            }
            DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
            dataLineMsgRecord.msgtype = DataLineHandler.C4(i3);
            dataLineMsgRecord.sessionid = dataLineHandler.u3(0, this.f411308b).longValue();
            dataLineMsgRecord.path = str;
            dataLineMsgRecord.thumbPath = null;
            dataLineMsgRecord.groupId = i16;
            dataLineMsgRecord.groupSize = i17;
            dataLineMsgRecord.groupIndex = i18;
            return dataLineMsgRecord;
        }

        void c(List<String> list, int i3) {
            if (list == null) {
                return;
            }
            DataLineHandler dataLineHandler = (DataLineHandler) a.this.f411306a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
            while (true) {
                int size = list.size();
                if (size <= 3) {
                    for (int i16 = 0; i16 < size; i16++) {
                        DataLineMsgRecord b16 = b(dataLineHandler, list.get(i16), i3, 0, 0, 0);
                        if (b16 != null) {
                            dataLineHandler.q4(b16, false);
                        }
                    }
                    return;
                }
                if (size > 3 && size < 50) {
                    ArrayList<DataLineMsgRecord> arrayList = new ArrayList<>();
                    int s36 = dataLineHandler.s3();
                    ArrayList<DataLineMsgRecord> arrayList2 = arrayList;
                    for (int i17 = 0; i17 < size; i17++) {
                        DataLineMsgRecord b17 = b(dataLineHandler, list.get(i17), i3, s36, size, i17);
                        if (b17 != null) {
                            arrayList2.add(b17);
                        }
                        if (DataLineMsgSet.isSingle(i3, s36)) {
                            if (b17 != null) {
                                b17.groupId = 0;
                                b17.groupIndex = 0;
                                b17.groupSize = 0;
                            }
                            if (arrayList2.size() > 0) {
                                dataLineHandler.r4(arrayList2, false);
                            }
                            arrayList2 = new ArrayList<>();
                        }
                    }
                    if (arrayList2.size() > 0) {
                        dataLineHandler.r4(arrayList2, false);
                        return;
                    }
                    return;
                }
                ArrayList<DataLineMsgRecord> arrayList3 = new ArrayList<>();
                int s37 = dataLineHandler.s3();
                ArrayList<DataLineMsgRecord> arrayList4 = arrayList3;
                for (int i18 = 0; i18 < 50; i18++) {
                    DataLineMsgRecord b18 = b(dataLineHandler, list.get(i18), i3, s37, 50, i18);
                    if (b18 != null) {
                        arrayList4.add(b18);
                    }
                    if (DataLineMsgSet.isSingle(i3, s37)) {
                        if (b18 != null) {
                            b18.groupId = 0;
                            b18.groupIndex = 0;
                            b18.groupSize = 0;
                        }
                        if (arrayList4.size() > 0) {
                            dataLineHandler.r4(arrayList4, false);
                        }
                        arrayList4 = new ArrayList<>();
                    }
                }
                if (arrayList4.size() > 0) {
                    dataLineHandler.r4(arrayList4, false);
                }
                for (int i19 = 0; i19 < 50; i19++) {
                    list.remove(0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class b implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsyncTask f411310a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f411311b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ FMDialogUtil.c f411312c;

        b(AsyncTask asyncTask, int i3, FMDialogUtil.c cVar) {
            this.f411310a = asyncTask;
            this.f411311b = i3;
            this.f411312c = cVar;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
            FMDialogUtil.c cVar = this.f411312c;
            if (cVar != null) {
                cVar.a();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            AsyncTask asyncTask = this.f411310a;
            if (asyncTask != null) {
                asyncTask.execute(Integer.valueOf(this.f411311b));
            }
            FMDialogUtil.c cVar = this.f411312c;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f411313a = false;

        public void a(int i3, Runnable runnable) {
            this.f411313a = true;
        }

        public void b(AsyncTask<Integer, Integer, String> asyncTask, int i3) {
            this.f411313a = true;
        }

        public void c() {
            a.q(HardCodeUtil.qqStr(R.string.lnc), 1);
        }

        public void d() {
            a.p(R.string.c3q, 1);
        }

        public void e() {
            a.q(HardCodeUtil.qqStr(R.string.ln_), 1);
        }

        public void f() {
            a.q(HardCodeUtil.qqStr(R.string.lna), 1);
        }
    }

    public a(QQAppInterface qQAppInterface) {
        this.f411306a = qQAppInterface;
    }

    private DataLineMsgRecord a(ForwardFileInfo forwardFileInfo, boolean z16, int i3) {
        FileManagerEntity D = this.f411306a.getFileManagerDataCenter().D(forwardFileInfo.n());
        if (D == null) {
            return null;
        }
        int S2 = DataLineHandler.S2(D);
        if (!DataLineHandler.U2(S2)) {
            return null;
        }
        int R2 = DataLineHandler.R2(forwardFileInfo.f(), z16);
        if (!z16 && R2 == 1) {
            R2 = 0;
        }
        DataLineMsgRecord dataLineMsgRecord = new DataLineMsgRecord();
        dataLineMsgRecord.msgtype = DataLineHandler.C4(R2);
        dataLineMsgRecord.sessionid = ((DataLineHandler) this.f411306a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).u3(0, i3).longValue();
        dataLineMsgRecord.filename = forwardFileInfo.f();
        dataLineMsgRecord.filesize = forwardFileInfo.g();
        dataLineMsgRecord.fileUuid = forwardFileInfo.s();
        dataLineMsgRecord.fileFrom = S2;
        dataLineMsgRecord.thumbPath = forwardFileInfo.p();
        if (!TextUtils.isEmpty(D.strFileMd5)) {
            dataLineMsgRecord.md5 = HexUtil.hexStr2Bytes(D.strFileMd5);
        }
        if (!TextUtils.isEmpty(D.peerUin)) {
            dataLineMsgRecord.uOwnerUin = Long.parseLong(D.peerUin.replace(Marker.ANY_NON_NULL_MARKER, ""));
        }
        if (TextUtils.isEmpty(forwardFileInfo.l())) {
            dataLineMsgRecord.path = forwardFileInfo.f();
        } else {
            dataLineMsgRecord.path = forwardFileInfo.l();
        }
        return dataLineMsgRecord;
    }

    private int b(String str, int i3, boolean z16, c cVar) {
        String str2;
        s.a(this.f411306a.getApplication().getApplicationContext(), this.f411306a.getCurrentAccountUin(), "dl_forwardin_file");
        if (str != null && !str.equals("")) {
            ArrayList<String> arrayList = new ArrayList<>();
            String[] split = str.split(";");
            boolean z17 = false;
            for (int i16 = 0; i16 < split.length; i16++) {
                if (q.f(split[i16])) {
                    str2 = split[i16];
                } else {
                    try {
                        str2 = URLDecoder.decode(split[i16], "UTF-8");
                    } catch (UnsupportedEncodingException unused) {
                        if (QLog.isColorLevel()) {
                            QLog.e("qqdataline", 2, "forwardFile|decode exp. imageUrls[i]=" + split[i16]);
                        }
                    } catch (IllegalArgumentException unused2) {
                        str2 = split[i16];
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    if (!str2.startsWith("http://") && !str2.startsWith("https://")) {
                        arrayList.add(str2);
                    } else if (m(str2, i3, z16, cVar) == 0) {
                        z17 = true;
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.e("qqdataline", 2, "forwardFile|file path invalid. path=" + str2);
                }
            }
            if (!arrayList.isEmpty()) {
                if (z16) {
                    ReportController.o(this.f411306a, "CliOper", "", "", "0X8004932", "0X8004932", 0, 0, "", "", "", "");
                    if (QLog.isColorLevel()) {
                        QLog.e("qqdataline", 2, "forwardFile shareFromMigSdk|report send file:0X8004932.");
                    }
                }
                if (l(arrayList, 0, i3, z16, cVar) == 0 || z17) {
                    return 0;
                }
                return 8;
            }
            if (!z17) {
                return 4;
            }
            return 0;
        }
        QLog.e(f411305b, 2, "forwardFile. path=null");
        return 4;
    }

    private boolean d(Bundle bundle, ForwardFileInfo forwardFileInfo, int i3, int i16) {
        boolean z16;
        if (forwardFileInfo == null) {
            return false;
        }
        FileManagerEntity D = this.f411306a.getFileManagerDataCenter().D(forwardFileInfo.n());
        int i17 = 7;
        if (D == null && forwardFileInfo.c() == 10) {
            D = QfavHelper.m(bundle, forwardFileInfo.k() + "", 7);
        }
        FileManagerEntity fileManagerEntity = D;
        if (fileManagerEntity == null) {
            return false;
        }
        QLog.i(f411305b, 1, "ForwardOfflineFile forwardFileType: " + i3 + " devType:" + i16);
        int S2 = DataLineHandler.S2(fileManagerEntity);
        if (S2 != 1) {
            if (S2 != 2) {
                if (S2 != 3) {
                    if (S2 != 6) {
                        QLog.w(f411305b, 1, "ForwardOfflineFile fileFrom " + S2 + " is not handled");
                        return false;
                    }
                    this.f411306a.getFileManagerEngine().C0(fileManagerEntity, "7", "", 6000, forwardFileInfo.L);
                } else {
                    if (i3 == 101) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    DataLineMsgRecord a16 = a(forwardFileInfo, z16, i16);
                    if (a16 == null) {
                        return false;
                    }
                    ((DataLineHandler) this.f411306a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).q4(a16, false);
                }
            } else {
                if (i16 == 1) {
                    i17 = 6003;
                } else if (i16 == 2) {
                    i17 = 6005;
                }
                this.f411306a.getFileManagerEngine().G(forwardFileInfo.n(), forwardFileInfo.q(), forwardFileInfo.k(), Long.parseLong(this.f411306a.getCurrentAccountUin()), "", i17, forwardFileInfo.j());
            }
        } else {
            this.f411306a.getFileManagerEngine().w(3, forwardFileInfo.n(), i16);
        }
        return true;
    }

    private int e(String str, int i3, boolean z16, c cVar) {
        String str2;
        s.a(this.f411306a.getApplication().getApplicationContext(), this.f411306a.getCurrentAccountUin(), "dl_forwardin_image");
        if (str != null && !str.equals("")) {
            ArrayList<String> arrayList = new ArrayList<>();
            String[] split = str.split(";");
            boolean z17 = false;
            for (int i16 = 0; i16 < split.length; i16++) {
                if (q.f(split[i16])) {
                    str2 = split[i16];
                } else {
                    try {
                        str2 = URLDecoder.decode(split[i16], "UTF-8");
                    } catch (UnsupportedEncodingException unused) {
                        if (QLog.isColorLevel()) {
                            QLog.e("qqdataline", 2, "forwardImage. decode exp. imageUrls[i]=" + split[i16]);
                        }
                    } catch (IllegalArgumentException unused2) {
                        str2 = split[i16];
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    if (!str2.startsWith("http://") && !str2.startsWith("https://")) {
                        arrayList.add(str2);
                    } else {
                        ReportController.o(this.f411306a, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
                        if (QLog.isColorLevel()) {
                            QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
                        }
                        if (m(str2, i3, z16, cVar) == 0) {
                            z17 = true;
                        }
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.e("qqdataline", 2, "forwardImage|file path invalid. path=" + str2);
                }
            }
            if (!arrayList.isEmpty()) {
                if (z16) {
                    if (arrayList.size() > 1) {
                        ReportController.o(this.f411306a, "CliOper", "", "", "0X8004930", "0X8004930", 0, 0, "", "", "", "");
                        if (QLog.isColorLevel()) {
                            QLog.e("qqdataline", 2, "forwardImage shareFromMigSdk|report send multi pic:0X8004930.");
                        }
                    } else if (arrayList.size() == 1) {
                        ReportController.o(this.f411306a, "CliOper", "", "", "0X800492F", "0X800492F", 0, 0, "", "", "", "");
                        if (QLog.isColorLevel()) {
                            QLog.e("qqdataline", 2, "forwardImage shareFromMigSdk|report single pics:0X800492F.");
                        }
                    }
                }
                if (l(arrayList, 1, i3, z16, cVar) == 0 || z17) {
                    return 0;
                }
                return 8;
            }
            if (!z17) {
                return 4;
            }
            return 0;
        }
        QLog.e(f411305b, 2, "forwardPhoto. path=null");
        return 4;
    }

    private int f(String str, int i3, boolean z16, c cVar) {
        if (str != null && str.length() > 0) {
            if (cg.f307525d.matcher(str).find()) {
                s.a(this.f411306a.getApplication().getApplicationContext(), this.f411306a.getCurrentAccountUin(), "dl_forwardin_link");
            } else {
                s.a(this.f411306a.getApplication().getApplicationContext(), this.f411306a.getCurrentAccountUin(), "dl_forwardin_text");
            }
            return m(str, i3, z16, cVar);
        }
        return 4;
    }

    private long g(ArrayList<String> arrayList) {
        long j3 = 0;
        if (arrayList == null) {
            return 0L;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null) {
                j3 += new VFSFile(next).length();
            }
        }
        return j3;
    }

    public static void j(Context context, int i3) {
        if (i3 != 0) {
            if (i3 != 2 && i3 != 4) {
                if (i3 != 8) {
                    if (i3 == 9) {
                        p(R.string.cjm, 0);
                        return;
                    }
                    return;
                }
                q(HardCodeUtil.qqStr(R.string.lnb), 1);
                return;
            }
            n(context, R.string.f171085c51);
            return;
        }
        p(R.string.f170969bc3, 2);
    }

    private int l(ArrayList<String> arrayList, int i3, int i16, boolean z16, c cVar) {
        if (arrayList == null) {
            if (QLog.isColorLevel()) {
                QLog.d(f411305b, 2, "sendMultipleFile paths is null !!!!!!");
            }
            if (cVar != null) {
                cVar.c();
                return 268;
            }
            return 268;
        }
        if (z16) {
            String str = "";
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                ReportController.o(this.f411306a, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
                str = str + "sendMultipleFile shareFromMigSdk|report send one from sdk:0X800492D.";
            }
            if (QLog.isColorLevel()) {
                QLog.e("qqdataline", 2, str);
            }
        }
        AsyncTaskC10622a asyncTaskC10622a = new AsyncTaskC10622a(arrayList, i16);
        long g16 = g(arrayList);
        if (g16 == 0) {
            if (cVar != null) {
                cVar.d();
                return 128;
            }
            return 128;
        }
        if (NetworkUtil.isNetworkAvailable(this.f411306a.getApp()) && !NetworkUtil.isWifiConnected(this.f411306a.getApp()) && g16 > 3145728) {
            if (cVar != null) {
                cVar.b(asyncTaskC10622a, i3);
                return 512;
            }
            return 512;
        }
        asyncTaskC10622a.execute(Integer.valueOf(i3));
        return 0;
    }

    private int m(String str, int i3, boolean z16, c cVar) {
        if (TextUtils.isEmpty(str)) {
            if (cVar != null) {
                cVar.e();
                return 32;
            }
            return 32;
        }
        if (str.length() > 3478) {
            if (cVar != null) {
                cVar.f();
                return 64;
            }
            return 64;
        }
        if (z16) {
            ReportController.o(this.f411306a, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
                QLog.e("qqdataline", 2, "sendTextMessage shareFromMigSdk|report send one from sdk:0X800492D.");
            }
        }
        ((DataLineHandler) this.f411306a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).X2(str, i3);
        return 0;
    }

    public static void n(Context context, int i3) {
        QQToast qQToast = new QQToast(context);
        qQToast.setToastIcon(R.drawable.hac);
        qQToast.setDuration(2000);
        qQToast.setToastMsg(i3);
        qQToast.show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height) - ((int) al.a(context, 5.0f)));
    }

    public static void o(Context context, AsyncTask<Integer, Integer, String> asyncTask, int i3, FMDialogUtil.c cVar) {
        FMDialogUtil.a(context, R.string.b_v, R.string.f170958ba0, new b(asyncTask, i3, cVar));
    }

    public static void p(int i3, int i16) {
        String string = BaseApplicationImpl.getApplication().getBaseContext().getResources().getString(i3);
        if (string != null && string.length() > 0) {
            q(string, i16);
        }
    }

    public static void q(String str, int i3) {
        Context baseContext = BaseApplicationImpl.getApplication().getBaseContext();
        QQToast.makeText(baseContext, i3, str, 1).show(baseContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height) - ((int) al.a(baseContext, 5.0f)));
    }

    public boolean c(FileManagerEntity fileManagerEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 0);
        bundle.putBoolean("not_forward", true);
        bundle.putInt("dataline_forward_type", 100);
        bundle.putString("dataline_forward_path", fileManagerEntity.getFilePath());
        bundle.putParcelable("fileinfo", ForwardFileOption.U(fileManagerEntity));
        if (r(AppConstants.DATALINE_PC_UIN, bundle, null) != 0) {
            return false;
        }
        return true;
    }

    public int h(String str, Bundle bundle, c cVar) {
        int i3;
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            return 9;
        }
        int i16 = bundle.getInt("dataline_forward_type", -1);
        ArrayList<String> stringArrayList = bundle.getStringArrayList("dataline_forward_pathlist");
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("fileinfo_array");
        boolean z16 = bundle.getBoolean("isMigSdkShare", false);
        DataLineHandler dataLineHandler = (DataLineHandler) this.f411306a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        String str2 = AppConstants.DATALINE_PC_UIN;
        if (str2.equalsIgnoreCase(str)) {
            dataLineHandler.f194549h = str2;
            dataLineHandler.f194551i = 0;
        } else {
            String str3 = AppConstants.DATALINE_IPAD_UIN;
            if (str3.equalsIgnoreCase(str)) {
                dataLineHandler.f194549h = str3;
                dataLineHandler.f194551i = 1;
            } else {
                return 8;
            }
        }
        int i17 = dataLineHandler.f194551i;
        if (i16 == -1) {
            return 2;
        }
        if (i16 == 100) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        int i18 = 4;
        if (stringArrayList == null) {
            if (parcelableArrayList == null) {
                parcelableArrayList = null;
            }
            if (parcelableArrayList == null) {
                return 4;
            }
            ArrayList<DataLineMsgRecord> arrayList = new ArrayList<>();
            Iterator it = parcelableArrayList.iterator();
            boolean z17 = false;
            while (it.hasNext()) {
                ForwardFileInfo forwardFileInfo = (ForwardFileInfo) it.next();
                if (!d(bundle, forwardFileInfo, i16, i17)) {
                    DataLineMsgRecord a16 = a(forwardFileInfo, false, i17);
                    if (a16 != null) {
                        if (DataLineMsgSet.isSingle(a16)) {
                            ArrayList<DataLineMsgRecord> arrayList2 = new ArrayList<>();
                            arrayList2.add(a16);
                            dataLineHandler.r4(arrayList2, false);
                        } else {
                            arrayList.add(a16);
                        }
                    }
                }
                z17 = true;
            }
            if (arrayList.size() > 0) {
                dataLineHandler.r4(arrayList, false);
            } else if (!z17) {
                return 4;
            }
            return 0;
        }
        Iterator<String> it5 = stringArrayList.iterator();
        while (it5.hasNext()) {
            String next = it5.next();
            if (next == null || next.equals("/")) {
                it5.remove();
            }
        }
        if (!stringArrayList.isEmpty() && (i18 = l(stringArrayList, i3, i17, z16, cVar)) == 0) {
            return 0;
        }
        return i18;
    }

    public void i() {
        this.f411306a = null;
    }

    public boolean k(DataLineMsgRecord dataLineMsgRecord, int i3, int i16) {
        boolean z16 = false;
        if (dataLineMsgRecord == null) {
            QLog.e(f411305b, 1, "reForwardOfflineFile msg=null ");
            return false;
        }
        int i17 = dataLineMsgRecord.nOpType;
        if (i17 == 31) {
            TroopFileTransferManager.O(this.f411306a, dataLineMsgRecord.uOwnerUin).u0(i16, dataLineMsgRecord.uOwnerUin, dataLineMsgRecord.busId, Long.valueOf(dataLineMsgRecord.selfuin).longValue(), dataLineMsgRecord.istroop, dataLineMsgRecord.filename, dataLineMsgRecord.thumbPath, dataLineMsgRecord.filesize, dataLineMsgRecord.fileUuid, true, dataLineMsgRecord.sessionid, FileManagerUtil.getDatalineProcessCallBack(this.f411306a, i3));
            dataLineMsgRecord.fileMsgStatus = 0L;
            dataLineMsgRecord.issuc = true;
        } else {
            if (i17 == 29) {
                if (this.f411306a.getFileManagerEngine().x(3, dataLineMsgRecord.trans2Entity(), i3)) {
                    dataLineMsgRecord.fileMsgStatus = 0L;
                    dataLineMsgRecord.issuc = true;
                }
            }
            if (3 != dataLineMsgRecord.fileFrom && !TextUtils.isEmpty(dataLineMsgRecord.fileUuid)) {
                ((DataLineHandler) this.f411306a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).q4(dataLineMsgRecord, true);
                return true;
            }
            return z16;
        }
        z16 = true;
        if (3 != dataLineMsgRecord.fileFrom) {
        }
        return z16;
    }

    public int r(String str, Bundle bundle, c cVar) {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            return 9;
        }
        int i3 = bundle.getInt("dataline_forward_type", -1);
        String string = bundle.getString("dataline_forward_path");
        String string2 = bundle.getString("dataline_forward_text");
        boolean z16 = bundle.getBoolean("isMigSdkShare", false);
        ForwardFileInfo forwardFileInfo = (ForwardFileInfo) bundle.getParcelable("fileinfo");
        DataLineHandler dataLineHandler = (DataLineHandler) this.f411306a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        String str2 = AppConstants.DATALINE_PC_UIN;
        if (str2.equalsIgnoreCase(str)) {
            dataLineHandler.f194549h = str2;
            dataLineHandler.f194551i = 0;
        } else {
            String str3 = AppConstants.DATALINE_IPAD_UIN;
            if (str3.equalsIgnoreCase(str)) {
                dataLineHandler.f194549h = str3;
                dataLineHandler.f194551i = 1;
            } else {
                String str4 = AppConstants.DATALINE_PHONE_UIN;
                if (str4.equalsIgnoreCase(str)) {
                    dataLineHandler.f194549h = str4;
                    dataLineHandler.f194551i = 2;
                } else {
                    return 8;
                }
            }
        }
        int i16 = dataLineHandler.f194551i;
        if (i3 == -1) {
            return 2;
        }
        if (d(bundle, forwardFileInfo, i3, i16)) {
            return 0;
        }
        if (bundle.getBoolean("filepath_copy", false)) {
            string = QFileUtils.j(string);
        }
        switch (i3) {
            case 100:
                return b(string, i16, z16, cVar);
            case 101:
                return e(string, i16, z16, cVar);
            case 102:
                return f(string2, i16, z16, cVar);
            default:
                s.a(this.f411306a.getApplication().getApplicationContext(), this.f411306a.getCurrentAccountUin(), "dl_forwardin_other");
                return 4;
        }
    }
}
