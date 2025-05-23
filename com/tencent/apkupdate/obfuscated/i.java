package com.tencent.apkupdate.obfuscated;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Message;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.apkupdate.logic.protocol.BaseHttpRequest;
import com.tencent.apkupdate.logic.protocol.jce.ApkDownUrl;
import com.tencent.apkupdate.logic.protocol.jce.AppInfoForUpdate;
import com.tencent.apkupdate.logic.protocol.jce.AppUpdateInfo;
import com.tencent.apkupdate.logic.protocol.jce.GetAppUpdateRequest;
import com.tencent.apkupdate.logic.protocol.jce.GetAppUpdateResponse;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class i extends BaseHttpRequest {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public final List<AppInfoForUpdate> f72532d;

    public i(List<AppInfoForUpdate> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
        } else {
            this.f72532d = list;
        }
    }

    @Override // com.tencent.apkupdate.logic.protocol.BaseHttpRequest
    public void onDataReceiveFailed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Message obtainMessage = g.a().obtainMessage();
        obtainMessage.what = 2;
        obtainMessage.sendToTarget();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01cd A[ADDED_TO_REGION] */
    @Override // com.tencent.apkupdate.logic.protocol.BaseHttpRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onFinished(JceStruct jceStruct, JceStruct jceStruct2) {
        boolean z16;
        ApkUpdateDetail apkUpdateDetail;
        Collection<ArrayList<AppUpdateInfo>> values;
        Iterator<ArrayList<AppUpdateInfo>> it;
        boolean z17;
        String str;
        Iterator<AppUpdateInfo> it5;
        String b16;
        int i3;
        int i16;
        int i17;
        Iterator<ApkDownUrl> it6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jceStruct, (Object) jceStruct2);
            return;
        }
        if (jceStruct2 == null || !(jceStruct2 instanceof GetAppUpdateResponse)) {
            return;
        }
        GetAppUpdateResponse getAppUpdateResponse = (GetAppUpdateResponse) jceStruct2;
        StringBuffer stringBuffer = new StringBuffer("CheckAppUpdateHttpRequest:checkupdate from server; response=  [");
        stringBuffer.append("ret=" + getAppUpdateResponse.ret + "| ");
        if (getAppUpdateResponse.ret == 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Map<Integer, ArrayList<AppUpdateInfo>> map = getAppUpdateResponse.appUpdateInfoGroup;
            int i18 = 0;
            int i19 = 1;
            if (map != null && map.size() > 0 && (values = map.values()) != null && values.size() > 0) {
                Iterator<ArrayList<AppUpdateInfo>> it7 = values.iterator();
                while (it7.hasNext()) {
                    ArrayList<AppUpdateInfo> next = it7.next();
                    if (next != null && next.size() > 0) {
                        Iterator<AppUpdateInfo> it8 = next.iterator();
                        while (it8.hasNext()) {
                            AppUpdateInfo next2 = it8.next();
                            int i26 = (next2.flag >>> i18) & i19;
                            if ((i26 == i19 ? i19 : i18) != 0) {
                                arrayList2.add(next2);
                            }
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("pkgname=");
                            sb5.append(next2.packageName);
                            sb5.append(";versionCode=");
                            sb5.append(next2.versionCode);
                            sb5.append(";uploadFlag=");
                            sb5.append(i26 == i19 ? i19 : i18);
                            sb5.append("| \n\r");
                            stringBuffer.append(sb5.toString());
                            ApkUpdateDetail apkUpdateDetail2 = new ApkUpdateDetail();
                            apkUpdateDetail2.packageName = next2.packageName;
                            apkUpdateDetail2.versionname = next2.versionName;
                            apkUpdateDetail2.versioncode = next2.versionCode;
                            ArrayList<ApkDownUrl> arrayList3 = next2.apkDownUrl;
                            String str2 = "";
                            if (arrayList3 != null && arrayList3.size() > 0) {
                                Iterator<ApkDownUrl> it9 = arrayList3.iterator();
                                while (it9.hasNext()) {
                                    ApkDownUrl next3 = it9.next();
                                    if (next3 != null) {
                                        it = it7;
                                        if (next3.type == 2) {
                                            ArrayList<String> arrayList4 = next3.urlList;
                                            str = arrayList4 != null ? arrayList4.get(0) : "";
                                            z17 = true;
                                            if (!z17 && arrayList3 != null && arrayList3.size() > 0) {
                                                it6 = arrayList3.iterator();
                                                while (it6.hasNext()) {
                                                    ApkDownUrl next4 = it6.next();
                                                    if (next4 != null) {
                                                        it5 = it8;
                                                        Iterator<ApkDownUrl> it10 = it6;
                                                        if (next4.type == 1) {
                                                            ArrayList<String> arrayList5 = next4.urlList;
                                                            if (arrayList5 != null) {
                                                                str2 = arrayList5.get(0);
                                                            }
                                                            if (z17) {
                                                                apkUpdateDetail2.updatemethod = 4;
                                                                apkUpdateDetail2.url = str;
                                                            } else {
                                                                apkUpdateDetail2.updatemethod = 2;
                                                                apkUpdateDetail2.url = str2;
                                                            }
                                                            apkUpdateDetail2.newapksize = (int) next2.fileSize;
                                                            apkUpdateDetail2.patchsize = (int) next2.diffFileSize;
                                                            apkUpdateDetail2.fileMd5 = next2.diffApkMd5;
                                                            apkUpdateDetail2.sigMd5 = next2.signatureMd5;
                                                            apkUpdateDetail2.newFeature = next2.newFeature;
                                                            b16 = h.a().b(apkUpdateDetail2.packageName);
                                                            if (l.a().f72549a != null) {
                                                                Context context = l.a().f72549a;
                                                                String str3 = apkUpdateDetail2.packageName;
                                                                if (context == null || TextUtils.isEmpty(str3)) {
                                                                    i3 = 0;
                                                                } else {
                                                                    i3 = 0;
                                                                    try {
                                                                        i17 = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str3, 0).versionCode;
                                                                    } catch (PackageManager.NameNotFoundException e16) {
                                                                        e16.printStackTrace();
                                                                    }
                                                                    if (i17 == apkUpdateDetail2.versioncode) {
                                                                        i16 = 1;
                                                                        if (b16.compareToIgnoreCase(apkUpdateDetail2.sigMd5) == 0 || i16 != 0) {
                                                                            apkUpdateDetail2.updatemethod = 1;
                                                                        }
                                                                        p.a("CheckAppUpdateHttpRequest", "packageName: " + apkUpdateDetail2.packageName);
                                                                        p.a("CheckAppUpdateHttpRequest", "updatemethod: " + apkUpdateDetail2.updatemethod);
                                                                        p.a("CheckAppUpdateHttpRequest", "newapksize: " + apkUpdateDetail2.newapksize);
                                                                        p.a("CheckAppUpdateHttpRequest", "patchsize: " + apkUpdateDetail2.patchsize);
                                                                        p.a("CheckAppUpdateHttpRequest", "url: " + apkUpdateDetail2.url);
                                                                        arrayList.add(apkUpdateDetail2);
                                                                        i18 = i3;
                                                                        it8 = it5;
                                                                        it7 = it;
                                                                        i19 = 1;
                                                                    }
                                                                }
                                                                i17 = i3;
                                                                if (i17 == apkUpdateDetail2.versioncode) {
                                                                }
                                                            } else {
                                                                i3 = 0;
                                                            }
                                                            i16 = i3;
                                                            if (b16.compareToIgnoreCase(apkUpdateDetail2.sigMd5) == 0) {
                                                            }
                                                            apkUpdateDetail2.updatemethod = 1;
                                                            p.a("CheckAppUpdateHttpRequest", "packageName: " + apkUpdateDetail2.packageName);
                                                            p.a("CheckAppUpdateHttpRequest", "updatemethod: " + apkUpdateDetail2.updatemethod);
                                                            p.a("CheckAppUpdateHttpRequest", "newapksize: " + apkUpdateDetail2.newapksize);
                                                            p.a("CheckAppUpdateHttpRequest", "patchsize: " + apkUpdateDetail2.patchsize);
                                                            p.a("CheckAppUpdateHttpRequest", "url: " + apkUpdateDetail2.url);
                                                            arrayList.add(apkUpdateDetail2);
                                                            i18 = i3;
                                                            it8 = it5;
                                                            it7 = it;
                                                            i19 = 1;
                                                        } else {
                                                            it8 = it5;
                                                            it6 = it10;
                                                        }
                                                    }
                                                }
                                            }
                                            it5 = it8;
                                            str2 = null;
                                            if (z17) {
                                            }
                                            apkUpdateDetail2.newapksize = (int) next2.fileSize;
                                            apkUpdateDetail2.patchsize = (int) next2.diffFileSize;
                                            apkUpdateDetail2.fileMd5 = next2.diffApkMd5;
                                            apkUpdateDetail2.sigMd5 = next2.signatureMd5;
                                            apkUpdateDetail2.newFeature = next2.newFeature;
                                            b16 = h.a().b(apkUpdateDetail2.packageName);
                                            if (l.a().f72549a != null) {
                                            }
                                            i16 = i3;
                                            if (b16.compareToIgnoreCase(apkUpdateDetail2.sigMd5) == 0) {
                                            }
                                            apkUpdateDetail2.updatemethod = 1;
                                            p.a("CheckAppUpdateHttpRequest", "packageName: " + apkUpdateDetail2.packageName);
                                            p.a("CheckAppUpdateHttpRequest", "updatemethod: " + apkUpdateDetail2.updatemethod);
                                            p.a("CheckAppUpdateHttpRequest", "newapksize: " + apkUpdateDetail2.newapksize);
                                            p.a("CheckAppUpdateHttpRequest", "patchsize: " + apkUpdateDetail2.patchsize);
                                            p.a("CheckAppUpdateHttpRequest", "url: " + apkUpdateDetail2.url);
                                            arrayList.add(apkUpdateDetail2);
                                            i18 = i3;
                                            it8 = it5;
                                            it7 = it;
                                            i19 = 1;
                                        } else {
                                            it7 = it;
                                        }
                                    }
                                }
                            }
                            it = it7;
                            z17 = false;
                            str = null;
                            if (!z17) {
                                it6 = arrayList3.iterator();
                                while (it6.hasNext()) {
                                }
                            }
                            it5 = it8;
                            str2 = null;
                            if (z17) {
                            }
                            apkUpdateDetail2.newapksize = (int) next2.fileSize;
                            apkUpdateDetail2.patchsize = (int) next2.diffFileSize;
                            apkUpdateDetail2.fileMd5 = next2.diffApkMd5;
                            apkUpdateDetail2.sigMd5 = next2.signatureMd5;
                            apkUpdateDetail2.newFeature = next2.newFeature;
                            b16 = h.a().b(apkUpdateDetail2.packageName);
                            if (l.a().f72549a != null) {
                            }
                            i16 = i3;
                            if (b16.compareToIgnoreCase(apkUpdateDetail2.sigMd5) == 0) {
                            }
                            apkUpdateDetail2.updatemethod = 1;
                            p.a("CheckAppUpdateHttpRequest", "packageName: " + apkUpdateDetail2.packageName);
                            p.a("CheckAppUpdateHttpRequest", "updatemethod: " + apkUpdateDetail2.updatemethod);
                            p.a("CheckAppUpdateHttpRequest", "newapksize: " + apkUpdateDetail2.newapksize);
                            p.a("CheckAppUpdateHttpRequest", "patchsize: " + apkUpdateDetail2.patchsize);
                            p.a("CheckAppUpdateHttpRequest", "url: " + apkUpdateDetail2.url);
                            arrayList.add(apkUpdateDetail2);
                            i18 = i3;
                            it8 = it5;
                            it7 = it;
                            i19 = 1;
                        }
                    }
                }
            }
            p.a("CheckAppUpdateHttpRequest", stringBuffer.toString() + "]");
            ArrayList arrayList6 = new ArrayList();
            List<AppInfoForUpdate> list = this.f72532d;
            if (list != null) {
                for (AppInfoForUpdate appInfoForUpdate : list) {
                    String str4 = appInfoForUpdate.packageName;
                    int i27 = appInfoForUpdate.versionCode;
                    String str5 = appInfoForUpdate.versionName;
                    Iterator it11 = arrayList.iterator();
                    while (true) {
                        if (!it11.hasNext()) {
                            z16 = false;
                            apkUpdateDetail = null;
                            break;
                        }
                        apkUpdateDetail = (ApkUpdateDetail) it11.next();
                        String str6 = apkUpdateDetail.packageName;
                        if (str4 != null && str6 != null && str4.equals(str6)) {
                            z16 = true;
                            break;
                        }
                    }
                    if (z16) {
                        arrayList6.add(apkUpdateDetail);
                    } else {
                        ApkUpdateDetail apkUpdateDetail3 = new ApkUpdateDetail();
                        apkUpdateDetail3.packageName = str4;
                        apkUpdateDetail3.versionname = str5;
                        apkUpdateDetail3.versioncode = i27;
                        apkUpdateDetail3.updatemethod = 1;
                        arrayList6.add(apkUpdateDetail3);
                    }
                }
            }
            StringBuffer stringBuffer2 = new StringBuffer("CheckAppUpdateHttpRequest:checkupdate from server; returnSuceessList response= [");
            Iterator it12 = arrayList6.iterator();
            while (it12.hasNext()) {
                ApkUpdateDetail apkUpdateDetail4 = (ApkUpdateDetail) it12.next();
                stringBuffer2.append("pkgname=" + apkUpdateDetail4.packageName + ";versionCode=" + apkUpdateDetail4.versioncode + "| \n\r");
            }
            p.a("CheckAppUpdateHttpRequest", stringBuffer2.toString() + "]");
            Message obtainMessage = g.a().obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = arrayList6;
            obtainMessage.sendToTarget();
            StringBuffer stringBuffer3 = new StringBuffer("CheckAppUpdateHttpRequest:NeedUpdateApk from server; needUpdateApkInfos response= [");
            Iterator it13 = arrayList2.iterator();
            while (it13.hasNext()) {
                AppUpdateInfo appUpdateInfo = (AppUpdateInfo) it13.next();
                stringBuffer3.append("pkgname=" + appUpdateInfo.packageName + ";versionCode=" + appUpdateInfo.versionCode + ";grayVersionCode=" + appUpdateInfo.grayVersionCode + "| \n\r");
            }
            p.a("CheckAppUpdateHttpRequest", stringBuffer3.toString() + "]");
            if (arrayList2.size() > 0) {
                Message obtainMessage2 = g.a().obtainMessage();
                obtainMessage2.what = 7;
                obtainMessage2.obj = arrayList2;
                obtainMessage2.sendToTarget();
                return;
            }
            return;
        }
        onDataReceiveFailed();
    }

    @Override // com.tencent.apkupdate.logic.protocol.BaseHttpRequest
    public void prepareData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.prepareData();
        if (this.f72532d != null) {
            GetAppUpdateRequest getAppUpdateRequest = new GetAppUpdateRequest();
            getAppUpdateRequest.appInfoForUpdateList = (ArrayList) this.f72532d;
            getAppUpdateRequest.flag = (byte) 0;
            StringBuffer stringBuffer = new StringBuffer("CheckAppUpdateHttpRequest:prepareData to server; appInfoForUpdateList= [");
            for (AppInfoForUpdate appInfoForUpdate : this.f72532d) {
                stringBuffer.append("pkgname=" + appInfoForUpdate.packageName + ";versionCode=" + appInfoForUpdate.versionCode + ";targetVersionCode=" + appInfoForUpdate.targetVersionCode + ";targetGrayVersionCode=" + appInfoForUpdate.targetGrayVersionCode + "| \n\r");
            }
            p.a("CheckAppUpdateHttpRequest", stringBuffer.toString() + "]");
            setData(getAppUpdateRequest);
        }
    }
}
