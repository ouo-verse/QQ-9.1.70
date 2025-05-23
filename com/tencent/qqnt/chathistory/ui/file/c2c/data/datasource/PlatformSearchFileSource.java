package com.tencent.qqnt.chathistory.ui.file.c2c.data.datasource;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.chathistory.ui.file.c2c.data.model.FileItemModel;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgTypeFilter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ,\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002JX\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0010\u001a\u00020\u0007R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/datasource/PlatformSearchFileSource;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "list", "", "peerId", "", "chartType", "Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/model/FileItemModel;", "e", "", "msgId", "msgTime", "msgSeq", "subTypeFilters", "pageCount", "Lkotlinx/coroutines/flow/Flow;", "b", "Lkotlinx/coroutines/CoroutineScope;", "a", "Lkotlinx/coroutines/CoroutineScope;", "d", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class PlatformSearchFileSource {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/file/c2c/data/datasource/PlatformSearchFileSource$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.file.c2c.data.datasource.PlatformSearchFileSource$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45937);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PlatformSearchFileSource(@NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) scope);
        } else {
            this.scope = scope;
        }
    }

    public static /* synthetic */ Flow c(PlatformSearchFileSource platformSearchFileSource, int i3, String str, long j3, long j16, long j17, List list, int i16, int i17, Object obj) {
        long j18;
        long j19;
        long j26;
        List list2;
        List emptyList;
        if ((i17 & 4) != 0) {
            j18 = 0;
        } else {
            j18 = j3;
        }
        if ((i17 & 8) != 0) {
            j19 = 0;
        } else {
            j19 = j16;
        }
        if ((i17 & 16) != 0) {
            j26 = 0;
        } else {
            j26 = j17;
        }
        if ((i17 & 32) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = list;
        }
        return platformSearchFileSource.b(i3, str, j18, j19, j26, list2, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<FileItemModel> e(List<MsgRecord> list, final String peerId, final int chartType) {
        Sequence asSequence;
        Sequence map;
        List<FileItemModel> list2;
        asSequence = CollectionsKt___CollectionsKt.asSequence(list);
        map = SequencesKt___SequencesKt.map(asSequence, new Function1<MsgRecord, FileItemModel>(peerId, chartType, this) { // from class: com.tencent.qqnt.chathistory.ui.file.c2c.data.datasource.PlatformSearchFileSource$wrapData$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $chartType;
            final /* synthetic */ String $peerId;
            final /* synthetic */ PlatformSearchFileSource this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$peerId = peerId;
                this.$chartType = chartType;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, peerId, Integer.valueOf(chartType), this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final FileItemModel invoke(@NotNull MsgRecord it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (FileItemModel) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                return new FileItemModel(it, this.$peerId, this.$chartType, this.this$0.d());
            }
        });
        list2 = SequencesKt___SequencesKt.toList(map);
        return list2;
    }

    @NotNull
    public final Flow<List<FileItemModel>> b(int chartType, @NotNull String peerId, long msgId, long msgTime, long msgSeq, @NotNull List<Integer> subTypeFilters, int pageCount) {
        List listOf;
        List emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Flow) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(chartType), peerId, Long.valueOf(msgId), Long.valueOf(msgTime), Long.valueOf(msgSeq), subTypeFilters, Integer.valueOf(pageCount));
        }
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        Intrinsics.checkNotNullParameter(subTypeFilters, "subTypeFilters");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new MsgTypeFilter(3, new ArrayList(subTypeFilters)));
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return FlowKt.callbackFlow(new PlatformSearchFileSource$getData$$inlined$getMsgsByTypeFilterListByKernel$default$1(msgId, msgTime, msgSeq, chartType, peerId, listOf, emptyList, 0L, 0L, pageCount, null, this, peerId, chartType));
    }

    @NotNull
    public final CoroutineScope d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CoroutineScope) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.scope;
    }
}
