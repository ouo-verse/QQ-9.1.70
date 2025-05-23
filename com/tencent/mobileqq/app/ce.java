package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.os.Build;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.troop.TroopMemberSpecialTitleInfo;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate$AppBehavior;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate$ControlReqHead;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate$ControlRspHead;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate$PreloadInfoReq;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate$PreloadInfoRsp;
import com.tencent.pb.getpreload.PreloadInfoCheckUpdate$PreloadResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ce implements com.tencent.mobileqq.service.profile.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f195418d;

    public ce(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f195418d = qQAppInterface;
        }
    }

    private boolean a(com.tencent.mobileqq.servlet.e eVar, String str) {
        if (eVar == null || eVar.a(str) == -1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public ReqItem d2(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ReqItem) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PreloadInfoCheckUpdateItem", 2, "getCheckUpdateItemData");
        }
        com.tencent.mobileqq.webview.util.t m3 = com.tencent.mobileqq.webview.util.t.m("busi_preload_");
        int intValue = ((Integer) m3.b("key_check_update_interval" + this.f195418d.getCurrentAccountUin(), Integer.valueOf(TroopMemberSpecialTitleInfo.SPECIAL_TITLE_EXPIRE_SOON_TIME))).intValue();
        int intValue2 = ((Integer) m3.b("key_last_check_update_timestamp" + this.f195418d.getCurrentAccountUin(), 0)).intValue();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (QLog.isColorLevel()) {
            QLog.d("PreloadInfoCheckUpdateItem", 2, "getPreloadInfo:lastCheckTime=" + intValue2 + ",nowSystemTime=" + currentTimeMillis);
        }
        if (currentTimeMillis - intValue2 <= intValue && currentTimeMillis >= intValue2) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PreloadInfoCheckUpdateItem", 2, "getPreloadInfo:start send check update new info update time.");
        }
        m3.d("key_last_check_update_timestamp" + this.f195418d.getCurrentAccountUin(), Integer.valueOf((int) (System.currentTimeMillis() / 1000))).a();
        ReqItem reqItem = new ReqItem();
        reqItem.eServiceID = 123;
        PreloadInfoCheckUpdate$PreloadInfoReq preloadInfoCheckUpdate$PreloadInfoReq = new PreloadInfoCheckUpdate$PreloadInfoReq();
        PreloadInfoCheckUpdate$ControlReqHead preloadInfoCheckUpdate$ControlReqHead = new PreloadInfoCheckUpdate$ControlReqHead();
        preloadInfoCheckUpdate$ControlReqHead.protocol_ver.set(1);
        preloadInfoCheckUpdate$ControlReqHead.client_plat_id.set(109);
        preloadInfoCheckUpdate$ControlReqHead.client_ver.set(AppSetting.f99551k);
        preloadInfoCheckUpdate$ControlReqHead.os_ver.set(Build.VERSION.SDK);
        preloadInfoCheckUpdate$ControlReqHead.uin.set(this.f195418d.getLongAccountUin());
        preloadInfoCheckUpdate$ControlReqHead.mem.set(((int) com.tencent.mobileqq.utils.m.c()) / 1048576);
        preloadInfoCheckUpdate$ControlReqHead.ext1.set("nothing");
        preloadInfoCheckUpdate$PreloadInfoReq.head.set(preloadInfoCheckUpdate$ControlReqHead);
        Set<String> k3 = m3.k("key_web_plugin_list" + this.f195418d.getCurrentAccountUin(), null);
        if (k3 != null && !k3.isEmpty()) {
            com.tencent.mobileqq.servlet.e eVar = (com.tencent.mobileqq.servlet.e) this.f195418d.getManager(QQManagerFactory.GAMECENTER_MANAGER);
            for (String str : k3) {
                PreloadInfoCheckUpdate$AppBehavior preloadInfoCheckUpdate$AppBehavior = new PreloadInfoCheckUpdate$AppBehavior();
                preloadInfoCheckUpdate$AppBehavior.appid.set(Integer.parseInt(str));
                preloadInfoCheckUpdate$AppBehavior.click_num.set(((Integer) m3.b("key_web_plugin_click_num" + str + this.f195418d.getCurrentAccountUin(), 0)).intValue());
                preloadInfoCheckUpdate$AppBehavior.click_red_num.set(((Integer) m3.b("key_web_plugin_click_red_num" + str + this.f195418d.getCurrentAccountUin(), 0)).intValue());
                PBInt32Field pBInt32Field = preloadInfoCheckUpdate$AppBehavior.red_state;
                if (a(eVar, str)) {
                    i16 = 2;
                } else {
                    i16 = 1;
                }
                pBInt32Field.set(i16);
                preloadInfoCheckUpdate$PreloadInfoReq.app_behavior.add(preloadInfoCheckUpdate$AppBehavior);
            }
        }
        byte[] byteArray = preloadInfoCheckUpdate$PreloadInfoReq.toByteArray();
        int length = byteArray.length;
        int i17 = length + 4;
        byte[] bArr = new byte[i17];
        System.arraycopy(com.tencent.mobileqq.util.z.d(i17), 0, bArr, 0, 4);
        System.arraycopy(byteArray, 0, bArr, 4, length);
        reqItem.vecParam = bArr;
        return reqItem;
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public void l2(RespItem respItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) respItem);
            return;
        }
        if (respItem != null) {
            byte b16 = respItem.cResult;
            byte[] bArr = respItem.vecUpdate;
            if (QLog.isColorLevel()) {
                QLog.d("PreloadInfoCheckUpdateItem", 2, "handleCheckUpdateItemData result=" + ((int) b16) + ",dataLen=" + bArr.length);
            }
            if (b16 == 2) {
                try {
                    if (bArr.length > 4) {
                        int longData = ((int) PkgTools.getLongData(bArr, 0)) - 4;
                        byte[] bArr2 = new byte[longData];
                        PkgTools.copyData(bArr2, 0, bArr, 4, longData);
                        PreloadInfoCheckUpdate$PreloadInfoRsp preloadInfoCheckUpdate$PreloadInfoRsp = new PreloadInfoCheckUpdate$PreloadInfoRsp();
                        preloadInfoCheckUpdate$PreloadInfoRsp.mergeFrom(bArr2);
                        PreloadInfoCheckUpdate$ControlRspHead preloadInfoCheckUpdate$ControlRspHead = preloadInfoCheckUpdate$PreloadInfoRsp.head.get();
                        if (preloadInfoCheckUpdate$ControlRspHead != null) {
                            int i3 = preloadInfoCheckUpdate$ControlRspHead.code.get();
                            if (QLog.isColorLevel()) {
                                QLog.d("PreloadInfoCheckUpdateItem", 2, "PreloadInfoCheckUpdateItem preloadInfoRsp data code=" + i3);
                            }
                            if (i3 == 0) {
                                com.tencent.mobileqq.webview.util.t m3 = com.tencent.mobileqq.webview.util.t.m("busi_preload_");
                                m3.d("key_preload_strategy" + this.f195418d.getCurrentAccountUin(), Integer.valueOf(preloadInfoCheckUpdate$PreloadInfoRsp.preload_switch.get()));
                                if (QLog.isColorLevel()) {
                                    QLog.d("PreloadInfoCheckUpdateItem", 2, "preload_switch=" + preloadInfoCheckUpdate$PreloadInfoRsp.preload_switch.get());
                                }
                                m3.d("key_preload_flag" + this.f195418d.getCurrentAccountUin(), Boolean.valueOf(preloadInfoCheckUpdate$PreloadInfoRsp.preload.get()));
                                if (QLog.isColorLevel()) {
                                    QLog.d("PreloadInfoCheckUpdateItem", 2, "preload=" + preloadInfoCheckUpdate$PreloadInfoRsp.preload.get());
                                }
                                m3.d("key_check_update_interval" + this.f195418d.getCurrentAccountUin(), Integer.valueOf(preloadInfoCheckUpdate$PreloadInfoRsp.interval.get()));
                                if (QLog.isColorLevel()) {
                                    QLog.d("PreloadInfoCheckUpdateItem", 2, "interval=" + preloadInfoCheckUpdate$PreloadInfoRsp.interval.get());
                                }
                                List<String> list = preloadInfoCheckUpdate$PreloadInfoRsp.applist.get();
                                if (list != null && !list.isEmpty()) {
                                    HashSet hashSet = new HashSet();
                                    for (String str : list) {
                                        hashSet.add(str);
                                        m3.d("key_web_plugin_click_num" + str + this.f195418d.getCurrentAccountUin(), 0);
                                        m3.d("key_web_plugin_click_red_num" + str + this.f195418d.getCurrentAccountUin(), 0);
                                    }
                                    m3.q("key_web_plugin_list" + this.f195418d.getCurrentAccountUin(), hashSet);
                                }
                                m3.d("key_red_ram" + this.f195418d.getCurrentAccountUin(), Integer.valueOf(preloadInfoCheckUpdate$PreloadInfoRsp.red_ram.get()));
                                if (QLog.isColorLevel()) {
                                    QLog.d("PreloadInfoCheckUpdateItem", 2, "red_ram=" + preloadInfoCheckUpdate$PreloadInfoRsp.red_ram.get());
                                }
                                m3.d("key_click_ram" + this.f195418d.getCurrentAccountUin(), Integer.valueOf(preloadInfoCheckUpdate$PreloadInfoRsp.click_ram.get()));
                                if (QLog.isColorLevel()) {
                                    QLog.d("PreloadInfoCheckUpdateItem", 2, "click_ram=" + preloadInfoCheckUpdate$PreloadInfoRsp.click_ram.get());
                                }
                                List<PreloadInfoCheckUpdate$PreloadResult> list2 = preloadInfoCheckUpdate$PreloadInfoRsp.preload_result.get();
                                if (list2 != null && !list2.isEmpty()) {
                                    SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(IQQComicPluginUtil.PPP_PROFILE, 4).edit();
                                    for (PreloadInfoCheckUpdate$PreloadResult preloadInfoCheckUpdate$PreloadResult : list2) {
                                        int i16 = preloadInfoCheckUpdate$PreloadResult.appid.get();
                                        edit.putInt(i16 + IQQComicPluginUtil.PPP_PRELOAD_SWITCH + this.f195418d.getCurrentAccountUin(), preloadInfoCheckUpdate$PreloadResult.preload_switch.get());
                                        edit.putBoolean(i16 + "preload" + this.f195418d.getCurrentAccountUin(), preloadInfoCheckUpdate$PreloadResult.preload.get());
                                        edit.putBoolean(i16 + IQQComicPluginUtil.PPP_PRELOAD_DATA + this.f195418d.getCurrentAccountUin(), preloadInfoCheckUpdate$PreloadResult.preload_data.get());
                                        edit.putInt(i16 + IQQComicPluginUtil.PPP_MEM_LIMIT + this.f195418d.getCurrentAccountUin(), preloadInfoCheckUpdate$PreloadResult.mem_limit.get());
                                        edit.putString(i16 + "ext1" + this.f195418d.getCurrentAccountUin(), preloadInfoCheckUpdate$PreloadResult.ext1.get());
                                    }
                                }
                                m3.d("key_last_check_update_timestamp" + this.f195418d.getCurrentAccountUin(), Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                m3.a();
                                ((IWebProcessManagerService) this.f195418d.getRuntimeService(IWebProcessManagerService.class, "")).updatePreloadWebProcessFlag();
                                ILebaHelperService iLebaHelperService = (ILebaHelperService) this.f195418d.getRuntimeService(ILebaHelperService.class, "");
                                iLebaHelperService.updateBuffer();
                                iLebaHelperService.notifyRefreshWebProcess();
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("PreloadInfoCheckUpdateItem", 2, "PreloadInfoCheckUpdateItem preloadInfoRsp erro msg=" + preloadInfoCheckUpdate$ControlRspHead.err_msg.get());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PreloadInfoCheckUpdateItem", 2, "PreloadInfoCheckUpdateItem Exception msg=" + th5.getMessage());
                    }
                    th5.printStackTrace();
                    return;
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PreloadInfoCheckUpdateItem", 2, "PreloadInfoCheckUpdateItem handleCheckUpdateItemData respitem is null");
        }
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public int w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 3;
    }
}
