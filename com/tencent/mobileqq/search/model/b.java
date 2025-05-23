package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import pb.unify.search.UnifySearchDiscovery$Result;
import pb.unify.search.UnifySearchDiscovery$SubBusinessItem;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends SearchEntryDataModel {
    public List<a> D;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f283518a;

        /* renamed from: b, reason: collision with root package name */
        public String f283519b;

        /* renamed from: c, reason: collision with root package name */
        public long[] f283520c;

        /* renamed from: d, reason: collision with root package name */
        public String f283521d;

        /* renamed from: e, reason: collision with root package name */
        public int f283522e;

        /* renamed from: f, reason: collision with root package name */
        public int f283523f;

        /* renamed from: g, reason: collision with root package name */
        public int f283524g;
    }

    public b(int i3, int i16) {
        super(i3, i16);
        this.D = new ArrayList();
    }

    @NonNull
    private static a p() {
        String p16 = com.tencent.mobileqq.search.util.w.p("emoji");
        if (QLog.isColorLevel()) {
            QLog.d("SearchEntryDataModel", 2, "fabricateModel, EmojiEntrySwitchOn url= " + p16);
        }
        a aVar = new a();
        aVar.f283518a = HardCodeUtil.qqStr(R.string.k5d);
        aVar.f283519b = "https://pub.idqqimg.com/pc/misc/files/20190522/88ab43d24bc14de9a48d3ee11471b7ea.png";
        aVar.f283520c = new long[0];
        if (!TextUtils.isEmpty(p16)) {
            aVar.f283521d = p16;
        }
        aVar.f283522e = 0;
        aVar.f283523f = 0;
        aVar.f283524g = 101;
        return aVar;
    }

    @NonNull
    private static a q() {
        a aVar = new a();
        aVar.f283518a = HardCodeUtil.qqStr(R.string.f171677k51);
        aVar.f283519b = "https://qzonestyle.gtimg.cn/aoi/sola/20190816141611_NQ31kYWAQJ.png";
        aVar.f283520c = new long[0];
        aVar.f283521d = "mqqapi://contact/search_might_know";
        aVar.f283522e = 0;
        aVar.f283523f = 0;
        aVar.f283524g = 104;
        return aVar;
    }

    @NonNull
    private static a r() {
        a aVar = new a();
        aVar.f283518a = HardCodeUtil.qqStr(R.string.k5e);
        aVar.f283519b = "https://qzonestyle.gtimg.cn/aoi/sola/20190529143225_pb7ADOBDqd.png";
        aVar.f283520c = new long[0];
        aVar.f283521d = "mqqapi://miniapp/open?_atype=0&_mappid=1109875297&_mvid=&_vt=3&via=2005_1&_sig=4bf2da5e43a83ba7a9e2446bf338da983e145d8c21ed6e9a3bdcb28c3f125c12";
        aVar.f283522e = 0;
        aVar.f283523f = 0;
        aVar.f283524g = 103;
        return aVar;
    }

    @NonNull
    private static a s() {
        a aVar = new a();
        aVar.f283518a = HardCodeUtil.qqStr(R.string.vqn);
        aVar.f283519b = "https://downv6.qq.com/innovate/search_robot.png";
        aVar.f283520c = new long[0];
        aVar.f283521d = "mqqapi://trooprobot/open_robot_search";
        aVar.f283522e = 0;
        aVar.f283523f = 0;
        aVar.f283524g = 107;
        return aVar;
    }

    @NonNull
    private static a t() {
        String p16 = com.tencent.mobileqq.search.util.w.p("heihua");
        String o16 = com.tencent.mobileqq.search.util.w.o("heihua");
        String n3 = com.tencent.mobileqq.search.util.w.n("heihua");
        if (QLog.isColorLevel()) {
            QLog.d("SearchEntryDataModel", 2, "fabricateModel, isWikiEntrySwitchOn wikiUrl= " + p16 + ", wikiIconUrl = " + o16);
        }
        a aVar = new a();
        if (TextUtils.isEmpty(n3)) {
            n3 = HardCodeUtil.qqStr(R.string.f224786jv);
        }
        aVar.f283518a = n3;
        aVar.f283520c = new long[0];
        if (!TextUtils.isEmpty(p16)) {
            aVar.f283521d = p16;
        }
        if (!TextUtils.isEmpty(o16)) {
            aVar.f283519b = o16;
        }
        aVar.f283522e = 0;
        aVar.f283523f = 0;
        aVar.f283524g = 105;
        return aVar;
    }

    @Override // com.tencent.mobileqq.search.model.SearchEntryDataModel
    public void k(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        UnifySearchDiscovery$Result unifySearchDiscovery$Result = new UnifySearchDiscovery$Result();
        try {
            unifySearchDiscovery$Result.mergeFrom(bArr);
            List<UnifySearchDiscovery$SubBusinessItem> list = unifySearchDiscovery$Result.sub_business_items.get();
            for (int i3 = 0; i3 < list.size(); i3++) {
                UnifySearchDiscovery$SubBusinessItem unifySearchDiscovery$SubBusinessItem = list.get(i3);
                a aVar = new a();
                aVar.f283518a = unifySearchDiscovery$SubBusinessItem.title.get().toStringUtf8();
                aVar.f283519b = unifySearchDiscovery$SubBusinessItem.icon_url.get().toStringUtf8();
                List<Long> list2 = unifySearchDiscovery$SubBusinessItem.group_masks.get();
                aVar.f283520c = new long[list2.size()];
                for (int i16 = 0; i16 < list2.size(); i16++) {
                    aVar.f283520c[i16] = list2.get(i16).longValue();
                }
                aVar.f283521d = unifySearchDiscovery$SubBusinessItem.jump_url.get().toStringUtf8();
                aVar.f283522e = unifySearchDiscovery$SubBusinessItem.has_red_dot.get();
                aVar.f283523f = unifySearchDiscovery$SubBusinessItem.red_seq.get();
                aVar.f283524g = unifySearchDiscovery$SubBusinessItem.bzid.get();
                this.D.add(aVar);
            }
            if (!u()) {
                o();
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SearchEntryDataModel", 2, "fabricateModel, UnifySearchDiscovery InvalidProtocolBufferMicroException e = " + e16);
            }
        }
        QLog.d("SearchEntryDataModel818searchProto_new", 2, "fabricateModel");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        a aVar = null;
        a aVar2 = null;
        for (int i3 = 0; i3 < this.D.size(); i3++) {
            a aVar3 = this.D.get(i3);
            int i16 = aVar3.f283524g;
            if (i16 == 1) {
                aVar = aVar3;
            } else if (i16 == 3) {
                aVar2 = aVar3;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(q());
        if (com.tencent.mobileqq.search.util.w.x("emoji")) {
            arrayList.add(p());
        }
        if (aVar != null) {
            aVar.f283519b = "https://pub.idqqimg.com/pc/misc/files/20190522/299abcb70f194aeab89292db649698f5.png";
            aVar.f283521d = "mqqapi://miniapp/open?_atype=0&_mappid=1109740431&_mvid=&_vt=3&referer=2005&via=2005_4&_sig=6ee2c9e5075a2d129ac57b0a38af3fcdab417ff1fef97908d5e4806f94eb44af";
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async("search", "headentrance", "expo", "2", null, null);
            arrayList.add(aVar);
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101634", false)) {
            arrayList.add(s());
        }
        arrayList.add(r());
        if (com.tencent.mobileqq.search.util.w.x("heihua")) {
            arrayList.add(t());
        } else if (aVar2 != null && !StudyModeManager.t()) {
            aVar2.f283519b = "https://pub.idqqimg.com/pc/misc/files/20190522/cd2f6f83d9814d529c5efed2b45dbecd.png";
            arrayList.add(aVar2);
        }
        this.D.clear();
        this.D.addAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u() {
        if (QLog.isColorLevel()) {
            QLog.d("SearchEntryDataModel", 2, "fabricateModel, isFromReadInjoy mTabType= " + this.f283457h);
        }
        if (this.f283457h == 10) {
            return true;
        }
        return false;
    }
}
