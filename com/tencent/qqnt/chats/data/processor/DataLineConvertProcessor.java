package com.tencent.qqnt.chats.data.processor;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatPartConvertProcessor;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.adapter.menu.creator.c;
import com.tencent.qqnt.chats.data.converter.e;
import com.tencent.qqnt.chats.data.converter.g;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import cooperation.qzone.util.QZoneImageUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@KeepClassConstructor
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/chats/data/processor/DataLineConvertProcessor;", "Lcom/tencent/qqnt/chats/data/converter/e;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "c", "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "e", "d", "", "peerUid", "b", "", QZoneImageUtils.KEY_MATCH, "update", "", "a", "", "Lcom/tencent/qqnt/chats/data/converter/g;", "Ljava/util/List;", "mProcessorList", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class DataLineConvertProcessor extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<g> mProcessorList;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/data/processor/DataLineConvertProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.data.processor.DataLineConvertProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44808);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public DataLineConvertProcessor() {
        List<g> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new g[]{(g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createSummaryConvertProcessor(), (g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createTimeConvertProcessor(), (g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createUnreadConvertProcessor()});
            this.mProcessorList = listOf;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String b(String peerUid) {
        int hashCode = peerUid.hashCode();
        if (hashCode != -1834626455) {
            if (hashCode != -1656358474) {
                if (hashCode == 1930502276 && peerUid.equals(PeerUid.DATALINE_PC_UID)) {
                    return "\u6211\u7684\u7535\u8111";
                }
            } else if (peerUid.equals(PeerUid.DATALINE_PAD_UID)) {
                return "\u6211\u7684Pad";
            }
        } else if (peerUid.equals(PeerUid.DATALINE_PHONE_UID)) {
            return "\u6211\u7684\u624b\u673a";
        }
        return "";
    }

    private final void c(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        item.g().n(2);
        try {
            QLog.i("DataLineConvertProcessor", 1, "processAvatar for new contact, uid=" + item.s().peerUid + ", uin=" + item.s().peerUin);
            g.a g16 = item.g();
            String str = item.s().peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "item.originData.peerUid");
            g16.l(Integer.valueOf(a(str)));
        } catch (NumberFormatException e16) {
            QLog.e("DataLineConvertProcessor", 1, "processAvatar error:" + e16);
        }
    }

    private final void d(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        ArrayList arrayList = new ArrayList();
        if (item.H()) {
            arrayList.add(c.INSTANCE.d());
        } else {
            arrayList.add(c.INSTANCE.q());
        }
        arrayList.add(c.INSTANCE.g());
        item.O(arrayList);
    }

    private final void e(com.tencent.qqnt.chats.core.adapter.itemdata.g item, com.tencent.qqnt.chats.data.converter.c params) {
        QLog.i("DataLineConvertProcessor", 1, "processTitle for new contact, uid=" + item.s().peerUid + ", uin=" + item.s().peerUin);
        g.f w3 = item.w();
        String str = item.s().peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "item.originData.peerUid");
        w3.i(b(str));
    }

    public final int a(@NotNull String peerUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) peerUid)).intValue();
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        int hashCode = peerUid.hashCode();
        if (hashCode != -1834626455) {
            if (hashCode != -1656358474) {
                if (hashCode == 1930502276 && peerUid.equals(PeerUid.DATALINE_PC_UID)) {
                    return R.drawable.qfile_dataline_pc_recent;
                }
            } else if (peerUid.equals(PeerUid.DATALINE_PAD_UID)) {
                return R.drawable.qfile_dataline_ipad_recent;
            }
        } else if (peerUid.equals(PeerUid.DATALINE_PHONE_UID)) {
            return R.drawable.qfile_dataline_user_aio;
        }
        return 0;
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public boolean match(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.n() == 8) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull com.tencent.qqnt.chats.data.converter.c params) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        List<com.tencent.qqnt.chats.data.converter.g> list = this.mProcessorList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.qqnt.chats.data.converter.g) it.next()).update(item, params);
            arrayList.add(Unit.INSTANCE);
        }
        c(item);
        e(item, params);
        d(item);
    }
}
