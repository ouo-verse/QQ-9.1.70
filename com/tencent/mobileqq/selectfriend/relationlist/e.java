package com.tencent.mobileqq.selectfriend.relationlist;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\n\u001a\u00020\t2\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007H\u0002J\u0006\u0010\u000b\u001a\u00020\tJ\u0018\u0010\u000f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dJ\u0016\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u0004R \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010#R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010&R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010#R\u0018\u0010*\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010)R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00100+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010,R\u0016\u0010/\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/relationlist/e;", "", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", "node", "", "e", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sharedNodes", "", "i", "k", "Lcom/tencent/mobileqq/selectfriend/relationlist/c;", "listener", "from", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/selectfriend/relationlist/b;", "a", "l", "c", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "g", h.F, "j", "type", "nodeKey", "d", "", "f", "", "count", "o", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "selectedNodeMap", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "selectedNodesList", "unselectableNodeMap", "Lcom/tencent/mobileqq/selectfriend/relationlist/c;", "exceedListener", "", "Ljava/util/List;", "selectedNodeListChangeListeners", "I", "mostSelectCount", "<init>", "()V", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f285562a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, SharedNode> selectedNodeMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<SharedNode> selectedNodesList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, SharedNode> unselectableNodeMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static c exceedListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<b> selectedNodeListChangeListeners;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static int mostSelectCount;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23709);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
            return;
        }
        f285562a = new e();
        selectedNodeMap = new ConcurrentHashMap<>();
        selectedNodesList = new CopyOnWriteArrayList<>();
        unselectableNodeMap = new ConcurrentHashMap<>();
        selectedNodeListChangeListeners = new ArrayList();
        mostSelectCount = Integer.MAX_VALUE;
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String e(SharedNode node) {
        return d(node.getType(), node.getKey());
    }

    private final void i(ArrayList<SharedNode> sharedNodes) {
        Iterator<b> it = selectedNodeListChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().b(sharedNodes);
        }
    }

    public final void a(@NotNull b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            selectedNodeListChangeListeners.add(listener);
        }
    }

    public final void b(@NotNull SharedNode node) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) node);
            return;
        }
        Intrinsics.checkNotNullParameter(node, "node");
        String e16 = e(node);
        ConcurrentHashMap<String, SharedNode> concurrentHashMap = selectedNodeMap;
        if (concurrentHashMap.containsKey(e16)) {
            return;
        }
        CopyOnWriteArrayList<SharedNode> copyOnWriteArrayList = selectedNodesList;
        int size = copyOnWriteArrayList.size();
        int i3 = mostSelectCount;
        if (size >= i3) {
            c cVar = exceedListener;
            if (cVar != null) {
                cVar.a(i3, node);
                return;
            }
            return;
        }
        concurrentHashMap.put(e16, node);
        copyOnWriteArrayList.add(node);
        i(new ArrayList<>(Collections.singletonList(node)));
    }

    public final void c(@NotNull SharedNode node) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) node);
            return;
        }
        Intrinsics.checkNotNullParameter(node, "node");
        if (selectedNodeMap.containsKey(e(node))) {
            m(node);
        } else {
            b(node);
        }
    }

    @NotNull
    public final String d(@NotNull String type, @NotNull String nodeKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, (Object) type, (Object) nodeKey);
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(nodeKey, "nodeKey");
        return type + util.base64_pad_url + nodeKey;
    }

    @NotNull
    public final List<SharedNode> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return selectedNodesList;
    }

    public final boolean g(@NotNull SharedNode node) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) node)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(node, "node");
        return selectedNodeMap.containsKey(e(node));
    }

    public final boolean h(@NotNull SharedNode node) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) node)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(node, "node");
        return unselectableNodeMap.containsKey(e(node));
    }

    public final void j(@NotNull SharedNode node) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) node);
            return;
        }
        Intrinsics.checkNotNullParameter(node, "node");
        Iterator<b> it = selectedNodeListChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().a(node);
        }
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        selectedNodesList.clear();
        selectedNodeMap.clear();
        unselectableNodeMap.clear();
        exceedListener = null;
    }

    public final void l(@NotNull b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            selectedNodeListChangeListeners.remove(listener);
        }
    }

    public final void m(@NotNull SharedNode node) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) node);
            return;
        }
        Intrinsics.checkNotNullParameter(node, "node");
        String e16 = e(node);
        ConcurrentHashMap<String, SharedNode> concurrentHashMap = selectedNodeMap;
        if (!concurrentHashMap.containsKey(e16)) {
            return;
        }
        concurrentHashMap.remove(e16);
        selectedNodesList.remove(node);
        i(new ArrayList<>(Collections.singletonList(node)));
    }

    public final void n(@Nullable c listener, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener, (Object) from);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        QLog.i("SharedNodeCenter", 1, "setExceedListener from " + from + " listener " + listener);
        exceedListener = listener;
    }

    public final void o(int count, @NotNull String from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, count, (Object) from);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        QLog.i("SharedNodeCenter", 1, "setSelectCount from " + from + " count " + count);
        mostSelectCount = count;
    }
}
