package com.tencent.qqnt.aio.forward;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.nativeinterface.MultiMsgInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \t2\u00020\u0001:\u0001\u000bB\t\b\u0002\u00a2\u0006\u0004\b/\u00100J\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0004j\b\u0012\u0004\u0012\u00020\b`\u0006R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001f\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010&\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/aio/forward/l;", "", "", "b", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MultiMsgInfo;", "Lkotlin/collections/ArrayList;", "g", "", "f", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "d", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "l", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)V", "forwardMsgItem", "", "Ljava/util/List;", tl.h.F, "()Ljava/util/List;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/util/List;)V", "multiSelectMsgItems", "Lcom/tencent/mobileqq/emoticonview/IPicEmoticonInfo;", "c", "Lcom/tencent/mobileqq/emoticonview/IPicEmoticonInfo;", "()Lcom/tencent/mobileqq/emoticonview/IPicEmoticonInfo;", "k", "(Lcom/tencent/mobileqq/emoticonview/IPicEmoticonInfo;)V", "emoticonInfo", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "j", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "o", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;)V", "srcContact", "", "e", "I", "i", "()I", DomainData.DOMAIN_NAME, "(I)V", "ntForwardType", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class l {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final l f349978g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOMsgItem forwardMsgItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends AIOMsgItem> multiSelectMsgItems;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPicEmoticonInfo emoticonInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Contact srcContact;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int ntForwardType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/forward/l$a;", "", "Lcom/tencent/qqnt/aio/forward/l;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/qqnt/aio/forward/l;", "a", "()Lcom/tencent/qqnt/aio/forward/l;", "getInstance$annotations", "()V", "<init>", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.forward.l$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final l a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return l.f349978g;
            }
            return (l) iPatchRedirector.redirect((short) 2, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63487);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
            f349978g = new l();
        }
    }

    l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.ntForwardType = -1;
        }
    }

    @NotNull
    public static final l e() {
        return INSTANCE.a();
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.forwardMsgItem = null;
        this.multiSelectMsgItems = null;
        this.emoticonInfo = null;
        this.srcContact = null;
        this.ntForwardType = -1;
    }

    @Nullable
    public final IPicEmoticonInfo c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (IPicEmoticonInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.emoticonInfo;
    }

    @Nullable
    public final AIOMsgItem d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.forwardMsgItem;
    }

    @NotNull
    public final ArrayList<Long> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ArrayList) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        List<? extends AIOMsgItem> list = this.multiSelectMsgItems;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((AIOMsgItem) it.next()).getMsgId()));
            }
        }
        return arrayList;
    }

    @NotNull
    public final ArrayList<MultiMsgInfo> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ArrayList) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        ArrayList<MultiMsgInfo> arrayList = new ArrayList<>();
        List<? extends AIOMsgItem> list = this.multiSelectMsgItems;
        if (list != null) {
            for (AIOMsgItem aIOMsgItem : list) {
                arrayList.add(new MultiMsgInfo(aIOMsgItem.getMsgId(), aIOMsgItem.getMsgRecord().sendNickName));
            }
        }
        return arrayList;
    }

    @Nullable
    public final List<AIOMsgItem> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.multiSelectMsgItems;
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.ntForwardType;
    }

    @Nullable
    public final Contact j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Contact) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.srcContact;
    }

    public final void k(@Nullable IPicEmoticonInfo iPicEmoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) iPicEmoticonInfo);
        } else {
            this.emoticonInfo = iPicEmoticonInfo;
        }
    }

    public final void l(@Nullable AIOMsgItem aIOMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aIOMsgItem);
        } else {
            this.forwardMsgItem = aIOMsgItem;
        }
    }

    public final void m(@Nullable List<? extends AIOMsgItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            this.multiSelectMsgItems = list;
        }
    }

    public final void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.ntForwardType = i3;
        }
    }

    public final void o(@Nullable Contact contact) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) contact);
        } else {
            this.srcContact = contact;
        }
    }
}
