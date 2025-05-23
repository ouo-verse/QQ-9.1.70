package com.tencent.mobileqq.filemanager.data.search.troop;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchManager;
import com.tencent.mobileqq.troop.filemanager.data.d;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends y {
    private CharSequence C;
    private CharSequence D;

    /* renamed from: f, reason: collision with root package name */
    private QQAppInterface f207956f;

    /* renamed from: h, reason: collision with root package name */
    private Context f207957h;

    /* renamed from: i, reason: collision with root package name */
    private String f207958i;

    /* renamed from: m, reason: collision with root package name */
    private d f207959m;

    public a(QQAppInterface qQAppInterface, Context context, String str, d dVar) {
        this.f207956f = qQAppInterface;
        this.f207957h = context;
        this.f207959m = dVar;
        this.f207958i = str;
        A();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A() {
        LifecycleOwner lifecycleOwner;
        boolean z16;
        String str;
        String str2;
        int c16;
        String str3;
        String str4;
        d dVar = this.f207959m;
        if (dVar == null) {
            return;
        }
        String valueOf = String.valueOf(dVar.f295820a);
        String valueOf2 = String.valueOf(this.f207959m.f295822c);
        String valueOf3 = String.valueOf(this.f207959m.f295825f);
        n nVar = this.f207959m.f295828i;
        Object obj = this.f207957h;
        String str5 = null;
        if (obj instanceof LifecycleOwner) {
            lifecycleOwner = (LifecycleOwner) obj;
        } else {
            lifecycleOwner = null;
        }
        TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(valueOf, valueOf2, lifecycleOwner, "TroopFileSearchResultMo");
        if (troopMemberInfoSync != null && ac.v0(troopMemberInfoSync.troopnick, valueOf3)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str5 = troopMemberInfoSync.troopnick;
        }
        d dVar2 = this.f207959m;
        long j3 = dVar2.f295825f;
        String str6 = "";
        if (j3 > 0) {
            String valueOf4 = String.valueOf(j3);
            TroopFileSearchManager e16 = TroopFileSearchManager.e();
            com.tencent.mobileqq.search.c b16 = e16.b(valueOf4);
            if (b16 != null) {
                String str7 = this.f207958i;
                d dVar3 = this.f207959m;
                c16 = TroopFileSearchManager.c(str7, str5, dVar3.f295826g, b16.f283094j0, b16.f283095k0, dVar3.f295827h, b16.f283092h0, b16.f283093i0);
                d dVar4 = this.f207959m;
                str = TroopFileSearchManager.f(str5, dVar4.f295826g, dVar4.f295827h, c16);
            } else {
                String str8 = this.f207958i;
                d dVar5 = this.f207959m;
                c16 = TroopFileSearchManager.c(str8, str5, dVar5.f295826g, null, null, dVar5.f295827h, null, null);
                d dVar6 = this.f207959m;
                str = TroopFileSearchManager.f(str5, dVar6.f295826g, dVar6.f295827h, c16);
            }
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(this.f207959m.f295826g)) {
                    str4 = this.f207959m.f295827h;
                } else {
                    str4 = this.f207959m.f295826g;
                }
                str = str4;
            } else {
                if (c16 != 1 && c16 != 4 && c16 != 7) {
                    if (c16 == 5 || c16 == 6 || c16 == 2 || c16 == 3) {
                        str3 = e16.d(this.f207958i, valueOf4);
                    }
                } else {
                    str3 = this.f207958i;
                }
                str6 = str3;
            }
        } else {
            if (!z16) {
                str5 = dVar2.f295823d;
            }
            ArrayList<String> arrayList = dVar2.f295824e;
            if (arrayList != null && arrayList.size() > 0) {
                str2 = this.f207959m.f295824e.get(0);
                if (!TextUtils.isEmpty(str5) && str5.toLowerCase().contains(str2.toLowerCase())) {
                    str = str5;
                    String e17 = nVar.e();
                    String str9 = nVar.E;
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) str9).append((CharSequence) "  ");
                    if (TextUtils.isEmpty(str2)) {
                        spannableStringBuilder.append(SearchUtils.C(str, str2)).append((CharSequence) "  ");
                    } else {
                        spannableStringBuilder.append((CharSequence) str).append((CharSequence) "  ");
                    }
                    spannableStringBuilder.append((CharSequence) e17);
                    this.D = spannableStringBuilder;
                    this.C = z(nVar);
                }
            }
            str = str5;
        }
        str2 = str6;
        String e172 = nVar.e();
        String str92 = nVar.E;
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        spannableStringBuilder2.append((CharSequence) str92).append((CharSequence) "  ");
        if (TextUtils.isEmpty(str2)) {
        }
        spannableStringBuilder2.append((CharSequence) e172);
        this.D = spannableStringBuilder2;
        this.C = z(nVar);
    }

    private CharSequence z(n nVar) {
        ArrayList<String> arrayList = this.f207959m.f295824e;
        String str = "";
        if (arrayList != null && arrayList.size() > 0 && !TextUtils.isEmpty(nVar.f294917c) && nVar.f294917c.toLowerCase().contains("".toLowerCase())) {
            str = this.f207959m.f295824e.get(0);
        }
        String str2 = nVar.f294917c;
        if (!TextUtils.isEmpty(str)) {
            return SearchUtils.C(nVar.f294917c, str);
        }
        return str2;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        return this.D;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public Object n(String str) {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence o() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public int p() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public int q() {
        return 0;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: s */
    public String getKeyword() {
        return this.f207958i;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitleSpans() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        return this.C;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(View view) {
        TroopFileTransferManager O = TroopFileTransferManager.O(this.f207956f, this.f207959m.f295820a);
        n nVar = this.f207959m.f295828i;
        t H = O.H(nVar.f294916b);
        if (H == null) {
            H = TroopFileUtils.k(this.f207956f, this.f207959m.f295820a, nVar.f294915a.toString(), nVar.f294916b, nVar.f294917c, nVar.f294918d, nVar.f294919e);
            H.f294980n = nVar.f294938x;
            H.f294981o = nVar.f294939y;
            H.f294979m = nVar.f294937w;
        }
        t tVar = H;
        if (tVar.f294976j == 0) {
            tVar.f294976j = nVar.f294918d;
        }
        int fileType = FileManagerUtil.getFileType(tVar.f294987u);
        if (fileType != 0 && fileType != 2) {
            QFileUtils.q(this.f207956f, this.f207957h, tVar, nVar.f294928n, nVar.f294923i, 4);
        } else {
            QFileUtils.n(this.f207956f, this.f207957h, null, null, this.f207959m.f295820a, tVar, nVar.f294928n, nVar.f294923i, 2, 4, QFileUtils.b0(view.findViewById(R.id.c_5), nVar.f294917c), false, false);
        }
    }

    public String x() {
        n nVar = this.f207959m.f295828i;
        if (nVar != null) {
            return nVar.f294917c;
        }
        return "";
    }

    public String y() {
        String str;
        TroopFileTransferManager O = TroopFileTransferManager.O(this.f207956f, this.f207959m.f295820a);
        n nVar = this.f207959m.f295828i;
        t H = O.H(nVar.f294916b);
        if (H != null) {
            str = H.f294979m;
        } else {
            O.D(nVar.f294915a, 128);
            str = "";
        }
        if (!FileUtils.fileExistsAndNotEmpty(str)) {
            return this.f207959m.f295828i.f294937w;
        }
        return str;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void w(int i3, int i16) {
    }
}
