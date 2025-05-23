package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetUserListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProLoadNextPageMemberListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import vh2.bl;

/* loaded from: classes17.dex */
public class GProUserListPaginationRequest {

    /* renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<String, ArrayList<GProUser>> f269557d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private static final Handler f269558e = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    private final IKernelGuildService f269559a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f269560b = false;

    /* renamed from: c, reason: collision with root package name */
    private long f269561c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a implements IGProGetUserListCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f269567a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ vh2.bl f269568b;

        a(String str, vh2.bl blVar) {
            this.f269567a = str;
            this.f269568b = blVar;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetUserListCallback
        public void onGetUserList(int i3, String str, boolean z16, boolean z17, byte[] bArr, ArrayList<GProUser> arrayList, ArrayList<GProUser> arrayList2, ArrayList<GProUser> arrayList3) {
            GProUserListPaginationRequest.this.g(this.f269567a, i3, str, z17, bArr, arrayList, arrayList2, arrayList3, this.f269568b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class b implements IGProLoadNextPageMemberListCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f269570a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ vh2.bl f269571b;

        b(String str, vh2.bl blVar) {
            this.f269570a = str;
            this.f269571b = blVar;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProLoadNextPageMemberListCallback
        public void onGetMemberList(int i3, String str, boolean z16, boolean z17, byte[] bArr, ArrayList<GProUser> arrayList, ArrayList<GProUser> arrayList2, ArrayList<GProUser> arrayList3) {
            GProUserListPaginationRequest.this.g(this.f269570a, i3, str, z17, bArr, arrayList, arrayList2, arrayList3, this.f269571b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static class c {

        /* renamed from: d, reason: collision with root package name */
        private static final AtomicInteger f269573d = new AtomicInteger(0);

        /* renamed from: a, reason: collision with root package name */
        private String f269574a;

        /* renamed from: b, reason: collision with root package name */
        private String f269575b;

        /* renamed from: c, reason: collision with root package name */
        private byte[] f269576c;

        c() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static c c(String str, byte[] bArr) {
            c cVar = new c();
            cVar.f269574a = String.format(Locale.getDefault(), "REQUEST-%08d", Integer.valueOf(f269573d.incrementAndGet()));
            cVar.f269575b = str;
            cVar.f269576c = bArr;
            return cVar;
        }
    }

    GProUserListPaginationRequest(IKernelGuildService iKernelGuildService) {
        this.f269559a = iKernelGuildService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<IGProUserInfo> d(List<GProUser> list) {
        ArrayList<IGProUserInfo> arrayList = new ArrayList<>();
        Iterator<GProUser> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new GProUserInfo(it.next()));
        }
        return arrayList;
    }

    private void e(final c cVar, final vh2.bl blVar, final boolean z16) {
        QLog.e("GProUserListPaginationRequest", 1, "dispatchCallback() hasMore: " + z16);
        f269558e.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProUserListPaginationRequest.4
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = (ArrayList) GProUserListPaginationRequest.f269557d.get(cVar.f269574a);
                QLog.e("GProUserListPaginationRequest", 1, "dispatchCallback() userList: " + arrayList.size());
                bl.a a16 = bl.a.a(GProUserListPaginationRequest.d(arrayList), cVar, true ^ z16);
                if (QLog.isColorLevel()) {
                    QLog.d("GProUserListPaginationRequest", 2, "dispatchCallback() " + a16);
                }
                blVar.a(a16);
                if (!z16) {
                    GProUserListPaginationRequest.f269557d.remove(cVar.f269574a);
                }
            }
        });
    }

    private void f(int i3, String str, final vh2.bl blVar) {
        final bl.a b16 = bl.a.b(i3, str);
        QLog.e("GProUserListPaginationRequest", 1, "dispatchErrorCallback() " + b16);
        f269558e.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.wrapper.GProUserListPaginationRequest.3
            @Override // java.lang.Runnable
            public void run() {
                blVar.a(b16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(@NonNull String str, int i3, String str2, boolean z16, byte[] bArr, ArrayList<GProUser> arrayList, ArrayList<GProUser> arrayList2, ArrayList<GProUser> arrayList3, @NonNull vh2.bl blVar) {
        if (i3 != 0) {
            f(i3, str2, blVar);
            return;
        }
        ArrayList<GProUser> arrayList4 = new ArrayList<>();
        arrayList4.addAll(arrayList);
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        c c16 = c.c(str, bArr);
        f269557d.put(c16.f269574a, arrayList4);
        e(c16, blVar, z16);
    }

    public static GProUserListPaginationRequest j(IKernelGuildService iKernelGuildService) {
        return new GProUserListPaginationRequest(iKernelGuildService);
    }

    public GProUserListPaginationRequest h(boolean z16) {
        this.f269560b = z16;
        return this;
    }

    public void i(@NonNull String str, @Nullable Object obj, int i3, @NonNull vh2.bl blVar) {
        if (com.tencent.mobileqq.qqguildsdk.util.j.i(str)) {
            f(-90, "guildId \u53c2\u6570\u5f02\u5e38!", blVar);
            return;
        }
        if (obj != null && !(obj instanceof c)) {
            f(-90, "Cookie \u53c2\u6570\u5f02\u5e38!", blVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GProUserListPaginationRequest", 2, "getUserList() call: mSdkWrapper.getUserList() with", str, " ", Long.valueOf(this.f269561c), " ", Boolean.valueOf(this.f269560b));
        }
        if (obj == null) {
            this.f269559a.getUserList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), this.f269561c, this.f269560b, i3, new a(str, blVar));
        } else {
            this.f269559a.loadNextPageMemberList(com.tencent.mobileqq.qqguildsdk.util.g.O0(str), this.f269561c, this.f269560b, ((c) obj).f269576c, i3, new b(str, blVar));
        }
    }

    public GProUserListPaginationRequest k(long j3) {
        this.f269561c = j3;
        return this;
    }
}
