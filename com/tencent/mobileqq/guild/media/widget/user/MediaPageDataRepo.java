package com.tencent.mobileqq.guild.media.widget.user;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.r;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelRaiseHandHelper;
import com.tencent.mobileqq.guild.media.core.m;
import com.tencent.mobileqq.guild.media.core.w;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import rt1.GameNormalItem;
import rt1.LoadPlayerDataResult;
import rt1.LoadViewerDataResult;
import rt1.MediaInviteItem;
import rt1.MediaPlayerMoreItem;
import rt1.MediaPlayerRobotUserItem;
import rt1.MediaPlayerUserItem;
import rt1.MediaViewerMoreItem;
import rt1.MediaViewerTitleItem;
import rt1.MediaViewerUserItem;
import rt1.PageLoadLoadParams;
import tl.h;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b3\u00104J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002J0\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J@\u0010\u001b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0002J\u001e\u0010\u001e\u001a\u00020\u001d2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\u001e\u0010\u001f\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 J\u000e\u0010#\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 J\u0016\u0010&\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010%\u001a\u00020$R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020 0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010+R!\u00102\u001a\b\u0012\u0004\u0012\u00020.0-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010/\u001a\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/MediaPageDataRepo;", "", "Ljava/util/ArrayList;", "Lrt1/a;", "items", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userList", "res", "Lrt1/c;", "e", "f", "", "c", "playerNum", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "tailUserInfo", "g", "Lrt1/d;", "j", "dstResList", "totalViewerNum", "viewerNumAlreadyAdded", "moreViewerStartIndex", "tailViewerInfo", "k", ITVKPlayerEventListener.KEY_USER_INFO, "", h.F, "i", "Lcom/tencent/mobileqq/guild/media/widget/user/b;", "observer", "b", "o", "Lrt1/m;", "loadParams", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "a", "Ljava/util/concurrent/CopyOnWriteArrayList;", "observers", "Lrt1/m;", "mLoadParams", "", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelRaiseHandHelper$RaiseHandState;", "Lkotlin/Lazy;", "getMNeedShowRaiseHandTypeList", "()Ljava/util/List;", "mNeedShowRaiseHandTypeList", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaPageDataRepo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<b> observers = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PageLoadLoadParams mLoadParams = new PageLoadLoadParams(false, false, false, 7, null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mNeedShowRaiseHandTypeList;

    public MediaPageDataRepo() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends MediaChannelRaiseHandHelper.RaiseHandState>>() { // from class: com.tencent.mobileqq.guild.media.widget.user.MediaPageDataRepo$mNeedShowRaiseHandTypeList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends MediaChannelRaiseHandHelper.RaiseHandState> invoke() {
                List<? extends MediaChannelRaiseHandHelper.RaiseHandState> listOf;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new MediaChannelRaiseHandHelper.RaiseHandState[]{MediaChannelRaiseHandHelper.RaiseHandState.MANAGER, MediaChannelRaiseHandHelper.RaiseHandState.PLAIN_USER_NOT_CLICK, MediaChannelRaiseHandHelper.RaiseHandState.PLAIN_USER_CLICKED});
                return listOf;
            }
        });
        this.mNeedShowRaiseHandTypeList = lazy;
    }

    private final int c(r userList) {
        int i3;
        int coerceAtMost;
        if (this.mLoadParams.getIsFromGame()) {
            i3 = 4;
        } else {
            i3 = 9;
        }
        Iterator<p> it = userList.f228125a.iterator();
        int i16 = 0;
        while (it.hasNext() && (it.next().f228099g != 1 || (i16 = i16 + 1) < i3)) {
        }
        if (!j.a().H0().A(false)) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i16, i3);
            return coerceAtMost;
        }
        if (i16 < 6) {
            return 2;
        }
        return 3;
    }

    private final LoadPlayerDataResult e(r userList, ArrayList<rt1.a> res) {
        int maxDetailShowNum = j.c().getMaxPlayerShowRule().getMaxDetailShowNum();
        int i3 = 0;
        p pVar = null;
        int i16 = 0;
        for (p pVar2 : userList.f228125a) {
            int i17 = pVar2.f228099g;
            if (i17 == 1) {
                if (i3 >= maxDetailShowNum) {
                    if (i3 == maxDetailShowNum) {
                        pVar = pVar2.c();
                    }
                } else {
                    p c16 = pVar2.c();
                    Intrinsics.checkNotNullExpressionValue(c16, "userInfo.copy()");
                    h(res, c16);
                }
                i3++;
            } else if (i17 == 2) {
                i16++;
            }
        }
        return new LoadPlayerDataResult(i3, i16, pVar);
    }

    private final void f(r userList, ArrayList<rt1.a> res) {
        int c16 = c(userList);
        int i3 = 0;
        for (p pVar : userList.f228125a) {
            if (pVar.f228099g == 1) {
                p c17 = pVar.c();
                Intrinsics.checkNotNullExpressionValue(c17, "userInfo.copy()");
                if (h(res, c17)) {
                    i3++;
                }
            }
            if (i3 >= c16) {
                return;
            }
        }
    }

    private final void g(r userList, ArrayList<rt1.a> res, int playerNum, p tailUserInfo) {
        int coerceAtMost;
        int coerceAtMost2;
        if (playerNum == res.size() + 1 && tailUserInfo != null) {
            p c16 = tailUserInfo.c();
            Intrinsics.checkNotNullExpressionValue(c16, "tailUserInfo.copy()");
            h(res, c16);
            return;
        }
        if (playerNum == 0) {
            w.c("getItemViewType_Screen");
            boolean A = j.a().H0().A(false);
            w.d();
            if (!A && !j.a().d0().m1() && m.n(j.c()) != 2) {
                res.add(new MediaInviteItem("MediaInviteItem", 1));
                return;
            }
            return;
        }
        if (playerNum > j.c().getMaxPlayerShowRule().getMaxDetailShowNum()) {
            int maxThumbnailShowNum = j.c().getMaxPlayerShowRule().getMaxThumbnailShowNum();
            int maxDetailShowNum = j.c().getMaxPlayerShowRule().getMaxDetailShowNum();
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(playerNum - maxDetailShowNum, maxThumbnailShowNum);
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(coerceAtMost + maxDetailShowNum, userList.f228125a.size());
            if (maxDetailShowNum >= 0 && maxDetailShowNum < userList.f228125a.size() && coerceAtMost2 > maxDetailShowNum) {
                try {
                    res.add(new MediaPlayerMoreItem(userList.f228125a.subList(maxDetailShowNum, coerceAtMost2)));
                    return;
                } catch (IndexOutOfBoundsException e16) {
                    QLog.e("QGMC.MediaUserDataRepo", 1, "[loadPlayerTailGrid] failed " + e16, e16);
                    return;
                }
            }
            return;
        }
        MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
        if (!mediaChannelUtils.u(j.c().e()) && j.c().getSelfUserInfo().f228099g == 1 && playerNum == 1) {
            if (MediaChannelUtils.o(mediaChannelUtils, null, 1, null) != 4 || MediaChannelUtils.o(mediaChannelUtils, null, 1, null) != 4) {
                res.add(new MediaInviteItem("MediaInviteItem", 2));
            }
        }
    }

    private final boolean h(ArrayList<rt1.a> res, p userInfo) {
        if (this.mLoadParams.getNeedIgnoreSelf() && TextUtils.equals(userInfo.f228093a, j.c().getSelfUserInfo().f228093a)) {
            return false;
        }
        if (userInfo.f228098f == 1) {
            res.add(new MediaPlayerRobotUserItem(userInfo));
        } else if (this.mLoadParams.getIsFromGame()) {
            res.add(new GameNormalItem(userInfo));
        } else {
            res.add(new MediaPlayerUserItem(userInfo));
        }
        return true;
    }

    private final void i(ArrayList<rt1.a> res, p userInfo) {
        if (this.mLoadParams.getNeedIgnoreSelf() && TextUtils.equals(userInfo.f228093a, j.c().getSelfUserInfo().f228093a)) {
            return;
        }
        res.add(new MediaViewerUserItem(userInfo));
    }

    private final LoadViewerDataResult j(r userList, ArrayList<rt1.a> res) {
        p pVar;
        int maxDetailShowNum = j.c().getMaxViewerShowRule().getMaxDetailShowNum();
        int size = userList.f228125a.size();
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (i3 < size) {
                pVar = userList.f228125a.get(i3);
                if (pVar.f228099g == 2) {
                    if (i16 >= maxDetailShowNum) {
                        break;
                    }
                    p c16 = pVar.c();
                    Intrinsics.checkNotNullExpressionValue(c16, "userInfo.copy()");
                    i(res, c16);
                    i16++;
                }
                i3++;
            } else {
                i3 = -1;
                pVar = null;
                break;
            }
        }
        return new LoadViewerDataResult(i16, i3, pVar);
    }

    private final void k(r userList, ArrayList<rt1.a> dstResList, int totalViewerNum, int viewerNumAlreadyAdded, int moreViewerStartIndex, p tailViewerInfo) {
        int coerceAtMost;
        int coerceAtMost2;
        if (totalViewerNum == viewerNumAlreadyAdded + 1 && tailViewerInfo != null) {
            p c16 = tailViewerInfo.c();
            Intrinsics.checkNotNullExpressionValue(c16, "tailViewerInfo.copy()");
            i(dstResList, c16);
            return;
        }
        if (totalViewerNum >= viewerNumAlreadyAdded + 2) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(totalViewerNum - j.c().getMaxViewerShowRule().getMaxDetailShowNum(), j.c().getMaxViewerShowRule().getMaxThumbnailShowNum());
            int size = userList.f228125a.size();
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(coerceAtMost + moreViewerStartIndex, size);
            if (moreViewerStartIndex >= 0 && moreViewerStartIndex < size && coerceAtMost2 > moreViewerStartIndex) {
                try {
                    dstResList.add(new MediaViewerMoreItem(userList.f228125a.subList(moreViewerStartIndex, coerceAtMost2)));
                } catch (IndexOutOfBoundsException e16) {
                    QLog.e("QGMC.MediaUserDataRepo", 1, "[loadViewerTailGrid] failed. " + e16, e16);
                }
            }
        }
    }

    private final void l(ArrayList<rt1.a> items) {
        Iterator<T> it = this.observers.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(items);
        }
    }

    private final void m(final ArrayList<rt1.a> items) {
        if (UiThreadUtil.isOnUiThread()) {
            l(items);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.user.c
                @Override // java.lang.Runnable
                public final void run() {
                    MediaPageDataRepo.n(MediaPageDataRepo.this, items);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(MediaPageDataRepo this$0, ArrayList items) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(items, "$items");
        this$0.l(items);
    }

    public final void b(@NotNull b observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.remove(observer);
        this.observers.add(observer);
    }

    public final void d(@NotNull r userList, @NotNull PageLoadLoadParams loadParams) {
        boolean z16;
        Intrinsics.checkNotNullParameter(userList, "userList");
        Intrinsics.checkNotNullParameter(loadParams, "loadParams");
        this.mLoadParams = loadParams;
        List<p> list = userList.f228125a;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            m(new ArrayList<>());
            return;
        }
        ArrayList<rt1.a> arrayList = new ArrayList<>();
        r F = MediaChannelUtils.F(userList);
        if (this.mLoadParams.getIsFromQCircle()) {
            f(F, arrayList);
            m(arrayList);
            return;
        }
        LoadPlayerDataResult e16 = e(F, arrayList);
        int playerNumInCache = e16.getPlayerNumInCache();
        int viewerNumInCache = e16.getViewerNumInCache();
        g(F, arrayList, playerNumInCache, e16.getTailPlayerInfo());
        arrayList.add(new MediaViewerTitleItem(null, 1, null));
        LoadViewerDataResult j3 = j(F, arrayList);
        k(F, arrayList, viewerNumInCache, j3.getViewerNumInCache(), j3.getViewerMoreStartIndex(), j3.getTailViewerInfo());
        m(arrayList);
    }

    public final void o(@NotNull b observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.remove(observer);
    }
}
