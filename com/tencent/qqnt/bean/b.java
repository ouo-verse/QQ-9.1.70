package com.tencent.qqnt.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.KickMemberReq;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$J&\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u0004J\u0018\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0003J\u001c\u0010\f\u001a\u00020\b2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nJ\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\rj\b\u0012\u0004\u0012\u00020\u0003`\u000eJ\u0010\u0010\u0010\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0011J\u0014\u0010\u0015\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013J\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00030\rj\b\u0012\u0004\u0012\u00020\u0003`\u000eJ\u0006\u0010\u0018\u001a\u00020\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001cR&\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\rj\b\u0012\u0004\u0012\u00020\u0003`\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001eR&\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00030\rj\b\u0012\u0004\u0012\u00020\u0003`\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001eR6\u0010\"\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/bean/b;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "i", "uid", "uin", "", "a", "", "map", "e", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "g", "b", "", "c", "", SquareJSConst.Params.PARAMS_UIN_LIST, "d", h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/KickMemberReq;", "f", "Ljava/lang/String;", "troopUin", "", "Z", "isBlack", "Ljava/util/ArrayList;", "deleteUinList", "deleteUidList", "Ljava/util/HashMap;", "uid2uinMap", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public String troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public boolean isBlack;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> deleteUinList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> deleteUidList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, String> uid2uinMap;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.deleteUinList = new ArrayList<>();
        this.deleteUidList = new ArrayList<>();
        this.uid2uinMap = new HashMap<>();
    }

    public final void a(@Nullable String uid, @NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) uid, (Object) uin);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (uid != null) {
            this.deleteUidList.add(uid);
            this.uid2uinMap.put(uid, uin);
        }
    }

    public final void b(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) uin);
        } else if (uin != null) {
            this.deleteUinList.add(uin);
        }
    }

    public final void c(long uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, uin);
        } else {
            this.deleteUinList.add(String.valueOf(uin));
        }
    }

    public final void d(@NotNull List<Long> uinList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) uinList);
            return;
        }
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        Iterator<T> it = uinList.iterator();
        while (it.hasNext()) {
            c(((Number) it.next()).longValue());
        }
    }

    public final void e(@Nullable Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) map);
            return;
        }
        if (map != null) {
            this.deleteUidList.addAll(map.values());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.uid2uinMap.put(entry.getValue(), entry.getKey());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r1);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final KickMemberReq f() {
        long j3;
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (KickMemberReq) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        KickMemberReq kickMemberReq = new KickMemberReq();
        String str = this.troopUin;
        if (str != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        kickMemberReq.groupCode = j3;
        kickMemberReq.kickListUids = this.deleteUidList;
        kickMemberReq.kickFlag = this.isBlack ? 1 : 0;
        return kickMemberReq;
    }

    @NotNull
    public final ArrayList<String> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.deleteUidList;
    }

    @NotNull
    public final ArrayList<String> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.deleteUinList;
    }

    @NotNull
    public final HashMap<String, String> i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.uid2uinMap;
    }
}
