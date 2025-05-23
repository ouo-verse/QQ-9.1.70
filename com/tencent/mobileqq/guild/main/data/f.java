package com.tencent.mobileqq.guild.main.data;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes14.dex */
public class f extends d {
    public cy C;
    public IGProGuildInfo D;
    public boolean E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public boolean L;

    private boolean d(f fVar) {
        if (this.F == fVar.F && this.G == fVar.G && this.H == fVar.H && this.I == fVar.I) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.main.data.d
    /* renamed from: a */
    public d clone() throws CloneNotSupportedException {
        f fVar = (f) super.clone();
        fVar.C = this.C;
        fVar.D = this.D;
        fVar.E = this.E;
        fVar.F = this.F;
        fVar.G = this.G;
        fVar.H = this.H;
        fVar.I = this.I;
        fVar.J = this.J;
        fVar.K = this.K;
        fVar.L = this.L;
        return fVar;
    }

    @Override // com.tencent.mobileqq.guild.main.data.d
    public boolean b() {
        if (this.f227156h && (this.F > 0 || this.G > 0 || this.H > 0)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.main.data.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f) || !super.equals(obj)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.E == fVar.E && TextUtils.equals(this.C.getCategoryName(), fVar.C.getCategoryName()) && this.C.getCategoryId() == fVar.C.getCategoryId() && this.C.getChannelList().size() == fVar.C.getChannelList().size() && TextUtils.equals(this.D.getGuildID(), fVar.D.getGuildID()) && d(fVar) && this.K == fVar.K && this.D.getUserType() == fVar.D.getUserType() && this.L == fVar.L) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.main.data.d
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.C, this.D, Boolean.valueOf(this.E), Integer.valueOf(this.F), Integer.valueOf(this.G), Integer.valueOf(this.H), Integer.valueOf(this.I), Integer.valueOf(this.J), Integer.valueOf(this.K), Boolean.valueOf(this.L));
    }

    public String toString() {
        return "QQGuildChannelGroup{mCategoryName='" + this.f227153d + "', mCategoryId='" + this.f227154e + "', mIsCategoryCollapse=" + this.f227156h + ", mShouldAnimate=" + this.E + ", mAboutMeMsgCount=" + this.F + ", mBlueMsgCount=" + this.G + ", mGrayMsgCount=" + this.H + ", mNoNumGrayMsgCount=" + this.I + ", mAboutMeMsgType=" + this.J + ", mUserType=" + this.K + ", mHasCreateChannelPermission=" + this.L + '}';
    }
}
