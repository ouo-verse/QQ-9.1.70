package com.tencent.rmonitor.fd;

import com.tencent.rmonitor.fd.analysis.data.FdLeakIssueResult;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
class b implements c {

    /* renamed from: a, reason: collision with root package name */
    private final List<c> f365568a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(List<c> list) {
        if (list == null) {
            this.f365568a = Collections.emptyList();
        } else {
            this.f365568a = list;
        }
    }

    @Override // com.tencent.rmonitor.fd.c
    public void b(int i3) {
        for (c cVar : this.f365568a) {
            if (cVar != null) {
                cVar.b(i3);
            }
        }
    }

    @Override // w04.b
    public void c(int i3, FdLeakDumpResult fdLeakDumpResult) {
        for (c cVar : this.f365568a) {
            if (cVar != null) {
                cVar.c(i3, fdLeakDumpResult);
            }
        }
    }

    @Override // t04.c
    public void e() {
        for (c cVar : this.f365568a) {
            if (cVar != null) {
                cVar.e();
            }
        }
    }

    @Override // com.tencent.rmonitor.fd.c
    public ArrayList<String> f(int i3, int i16) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (c cVar : this.f365568a) {
            if (cVar != null) {
                arrayList.addAll(cVar.f(i3, i16));
            }
        }
        return arrayList;
    }

    @Override // w04.b
    public void g(int i3) {
        for (c cVar : this.f365568a) {
            if (cVar != null) {
                cVar.g(i3);
            }
        }
    }

    @Override // t04.c
    public void h(FdLeakIssueResult fdLeakIssueResult) {
        for (c cVar : this.f365568a) {
            if (cVar != null) {
                cVar.h(fdLeakIssueResult);
            }
        }
    }
}
