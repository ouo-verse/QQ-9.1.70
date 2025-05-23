package com.tencent.luggage.wxa.vf;

import android.app.Activity;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.Bundle;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends com.tencent.luggage.wxa.vf.a {

    /* renamed from: l, reason: collision with root package name */
    public static final a f143428l = new a(null);

    /* renamed from: m, reason: collision with root package name */
    public static final Bundle f143429m = null;

    /* renamed from: i, reason: collision with root package name */
    public int f143430i;

    /* renamed from: j, reason: collision with root package name */
    public final NfcAdapter.ReaderCallback f143431j;

    /* renamed from: k, reason: collision with root package name */
    public volatile Tag f143432k;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements NfcAdapter.ReaderCallback {
        public b() {
        }

        @Override // android.nfc.NfcAdapter.ReaderCallback
        public final void onTagDiscovered(Tag tag) {
            ArrayList arrayList;
            List list;
            Ndef ndef;
            NdefMessage cachedNdefMessage;
            e.this.c().clear();
            e.this.a(tag);
            if (tag == null) {
                w.d("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "onTagDiscovered, discoveredTag is null");
                return;
            }
            Function3 g16 = e.this.g();
            if (g16 == null) {
                w.d("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "onTagDiscovered, onDiscoveryListener is null");
                return;
            }
            byte[] id5 = tag.getId();
            String[] techList = tag.getTechList();
            boolean z16 = false;
            String str = null;
            if (techList != null) {
                arrayList = new ArrayList();
                for (String str2 : techList) {
                    String str3 = (String) com.tencent.luggage.wxa.wf.b.f144216e.a().get(str2);
                    if (str3 != null) {
                        arrayList.add(str3);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList == null || arrayList.isEmpty()) {
                z16 = true;
            }
            if (z16) {
                w.d("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "onTagDiscovered, techs is empty");
                return;
            }
            if (arrayList.contains(com.tencent.luggage.wxa.wf.b.D.f()) && (ndef = Ndef.get(tag)) != null && (cachedNdefMessage = ndef.getCachedNdefMessage()) != null) {
                list = CollectionsKt__CollectionsJVMKt.listOf(cachedNdefMessage);
            } else {
                list = null;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onTagDiscovered, id: ");
            if (id5 != null) {
                str = Arrays.toString(id5);
                Intrinsics.checkNotNullExpressionValue(str, "toString(this)");
            }
            sb5.append(str);
            sb5.append(", techs: ");
            sb5.append(arrayList);
            w.d("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", sb5.toString());
            g16.invoke(id5, arrayList, list);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String appId, r activityProvider) {
        super(appId, activityProvider);
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(activityProvider, "activityProvider");
        this.f143430i = 15;
        this.f143431j = new b();
    }

    public void a(Tag tag) {
        this.f143432k = tag;
    }

    @Override // com.tencent.luggage.wxa.vf.a
    public void d() {
        w.d("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "enableReaderMode");
        Activity a16 = f().a();
        if (a16 == null) {
            w.b("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "enableReaderMode, activity is null");
            return;
        }
        NfcAdapter a17 = com.tencent.luggage.wxa.xf.a.a();
        Intrinsics.checkNotNull(a17);
        a17.enableReaderMode(a16, this.f143431j, this.f143430i, f143429m);
    }

    @Override // com.tencent.luggage.wxa.vf.a
    public void e() {
        w.d("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "disableReaderMode");
        Activity a16 = f().a();
        if (a16 == null) {
            w.b("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "disableReaderMode, activity is null");
            return;
        }
        NfcAdapter a17 = com.tencent.luggage.wxa.xf.a.a();
        Intrinsics.checkNotNull(a17);
        a17.disableReaderMode(a16);
    }

    @Override // com.tencent.luggage.wxa.vf.b
    public Tag getTag() {
        return this.f143432k;
    }

    @Override // com.tencent.luggage.wxa.vf.a
    public void k() {
        NfcAdapter a16;
        super.k();
        if (h().getAndSet(false)) {
            w.d("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "onPause, isNFCDiscovering");
            try {
                w.d("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "disableReaderMode");
                Activity a17 = f().a();
                if (a17 != null && (a16 = com.tencent.luggage.wxa.xf.a.a()) != null) {
                    a16.disableReaderMode(a17);
                }
            } catch (Exception e16) {
                w.f("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "disableReaderMode failed since " + e16);
            }
            b(true);
        }
    }

    @Override // com.tencent.luggage.wxa.vf.a
    public void l() {
        boolean z16;
        NfcAdapter a16;
        super.l();
        if (i()) {
            w.d("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "onResume, isNFCDiscoverySticky");
            NfcAdapter a17 = com.tencent.luggage.wxa.xf.a.a();
            if (a17 != null && true == a17.isEnabled()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                w.d("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "onResume, nfc is not enabled");
                return;
            }
            try {
                w.d("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "enableReaderMode");
                Activity a18 = f().a();
                if (a18 != null && (a16 = com.tencent.luggage.wxa.xf.a.a()) != null) {
                    a16.enableReaderMode(a18, this.f143431j, this.f143430i, f143429m);
                }
                h().set(true);
            } catch (Exception e16) {
                w.f("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "enableReaderMode failed since " + e16);
            }
            b(false);
        }
    }

    @Override // com.tencent.luggage.wxa.vf.b
    public void a(ArrayList filters) {
        Intrinsics.checkNotNullParameter(filters, "filters");
        if (filters.size() == 0) {
            return;
        }
        this.f143430i = 0;
        Iterator it = filters.iterator();
        while (it.hasNext()) {
            com.tencent.luggage.wxa.wf.b bVar = (com.tencent.luggage.wxa.wf.b) it.next();
            if (bVar == com.tencent.luggage.wxa.wf.b.f144219h) {
                this.f143430i |= 1;
            } else if (bVar == com.tencent.luggage.wxa.wf.b.f144220i) {
                this.f143430i |= 2;
            } else if (bVar == com.tencent.luggage.wxa.wf.b.f144222k) {
                this.f143430i |= 4;
            } else if (bVar == com.tencent.luggage.wxa.wf.b.f144223l) {
                this.f143430i |= 8;
            } else {
                w.d("MicroMsg.AppBrand.NFCDiscoverableReaderModeImpl", "setNFCFilters, unsupported %s", bVar.f());
            }
        }
    }
}
