package com.tencent.mobileqq.guild.usecases;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.share.GuildShareWrapper;
import com.tencent.mobileqq.guild.share.ShareInfoResult;
import com.tencent.mobileqq.guild.share.t;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.ey;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final IGProGuildInfo f235314a;

    /* renamed from: b, reason: collision with root package name */
    private final IGProChannelInfo f235315b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC7909b f235316c;

    /* renamed from: d, reason: collision with root package name */
    private final int f235317d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements t {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.share.t
        public void a(@NonNull ShareInfoResult shareInfoResult) {
            b.this.f(shareInfoResult);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.usecases.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC7909b {
        void a(@NonNull ri1.a aVar, @Nullable c cVar);
    }

    public b(@NonNull IGProGuildInfo iGProGuildInfo, @Nullable IGProChannelInfo iGProChannelInfo, int i3, @NonNull InterfaceC7909b interfaceC7909b) {
        this.f235314a = iGProGuildInfo;
        this.f235315b = iGProChannelInfo;
        this.f235317d = i3;
        this.f235316c = interfaceC7909b;
    }

    private ArrayList<ey> a(HashMap<String, String> hashMap) {
        if (hashMap != null && !hashMap.isEmpty()) {
            ArrayList<ey> arrayList = new ArrayList<>();
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                ey eyVar = new ey();
                if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getKey())) {
                    eyVar.c(entry.getKey());
                    eyVar.d(entry.getValue());
                    arrayList.add(eyVar);
                }
            }
            return arrayList;
        }
        return null;
    }

    private void b(@NonNull ri1.a aVar, @NonNull c cVar) {
        if (aVar.f431477a != 0) {
            QLog.w("Guild.share.FetchShareInfoUseCase", 1, String.format("onFetchGuildShareUrl,  error=%s, url=%s", aVar, cVar.f235319a));
        } else if (QLog.isColorLevel()) {
            QLog.d("Guild.share.FetchShareInfoUseCase", 2, String.format("onFetchGuildShareUrl,  error=%s, url=%s", aVar, cVar.f235319a));
        }
        this.f235316c.a(aVar, cVar);
    }

    private void c(HashMap<String, String> hashMap) {
        IGProChannelInfo iGProChannelInfo;
        a aVar = new a();
        int i3 = this.f235317d;
        if (i3 != 9 && i3 != 15 && (iGProChannelInfo = this.f235315b) != null) {
            GuildShareWrapper.e(this.f235314a.getGuildID(), iGProChannelInfo.getChannelUin(), this.f235317d, new byte[0], a(hashMap), aVar);
        } else {
            GuildShareWrapper.e(this.f235314a.getGuildID(), "", this.f235317d, new byte[0], a(hashMap), aVar);
        }
    }

    public static void g(@NonNull IGProGuildInfo iGProGuildInfo, @Nullable IGProChannelInfo iGProChannelInfo, int i3, InterfaceC7909b interfaceC7909b) {
        new b(iGProGuildInfo, iGProChannelInfo, i3, interfaceC7909b).d();
    }

    public static void h(@NonNull IGProGuildInfo iGProGuildInfo, @NonNull IGProChannelInfo iGProChannelInfo, int i3, HashMap<String, String> hashMap, InterfaceC7909b interfaceC7909b) {
        new b(iGProGuildInfo, iGProChannelInfo, i3, interfaceC7909b).e(hashMap);
    }

    public void d() {
        c(null);
    }

    public void e(HashMap<String, String> hashMap) {
        c(hashMap);
    }

    public void f(@NonNull ShareInfoResult shareInfoResult) {
        QLog.d("Guild.share.FetchShareInfoUseCase", 1, "fetchShareInfoCallback0x10c3 onFetchGuildShareUrl, url=", shareInfoResult.getShareUrl());
        c cVar = new c(shareInfoResult.getShareUrl(), shareInfoResult.getShareInfo());
        if (shareInfoResult.getShareExtendInfo() != null && !TextUtils.isEmpty(shareInfoResult.getShareExtendInfo().getShareCopywriting())) {
            cVar.f235321c = shareInfoResult.getShareExtendInfo().getShareCopywriting();
        }
        if (!ch.p(shareInfoResult.getSecResult())) {
            b(ri1.a.c(-200, "\u5b89\u5168\u9519\u8bef", shareInfoResult.getSecResult()), cVar);
        } else {
            cVar.f235323e = shareInfoResult.getLongShareUrl();
            b(ri1.a.b(shareInfoResult.getResult(), shareInfoResult.getErrMsg()), cVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f235319a;

        /* renamed from: b, reason: collision with root package name */
        public final String f235320b;

        /* renamed from: c, reason: collision with root package name */
        public String f235321c;

        /* renamed from: d, reason: collision with root package name */
        public String f235322d;

        /* renamed from: e, reason: collision with root package name */
        public String f235323e;

        /* renamed from: f, reason: collision with root package name */
        public String f235324f;

        public c(String str, String str2) {
            this.f235319a = str;
            this.f235320b = str2;
        }

        public String toString() {
            return "ShareUrlInfo{url='" + this.f235319a + "', info='" + this.f235320b + "', title='" + this.f235321c + "', desc='" + this.f235322d + "', longUrl='" + this.f235323e + "'}";
        }

        public c(String str, String str2, String str3, String str4, String str5) {
            this(str, str2);
            this.f235321c = str3;
            this.f235322d = str4;
            this.f235323e = str5;
        }
    }
}
