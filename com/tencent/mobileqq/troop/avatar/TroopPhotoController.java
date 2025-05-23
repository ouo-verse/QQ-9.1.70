package com.tencent.mobileqq.troop.avatar;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import tencent.trpc.qqgroup.GroupFace$UploadRsp;

/* loaded from: classes19.dex */
public class TroopPhotoController implements Observer {
    static IPatchRedirector $redirector_;
    protected static int U;
    public static Uri V;
    protected static final boolean W;
    protected com.tencent.mobileqq.troop.avatar.e C;
    protected Bundle D;
    protected int E;
    protected Handler F;
    protected int G;
    int H;
    protected List<com.tencent.mobileqq.troop.avatar.a> I;
    public ArrayList<TroopClipPic> J;
    protected int K;
    protected String[] L;
    protected int[] M;
    List<d> N;
    WeakReference<f> P;
    WeakReference<e> Q;
    protected TransProcessorHandler R;
    private boolean S;
    com.tencent.mobileqq.troop.api.observer.a T;

    /* renamed from: d, reason: collision with root package name */
    Context f294490d;

    /* renamed from: e, reason: collision with root package name */
    protected Activity f294491e;

    /* renamed from: f, reason: collision with root package name */
    String f294492f;

    /* renamed from: h, reason: collision with root package name */
    protected TroopInfo f294493h;

    /* renamed from: i, reason: collision with root package name */
    protected TroopInfoData f294494i;

    /* renamed from: m, reason: collision with root package name */
    protected AppInterface f294495m;

    /* loaded from: classes19.dex */
    class a extends com.tencent.mobileqq.troop.api.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopPhotoController.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.a
        protected void onCmdTroopAvatar(boolean z16, String str, int i3, String str2, int i16, List<TroopClipPic> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2, Integer.valueOf(i16), list);
            } else {
                if (!Utils.p(str, TroopPhotoController.this.f294492f)) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopPhotoController", 2, String.format("onCmdTroopAvatar result=%d", Integer.valueOf(i3)));
                }
                TroopPhotoController.this.K(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.a
        public void onGetTroopAvatar(boolean z16, String str, int i3, String str2, int i16, List<TroopClipPic> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2, Integer.valueOf(i16), list);
                return;
            }
            TroopPhotoController troopPhotoController = TroopPhotoController.this;
            if (troopPhotoController.f294494i != null && z16 && Utils.p(str, troopPhotoController.f294492f)) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopPhotoController", 2, String.format("onGetTroopAvatar result=%d", Integer.valueOf(i3)));
                }
                if (i3 == 0) {
                    TroopPhotoController.this.K(true);
                }
            }
        }
    }

    /* loaded from: classes19.dex */
    class b extends TransProcessorHandler {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopPhotoController.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            FileMsg fileMsg;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            Object obj = message.obj;
            if ((obj instanceof FileMsg) && (fileMsg = (FileMsg) obj) != null && fileMsg.commandId == 3000) {
                GroupFace$UploadRsp groupFace$UploadRsp = new GroupFace$UploadRsp();
                com.tencent.mobileqq.troop.avatar.a l3 = TroopPhotoController.this.l();
                TroopUploadingThread.b bVar = new TroopUploadingThread.b();
                int i3 = message.what;
                if (i3 != 1002) {
                    if (i3 != 1003) {
                        if (i3 != 1005) {
                            if (i3 != 1008) {
                                return;
                            }
                        } else {
                            TroopPhotoController.this.q(fileMsg, groupFace$UploadRsp, l3, bVar);
                            return;
                        }
                    }
                    TroopPhotoController.this.r(fileMsg, groupFace$UploadRsp, l3, bVar);
                    return;
                }
                TroopPhotoController.this.s(fileMsg, l3, bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class c implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f294515d;

        /* loaded from: classes19.dex */
        class a extends QQPermission.BasePermissionsListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    super.onAllGranted();
                    TroopPhotoController.this.j();
                }
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onDenied(List<String> list, List<Integer> list2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) list, (Object) list2);
                } else {
                    super.onDenied(list, list2);
                }
            }
        }

        c(ActionSheet actionSheet) {
            this.f294515d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopPhotoController.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            TroopPhotoController troopPhotoController = TroopPhotoController.this;
            int[] iArr = troopPhotoController.M;
            if (iArr != null && i3 < iArr.length) {
                int i16 = iArr[i3];
                if (i16 != 13) {
                    if (i16 == 14) {
                        troopPhotoController.J();
                    }
                } else {
                    if (((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isUsingCameraOnVideo(TroopPhotoController.this.f294495m)) {
                        QQToast.makeText(TroopPhotoController.this.f294491e, 0, R.string.f1787437h, 0).show();
                        return;
                    }
                    QQPermission qQPermission = QQPermissionFactory.getQQPermission(TroopPhotoController.this.f294491e, TroopPhotoController.this.m());
                    if (qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) != 0) {
                        qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.CAMERA}, 2, new a());
                    } else {
                        TroopPhotoController.this.j();
                    }
                }
                try {
                    this.f294515d.dismiss();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes19.dex */
    public interface d {
        void B2();

        void C1(int i3);

        void H1(com.tencent.mobileqq.troop.avatar.a aVar, TroopUploadingThread.b bVar);

        void Z(com.tencent.mobileqq.troop.avatar.a aVar);

        void c0(com.tencent.mobileqq.troop.avatar.a aVar);
    }

    /* loaded from: classes19.dex */
    public interface e {
        void Z9(Bundle bundle);
    }

    /* loaded from: classes19.dex */
    public interface f {
        boolean N0(int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28371);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 45)) {
            redirector.redirect((short) 45);
        } else {
            U = 7;
            W = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106198", false);
        }
    }

    public TroopPhotoController(Context context, Activity activity, AppInterface appInterface, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, activity, appInterface, bundle);
            return;
        }
        this.F = new Handler(Looper.getMainLooper());
        this.G = 0;
        this.H = -1;
        this.I = new ArrayList();
        this.J = new ArrayList<>();
        this.K = 0;
        this.N = new ArrayList();
        this.R = new b();
        this.S = false;
        this.T = new a();
        this.f294490d = context;
        this.f294491e = activity;
        this.f294495m = appInterface;
        if (bundle != null) {
            this.D = bundle;
            this.f294492f = bundle.getString("troopUin", "");
            this.E = bundle.getInt("type", 1);
        }
        T();
        com.tencent.mobileqq.troop.avatar.e eVar = new com.tencent.mobileqq.troop.avatar.e(this.f294492f, com.tencent.mobileqq.troop.avatar.f.class, this.f294495m);
        this.C = eVar;
        eVar.b(this);
        this.f294495m.addObserver(this.T, true);
    }

    public static void P(String str) {
        Q(str, 0);
    }

    public static void Q(String str, int i3) {
        QQToast.makeText(BaseApplication.getContext(), i3, str, 1).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(TroopClipPic troopClipPic) {
        if (this.S && W && troopClipPic != null && troopClipPic.type == 0) {
            com.tencent.mobileqq.troop.avatar.a f16 = f(troopClipPic, null);
            for (int i3 = 0; i3 < this.I.size(); i3++) {
                com.tencent.mobileqq.troop.avatar.a aVar = this.I.get(i3);
                if (aVar != null && aVar.f294536h.equals(f16.f294536h) && aVar.f294537i == f16.f294537i && aVar.f294529a.equals(f16.f294529a)) {
                    QLog.i("TroopPhotoController", 1, "[checkToNeedFetchCovers] cover is show, skip fetch");
                    return;
                }
            }
            QLog.i("TroopPhotoController", 1, "[checkToNeedFetchCovers] start fetch");
            this.C.g(this.f294493h.troopuin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.H >= this.I.size()) {
            this.H = this.I.size() - 1;
        }
        if (this.H < 0) {
            return;
        }
        for (int i3 = 0; i3 < this.I.size(); i3++) {
            if (this.H == i3) {
                this.I.get(i3).f294535g = true;
            } else {
                this.I.get(i3).f294535g = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(com.tencent.mobileqq.troop.avatar.a aVar, TroopUploadingThread.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) aVar, (Object) bVar);
            return;
        }
        Iterator<d> it = this.N.iterator();
        while (it.hasNext()) {
            it.next().H1(aVar, bVar);
        }
    }

    public void B(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
            return;
        }
        com.tencent.mobileqq.troop.avatar.a aVar = this.I.get(i3);
        if (((ITroopAvatarUtilApi) QRoute.api(ITroopAvatarUtilApi.class)).isNumeric(aVar.f294530b)) {
            ReportController.o(this.f294495m, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "del_head", 0, 0, this.f294493h.troopuin, "", "", "");
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(Integer.valueOf(aVar.f294530b));
            this.C.c(this.f294493h.troopuin, 2, arrayList);
        }
        this.I.remove(aVar);
        y(aVar);
        ITroopAvatarUtilApi iTroopAvatarUtilApi = (ITroopAvatarUtilApi) QRoute.api(ITroopAvatarUtilApi.class);
        boolean z16 = true;
        if (aVar.f294531c == 1 && !TextUtils.isEmpty(aVar.f294530b) && iTroopAvatarUtilApi.isNumeric(aVar.f294530b)) {
            List<TroopClipPic> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.f294493h.mTroopPicList);
            Iterator<TroopClipPic> it = arrayList2.iterator();
            while (true) {
                if (it.hasNext()) {
                    TroopClipPic next = it.next();
                    if (aVar.f294530b.equals(next.f203184id)) {
                        arrayList2.remove(next);
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (z16) {
                this.f294493h.updateTroopPicList(arrayList2, "TroopPhotoController-onDeleteItem");
                this.f294493h.mTroopVerifyingPics.remove(aVar.f294530b);
            }
        }
    }

    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        this.C.h(this);
        this.f294495m.removeObserver(this.T);
        this.N.clear();
        com.tencent.mobileqq.troop.helper.a.c().j(this.R);
    }

    public void D(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
        } else {
            this.G = i3;
        }
    }

    public void E(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController", 2, "onInsertAvatarFailed " + i3);
        }
        P(((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getErrText(BaseApplication.getContext(), -1));
        Iterator<com.tencent.mobileqq.troop.avatar.a> it = this.I.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.troop.avatar.a next = it.next();
            if (next.f294531c == 2 || next.f294533e) {
                it.remove();
                y(next);
            }
        }
        this.J.clear();
        this.C.g(this.f294493h.troopuin);
    }

    public void F(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
            return;
        }
        this.H = i3;
        v();
        z(i3);
    }

    public boolean G(String str, String str2) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        boolean z16 = false;
        if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController", 2, String.format("onPicPicked clip=%s path=%s", str2, str));
        }
        if (k(str) || h(str, str2)) {
            return false;
        }
        TroopClipPic g16 = g(str, str2);
        if (this.I.size() >= 7) {
            return false;
        }
        f fVar = null;
        com.tencent.mobileqq.troop.avatar.a f16 = f(g16, null);
        this.I.add(f16);
        this.J.add(g16);
        w(f16);
        if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController", 2, String.format("onPicPicked uploadPaths=[size=%d, %s]", Integer.valueOf(this.J.size()), Arrays.toString(this.I.toArray())));
        }
        WeakReference<f> weakReference = this.P;
        if (weakReference != null) {
            fVar = weakReference.get();
        }
        if (fVar != null && fVar.N0(this.K)) {
            z16 = true;
        }
        if (!z16) {
            R();
        }
        AppInterface appInterface = this.f294495m;
        TroopInfo troopInfo = this.f294493h;
        if (troopInfo == null) {
            str3 = "";
        } else {
            str3 = troopInfo.troopuin;
        }
        ReportController.o(appInterface, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, str3, "", "", "");
        return true;
    }

    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (this.f294491e == null) {
            return;
        }
        boolean z16 = false;
        int i3 = 0;
        if ((this.f294494i.dwGroupFlagExt & 2048) == 0 && this.G <= 0) {
            if (this.M == null) {
                this.M = new int[U];
            }
            int[] iArr = this.M;
            iArr[0] = 13;
            iArr[1] = 14;
            iArr[2] = 16;
            for (int i16 = 3; i16 < U; i16++) {
                this.M[i16] = -1;
            }
            if (this.L == null) {
                this.L = this.f294491e.getResources().getStringArray(R.array.f155206av);
            }
            ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.f294491e, null);
            while (true) {
                int[] iArr2 = this.M;
                if (i3 < iArr2.length) {
                    int i17 = iArr2[i3];
                    if (i17 == 16) {
                        actionSheet.addCancelButton(this.L[i17]);
                    } else if (i17 >= 0) {
                        String[] strArr = this.L;
                        if (i17 < strArr.length) {
                            actionSheet.addButton(strArr[i17], 1);
                        }
                    }
                    i3++;
                } else {
                    actionSheet.setOnButtonClickListener(new c(actionSheet));
                    actionSheet.show();
                    return;
                }
            }
        } else {
            if (this.G > 0) {
                z16 = true;
            }
            e(z16);
            ReportController.o(this.f294495m, "dc00899", "Grp_certified", "", "data", "exp_edit_head", 3, 0, this.f294493h.troopuin, "", "", "");
        }
    }

    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        Uri uri = V;
        if (uri != null) {
            String realPathFromContentURI = BaseImageUtil.getRealPathFromContentURI(this.f294491e, uri);
            if (!TextUtils.isEmpty(realPathFromContentURI)) {
                ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoEdit(this.f294491e, realPathFromContentURI, ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getBusiByType(this.K));
            }
        }
    }

    protected void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoListEdit(this.f294491e, ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getBusiByType(this.K));
        }
    }

    public void K(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController", 2, String.format("onUpdateTroopAvatarWallList bServer=%b", Boolean.valueOf(z16)));
        }
        if (this.f294495m != null) {
            if (z16) {
                T();
            }
            if (this.f294493h != null) {
                ArrayList arrayList = new ArrayList();
                ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getCoverFromDb(arrayList, this.f294493h);
                ArrayList<g> e16 = this.C.e();
                if (e16 != null) {
                    Iterator<g> it = e16.iterator();
                    while (it.hasNext()) {
                        g next = it.next();
                        if (next != null && next.f294554e != 1) {
                            if (arrayList.size() == 7) {
                                it.remove();
                            } else {
                                com.tencent.mobileqq.troop.avatar.a aVar = new com.tencent.mobileqq.troop.avatar.a();
                                aVar.f294529a = next.f294550a;
                                aVar.f294532d = next.f294553d;
                                aVar.f294537i = next.f294554e;
                                aVar.f294531c = 2;
                                aVar.f294533e = true;
                                aVar.f294538j = next.f294555f;
                                aVar.f294536h = next.f294556g;
                                arrayList.add(aVar);
                            }
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopPhotoController", 2, String.format("onUpdateTroopAvatarWallList bserver=%b size=%d info=%s", Boolean.valueOf(z16), Integer.valueOf(arrayList.size()), arrayList.toString()));
                }
                Runnable runnable = new Runnable(arrayList) { // from class: com.tencent.mobileqq.troop.avatar.TroopPhotoController.10
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ List f294496d;

                    {
                        this.f294496d = arrayList;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopPhotoController.this, (Object) arrayList);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        TroopPhotoController.this.I.clear();
                        TroopPhotoController.this.I.addAll(this.f294496d);
                        TroopPhotoController.this.v();
                        TroopPhotoController.this.x();
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    runnable.run();
                } else {
                    this.F.post(runnable);
                }
            }
        }
    }

    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
            return;
        }
        TroopInfo troopInfo = this.f294493h;
        if (troopInfo != null && this.f294495m != null) {
            this.D.putString(IProfileProtocolConst.PARAM_TROOP_CODE, troopInfo.troopcode);
            this.D.putString("uin", this.f294495m.getCurrentAccountUin());
            this.D.putString("pUin", this.f294495m.getCurrentAccountUin());
            QLog.d("TroopPhotoController", 4, "troopCode:" + this.f294493h.troopcode + " uin and pUin:" + this.f294495m.getCurrentAccountUin());
        }
    }

    public void M(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.S = z16;
        }
    }

    public void N(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) eVar);
        } else if (eVar != null) {
            this.Q = new WeakReference<>(eVar);
        }
    }

    public void O(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) fVar);
        } else if (fVar != null) {
            this.P = new WeakReference<>(fVar);
        }
    }

    public void R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
        } else {
            L();
            com.tencent.mobileqq.troop.helper.a.c().k(this.J, this.D, StatisticCollector.QTROOP_AVATAR_UPLOAD_STATISTIC_TAG);
        }
    }

    protected boolean S(int i3, com.tencent.mobileqq.troop.avatar.a aVar) {
        ITroopInfoService iTroopInfoService;
        TroopInfo findTroopInfo;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) aVar)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController", 2, String.format("update2DB picId=%d info=%s", Integer.valueOf(i3), aVar));
        }
        if (this.E == 2) {
            return false;
        }
        String valueOf = String.valueOf(i3);
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        boolean z16 = false;
        for (com.tencent.mobileqq.troop.avatar.a aVar2 : this.I) {
            if (aVar2 != null) {
                String str = aVar2.f294530b;
                try {
                    i16 = Integer.parseInt(str);
                } catch (NumberFormatException unused) {
                    i16 = -1;
                }
                if (str != null && i16 >= 0) {
                    if (aVar2.f294531c == 1) {
                        TroopClipPic troopClipPic = new TroopClipPic();
                        troopClipPic.f203184id = str;
                        troopClipPic.clipInfo = aVar2.f294536h;
                        troopClipPic.type = aVar2.f294537i;
                        arrayList.add(troopClipPic);
                        if (aVar2.f294534f) {
                            hashSet.add(str);
                        }
                    }
                    if (str.equals(valueOf)) {
                        z16 = true;
                    }
                }
            }
        }
        if (z16) {
            this.I.remove(aVar);
            y(aVar);
            return false;
        }
        aVar.f294530b = String.valueOf(i3);
        aVar.f294531c = 1;
        aVar.f294533e = false;
        TroopClipPic troopClipPic2 = new TroopClipPic();
        troopClipPic2.f203184id = aVar.f294530b;
        troopClipPic2.type = aVar.f294537i;
        troopClipPic2.clipInfo = aVar.f294536h;
        arrayList.add(troopClipPic2);
        if (aVar.f294534f) {
            hashSet.add(aVar.f294530b);
        }
        AppInterface appInterface = this.f294495m;
        if (appInterface != null && (iTroopInfoService = (ITroopInfoService) appInterface.getRuntimeService(ITroopInfoService.class, "")) != null && (findTroopInfo = iTroopInfoService.findTroopInfo(String.valueOf(this.f294493h.troopuin))) != null && arrayList.size() > 0) {
            findTroopInfo.updateTroopPicList(arrayList, "TroopPhotoController-update2DB");
            findTroopInfo.mTroopVerifyingPics.clear();
            findTroopInfo.mTroopVerifyingPics.addAll(hashSet);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        if (this.E == 1) {
            TroopInfo findTroopInfo = ((ITroopInfoService) this.f294495m.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(this.f294492f));
            this.f294493h = findTroopInfo;
            if (findTroopInfo == null) {
                this.f294493h = new TroopInfo(this.f294492f);
            }
        } else {
            this.f294493h = new TroopInfo(this.f294492f);
        }
        TroopInfoData troopInfoData = new TroopInfoData();
        this.f294494i = troopInfoData;
        troopInfoData.troopUin = this.f294492f;
        troopInfoData.updateForTroopChatSetting(this.f294493h, this.f294490d.getResources(), this.f294495m.getCurrentAccountUin());
    }

    public void c(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) dVar);
        } else if (!this.N.contains(dVar)) {
            this.N.add(dVar);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
        } else {
            com.tencent.mobileqq.troop.helper.a.c().a(this.f294495m, this.R);
        }
    }

    public void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, z16);
            return;
        }
        Activity activity = this.f294491e;
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
        createCustomDialog.setTitle((String) null);
        if (z16) {
            createCustomDialog.setMessage(activity.getResources().getString(R.string.bu7));
        } else {
            createCustomDialog.setMessage(activity.getResources().getString(R.string.bu6));
        }
        createCustomDialog.setPositiveButton(activity.getResources().getString(R.string.buu), new DialogUtil.DialogOnClickAdapter());
        createCustomDialog.setPositiveButtonContentDescription(activity.getResources().getString(R.string.buu));
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public com.tencent.mobileqq.troop.avatar.a f(TroopClipPic troopClipPic, @Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (com.tencent.mobileqq.troop.avatar.a) iPatchRedirector.redirect((short) 20, (Object) this, (Object) troopClipPic, (Object) str);
        }
        com.tencent.mobileqq.troop.avatar.a aVar = new com.tencent.mobileqq.troop.avatar.a();
        aVar.f294529a = troopClipPic.f203184id;
        aVar.f294536h = troopClipPic.clipInfo;
        aVar.f294531c = 2;
        aVar.f294533e = true;
        aVar.f294530b = str;
        aVar.f294537i = troopClipPic.type;
        aVar.f294538j = troopClipPic.f203185ts;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public TroopClipPic g(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (TroopClipPic) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, (Object) str2);
        }
        TroopClipPic troopClipPic = new TroopClipPic();
        troopClipPic.f203184id = str;
        troopClipPic.clipInfo = str2;
        troopClipPic.type = this.K;
        troopClipPic.f203185ts = SystemClock.uptimeMillis();
        return troopClipPic;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h(String str, String str2) {
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        boolean z16 = false;
        if (((ITroopCardApi) QRoute.api(ITroopCardApi.class)).isInstanceOfTroopAvatarWallEditActivity(this.f294491e)) {
            return false;
        }
        WeakReference<e> weakReference = this.Q;
        if (weakReference != null) {
            eVar = weakReference.get();
        } else {
            eVar = null;
        }
        if (eVar != null) {
            Bundle bundle = new Bundle();
            bundle.putString("PhotoConst.SINGLE_PHOTO_PATH", str);
            bundle.putString(ITroopPhotoUtilsApi.KEY_CLIP_INFO, str2);
            if (this.K == 0) {
                z16 = true;
            }
            bundle.putBoolean("IS_COVER", z16);
            bundle.putBoolean("IS_EDIT", true);
            eVar.Z9(bundle);
        }
        return true;
    }

    protected void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            V = ((ITroopCardApi) QRoute.api(ITroopCardApi.class)).profileCardUtils_enterSnapshot(this.f294491e, 257);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean k(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) str)).booleanValue();
        }
        TroopInfo troopInfo = this.f294493h;
        if (troopInfo == null) {
            return false;
        }
        int i3 = troopInfo.troopTypeExt;
        if (i3 == 2 || i3 == 3 || i3 == 4) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            if (options.outWidth < 100 || options.outHeight < 100) {
                QQToast.makeText(this.f294491e, R.string.eiq, 1).show();
                return true;
            }
        }
        return false;
    }

    public com.tencent.mobileqq.troop.avatar.a l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (com.tencent.mobileqq.troop.avatar.a) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        List<com.tencent.mobileqq.troop.avatar.a> list = this.I;
        if (list != null && !list.isEmpty()) {
            return this.I.get(r0.size() - 1);
        }
        return null;
    }

    public BusinessConfig m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (BusinessConfig) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return new BusinessConfig(QQPermissionConstants.Business.ID.QQ_TROOP, QQPermissionConstants.Business.SCENE.QQ_TROOP_PHOTO);
    }

    @NonNull
    public List<com.tencent.mobileqq.troop.avatar.a> n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (List) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return this.I;
    }

    protected com.tencent.mobileqq.troop.avatar.a o(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (com.tencent.mobileqq.troop.avatar.a) iPatchRedirector.redirect((short) 41, (Object) this, j3);
        }
        for (com.tencent.mobileqq.troop.avatar.a aVar : this.I) {
            if (aVar.f294538j == j3) {
                return aVar;
            }
        }
        return null;
    }

    @NonNull
    protected Runnable p(GroupFace$UploadRsp groupFace$UploadRsp, com.tencent.mobileqq.troop.avatar.a aVar, TroopUploadingThread.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Runnable) iPatchRedirector.redirect((short) 3, this, groupFace$UploadRsp, aVar, bVar);
        }
        return new Runnable(groupFace$UploadRsp, aVar, bVar) { // from class: com.tencent.mobileqq.troop.avatar.TroopPhotoController.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ GroupFace$UploadRsp f294500d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.troop.avatar.a f294501e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ TroopUploadingThread.b f294502f;

            {
                this.f294500d = groupFace$UploadRsp;
                this.f294501e = aVar;
                this.f294502f = bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopPhotoController.this, groupFace$UploadRsp, aVar, bVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                TroopClipPic troopClipPic;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                int i3 = this.f294500d.seq.get();
                com.tencent.mobileqq.troop.avatar.a aVar2 = this.f294501e;
                aVar2.f294533e = false;
                aVar2.f294531c = 1;
                aVar2.f294534f = false;
                TroopPhotoController.this.t(aVar2);
                if ((i3 & Integer.MAX_VALUE) != 0) {
                    TroopPhotoController.this.S(this.f294502f.f294521b, this.f294501e);
                }
                Iterator<TroopClipPic> it = TroopPhotoController.this.J.iterator();
                while (true) {
                    if (it.hasNext()) {
                        troopClipPic = it.next();
                        if (troopClipPic.f203185ts == this.f294501e.f294538j) {
                            TroopPhotoController.this.J.remove(troopClipPic);
                            break;
                        }
                    } else {
                        troopClipPic = null;
                        break;
                    }
                }
                TroopPhotoController.this.A(this.f294501e, this.f294502f);
                TroopPhotoController.this.i(troopClipPic);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(FileMsg fileMsg, GroupFace$UploadRsp groupFace$UploadRsp, com.tencent.mobileqq.troop.avatar.a aVar, TroopUploadingThread.b bVar) {
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, fileMsg, groupFace$UploadRsp, aVar, bVar);
            return;
        }
        com.tencent.mobileqq.troop.helper.a.c().h(fileMsg, groupFace$UploadRsp, bVar);
        byte[] bArr = fileMsg.bdhExtendInfo;
        if (bArr != null && bArr.length != 0) {
            i3 = groupFace$UploadRsp.err_code.get();
        } else {
            i3 = -1;
        }
        bVar.f294521b = i3;
        ReportController.o(this.f294495m, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "upload_head_cancel", 0, 0, this.f294493h.troopuin, String.valueOf(i3), "", "");
        if (TextUtils.isEmpty(bVar.f294526g)) {
            str = ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getErrText(this.f294491e, bVar.f294521b);
        } else {
            str = bVar.f294526g;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController", 2, String.format("handleUploadError result=%d info=%s", Integer.valueOf(bVar.f294521b), aVar));
        }
        this.F.post(new Runnable(str) { // from class: com.tencent.mobileqq.troop.avatar.TroopPhotoController.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f294497d;

            {
                this.f294497d = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopPhotoController.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                TroopPhotoController troopPhotoController = TroopPhotoController.this;
                troopPhotoController.C.g(troopPhotoController.f294493h.troopuin);
                TroopPhotoController troopPhotoController2 = TroopPhotoController.this;
                if (troopPhotoController2.E != 2) {
                    troopPhotoController2.x();
                }
                TroopPhotoController.P(this.f294497d);
            }
        });
    }

    protected void r(FileMsg fileMsg, GroupFace$UploadRsp groupFace$UploadRsp, com.tencent.mobileqq.troop.avatar.a aVar, TroopUploadingThread.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, fileMsg, groupFace$UploadRsp, aVar, bVar);
            return;
        }
        if (aVar == null) {
            return;
        }
        com.tencent.mobileqq.troop.helper.a.c().h(fileMsg, groupFace$UploadRsp, bVar);
        String str = groupFace$UploadRsp.file_name.get();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.mobileqq.troop.helper.a.c().i(bVar, str);
        bVar.f294520a = 1;
        this.F.post(p(groupFace$UploadRsp, aVar, bVar));
        ThreadManagerV2.excute(new Runnable(bVar, aVar) { // from class: com.tencent.mobileqq.troop.avatar.TroopPhotoController.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TroopUploadingThread.b f294498d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.troop.avatar.a f294499e;

            {
                this.f294498d = bVar;
                this.f294499e = aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopPhotoController.this, bVar, aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).cacheFileFromLocal(this.f294498d.f294521b, this.f294499e.f294529a, TroopPhotoController.this.f294493h.troopuin);
                }
            }
        }, 32, null, true);
    }

    protected void s(FileMsg fileMsg, com.tencent.mobileqq.troop.avatar.a aVar, TroopUploadingThread.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, fileMsg, aVar, bVar);
            return;
        }
        int i3 = (int) ((fileMsg.transferedSize * 100) / fileMsg.fileSize);
        if (aVar != null) {
            aVar.f294532d = i3;
        }
        bVar.f294520a = 0;
        bVar.f294521b = i3;
        this.F.post(new Runnable(aVar, bVar) { // from class: com.tencent.mobileqq.troop.avatar.TroopPhotoController.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.troop.avatar.a f294503d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ TroopUploadingThread.b f294504e;

            {
                this.f294503d = aVar;
                this.f294504e = bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopPhotoController.this, aVar, bVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    TroopPhotoController.this.A(this.f294503d, this.f294504e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(com.tencent.mobileqq.troop.avatar.a aVar) {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVar);
            return;
        }
        TroopInfo findTroopInfo = ((ITroopInfoService) this.f294495m.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.f294493h.troopuin);
        if (findTroopInfo != null) {
            int i3 = findTroopInfo.troopTypeExt;
            if ((i3 == 2 || i3 == 4) && findTroopInfo.isOwnerOrAdmin()) {
                aVar.f294534f = true;
                if (!this.f294495m.getPreferences().getBoolean("has_shown_same_city_picture_uploaded_dialog", false) && (activity = this.f294491e) != null && !activity.isFinishing()) {
                    Activity activity2 = this.f294491e;
                    DialogUtil.createCustomDialog(activity2, 230, (String) null, activity2.getString(R.string.dpx), (String) null, this.f294491e.getString(R.string.dpn), new DialogUtil.DialogOnClickAdapter(), (DialogInterface.OnClickListener) null).show();
                    this.f294495m.getPreferences().edit().putBoolean("has_shown_same_city_picture_uploaded_dialog", true).commit();
                }
            }
        }
    }

    protected boolean u(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        if (this.J.size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        com.tencent.mobileqq.troop.avatar.a o16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) observable, obj);
            return;
        }
        if (obj == null || !(obj instanceof TroopUploadingThread.b)) {
            return;
        }
        TroopUploadingThread.b bVar = (TroopUploadingThread.b) obj;
        if (bVar.f294524e != this.K || (o16 = o(bVar.f294523d)) == null) {
            return;
        }
        int i3 = bVar.f294520a;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ReportController.o(this.f294495m, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "upload_head_cancel", 0, 0, this.f294493h.troopuin, String.valueOf(bVar.f294521b), "", "");
                    if (TextUtils.isEmpty(bVar.f294526g)) {
                        str = ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getErrText(this.f294491e, bVar.f294521b);
                    } else {
                        str = bVar.f294526g;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopPhotoController", 2, String.format("update() failed info=%s", o16));
                    }
                    this.F.post(new Runnable(o16, bVar, str) { // from class: com.tencent.mobileqq.troop.avatar.TroopPhotoController.8
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ com.tencent.mobileqq.troop.avatar.a f294510d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ TroopUploadingThread.b f294511e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ String f294512f;

                        {
                            this.f294510d = o16;
                            this.f294511e = bVar;
                            this.f294512f = str;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, TroopPhotoController.this, o16, bVar, str);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            TroopPhotoController troopPhotoController = TroopPhotoController.this;
                            if (!troopPhotoController.u(troopPhotoController.f294493h.troopuin)) {
                                TroopPhotoController troopPhotoController2 = TroopPhotoController.this;
                                troopPhotoController2.C.g(troopPhotoController2.f294493h.troopuin);
                            }
                            Iterator<TroopClipPic> it = TroopPhotoController.this.J.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                TroopClipPic next = it.next();
                                if (next.f203185ts == this.f294510d.f294538j) {
                                    TroopPhotoController.this.J.remove(next);
                                    break;
                                }
                            }
                            TroopPhotoController.this.I.remove(this.f294510d);
                            TroopPhotoController.this.y(this.f294510d);
                            TroopPhotoController.this.A(this.f294510d, this.f294511e);
                            TroopPhotoController.P(this.f294512f);
                        }
                    });
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopPhotoController", 2, String.format("update() suc state.result=%d newSeq=%d info=%s", Integer.valueOf(bVar.f294521b), Integer.valueOf(bVar.f294522c), o16));
            }
            int i16 = bVar.f294521b;
            this.F.post(new Runnable(bVar, o16, i16) { // from class: com.tencent.mobileqq.troop.avatar.TroopPhotoController.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ TroopUploadingThread.b f294507d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.troop.avatar.a f294508e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f294509f;

                {
                    this.f294507d = bVar;
                    this.f294508e = o16;
                    this.f294509f = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopPhotoController.this, bVar, o16, Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int i17 = this.f294507d.f294522c;
                    com.tencent.mobileqq.troop.avatar.a aVar = this.f294508e;
                    aVar.f294533e = false;
                    aVar.f294531c = 1;
                    aVar.f294534f = false;
                    TroopPhotoController.this.t(aVar);
                    int i18 = i17 & Integer.MAX_VALUE;
                    if (i18 < 0 || i18 >= 1) {
                        TroopPhotoController.this.S(this.f294509f, this.f294508e);
                    }
                    Iterator<TroopClipPic> it = TroopPhotoController.this.J.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TroopClipPic next = it.next();
                        if (next.f203185ts == this.f294508e.f294538j) {
                            TroopPhotoController.this.J.remove(next);
                            break;
                        }
                    }
                    TroopPhotoController.this.A(this.f294508e, this.f294507d);
                }
            });
            ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).cacheFileFromLocal(i16, o16.f294529a, this.f294493h.troopuin);
            return;
        }
        o16.f294532d = bVar.f294521b;
        this.F.post(new Runnable(o16, bVar) { // from class: com.tencent.mobileqq.troop.avatar.TroopPhotoController.6
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.troop.avatar.a f294505d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ TroopUploadingThread.b f294506e;

            {
                this.f294505d = o16;
                this.f294506e = bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopPhotoController.this, o16, bVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    TroopPhotoController.this.A(this.f294505d, this.f294506e);
                }
            }
        });
    }

    protected void w(com.tencent.mobileqq.troop.avatar.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) aVar);
            return;
        }
        Iterator<d> it = this.N.iterator();
        while (it.hasNext()) {
            it.next().Z(aVar);
        }
    }

    protected void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        Iterator<d> it = this.N.iterator();
        while (it.hasNext()) {
            it.next().B2();
        }
        if (this.H >= this.I.size()) {
            int size = this.I.size();
            this.H = size;
            z(size);
        }
    }

    protected void y(com.tencent.mobileqq.troop.avatar.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) aVar);
            return;
        }
        Iterator<d> it = this.N.iterator();
        while (it.hasNext()) {
            it.next().c0(aVar);
        }
        if (this.H >= this.I.size()) {
            v();
            z(this.H);
        }
    }

    protected void z(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
            return;
        }
        Iterator<d> it = this.N.iterator();
        while (it.hasNext()) {
            it.next().C1(i3);
        }
    }
}
