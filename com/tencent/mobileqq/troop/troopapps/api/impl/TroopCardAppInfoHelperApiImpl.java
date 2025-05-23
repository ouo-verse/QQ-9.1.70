package com.tencent.mobileqq.troop.troopapps.api.impl;

import android.os.Bundle;
import com.tencent.biz.m;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0x8d3.oidb_0x8d3$AppInfo;
import tencent.im.oidb.cmd0x8d3.oidb_0x8d3$AppTip;
import tencent.im.oidb.cmd0x8d3.oidb_0x8d3$ReqBody;
import tencent.im.oidb.cmd0x8d3.oidb_0x8d3$RspBody;
import tencent.im.oidb.oidb_0x8cf.oidb_0x8cf$AppBrief;
import tencent.im.oidb.oidb_0x8cf.oidb_0x8cf$ReqBody;
import tencent.im.oidb.oidb_0x8cf.oidb_0x8cf$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopCardAppInfoHelperApiImpl implements ITroopCardAppInfoHelperApi {
    static IPatchRedirector $redirector_ = null;
    public static final String CMD_GET_TROOP_APP_BRIEF_LIST = "OidbSvc.0x8cf_6";
    public static final String CMD_GET_TROOP_APP_INFO_LIST = "OidbSvc.0x8d3_1";
    protected static final String TAG = "TroopCardAppInfoHandler";
    protected ITroopCardAppInfoHelperApi.a mIGetAppInfoCB;
    protected AtomicBoolean mIsDestroy;

    public TroopCardAppInfoHelperApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mIsDestroy = new AtomicBoolean(false);
        }
    }

    private void doOnFailedInMainThread() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopapps.api.impl.TroopCardAppInfoHelperApiImpl.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopCardAppInfoHelperApiImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (!TroopCardAppInfoHelperApiImpl.this.mIsDestroy.get()) {
                    TroopCardAppInfoHelperApiImpl.this.onFailed();
                }
            }
        });
    }

    private void doOnSuccessInMainThread(ArrayList<TroopAppInfo> arrayList) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(arrayList) { // from class: com.tencent.mobileqq.troop.troopapps.api.impl.TroopCardAppInfoHelperApiImpl.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ArrayList f299386d;

            {
                this.f299386d = arrayList;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopCardAppInfoHelperApiImpl.this, (Object) arrayList);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (!TroopCardAppInfoHelperApiImpl.this.mIsDestroy.get()) {
                    TroopCardAppInfoHelperApiImpl.this.onSucess(this.f299386d);
                }
            }
        });
    }

    private void getAppInfoDetail(List<Long> list) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        oidb_0x8d3$ReqBody oidb_0x8d3_reqbody = new oidb_0x8d3$ReqBody();
        oidb_0x8d3_reqbody.rpt_uint64_appidlist.set(list);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2259);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x8d3_reqbody.toByteArray()));
        NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), m.class);
        newIntent.putExtra("cmd", CMD_GET_TROOP_APP_INFO_LIST);
        newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
        newIntent.setObserver(new BusinessObserver() { // from class: com.tencent.mobileqq.troop.troopapps.api.impl.TroopCardAppInfoHelperApiImpl.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopCardAppInfoHelperApiImpl.this);
                }
            }

            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i3, boolean z16, Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                } else {
                    if (TroopCardAppInfoHelperApiImpl.this.mIsDestroy.get()) {
                        return;
                    }
                    ThreadManagerV2.excute(new Runnable(z16, bundle) { // from class: com.tencent.mobileqq.troop.troopapps.api.impl.TroopCardAppInfoHelperApiImpl.4.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f299388d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ Bundle f299389e;

                        {
                            this.f299388d = z16;
                            this.f299389e = bundle;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, AnonymousClass4.this, Boolean.valueOf(z16), bundle);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                TroopCardAppInfoHelperApiImpl.this.handleGetAppInfoDetailRspInNetworkThread(this.f299388d, this.f299389e);
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    }, 128, null, true);
                }
            }
        });
        peekAppRuntime.startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGetAppInfoBriefListRspInNetworkThread(boolean z16, Bundle bundle, boolean z17) {
        if (z16 && bundle != null) {
            byte[] byteArray = bundle.getByteArray("data");
            if (byteArray != null && byteArray.length != 0) {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                try {
                    oidb_sso_oidbssopkg.mergeFrom(byteArray);
                    if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                        ArrayList<Long> parseAppInfoBriefList = parseAppInfoBriefList(oidb_sso_oidbssopkg);
                        if (parseAppInfoBriefList.size() > 0) {
                            if (!z17) {
                                getAppInfoDetail(parseAppInfoBriefList);
                                return;
                            }
                            ArrayList<TroopAppInfo> arrayList = new ArrayList<>();
                            Iterator<Long> it = parseAppInfoBriefList.iterator();
                            while (it.hasNext()) {
                                Long next = it.next();
                                TroopAppInfo troopAppInfo = new TroopAppInfo();
                                troopAppInfo.appId = next.longValue();
                                arrayList.add(troopAppInfo);
                            }
                            doOnSuccessInMainThread(arrayList);
                            return;
                        }
                        doOnFailedInMainThread();
                        return;
                    }
                    doOnFailedInMainThread();
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "handleGetTroopAppBriefList error " + QLog.getStackTraceString(e16));
                    }
                    doOnFailedInMainThread();
                    return;
                }
            }
            QLog.d(TAG, 1, "Empty or null data in response. bundle: " + bundle);
            doOnFailedInMainThread();
            return;
        }
        doOnFailedInMainThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGetAppInfoDetailRspInNetworkThread(boolean z16, Bundle bundle) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg;
        if (z16 && bundle != null) {
            try {
                byte[] byteArray = bundle.getByteArray("data");
                oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom(byteArray);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                ArrayList<TroopAppInfo> parseAppInfoDetail = parseAppInfoDetail(oidb_sso_oidbssopkg);
                if (parseAppInfoDetail.size() > 0) {
                    doOnSuccessInMainThread(parseAppInfoDetail);
                    return;
                }
                doOnFailedInMainThread();
                return;
            }
            doOnFailedInMainThread();
            return;
        }
        doOnFailedInMainThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailed() {
        ITroopCardAppInfoHelperApi.a aVar = this.mIGetAppInfoCB;
        if (aVar != null) {
            aVar.onFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSucess(ArrayList<TroopAppInfo> arrayList) {
        ITroopCardAppInfoHelperApi.a aVar = this.mIGetAppInfoCB;
        if (aVar != null) {
            aVar.onSuccess(arrayList);
        }
    }

    private ArrayList<Long> parseAppInfoBriefList(oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
        oidb_0x8cf$RspBody oidb_0x8cf_rspbody = new oidb_0x8cf$RspBody();
        ArrayList<Long> arrayList = new ArrayList<>();
        try {
            oidb_0x8cf_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
            Iterator<oidb_0x8cf$AppBrief> it = oidb_0x8cf_rspbody.rpt_msg_app_brief.get().iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(it.next().opt_uint64_appid.get()));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return arrayList;
    }

    private ArrayList<TroopAppInfo> parseAppInfoDetail(oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
        ArrayList<TroopAppInfo> arrayList = new ArrayList<>();
        try {
            oidb_0x8d3$RspBody oidb_0x8d3_rspbody = new oidb_0x8d3$RspBody();
            oidb_0x8d3_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
            List<oidb_0x8d3$AppInfo> list = oidb_0x8d3_rspbody.rpt_msg_appinfo_list.get();
            if (list != null && list.size() > 0) {
                for (oidb_0x8d3$AppInfo oidb_0x8d3_appinfo : list) {
                    TroopAppInfo troopAppInfo = new TroopAppInfo();
                    troopAppInfo.appId = oidb_0x8d3_appinfo.opt_uint64_appid.get();
                    troopAppInfo.appName = new String(oidb_0x8d3_appinfo.opt_bytes_appname.get().toByteArray());
                    troopAppInfo.appType = oidb_0x8d3_appinfo.opt_uint32_app_type.get();
                    troopAppInfo.appFrom = oidb_0x8d3_appinfo.opt_uint32_app_from.get();
                    troopAppInfo.appIntro = new String(oidb_0x8d3_appinfo.opt_bytes_app_intro.get().toByteArray());
                    troopAppInfo.appUrl = new String(oidb_0x8d3_appinfo.opt_bytes_app_url.get().toByteArray());
                    troopAppInfo.appIcon = new String(oidb_0x8d3_appinfo.opt_bytes_app_icon.get().toByteArray());
                    troopAppInfo.appWindowHeight = oidb_0x8d3_appinfo.opt_uint32_app_window_high.get();
                    troopAppInfo.appWindowWidth = oidb_0x8d3_appinfo.opt_uint32_app_window_width.get();
                    troopAppInfo.appUpdateTime = oidb_0x8d3_appinfo.opt_uint32_app_update_time.get();
                    troopAppInfo.openParam = new String(oidb_0x8d3_appinfo.opt_bytes_open_param.get().toByteArray());
                    troopAppInfo.appStatus = oidb_0x8d3_appinfo.opt_uint32_app_status.get();
                    troopAppInfo.appInnerType = oidb_0x8d3_appinfo.opt_uint32_app_inner_type.get();
                    troopAppInfo.initFlag = oidb_0x8d3_appinfo.opt_uint32_init_flag.get();
                    troopAppInfo.settingFlag = oidb_0x8d3_appinfo.opt_uint32_setting_flag.get();
                    troopAppInfo.tags = new String(oidb_0x8d3_appinfo.opt_bytes_tags.get().toByteArray());
                    troopAppInfo.versionAndroid = new String(oidb_0x8d3_appinfo.opt_bytes_version_android.get().toByteArray());
                    troopAppInfo.androidDownloadUrl = new String(oidb_0x8d3_appinfo.opt_bytes_android_download_url.get().toByteArray());
                    troopAppInfo.androidOpen = new String(oidb_0x8d3_appinfo.opt_bytes_android_open.get().toByteArray());
                    troopAppInfo.appSortKey = oidb_0x8d3_appinfo.opt_uint32_app_sort_key.get();
                    troopAppInfo.appIsNew = oidb_0x8d3_appinfo.opt_uint32_app_is_new.get();
                    troopAppInfo.appNewTime = oidb_0x8d3_appinfo.opt_uint32_app_new_time.get();
                    oidb_0x8d3$AppTip oidb_0x8d3_apptip = oidb_0x8d3_appinfo.opt_msg_app_tip.get();
                    if (oidb_0x8d3_apptip != null) {
                        troopAppInfo.AppTipInfoSeq = oidb_0x8d3_apptip.uint32_tip_info_seq.get();
                        troopAppInfo.AppTipIcon = new String(oidb_0x8d3_apptip.bytes_icon.get().toByteArray());
                        troopAppInfo.AppTipIconTimeStamp = oidb_0x8d3_apptip.uint32_icon_time_stamp.get();
                        troopAppInfo.AppTipToolTip = new String(oidb_0x8d3_apptip.bytes_tooltip.get().toByteArray());
                        troopAppInfo.AppTipReportIdClick = oidb_0x8d3_apptip.uint32_reportid_click.get();
                        troopAppInfo.AppTipReportIdShow = oidb_0x8d3_apptip.uint32_reportid_show.get();
                    }
                    arrayList.add(troopAppInfo);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mIGetAppInfoCB = null;
            this.mIsDestroy.set(true);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi
    public boolean getAppInfoBriefList(String str, ITroopCardAppInfoHelperApi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? getAppInfoBriefList(str, aVar, false) : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) aVar)).booleanValue();
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi
    public void init(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi
    public boolean getAppInfoBriefList(String str, ITroopCardAppInfoHelperApi.a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, aVar, Boolean.valueOf(z16))).booleanValue();
        }
        this.mIGetAppInfoCB = aVar;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            onFailed();
            return false;
        }
        oidb_0x8cf$ReqBody oidb_0x8cf_reqbody = new oidb_0x8cf$ReqBody();
        try {
            oidb_0x8cf_reqbody.opt_uint64_groupcode.set(Long.parseLong(str));
            oidb_0x8cf_reqbody.opt_uint32_need_mobile_sysapps.set(1);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(2255);
            oidb_sso_oidbssopkg.uint32_service_type.set(6);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x8cf_reqbody.toByteArray()));
            NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), m.class);
            newIntent.putExtra("cmd", CMD_GET_TROOP_APP_BRIEF_LIST);
            newIntent.putExtra("data", oidb_sso_oidbssopkg.toByteArray());
            newIntent.setObserver(new BusinessObserver(z16) { // from class: com.tencent.mobileqq.troop.troopapps.api.impl.TroopCardAppInfoHelperApiImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f299381d;

                {
                    this.f299381d = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopCardAppInfoHelperApiImpl.this, Boolean.valueOf(z16));
                    }
                }

                @Override // mqq.observer.BusinessObserver
                public void onReceive(int i3, boolean z17, Bundle bundle) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z17), bundle);
                    } else {
                        if (TroopCardAppInfoHelperApiImpl.this.mIsDestroy.get()) {
                            return;
                        }
                        ThreadManagerV2.excute(new Runnable(z17, bundle) { // from class: com.tencent.mobileqq.troop.troopapps.api.impl.TroopCardAppInfoHelperApiImpl.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ boolean f299383d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ Bundle f299384e;

                            {
                                this.f299383d = z17;
                                this.f299384e = bundle;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, Boolean.valueOf(z17), bundle);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    TroopCardAppInfoHelperApiImpl.this.handleGetAppInfoBriefListRspInNetworkThread(this.f299383d, this.f299384e, anonymousClass1.f299381d);
                                }
                            }
                        }, 128, null, true);
                    }
                }
            });
            peekAppRuntime.startServlet(newIntent);
            return true;
        } catch (NumberFormatException unused) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getTroopAppList, NumberFormatException, troopUin :" + str);
            }
            onFailed();
            return false;
        }
    }
}
