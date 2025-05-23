package com.tencent.mobileqq.aio.msg;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.IFontManager;
import com.tencent.qqnt.aio.mutualmark.api.IAIOMutualMaskApi;
import com.tencent.qqnt.aio.nick.MemberLevelInfoCache;
import com.tencent.qqnt.aio.nick.api.IAIONickBlockApi;
import com.tencent.qqnt.aio.refresher.bd;
import com.tencent.qqnt.aio.refresher.bf;
import com.tencent.qqnt.aio.refresher.bg;
import com.tencent.qqnt.aio.refresher.bh;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000\u001a\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001aX\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n*\u00020\u00002\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\tj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003`\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u000e\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\u0000H\u0000\u001a\f\u0010\u0010\u001a\u00020\u000f*\u00020\u0000H\u0000\u001a\u000e\u0010\u0011\u001a\u0004\u0018\u00010\u0007*\u00020\u0000H\u0000\u001a\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u0007*\u00020\u0000H\u0000\u001a\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0007*\u00020\u0000H\u0000\u001a\u0014\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014*\u00020\u0000H\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "a", "", "qqText", "", "qqTextSize", "Landroid/graphics/drawable/Drawable;", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "qqTextMap", "c", "Lcom/tencent/qqnt/aio/nick/e;", "d", "", "i", "g", tl.h.F, "f", "", "e", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    @Nullable
    public static final AIOBubbleSkinInfo a(@NotNull AIOMsgItem aIOMsgItem) {
        boolean z16;
        AIOBubbleSkinInfo a16;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        com.tencent.mobileqq.aio.utils.m mVar = com.tencent.mobileqq.aio.utils.m.f194167a;
        String b16 = mVar.b(aIOMsgItem);
        if (b16.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !com.tencent.mobileqq.aio.utils.d.s(aIOMsgItem)) {
            com.tencent.qqnt.aio.refresher.g gVar = new com.tencent.qqnt.aio.refresher.g(aIOMsgItem, b16, mVar.a(aIOMsgItem), "", null, 16, null);
            com.tencent.mobileqq.aio.msglist.holder.external.a.f192382a.d(gVar);
            com.tencent.qqnt.aio.refresher.h c16 = gVar.c();
            if (c16 != null && (a16 = c16.a()) != null) {
                return a16;
            }
        }
        return aIOMsgItem.x0();
    }

    @Nullable
    public static final Drawable b(@NotNull AIOMsgItem aIOMsgItem, @NotNull CharSequence qqText, int i3) {
        AIOBubbleSkinInfo.c cVar;
        boolean z16;
        Float f16;
        Integer c16;
        ColorStateList d16;
        Integer a16;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(qqText, "qqText");
        AIOBubbleSkinInfo x06 = aIOMsgItem.x0();
        if (x06 != null) {
            cVar = x06.e();
        } else {
            cVar = null;
        }
        com.tencent.qqnt.aio.utils.n nVar = com.tencent.qqnt.aio.utils.n.f352308a;
        int a17 = nVar.a(aIOMsgItem);
        int b16 = nVar.b(aIOMsgItem);
        int c17 = nVar.c(aIOMsgItem);
        if (a17 > 0 && b16 > 0) {
            if (aIOMsgItem.getMsgRecord().chatType == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            IFontManager.FontDrawableInfo fontDrawableInfo = new IFontManager.FontDrawableInfo(qqText, a17, b16, z16, String.valueOf(aIOMsgItem.getMsgRecord().senderUin), System.currentTimeMillis(), 0L, 64, null);
            fontDrawableInfo.w(c17);
            fontDrawableInfo.z(aIOMsgItem.isSelf());
            if (cVar != null && (a16 = cVar.a()) != null) {
                fontDrawableInfo.A(a16.intValue());
            }
            if (cVar != null && (d16 = cVar.d()) != null) {
                fontDrawableInfo.B(d16);
            }
            if (cVar != null && (c16 = cVar.c()) != null) {
                fontDrawableInfo.v(c16.intValue());
            }
            if (cVar != null) {
                f16 = cVar.e();
            } else {
                f16 = null;
            }
            if (f16 != null) {
                Float e16 = cVar.e();
                Intrinsics.checkNotNull(e16);
                fontDrawableInfo.C((int) e16.floatValue());
            } else {
                fontDrawableInfo.C(i3);
            }
            HashMap hashMap = new HashMap();
            hashMap.put(0, fontDrawableInfo);
            com.tencent.qqnt.aio.refresher.o oVar = new com.tencent.qqnt.aio.refresher.o(aIOMsgItem, hashMap, null, 4, null);
            com.tencent.mobileqq.aio.msglist.holder.external.a.f192382a.d(oVar);
            com.tencent.qqnt.aio.refresher.p c18 = oVar.c();
            if (c18 != null) {
                return c18.a().a().get(0);
            }
            return null;
        }
        return null;
    }

    @Nullable
    public static final HashMap<Integer, Drawable> c(@NotNull AIOMsgItem aIOMsgItem, @NotNull HashMap<Integer, CharSequence> qqTextMap, int i3) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        Intrinsics.checkNotNullParameter(qqTextMap, "qqTextMap");
        HashMap<Integer, Drawable> hashMap = new HashMap<>();
        for (Map.Entry<Integer, CharSequence> entry : qqTextMap.entrySet()) {
            Drawable b16 = b(aIOMsgItem, entry.getValue(), i3);
            if (b16 == null) {
                return null;
            }
            hashMap.put(entry.getKey(), b16);
        }
        return hashMap;
    }

    @Nullable
    public static final com.tencent.qqnt.aio.nick.e d(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        com.tencent.qqnt.aio.refresher.ac acVar = new com.tencent.qqnt.aio.refresher.ac(aIOMsgItem, null, 2, 0 == true ? 1 : 0);
        com.tencent.mobileqq.aio.msglist.holder.external.a.f192382a.d(acVar);
        com.tencent.qqnt.aio.refresher.ad b16 = acVar.b();
        if (b16 == null) {
            return null;
        }
        return b16.a();
    }

    @Nullable
    public static final List<Drawable> e(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        com.tencent.qqnt.aio.msg.e X = aIOMsgItem.X();
        if (X != null) {
            return ((IAIOMutualMaskApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOMutualMaskApi.class)).getDrawable(String.valueOf(aIOMsgItem.getMsgRecord().peerUin), String.valueOf(aIOMsgItem.getMsgRecord().senderUin), X.c(), X.d());
        }
        return null;
    }

    @Nullable
    public static final Drawable f(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        bd bdVar = new bd(aIOMsgItem, null, 2, 0 == true ? 1 : 0);
        com.tencent.mobileqq.aio.msglist.holder.external.a.f192382a.d(bdVar);
        bg b16 = bdVar.b();
        if (b16 == null) {
            return null;
        }
        return b16.a();
    }

    @Nullable
    public static final Drawable g(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        bf bfVar = new bf(aIOMsgItem, null, 2, 0 == true ? 1 : 0);
        com.tencent.mobileqq.aio.msglist.holder.external.a.f192382a.d(bfVar);
        bg b16 = bfVar.b();
        if (b16 == null) {
            return null;
        }
        return b16.a();
    }

    @Nullable
    public static final Drawable h(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        bh bhVar = new bh(aIOMsgItem, null, 2, 0 == true ? 1 : 0);
        com.tencent.mobileqq.aio.msglist.holder.external.a.f192382a.d(bhVar);
        bg b16 = bhVar.b();
        if (b16 == null) {
            return null;
        }
        return b16.a();
    }

    public static final void i(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        aIOMsgItem.v1(((IAIONickBlockApi) QRoute.api(IAIONickBlockApi.class)).getMemberLevelInfo(aIOMsgItem));
        aIOMsgItem.u1(d(aIOMsgItem));
        if (aIOMsgItem.M() != null) {
            MemberLevelInfoCache b16 = MemberLevelInfoCache.INSTANCE.b();
            String str = aIOMsgItem.getMsgRecord().peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "msgRecord.peerUid");
            String str2 = aIOMsgItem.getMsgRecord().senderUid;
            Intrinsics.checkNotNullExpressionValue(str2, "msgRecord.senderUid");
            b16.l(str, str2, aIOMsgItem.M());
        }
    }
}
