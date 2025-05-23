package com.tencent.biz.qqcircle.manager;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import com.tencent.biz.qqcircle.beans.QFSSearchHistoryItemInfo;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.application.QCircleApplication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class k {

    /* renamed from: e, reason: collision with root package name */
    private static final int f91582e = uq3.c.b4();

    /* renamed from: f, reason: collision with root package name */
    private static volatile k f91583f;

    /* renamed from: a, reason: collision with root package name */
    private final MMKVOptionEntity f91584a = QMMKV.from(QCircleApplication.APP, QMMKVFile.FILE_QCIRCLE);

    /* renamed from: b, reason: collision with root package name */
    private final List<QFSSearchHistoryItemInfo> f91585b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private String f91586c = "";

    /* renamed from: d, reason: collision with root package name */
    private final Collection<a> f91587d = new ArraySet();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void a(@NonNull List<QFSSearchHistoryItemInfo> list);
    }

    k() {
    }

    public static k d() {
        if (f91583f == null) {
            synchronized (k.class) {
                if (f91583f == null) {
                    f91583f = new k();
                }
            }
        }
        return f91583f;
    }

    private QFSSearchHistoryItemInfo e(String str) {
        for (QFSSearchHistoryItemInfo qFSSearchHistoryItemInfo : this.f91585b) {
            if (TextUtils.equals(qFSSearchHistoryItemInfo.searchHistoryWord, str)) {
                return qFSSearchHistoryItemInfo;
            }
        }
        return null;
    }

    private List<QFSSearchHistoryItemInfo> f() {
        h();
        return this.f91585b;
    }

    private static String g() {
        return "MMKV_KEY_QFS_SEARCH_HISTORY_KEY_" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
    }

    private void h() {
        if (!this.f91585b.isEmpty()) {
            return;
        }
        p();
        o();
    }

    private void i() {
        List<QFSSearchHistoryItemInfo> f16 = f();
        Iterator<a> it = this.f91587d.iterator();
        while (it.hasNext()) {
            it.next().a(f16);
        }
    }

    private void k() {
        this.f91586c = this.f91584a.decodeString(g(), "");
        this.f91585b.clear();
        for (String str : this.f91586c.split(",")) {
            QFSSearchHistoryItemInfo fromConcatString = QFSSearchHistoryItemInfo.fromConcatString(str);
            if (!TextUtils.isEmpty(fromConcatString.searchHistoryWord)) {
                this.f91585b.add(fromConcatString);
            }
        }
    }

    private void m() {
        this.f91584a.encodeString(g(), this.f91586c);
    }

    private void o() {
        if (r60.a.f430818a.g()) {
            return;
        }
        QFSSearchHistoryItemInfo qFSSearchHistoryItemInfo = null;
        int i3 = 2;
        for (QFSSearchHistoryItemInfo qFSSearchHistoryItemInfo2 : this.f91585b) {
            qFSSearchHistoryItemInfo2.needLabel = false;
            int i16 = qFSSearchHistoryItemInfo2.count;
            if (i16 > i3) {
                qFSSearchHistoryItemInfo = qFSSearchHistoryItemInfo2;
                i3 = i16;
            }
        }
        if (qFSSearchHistoryItemInfo != null) {
            qFSSearchHistoryItemInfo.needLabel = true;
            this.f91585b.remove(qFSSearchHistoryItemInfo);
            this.f91585b.add(0, qFSSearchHistoryItemInfo);
        }
    }

    private void p() {
        String decodeString = this.f91584a.decodeString(g(), "");
        this.f91586c = decodeString;
        if (TextUtils.isEmpty(decodeString)) {
            return;
        }
        this.f91585b.clear();
        for (String str : this.f91586c.split(",")) {
            QFSSearchHistoryItemInfo fromConcatString = QFSSearchHistoryItemInfo.fromConcatString(str);
            if (!TextUtils.isEmpty(fromConcatString.searchHistoryWord)) {
                this.f91585b.add(fromConcatString);
            }
        }
    }

    private void q() {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < this.f91585b.size(); i3++) {
            if (i3 != 0) {
                sb5.append(",");
            }
            sb5.append(this.f91585b.get(i3).toConcatString());
        }
        this.f91586c = sb5.toString();
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str.trim())) {
            return;
        }
        h();
        QFSSearchHistoryItemInfo e16 = e(str);
        if (e16 == null) {
            e16 = new QFSSearchHistoryItemInfo();
            e16.searchHistoryWord = str;
        } else {
            this.f91585b.remove(e16);
            e16.count++;
        }
        this.f91585b.add(0, e16);
        if (this.f91585b.size() > f91582e) {
            this.f91585b.remove(r3.size() - 1);
        }
        o();
        q();
        m();
        i();
    }

    public void b() {
        h();
        if (TextUtils.isEmpty(this.f91586c)) {
            return;
        }
        this.f91585b.clear();
        this.f91586c = "";
        m();
        i();
    }

    public void c(String str) {
        h();
        QFSSearchHistoryItemInfo e16 = e(str);
        if (e16 == null) {
            return;
        }
        this.f91585b.remove(e16);
        o();
        q();
        m();
        i();
    }

    public List<QFSSearchHistoryItemInfo> j() {
        k();
        o();
        return this.f91585b;
    }

    public void l(a aVar) {
        if (aVar != null) {
            this.f91587d.add(aVar);
        }
    }

    public void n(a aVar) {
        if (aVar != null) {
            this.f91587d.remove(aVar);
        }
    }
}
