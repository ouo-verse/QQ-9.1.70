package com.tencent.mobileqq.troop.troopsquare.data;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GroupSquareGroupInfoItem;
import com.tencent.qqnt.kernel.nativeinterface.GroupSquareLabel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\bJ\u0010KJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u000b\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R2\u0010.\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00105\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00109\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00100\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\"\u0010=\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u00100\u001a\u0004\b;\u00102\"\u0004\b<\u00104R\"\u0010A\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u00100\u001a\u0004\b?\u00102\"\u0004\b@\u00104R\"\u0010E\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010\u001c\u001a\u0004\bC\u0010\u001e\"\u0004\bD\u0010 R\"\u0010I\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u00100\u001a\u0004\bG\u00102\"\u0004\bH\u00104\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/data/a;", "", "", "d", "", "toString", "", "hashCode", "other", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareGroupInfoItem;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareGroupInfoItem;", "c", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareGroupInfoItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "Z", "()Z", "e", "(Z)V", "hasRequestJoin", "", "J", "()J", "setGroupCode", "(J)V", "groupCode", "Ljava/lang/String;", "getGroupName", "()Ljava/lang/String;", "setGroupName", "(Ljava/lang/String;)V", "groupName", "getMemo", "setMemo", "memo", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareLabel;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "getLabels", "()Ljava/util/ArrayList;", "setLabels", "(Ljava/util/ArrayList;)V", "labels", "g", "I", "getMemberNum", "()I", "setMemberNum", "(I)V", "memberNum", h.F, "getMemberMaxNum", "setMemberMaxNum", "memberMaxNum", "i", "getGroupFlagExt", "setGroupFlagExt", "groupFlagExt", "j", "getGroupFlag", "setGroupFlag", "groupFlag", "k", "getJoinGroupAuth", "setJoinGroupAuth", "joinGroupAuth", "l", "getUinPrivilege", "setUinPrivilege", "uinPrivilege", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareGroupInfoItem;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GroupSquareGroupInfoItem item;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean hasRequestJoin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long groupCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String groupName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String memo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<GroupSquareLabel> labels;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int memberNum;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int memberMaxNum;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int groupFlagExt;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int groupFlag;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String joinGroupAuth;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int uinPrivilege;

    public a(@NotNull GroupSquareGroupInfoItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) item);
            return;
        }
        this.item = item;
        this.groupCode = item.groupCode;
        String str = item.groupName;
        Intrinsics.checkNotNullExpressionValue(str, "item.groupName");
        this.groupName = str;
        String str2 = item.memo;
        Intrinsics.checkNotNullExpressionValue(str2, "item.memo");
        this.memo = str2;
        ArrayList<GroupSquareLabel> arrayList = item.labels;
        Intrinsics.checkNotNullExpressionValue(arrayList, "item.labels");
        this.labels = arrayList;
        this.memberNum = item.memberNum;
        this.memberMaxNum = item.memberMaxNum;
        this.groupFlagExt = item.groupFlagExt;
        this.groupFlag = item.groupFlag;
        String str3 = item.joinGroupAuth;
        Intrinsics.checkNotNullExpressionValue(str3, "item.joinGroupAuth");
        this.joinGroupAuth = str3;
        this.uinPrivilege = item.uinPrivilege;
    }

    public final long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.groupCode;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.hasRequestJoin;
    }

    @NotNull
    public final GroupSquareGroupInfoItem c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (GroupSquareGroupInfoItem) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.item;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        int i3 = this.uinPrivilege;
        if (i3 == 0 || i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    public final void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.hasRequestJoin = z16;
        }
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if ((other instanceof a) && Intrinsics.areEqual(this.item, ((a) other).item)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        return this.item.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return "GroupSquareGroupInfoItemWrapper(item=" + this.item + ")";
    }
}
