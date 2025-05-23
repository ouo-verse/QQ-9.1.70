package com.tencent.biz.pubaccount.weishi.profile.header;

import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\nH&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\nH&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\nH&J\b\u0010\u0013\u001a\u00020\u0004H&J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/profile/header/f;", "", "LUserGrowth/stSimpleMetaPerson;", "person", "", "i", "reset", "Lcom/tencent/biz/pubaccount/weishi/profile/header/g;", "profileHeaderView", "e", "", "newFollowStatus", tl.h.F, "newReceiveLikeCnt", "b", "newFansCnt", "p", "newFollowCnt", DomainData.DOMAIN_NAME, "c", "Landroid/content/Context;", "context", "a", "d", "f", "g", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public interface f {
    void a(Context context);

    void b(int newReceiveLikeCnt);

    void c();

    void d(Context context);

    void e(g profileHeaderView);

    void f(Context context);

    void g(Context context);

    void h(int newFollowStatus);

    void i(stSimpleMetaPerson person);

    void n(int newFollowCnt);

    void p(int newFansCnt);

    void reset();
}
