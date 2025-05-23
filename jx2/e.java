package jx2;

import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.paysdk.api.IUserInfoProvider;
import com.tencent.paysdk.api.j;
import jy2.g;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e implements IUserInfoProvider {

    /* renamed from: a, reason: collision with root package name */
    private String f411065a;

    /* renamed from: b, reason: collision with root package name */
    private String f411066b;

    /* renamed from: c, reason: collision with root package name */
    private a f411067c;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements j {

        /* renamed from: a, reason: collision with root package name */
        bu2.a f411068a = zt2.e.f453199a.i();

        public a() {
        }

        @Override // com.tencent.paysdk.api.j
        @NonNull
        public String a() {
            return e.this.f411065a;
        }

        @Override // com.tencent.paysdk.api.j
        @NonNull
        public String b() {
            return "102031143";
        }

        @Override // com.tencent.paysdk.api.j
        @NonNull
        public String c() {
            bu2.a aVar = this.f411068a;
            if (aVar != null) {
                return aVar.getNickName();
            }
            return "";
        }

        @Override // com.tencent.paysdk.api.j
        @NonNull
        public String d() {
            bu2.a aVar = this.f411068a;
            if (aVar != null) {
                return aVar.getRefreshToken();
            }
            return "";
        }

        @Override // com.tencent.paysdk.api.j
        @NonNull
        public String e() {
            bu2.a aVar = this.f411068a;
            if (aVar != null) {
                return aVar.getCom.huawei.hms.support.feature.result.CommonConstant.KEY_ACCESS_TOKEN java.lang.String();
            }
            return "";
        }

        @Override // com.tencent.paysdk.api.j
        @NonNull
        public String f() {
            bu2.a aVar = this.f411068a;
            if (aVar != null) {
                return aVar.getVideoSessionKey();
            }
            return "";
        }

        @Override // com.tencent.paysdk.api.j
        @NonNull
        public String g() {
            bu2.a aVar = this.f411068a;
            if (aVar != null) {
                return aVar.getHeadImageUrl();
            }
            return "";
        }

        @Override // com.tencent.paysdk.api.j
        @NonNull
        public String h() {
            bu2.a aVar = this.f411068a;
            if (aVar != null) {
                return aVar.getOpenId();
            }
            return "";
        }

        @Override // com.tencent.paysdk.api.j
        @NonNull
        public String i() {
            if (this.f411068a == null) {
                return "";
            }
            return this.f411068a.getVideoUserId() + "";
        }

        @Override // com.tencent.paysdk.api.j
        @NonNull
        public String j() {
            return e.this.f411066b;
        }
    }

    public e() {
        this.f411065a = "";
        this.f411066b = "";
        if (zt2.e.f453199a.k()) {
            this.f411065a = com.tencent.mobileqq.webview.swift.cookie.b.e(RFWApplication.getAccountId());
            this.f411066b = g.l(false);
        }
    }

    @Override // com.tencent.paysdk.api.IUserInfoProvider
    @NonNull
    public j getUserInfo() {
        if (this.f411067c == null) {
            this.f411067c = new a();
        }
        return this.f411067c;
    }

    @Override // com.tencent.paysdk.api.IUserInfoProvider
    @NonNull
    public IUserInfoProvider.UserType type() {
        return IUserInfoProvider.UserType.QQ;
    }
}
