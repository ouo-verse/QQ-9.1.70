package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IProtocolManager;
import com.tencent.mobileqq.filemanager.app.g;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f207242a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends g.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f207243a;

        a(e eVar) {
            this.f207243a = eVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.g.a
        public void a(boolean z16, int i3, String str, String str2, String str3, long j3, long j16) {
            if (z16) {
                this.f207243a.onSuccess(str2, str3);
            } else {
                this.f207243a.a(i3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.app.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class C7546b extends g.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f207245a;

        C7546b(e eVar) {
            this.f207245a = eVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.g.a
        public void a(boolean z16, int i3, String str, String str2, String str3, long j3, long j16) {
            if (z16) {
                this.f207245a.onSuccess(str2, str3);
            } else {
                this.f207245a.a(i3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c extends g.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f207247a;

        c(e eVar) {
            this.f207247a = eVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.g.a
        public void a(boolean z16, int i3, String str, String str2, String str3, long j3, long j16) {
            if (z16) {
                this.f207247a.onSuccess(str2, str3);
            } else {
                this.f207247a.a(i3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d extends g.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f207249a;

        d(e eVar) {
            this.f207249a = eVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.filemanager.app.g.a
        public void a(boolean z16, int i3, String str, String str2, String str3, long j3, long j16) {
            if (z16) {
                this.f207249a.onSuccess(str2, str3);
            } else {
                this.f207249a.a(i3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface e {
        void a(int i3, String str);

        void onSuccess(String str, String str2);
    }

    public b(QQAppInterface qQAppInterface) {
        this.f207242a = qQAppInterface;
    }

    public void a(String str, int i3, String str2, int i16, String str3, String str4, long j3, String str5, e eVar) {
        IProtocolManager iProtocolManager = (IProtocolManager) this.f207242a.getRuntimeService(IProtocolManager.class);
        h hVar = new h();
        hVar.f207275a = str4;
        hVar.f207276b = j3;
        hVar.f207278d = str5;
        hVar.f207277c = str3;
        if (i3 != 3000) {
            iProtocolManager.forwardDiscToOther(str, i3, str2, i16, hVar, 5000, 5, new c(eVar));
        } else {
            iProtocolManager.forwardDisc2Disc(str, str2, hVar, new d(eVar));
        }
    }

    public void b(String str, int i3, String str2, String str3, String str4, long j3, int i16, e eVar) {
        IProtocolManager iProtocolManager = (IProtocolManager) this.f207242a.getRuntimeService(IProtocolManager.class);
        h hVar = new h();
        hVar.f207275a = str4;
        hVar.f207276b = j3;
        if (i3 != 3000 && i3 != 1) {
            iProtocolManager.forwardOfflineFileToBuddy(str, i3, str2, str3, 5000, 3, new C7546b(eVar));
        } else {
            iProtocolManager.forwardOfflineFileToOther(str2, str, hVar, i16, 5000, 3, new a(eVar));
        }
    }
}
