package n6;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.block.y;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qphone.base.util.QLog;
import gf.q;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements q {

    /* renamed from: a, reason: collision with root package name */
    private int f418402a;

    /* renamed from: b, reason: collision with root package name */
    private int f418403b;

    /* renamed from: c, reason: collision with root package name */
    private int f418404c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<String> f418405d;

    /* renamed from: e, reason: collision with root package name */
    private y f418406e;

    @Override // gf.q
    public void a() {
        long j3;
        if (this.f418406e == null) {
            RFWLog.d("FriendFeedReadDivideLineManager", RFWLog.USR, "friend list adapter is null");
            return;
        }
        ArrayList<String> arrayList = this.f418405d;
        if (arrayList == null || arrayList.size() != 1) {
            return;
        }
        try {
            j3 = Long.parseLong(this.f418405d.get(0));
        } catch (Exception e16) {
            QLog.d("FriendFeedReadDivideLineManager", 1, "read divide line exception is " + e16);
            j3 = 0;
        }
        for (int i3 = 0; i3 < this.f418406e.getNUM_BACKGOURND_ICON(); i3++) {
            if (g(this.f418406e.getItem(i3), j3)) {
                QLog.d("FriendFeedReadDivideLineManager", 1, "jump pos " + i3);
                this.f418404c = i3;
                return;
            }
        }
        this.f418404c = this.f418406e.getNUM_BACKGOURND_ICON();
    }

    @Override // gf.q
    public void b(int i3) {
        this.f418403b = i3 - this.f418402a;
        this.f418402a = i3;
    }

    @Override // gf.q
    public void c(y yVar) {
        this.f418406e = yVar;
    }

    @Override // gf.q
    public int d() {
        return this.f418403b;
    }

    @Override // gf.q
    public void e(ArrayList<String> arrayList) {
        this.f418405d = arrayList;
    }

    @Override // gf.q
    public int f() {
        return this.f418404c;
    }

    private boolean g(BusinessFeedData businessFeedData, long j3) {
        return businessFeedData != null && businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().time > 0 && businessFeedData.getFeedCommInfo().time / 1000 < j3;
    }
}
