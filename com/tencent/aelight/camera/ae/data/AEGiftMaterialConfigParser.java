package com.tencent.aelight.camera.ae.data;

import android.text.TextUtils;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakeMaterialManager;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.light.device.OfflineConfig;
import tencent.im.oidb.cmd0xf8c.oidb_cmd0xf8c$GiftMsg;
import tencent.im.oidb.cmd0xf8c.oidb_cmd0xf8c$MapDynamicFields;
import tencent.im.oidb.cmd0xf8c.oidb_cmd0xf8c$MaterialInfo;
import tencent.im.oidb.cmd0xf8c.oidb_cmd0xf8c$RspBody;

/* loaded from: classes32.dex */
public class AEGiftMaterialConfigParser {

    /* renamed from: a, reason: collision with root package name */
    private static List<a> f63510a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static String f63511b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f63512c = true;

    /* renamed from: d, reason: collision with root package name */
    private static String f63513d = "display_name";

    /* loaded from: classes32.dex */
    public static class AEGiftMaterialConfigParserExpection extends Exception {
        public AEGiftMaterialConfigParserExpection(String str) {
            super(str);
        }
    }

    public static void a() {
        ms.a.a("AEGiftMaterialConfigParser", "arcake: clearCakeData");
        List<a> list = f63510a;
        if (list != null) {
            list.clear();
        }
        AEARCakeMaterialManager.i().x(false);
    }

    public static List<a> b() {
        return f63510a;
    }

    private static void c(AEARCakeMaterial aEARCakeMaterial) {
        if (TextUtils.isEmpty(aEARCakeMaterial.superLowPackageUrl) && TextUtils.isEmpty(aEARCakeMaterial.lowPackageUrl) && TextUtils.isEmpty(aEARCakeMaterial.midPackageUrl) && TextUtils.isEmpty(aEARCakeMaterial.highPackageUrl)) {
            aEARCakeMaterial.resurl = aEARCakeMaterial.packageUrl;
            aEARCakeMaterial.md5 = aEARCakeMaterial.packageMd5;
            ms.a.a("AEGiftMaterialConfigParser", "arcake: no level : " + aEARCakeMaterial.resurl);
        } else {
            String[] strArr = {aEARCakeMaterial.superLowPackageUrl, aEARCakeMaterial.lowPackageUrl, aEARCakeMaterial.midPackageUrl, aEARCakeMaterial.highPackageUrl, aEARCakeMaterial.packageUrl};
            String[] strArr2 = {aEARCakeMaterial.superLowPackageMd5, aEARCakeMaterial.lowPackageMd5, aEARCakeMaterial.midPackageMd5, aEARCakeMaterial.highPackageMd5, aEARCakeMaterial.packageMd5};
            int phonePerfLevel = OfflineConfig.getPhonePerfLevel(BaseApplicationImpl.getApplication()) - 1;
            ms.a.f("AEGiftMaterialConfigParser", "arcake: phoneLevelIndex : " + phonePerfLevel);
            if (!TextUtils.isEmpty(strArr[phonePerfLevel])) {
                aEARCakeMaterial.resurl = strArr[phonePerfLevel];
                aEARCakeMaterial.md5 = strArr2[phonePerfLevel];
                ms.a.a("AEGiftMaterialConfigParser", "arcake:  level " + aEARCakeMaterial.resurl);
            } else {
                aEARCakeMaterial.resurl = null;
                aEARCakeMaterial.md5 = null;
            }
        }
        String str = aEARCakeMaterial.packageUrl;
        if (str == null || str.equals(aEARCakeMaterial.resurl)) {
            return;
        }
        aEARCakeMaterial.isDowngrade = true;
        ms.a.a("AEGiftMaterialConfigParser", "arcake: [parseDowngradeInfo][material_downgrade] \u964d\u7ea7\u5b8c\u6210 : " + aEARCakeMaterial.resurl);
    }

    public static ArrayList<a> d(oidb_cmd0xf8c$RspBody oidb_cmd0xf8c_rspbody) throws AEGiftMaterialConfigParserExpection {
        ArrayList<a> arrayList = new ArrayList<>();
        if (oidb_cmd0xf8c_rspbody == null) {
            ms.a.c("AEGiftMaterialConfigParser", "arcake:content is null ,can not parse gif material ");
            return arrayList;
        }
        List<oidb_cmd0xf8c$GiftMsg> list = oidb_cmd0xf8c_rspbody.giftmsg.get();
        if (list != null && list.size() != 0) {
            ms.a.c("AEGiftMaterialConfigParser", "arcake:giftMsgs size :" + list.size());
            list.size();
            int i3 = 0;
            for (oidb_cmd0xf8c$GiftMsg oidb_cmd0xf8c_giftmsg : list) {
                a aVar = new a();
                aVar.f63560a = oidb_cmd0xf8c_giftmsg.giftuin.get();
                aVar.f63561b = oidb_cmd0xf8c_giftmsg.gitfnickname.get();
                ms.a.a("AEGiftMaterialConfigParser", "arcake: material \uff1a " + aVar.f63561b + "uin : " + aVar.f63560a);
                if (TextUtils.isEmpty(aVar.f63561b)) {
                    aVar.f63561b = AECameraPrefsUtil.f().j(IAECameraPrefsUtil.KEY_ARCAKE_NICK, null, 4);
                    ms.a.a("AEGiftMaterialConfigParser", "arcake: nickName \uff1a " + aVar.f63561b);
                }
                AEARCakeMaterial aEARCakeMaterial = new AEARCakeMaterial();
                oidb_cmd0xf8c$MaterialInfo oidb_cmd0xf8c_materialinfo = oidb_cmd0xf8c_giftmsg.materialInfo.get();
                if (oidb_cmd0xf8c_materialinfo != null) {
                    aEARCakeMaterial.iconurl = oidb_cmd0xf8c_materialinfo.ThumbURL.get();
                    aEARCakeMaterial.ID = oidb_cmd0xf8c_materialinfo.ID.get();
                    aEARCakeMaterial.name = oidb_cmd0xf8c_materialinfo.Name.get();
                    aEARCakeMaterial.f69050id = oidb_cmd0xf8c_materialinfo.Name.get();
                    aEARCakeMaterial.cakeId = oidb_cmd0xf8c_materialinfo.Name.get() + i3;
                    ms.a.a("AEGiftMaterialConfigParser", "arcake: cake id  \uff1a " + aEARCakeMaterial.cakeId);
                    i3++;
                    new HashMap();
                    List<oidb_cmd0xf8c$MapDynamicFields> list2 = oidb_cmd0xf8c_materialinfo.DynamicFields.get();
                    if (list2 != null && list2.size() > 0) {
                        for (oidb_cmd0xf8c$MapDynamicFields oidb_cmd0xf8c_mapdynamicfields : list2) {
                            if (oidb_cmd0xf8c_mapdynamicfields != null) {
                                String str = oidb_cmd0xf8c_mapdynamicfields.DynamicFieldkey.get();
                                String str2 = oidb_cmd0xf8c_mapdynamicfields.DynamicFieldvalue.get();
                                ms.a.a("AEGiftMaterialConfigParser", "arcake : dynamic key " + str);
                                ms.a.a("AEGiftMaterialConfigParser", "arcake : dynamic value " + str2);
                                if (str != null && f63513d.equals(str)) {
                                    aVar.f63563d = str2;
                                }
                            }
                        }
                    }
                    aEARCakeMaterial.packageMd5 = oidb_cmd0xf8c_materialinfo.ChecksumMd5.get();
                    aEARCakeMaterial.superLowPackageMd5 = oidb_cmd0xf8c_materialinfo.ChecksumMd5Superlow.get();
                    aEARCakeMaterial.lowPackageMd5 = oidb_cmd0xf8c_materialinfo.ChecksumMd5Low.get();
                    aEARCakeMaterial.midPackageMd5 = oidb_cmd0xf8c_materialinfo.ChecksumMd5Mid.get();
                    aEARCakeMaterial.highPackageMd5 = oidb_cmd0xf8c_materialinfo.ChecksumMd5High.get();
                    aEARCakeMaterial.packageUrl = oidb_cmd0xf8c_materialinfo.PackageURL.get();
                    aEARCakeMaterial.superLowPackageUrl = oidb_cmd0xf8c_materialinfo.PackageUrlSuperlow.get();
                    aEARCakeMaterial.lowPackageUrl = oidb_cmd0xf8c_materialinfo.PackageURLLow.get();
                    aEARCakeMaterial.midPackageUrl = oidb_cmd0xf8c_materialinfo.PackageURLMid.get();
                    aEARCakeMaterial.highPackageUrl = oidb_cmd0xf8c_materialinfo.PackageURLHigh.get();
                    ms.a.a("AEGiftMaterialConfigParser", "arcake packageUrl \uff1a" + oidb_cmd0xf8c_materialinfo.PackageURL.get());
                    ms.a.a("AEGiftMaterialConfigParser", "arcake superLowPackageUrl \uff1a " + oidb_cmd0xf8c_materialinfo.PackageUrlSuperlow.get());
                    ms.a.a("AEGiftMaterialConfigParser", "arcake lowPackageUrl \uff1a" + oidb_cmd0xf8c_materialinfo.PackageURLLow.get());
                    ms.a.a("AEGiftMaterialConfigParser", "arcake PackageURLMid \uff1a" + oidb_cmd0xf8c_materialinfo.PackageURLMid.get());
                    ms.a.a("AEGiftMaterialConfigParser", "arcake PackageURLHigh \uff1a" + oidb_cmd0xf8c_materialinfo.PackageURLHigh.get());
                    c(aEARCakeMaterial);
                }
                if (!TextUtils.isEmpty(aEARCakeMaterial.resurl)) {
                    aVar.f63562c = aEARCakeMaterial;
                    arrayList.add(aVar);
                }
            }
            List<a> list3 = f63510a;
            if (list3 != null) {
                list3.clear();
                f63510a.addAll(arrayList);
                ms.a.a("AEGiftMaterialConfigParser", "arcake: mGiftMaterials size" + f63510a.size());
            }
            return arrayList;
        }
        ms.a.c("AEGiftMaterialConfigParser", "arcake:giftMsgs is null ,can not parse gif material ");
        return arrayList;
    }

    public static void e(String str) {
        f63511b = str;
    }
}
