package ho2;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private int f405448a;

    /* renamed from: b, reason: collision with root package name */
    private int f405449b;

    /* renamed from: c, reason: collision with root package name */
    private String f405450c;

    public b() {
        this(0);
    }

    private boolean b(int i3) {
        if (i3 != 0 && i3 != 2 && i3 != 3) {
            return false;
        }
        return true;
    }

    private void c() {
        int i3 = this.f405448a;
        if (i3 != 2) {
            if (i3 != 3) {
                this.f405450c = "none";
                return;
            } else {
                this.f405450c = QCircleScheme.AttrQQGroupDetail.PERSONAL;
                this.f405449b = R.drawable.n8_;
                return;
            }
        }
        this.f405450c = IProfileProtocolConst.KEY_COMPANY;
        this.f405449b = R.drawable.n89;
    }

    public String a() {
        return this.f405450c;
    }

    public String toString() {
        return "GuildSearchChannelAuthenticate{flag=" + this.f405448a + ", resId=" + this.f405449b + ", reportTag='" + this.f405450c + "'}";
    }

    public b(int i3) {
        this.f405448a = 0;
        if (b(i3)) {
            this.f405448a = i3;
        }
        c();
    }
}
