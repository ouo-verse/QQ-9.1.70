package com.tencent.mobileqq.troop.troopcard.reborn.uimodel;

import com.tencent.mobileqq.pb.ByteStringMicro;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute$OStatisticInfo;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute$RspBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u0016\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Ltencent/im/cs/cmd0x6ff/subcmd0x608/troop_member_distribute$RspBody;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/p;", "c", "(Ltencent/im/cs/cmd0x6ff/subcmd0x608/troop_member_distribute$RspBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ltencent/im/cs/cmd0x6ff/subcmd0x608/troop_member_distribute$OStatisticInfo;", "", "index", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/o;", "b", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopMemberDistributionUIModelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final o b(troop_member_distribute$OStatisticInfo troop_member_distribute_ostatisticinfo, int i3) {
        String str;
        String str2;
        List split$default;
        Object orNull;
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        ByteStringMicro byteStringMicro = troop_member_distribute_ostatisticinfo.bytes_desc.get();
        if (byteStringMicro != null) {
            str = byteStringMicro.toStringUtf8();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{"-"}, false, 0, 6, (Object) null);
        orNull = CollectionsKt___CollectionsKt.getOrNull(split$default, 0);
        String str4 = (String) orNull;
        if (str4 != null) {
            str3 = str4;
        }
        int i16 = troop_member_distribute_ostatisticinfo.uint32_count.get();
        if (i3 != 0) {
            if (i3 == 1) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) "\u7537", false, 2, (Object) null);
                if (contains$default) {
                    return new o(MemberDistributionType.GENDER_MALE, str3, i16);
                }
                return new o(MemberDistributionType.GENDER_FEMALE, str3, i16);
            }
            if (i3 != 2) {
                if (i3 == 3) {
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) "00", false, 2, (Object) null);
                    if (!contains$default2) {
                        contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) "80", false, 2, (Object) null);
                        if (!contains$default3) {
                            contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) str3, (CharSequence) "90", false, 2, (Object) null);
                            if (!contains$default4) {
                                return new o(MemberDistributionType.AGE_70, str3, i16);
                            }
                        }
                        return new o(MemberDistributionType.AGE_8090, str3, i16);
                    }
                    return new o(MemberDistributionType.AGE_00, str3, i16);
                }
                return null;
            }
            return new o(MemberDistributionType.LOCATION, str3, i16);
        }
        return new o(MemberDistributionType.ACTIVE, str3, i16);
    }

    @Nullable
    public static final Object c(@NotNull troop_member_distribute$RspBody troop_member_distribute_rspbody, @NotNull Continuation<? super p> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new TroopMemberDistributionUIModelKt$toTroopMemberDistributionUIModel$2(troop_member_distribute_rspbody, null), continuation);
    }
}
