package com.tencent.qqnt.chathistory.business;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chathistory.exception.HistoryException;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryFragment;
import com.tencent.qqnt.chathistory.ui.date.ChatHistoryDateFragment;
import com.tencent.qqnt.chathistory.ui.document.ChatHistoryDocumentFragment;
import com.tencent.qqnt.chathistory.ui.file.troop.ChatHistoryTroopFileFragment;
import com.tencent.qqnt.chathistory.ui.link.ChatHistoryLinkFragment;
import com.tencent.qqnt.chathistory.ui.media.ChatHistoryMediaFragment;
import com.tencent.qqnt.chathistory.ui.shortvideo.ChatHistoryShortVideoFragment;
import com.tencent.qqnt.chathistory.ui.sticker.ChatHistoryStickerFragment;
import com.tencent.qqnt.chathistory.ui.troopMember.TroopMemberFragment;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0014\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/chathistory/business/TroopHistoryViewModel;", "Lcom/tencent/qqnt/chathistory/business/a;", "", "position", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryFragment;", "S1", "L1", "M1", "category", "Lkotlin/Pair;", "N1", "", "D", "Z", "fromStorageScan", "", "E", "Lkotlin/Lazy;", "Q1", "()Ljava/util/List;", "tabTexts", UserInfo.SEX_FEMALE, "getTabIds", "tabIds", "", "peerId", "sessionName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class TroopHistoryViewModel extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    private final boolean fromStorageScan;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy tabTexts;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy tabIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopHistoryViewModel(@NotNull String peerId, @Nullable String str, boolean z16) {
        super(peerId, str);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, peerId, str, Boolean.valueOf(z16));
            return;
        }
        this.fromStorageScan = z16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends Integer>>() { // from class: com.tencent.qqnt.chathistory.business.TroopHistoryViewModel$tabTexts$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopHistoryViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends Integer> invoke() {
                boolean z17;
                List<? extends Integer> listOf;
                List<? extends Integer> listOf2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (List) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                z17 = TroopHistoryViewModel.this.fromStorageScan;
                if (z17) {
                    listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.a1i), Integer.valueOf(R.string.a1f), Integer.valueOf(R.string.a1g), Integer.valueOf(R.string.f170732im3), Integer.valueOf(R.string.a1h)});
                    return listOf2;
                }
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.a1e), Integer.valueOf(R.string.a1j), Integer.valueOf(R.string.a1i), Integer.valueOf(R.string.a1f), Integer.valueOf(R.string.a1g), Integer.valueOf(R.string.f170732im3), Integer.valueOf(R.string.a1h)});
                return listOf;
            }
        });
        this.tabTexts = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends Integer>>() { // from class: com.tencent.qqnt.chathistory.business.TroopHistoryViewModel$tabIds$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopHistoryViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends Integer> invoke() {
                boolean z17;
                List<? extends Integer> listOf;
                List<? extends Integer> listOf2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (List) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                z17 = TroopHistoryViewModel.this.fromStorageScan;
                if (z17) {
                    listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.auq), Integer.valueOf(R.id.auv), Integer.valueOf(R.id.aus), Integer.valueOf(R.id.aut), Integer.valueOf(R.id.lcp), Integer.valueOf(R.id.auu), Integer.valueOf(R.id.f164776tt2)});
                    return listOf2;
                }
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.aur), Integer.valueOf(R.id.auq), Integer.valueOf(R.id.auw), Integer.valueOf(R.id.auv), Integer.valueOf(R.id.aus), Integer.valueOf(R.id.aut), Integer.valueOf(R.id.lcp), Integer.valueOf(R.id.auu), Integer.valueOf(R.id.tt9)});
                return listOf;
            }
        });
        this.tabIds = lazy2;
    }

    private final BaseHistoryFragment<?> S1(int position) {
        int i3 = 1;
        if (position == 0) {
            return new ChatHistoryMediaFragment(1);
        }
        if (position == 1) {
            return new ChatHistoryStickerFragment(1);
        }
        if (position == 2) {
            return new ChatHistoryTroopFileFragment(1);
        }
        if (position == 3) {
            return new ChatHistoryDocumentFragment(1);
        }
        if (position == 4) {
            return new ChatHistoryLinkFragment(1);
        }
        if (position == 5) {
            return new ChatHistoryShortVideoFragment(0, i3, null);
        }
        throw new RuntimeException("can not implement by " + position);
    }

    @Override // com.tencent.qqnt.chathistory.business.a
    public int L1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.qqnt.chathistory.business.a
    @NotNull
    public BaseHistoryFragment<?> M1(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BaseHistoryFragment) iPatchRedirector.redirect((short) 6, (Object) this, position);
        }
        if (this.fromStorageScan) {
            return S1(position);
        }
        if (position == 0) {
            return new ChatHistoryDateFragment();
        }
        int i3 = 1;
        if (position == 1) {
            return new TroopMemberFragment();
        }
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i16 = 0;
        if (position == 2) {
            return new ChatHistoryMediaFragment(i16, i3, defaultConstructorMarker);
        }
        if (position == 3) {
            return new ChatHistoryStickerFragment(i16, i3, defaultConstructorMarker);
        }
        if (position == 4) {
            return new ChatHistoryTroopFileFragment(i16, i3, defaultConstructorMarker);
        }
        if (position == 5) {
            return new ChatHistoryDocumentFragment(i16, i3, defaultConstructorMarker);
        }
        if (position == 6) {
            return new ChatHistoryLinkFragment(i16, i3, defaultConstructorMarker);
        }
        if (position == 7) {
            return new ChatHistoryShortVideoFragment(i16, i3, defaultConstructorMarker);
        }
        throw new RuntimeException("can not implement by " + position);
    }

    @Override // com.tencent.qqnt.chathistory.business.a
    @NotNull
    public Pair<Integer, BaseHistoryFragment<?>> N1(int category) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Pair) iPatchRedirector.redirect((short) 7, (Object) this, category);
        }
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i3 = 0;
        int i16 = 1;
        if (category == 1) {
            return TuplesKt.to(Integer.valueOf(R.string.a1i), new ChatHistoryMediaFragment(i3, i16, defaultConstructorMarker));
        }
        if (category == 2) {
            return TuplesKt.to(Integer.valueOf(R.string.a1f), new ChatHistoryStickerFragment(i3, i16, defaultConstructorMarker));
        }
        if (category == 3) {
            return TuplesKt.to(Integer.valueOf(R.string.a1h), new ChatHistoryLinkFragment(i3, i16, defaultConstructorMarker));
        }
        if (category == 4) {
            return TuplesKt.to(Integer.valueOf(R.string.f170732im3), new ChatHistoryDocumentFragment(i3, i16, defaultConstructorMarker));
        }
        if (category == 5) {
            return TuplesKt.to(Integer.valueOf(R.string.a1e), new ChatHistoryDateFragment());
        }
        throw new HistoryException("Illegal parameter " + category);
    }

    @Override // com.tencent.qqnt.chathistory.business.a
    @NotNull
    public List<Integer> Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (List) this.tabTexts.getValue();
    }

    public /* synthetic */ TroopHistoryViewModel(String str, String str2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
