package com.tencent.mobileqq.guild.media.detail;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.r;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudioLiveUserListRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.q;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.ad;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tJ \u0010\u0011\u001a\u00020\u00062\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ\u0014\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012R\u0016\u0010\u0018\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R'\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0019j\b\u0012\u0004\u0012\u00020\r`\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/media/detail/d;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/q;", "d", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAudioLiveUserListRsp;", "userListRsp", "", "f", "g", "Lkotlin/Function0;", "sucBlock", tl.h.F, "", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "data", "", "addLast", "b", "", "", "userIdList", "j", "a", "Z", "isPageEnd", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "e", "()Ljava/util/ArrayList;", "sortedUserList", "<init>", "()V", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isPageEnd;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<p> sortedUserList = new ArrayList<>();

    public static /* synthetic */ void c(d dVar, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        dVar.b(list, z16);
    }

    private final q d() {
        int size;
        q qVar = new q();
        qVar.j(Long.parseLong(com.tencent.mobileqq.guild.media.core.j.a().getGuildID()));
        qVar.i(Long.parseLong(com.tencent.mobileqq.guild.media.core.j.a().E()));
        if (this.sortedUserList.isEmpty()) {
            size = 0;
        } else {
            size = this.sortedUserList.size() - 1;
        }
        qVar.m(size);
        qVar.n(50);
        return qVar;
    }

    private final void f(IGProAudioLiveUserListRsp userListRsp) {
        QLog.d("QGMC.Core.MediaDetailUserListRepo", 1, "fetchAudioLiveChannelUserList " + userListRsp.getChannelMemberInfo().getUserList().size());
        this.isPageEnd = userListRsp.getIsEndPage();
        if (userListRsp.getChannelMemberInfo().getUserList().size() <= 0) {
            return;
        }
        ArrayList<p> arrayList = new ArrayList();
        p.h(userListRsp.getChannelMemberInfo().getUserList(), arrayList);
        for (p pVar : arrayList) {
            QLog.d("QGMC.Core.MediaDetailUserListRepo", 4, "handleFetchResult, " + pVar.f228094b + "-" + pVar.C.getSortKey());
            if (MediaChannelUtils.C(com.tencent.mobileqq.guild.media.core.j.a().E()) && MediaChannelUtils.E(pVar)) {
                pVar.f228099g = 2;
            }
        }
        c(this, arrayList, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(d this$0, Function0 sucBlock, int i3, String str, IGProAudioLiveUserListRsp userListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sucBlock, "$sucBlock");
        QLog.d("QGMC.Core.MediaDetailUserListRepo", 1, "fetchAudioLiveChannelUserList " + i3 + " " + str);
        if (i3 == 0) {
            Intrinsics.checkNotNullExpressionValue(userListRsp, "userListRsp");
            this$0.f(userListRsp);
            sucBlock.invoke();
        }
    }

    public final void b(@Nullable List<? extends p> data, boolean addLast) {
        if (data == null) {
            return;
        }
        r rVar = new r();
        if (!addLast) {
            rVar.f228125a.addAll(data);
        }
        rVar.f228125a.addAll(this.sortedUserList);
        if (addLast) {
            rVar.f228125a.addAll(data);
        }
        r F = MediaChannelUtils.F(rVar);
        this.sortedUserList.clear();
        this.sortedUserList.addAll(F.f228125a);
    }

    @NotNull
    public final ArrayList<p> e() {
        return this.sortedUserList;
    }

    public final void g() {
        this.sortedUserList.addAll(com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().f228125a);
    }

    public final void h(@NotNull final Function0<Unit> sucBlock) {
        Intrinsics.checkNotNullParameter(sucBlock, "sucBlock");
        if (this.isPageEnd) {
            QLog.i("QGMC.Core.MediaDetailUserListRepo", 1, "loadMoreUserList, isPageEnd, ignore.");
            return;
        }
        AppInterface l3 = ch.l();
        Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
        IRuntimeService runtimeService = l3.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        ((IGPSService) runtimeService).fetchAudioLiveChannelUserList(d(), new ad() { // from class: com.tencent.mobileqq.guild.media.detail.c
            @Override // wh2.ad
            public final void a(int i3, String str, IGProAudioLiveUserListRsp iGProAudioLiveUserListRsp) {
                d.i(d.this, sucBlock, i3, str, iGProAudioLiveUserListRsp);
            }
        });
    }

    public final boolean j(@NotNull List<String> userIdList) {
        Set set;
        Intrinsics.checkNotNullParameter(userIdList, "userIdList");
        set = CollectionsKt___CollectionsKt.toSet(userIdList);
        ArrayList arrayList = new ArrayList();
        boolean z16 = false;
        for (p pVar : this.sortedUserList) {
            if (!set.contains(pVar.f228093a)) {
                arrayList.add(pVar);
            } else {
                z16 = true;
            }
        }
        if (z16) {
            this.sortedUserList.clear();
            this.sortedUserList.addAll(arrayList);
        }
        return z16;
    }
}
