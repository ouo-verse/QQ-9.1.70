package com.tencent.mobileqq.emoticonview.ipc.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Pair;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.emoticonview.QueryTask;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public class EmoticonManagerServiceProxy extends AbsEmoRuntimeServiceProxy<IEmoticonManagerService> {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_EMOTICONMANAGER_GETMAGICEMOTICONINFOLIST = "emoticonmanager_getmagicemoticoninfolist";
    public static final String ACTION_EMOTICONMANAGER_GETPROEMOTICONPKGS = "emoticonmanager_getproemoticonpkgs";
    public static final String ACTION_EMOTICONMANAGER_IPSITEINFOFROMBYTES = "emoticonmanager_ipsiteinfofrombytes";
    public static final String ACTION_EMOTICONMANAGER_ISSHOWRECOMMENDTABREDPOINT = "emoticonmanager_isshowrecommendtabredpoint";
    public static final String ACTION_EMOTICONMANAGER_PUSHRECOMMENDEXPOSEINFOTOSP = "emoticonmanager_pushrecommendexposeinfotosp";
    public static final String ACTION_EMOTICONMANAGER_RECORDRECOMMENDEPEXPOSE = "emoticonmanager_recordrecommendepexpose";
    public static final String ACTION_EMOTICONMANAGER_SAVEEMOTICONPACKAGE = "emoticonmanager_saveemoticonpackage";
    public static final String ACTION_EMOTICONMANAGER_SETRECOMMENDEPREDFLAG = "emoticonmanager_setrecommendepredflag";
    public static final String ACTION_EMOTICONMANAGER_SYNCFINDEMOTICONPACKAGE = "emoticonmanager_syncfindemoticonpackage";
    public static final String IPSITEINFOBYTES = "ipSiteInfoBytes";
    public static final String PARAM_BUSINESSIDAIO = "param_businessidaio";
    public static final String PARAM_BUSINESSTYPE = "param_businesstype";
    public static final String PARAM_CLONE = "param_clone";
    public static final String PARAM_EPID = "param_epid";
    public static final String PARAM_ID = "param_id";
    public static final String PARAM_ISFROMCACHE = "param_isfromcache";
    public static final String PARAM_KANDIANBIU = "param_kandianbiu";
    public static final String PARAM_PACKAGE = "param_Package";
    public static final String REDPOINT_RESULT = "redpoint_result";
    private static final String TAG = "EmoticonManagerServiceProxy";
    public static final String VIPIPSITEINFO = "vipipsiteinfo";

    /* renamed from: em, reason: collision with root package name */
    protected EntityManager f204957em;

    public EmoticonManagerServiceProxy(BaseQQAppInterface baseQQAppInterface, EntityManager entityManager) {
        super(baseQQAppInterface, IEmoticonManagerService.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseQQAppInterface, (Object) entityManager);
        } else {
            this.f204957em = entityManager;
        }
    }

    public static EIPCResult checkMatch(AppRuntime appRuntime, String str, Bundle bundle, int i3) {
        if (ACTION_EMOTICONMANAGER_IPSITEINFOFROMBYTES.equals(str)) {
            return onGetIPSiteInfoFromBytes((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOTICONMANAGER_PUSHRECOMMENDEXPOSEINFOTOSP.equals(str)) {
            return onPushRecommendExposeInfoToSP((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOTICONMANAGER_GETPROEMOTICONPKGS.equals(str)) {
            return onGetProEmoticonPkgs((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOTICONMANAGER_ISSHOWRECOMMENDTABREDPOINT.equals(str)) {
            return onIsShowRecommendTabRedPoint((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOTICONMANAGER_SAVEEMOTICONPACKAGE.equals(str)) {
            return onSaveEmoticonPackage((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOTICONMANAGER_GETMAGICEMOTICONINFOLIST.equals(str)) {
            return onGetMagicEmoticonInfoList((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOTICONMANAGER_RECORDRECOMMENDEPEXPOSE.equals(str)) {
            return onRecordRecommendEpExpose((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOTICONMANAGER_SETRECOMMENDEPREDFLAG.equals(str)) {
            return onSetRecommendEpRedFlag((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        if (ACTION_EMOTICONMANAGER_SYNCFINDEMOTICONPACKAGE.equals(str)) {
            return onSyncFindEmoticonPackage((BaseQQAppInterface) appRuntime, str, bundle, i3);
        }
        return null;
    }

    public static EIPCResult onGetIPSiteInfoFromBytes(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        VipIPSiteInfo iPSiteInfoFromBytes = ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).getIPSiteInfoFromBytes(bundle.getByteArray(IPSITEINFOBYTES));
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(VIPIPSITEINFO, iPSiteInfoFromBytes);
        return EIPCResult.createSuccessResult(bundle2);
    }

    public static EIPCResult onGetMagicEmoticonInfoList(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        List<EmoticonInfo> magicEmoticonInfoList = ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).getMagicEmoticonInfoList(bundle.getInt(PARAM_BUSINESSIDAIO));
        Bundle bundle2 = new Bundle();
        bundle2.putParcelableArrayList(PARAM_PACKAGE, new ArrayList<>(magicEmoticonInfoList));
        return EIPCResult.createSuccessResult(bundle2);
    }

    public static EIPCResult onGetProEmoticonPkgs(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        List<PromotionEmoticonPkg> proEmoticonPkgs = ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).getProEmoticonPkgs(bundle.getBoolean(PARAM_ISFROMCACHE), bundle.getInt(PARAM_BUSINESSTYPE), bundle.getBoolean(PARAM_KANDIANBIU));
        if (proEmoticonPkgs == null) {
            proEmoticonPkgs = new ArrayList<>();
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelableArrayList(PARAM_PACKAGE, new ArrayList<>(proEmoticonPkgs));
        return EIPCResult.createSuccessResult(bundle2);
    }

    public static EIPCResult onIsShowRecommendTabRedPoint(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean(REDPOINT_RESULT, iEmoticonManagerService.isShowRecommendTabRedPoint(bundle.getInt(PARAM_BUSINESSTYPE)));
        return EIPCResult.createSuccessResult(bundle2);
    }

    public static EIPCResult onPushRecommendExposeInfoToSP(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).pushRecommendExposeInfoToSP();
        return EIPCResult.createSuccessResult(null);
    }

    public static EIPCResult onRecordRecommendEpExpose(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).recordRecommendEpExpose((PromotionEmoticonPkg) bundle.getParcelable(PARAM_PACKAGE));
        return EIPCResult.createSuccessResult(null);
    }

    public static EIPCResult onSaveEmoticonPackage(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).saveEmoticonPackage((EmoticonPackage) bundle.getSerializable(PARAM_PACKAGE));
        return EIPCResult.createSuccessResult(null);
    }

    public static EIPCResult onSetRecommendEpRedFlag(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).setRecommendEpRedFlag(bundle.getString("param_id"), bundle.getInt(PARAM_BUSINESSTYPE));
        return EIPCResult.createSuccessResult(null);
    }

    public static EIPCResult onSyncFindEmoticonPackage(BaseQQAppInterface baseQQAppInterface, String str, Bundle bundle, int i3) {
        EmoticonPackage syncFindEmoticonPackageById = ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(bundle.getString(PARAM_EPID), bundle.getInt(PARAM_BUSINESSTYPE));
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable(PARAM_PACKAGE, syncFindEmoticonPackageById);
        return EIPCResult.createSuccessResult(bundle2);
    }

    public void asyncFindEmoticonPackage(String str, int i3, QueryCallback<EmoticonPackage> queryCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), queryCallback);
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((IEmoticonManagerService) t16).asyncFindEmoticonPackage(str, i3, queryCallback);
        } else {
            realAsyncFindEmoticonPackage(str, i3, queryCallback);
        }
    }

    public VipIPSiteInfo getIPSiteInfoFromBytes(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (VipIPSiteInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((IEmoticonManagerService) t16).getIPSiteInfoFromBytes(bArr);
        }
        return getIPSiteInfoFromBytesOtherProcess(bArr);
    }

    public VipIPSiteInfo getIPSiteInfoFromBytesOtherProcess(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (VipIPSiteInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
        }
        if (bArr != null && bArr.length > 0) {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            VipIPSiteInfo createFromParcel = VipIPSiteInfo.CREATOR.createFromParcel(obtain);
            OaidMonitor.parcelRecycle(obtain);
            return createFromParcel;
        }
        QLog.e(TAG, 1, "getIPSiteInfoFromBytes, error data = " + bArr);
        return null;
    }

    public List<EmoticonInfo> getMagicEmoticonInfoList(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((IEmoticonManagerService) t16).getMagicEmoticonInfoList(i3);
        }
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_BUSINESSIDAIO, i3);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOTICONMANAGER_GETMAGICEMOTICONINFOLIST, bundle);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getParcelableArrayList(PARAM_PACKAGE);
        }
        QLog.e(TAG, 4, "getMagicEmoticonInfoList fail.");
        return new ArrayList();
    }

    public List<PromotionEmoticonPkg> getProEmoticonPkgs(boolean z16, int i3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17));
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((IEmoticonManagerService) t16).getProEmoticonPkgs(z16, i3, z17);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(PARAM_ISFROMCACHE, z16);
        bundle.putInt(PARAM_BUSINESSTYPE, i3);
        bundle.putBoolean(PARAM_KANDIANBIU, z17);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOTICONMANAGER_GETPROEMOTICONPKGS, bundle);
        if (callServer != null && callServer.isSuccess()) {
            callServer.data.setClassLoader(EmoticonPackage.class.getClassLoader());
            return callServer.data.getParcelableArrayList(PARAM_PACKAGE);
        }
        QLog.e(TAG, 4, "getProEmoticonPkgs fail.");
        return null;
    }

    public boolean isShowFavTabRedPoint(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, i3)).booleanValue();
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((IEmoticonManagerService) t16).isShowFavTabRedPoint(i3);
        }
        return false;
    }

    public boolean isShowRecommendTabRedPoint(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((IEmoticonManagerService) t16).isShowRecommendTabRedPoint(i3);
        }
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_BUSINESSTYPE, i3);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOTICONMANAGER_ISSHOWRECOMMENDTABREDPOINT, bundle);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getBoolean(REDPOINT_RESULT);
        }
        QLog.e(TAG, 4, "isShowRecommendTabRedPoint fail.");
        return false;
    }

    public void pushRecommendExposeInfoToSP() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((IEmoticonManagerService) t16).pushRecommendExposeInfoToSP();
            return;
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOTICONMANAGER_PUSHRECOMMENDEXPOSEINFOTOSP, null);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "pushRecommendExposeInfoToSP suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "pushRecommendExposeInfoToSP fail.");
    }

    public void realAsyncFindEmoticonPackage(String str, int i3, QueryCallback<EmoticonPackage> queryCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, Integer.valueOf(i3), queryCallback);
        } else {
            if (this.f204957em == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 4, "em is null.");
                    return;
                }
                return;
            }
            new QueryTask(new QueryTask.Query<Pair<String, Integer>, EmoticonPackage>(str, i3) { // from class: com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$businessType;
                final /* synthetic */ String val$epId;

                {
                    this.val$epId = str;
                    this.val$businessType = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, EmoticonManagerServiceProxy.this, str, Integer.valueOf(i3));
                    }
                }

                @Override // com.tencent.mobileqq.emoticonview.QueryTask.Query
                public EmoticonPackage query(Pair<String, Integer> pair) {
                    int i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (EmoticonPackage) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) pair);
                    }
                    EmoticonPackage emoticonPackage = (EmoticonPackage) DBMethodProxy.find(EmoticonManagerServiceProxy.this.f204957em, (Class<? extends Entity>) EmoticonPackage.class, this.val$epId);
                    if (emoticonPackage == null || (i16 = this.val$businessType) == -1) {
                        return emoticonPackage;
                    }
                    if (i16 == 0) {
                        if (emoticonPackage.aio) {
                            return emoticonPackage;
                        }
                        return null;
                    }
                    if (i16 != 1 || emoticonPackage.kandian) {
                        return emoticonPackage;
                    }
                    return null;
                }
            }, queryCallback).execute(new Pair(str, Integer.valueOf(i3)));
        }
    }

    public List<Emoticon> realSyncGetSubEmoticonsByPackageId(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (List) iPatchRedirector.redirect((short) 18, this, str, Boolean.valueOf(z16));
        }
        EntityManager entityManager = this.f204957em;
        if (entityManager == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "em is null.");
                return null;
            }
            return null;
        }
        ArrayList arrayList = (ArrayList) entityManager.query(Emoticon.class, false, "epId=?", new String[]{str}, null, null, null, null);
        if (arrayList != null && z16) {
            return (List) arrayList.clone();
        }
        return arrayList;
    }

    public List<EmoticonPackage> realSyncGetTabEmoticonPackages(int i3) {
        EmoticonPackage syncFindEmoticonPackageById;
        EmoticonPackage syncFindEmoticonPackageById2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
        ArrayList arrayList = new ArrayList();
        EntityManager entityManager = this.f204957em;
        if (entityManager == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "em is null.");
                return null;
            }
            return null;
        }
        if (i3 != 1 && i3 != 0) {
            return arrayList;
        }
        ArrayList arrayList2 = (ArrayList) entityManager.query(EmoticonTab.class, false, null, null, null, null, null, null);
        ArrayList<String> arrayList3 = new ArrayList();
        ArrayList<String> arrayList4 = new ArrayList();
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                EmoticonTab emoticonTab = (EmoticonTab) it.next();
                if (emoticonTab != null) {
                    if (emoticonTab.aioHave) {
                        arrayList3.add(emoticonTab.epId);
                    }
                    if (emoticonTab.kandianHave) {
                        arrayList4.add(emoticonTab.epId);
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "syncGetTabEmoticonPackages begins, kanDianTabCache.size:" + arrayList4.size() + " tabCache.size:" + arrayList3.size() + " businessType = " + i3);
        }
        if (i3 != 1) {
            for (String str : arrayList3) {
                if (str != null && (syncFindEmoticonPackageById2 = syncFindEmoticonPackageById(str, i3)) != null) {
                    arrayList.add(syncFindEmoticonPackageById2);
                }
            }
        } else {
            for (String str2 : arrayList4) {
                if (str2 != null && (syncFindEmoticonPackageById = syncFindEmoticonPackageById(str2, i3)) != null) {
                    arrayList.add(syncFindEmoticonPackageById);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "syncGetTabEmoticonPackages ends, list.size:" + arrayList.size());
        }
        return arrayList;
    }

    public void recordRecommendEpExpose(PromotionEmoticonPkg promotionEmoticonPkg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) promotionEmoticonPkg);
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((IEmoticonManagerService) t16).recordRecommendEpExpose(promotionEmoticonPkg);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(PARAM_PACKAGE, promotionEmoticonPkg);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOTICONMANAGER_RECORDRECOMMENDEPEXPOSE, bundle);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "recordRecommendEpExpose suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "recordRecommendEpExpose fail.");
    }

    public void saveEmoticonPackage(EmoticonPackage emoticonPackage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) emoticonPackage);
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((IEmoticonManagerService) t16).saveEmoticonPackage(emoticonPackage);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(PARAM_PACKAGE, emoticonPackage);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOTICONMANAGER_SAVEEMOTICONPACKAGE, bundle);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "saveEmoticonPackage suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "saveEmoticonPackage fail.");
    }

    public void setRecommendEpRedFlag(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, i3);
            return;
        }
        T t16 = this.manager;
        if (t16 != 0) {
            ((IEmoticonManagerService) t16).setRecommendEpRedFlag(str, i3);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("param_id", str);
        bundle.putInt(PARAM_BUSINESSTYPE, i3);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "module_emoticon_mainpanel", ACTION_EMOTICONMANAGER_SETRECOMMENDEPREDFLAG, bundle);
        if (callServer != null && callServer.isSuccess()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "setRecommendEpRedFlag suc.");
                return;
            }
            return;
        }
        QLog.e(TAG, 4, "setRecommendEpRedFlag fail.");
    }

    public EmoticonPackage syncFindEmoticonPackageById(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (EmoticonPackage) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((IEmoticonManagerService) t16).syncFindEmoticonPackageById(str);
        }
        return syncFindEmoticonPackageById(str, 0);
    }

    public List<Emoticon> syncGetSubEmoticonsByPackageId(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, this, str, Boolean.valueOf(z16));
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((IEmoticonManagerService) t16).syncGetSubEmoticonsByPackageId(str, z16);
        }
        return realSyncGetSubEmoticonsByPackageId(str, z16);
    }

    public List<EmoticonPackage> syncGetTabEmoticonPackages(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        T t16 = this.manager;
        if (t16 != 0) {
            return ((IEmoticonManagerService) t16).syncGetTabEmoticonPackages(i3);
        }
        return realSyncGetTabEmoticonPackages(i3);
    }

    public EmoticonPackage syncFindEmoticonPackageById(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (EmoticonPackage) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "syncFindEmoticonPackageById epId = " + str + ", type = " + i3);
        }
        EntityManager entityManager = this.f204957em;
        if (entityManager == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "em is null.");
            }
            return null;
        }
        EmoticonPackage emoticonPackage = (EmoticonPackage) DBMethodProxy.find(entityManager, (Class<? extends Entity>) EmoticonPackage.class, str);
        if (emoticonPackage == null || i3 == -1) {
            return emoticonPackage;
        }
        if (i3 == 0) {
            if (emoticonPackage.aio) {
                return emoticonPackage;
            }
            return null;
        }
        if (i3 != 1 || emoticonPackage.kandian) {
            return emoticonPackage;
        }
        return null;
    }
}
