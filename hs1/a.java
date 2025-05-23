package hs1;

import android.content.Intent;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.i;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.empty.GuildRightEmptyFragment;
import com.tencent.mobileqq.guild.util.q;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cs1.b;
import gs1.c;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends c {

    /* renamed from: i, reason: collision with root package name */
    private static final int f406121i = ViewUtils.dpToPx(0.0f);

    /* renamed from: f, reason: collision with root package name */
    GuildRightEmptyFragment f406122f;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup f406123h;

    public a(i iVar) {
        super(iVar);
        this.f406123h = null;
    }

    @Override // gs1.c
    public int k() {
        return 4;
    }

    @Override // gs1.c
    public void l() {
        GuildRightEmptyFragment guildRightEmptyFragment = this.f406122f;
        if (guildRightEmptyFragment != null) {
            guildRightEmptyFragment.ph();
        } else {
            QLog.w("Guild.MF.Rt.GuildEmptyController", 1, "no need hide fragment is null");
        }
    }

    @Override // gs1.c
    public void n(ViewGroup viewGroup) {
        this.f406123h = viewGroup;
    }

    @Override // gs1.c
    public void o(b bVar, @Nullable GuildAppReportSourceInfo guildAppReportSourceInfo) {
        r();
        this.f406122f.show();
        this.f227466d.d(f406121i);
        this.f227466d.Z0().r();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onDestroy() {
        GuildRightEmptyFragment guildRightEmptyFragment = this.f406122f;
        if (guildRightEmptyFragment != null) {
            q.b(guildRightEmptyFragment);
            this.f406122f = null;
        }
    }

    protected void r() {
        FragmentManager childFragmentManager = g().getChildFragmentManager();
        if (this.f406122f == null) {
            this.f406122f = GuildRightEmptyFragment.qh(new Intent());
            childFragmentManager.beginTransaction().add(this.f406123h.getId(), this.f406122f, "Guild.MF.Rt.GuildEmptyController").commitNowAllowingStateLoss();
        }
    }
}
