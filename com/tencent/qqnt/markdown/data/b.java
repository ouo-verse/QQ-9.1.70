package com.tencent.qqnt.markdown.data;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b2\u00103R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR'\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u000e\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010+\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010'\u001a\u0004\b\n\u0010(\"\u0004\b)\u0010*R\"\u00101\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010-\u001a\u0004\b\u0003\u0010.\"\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/qqnt/markdown/data/b;", "", "", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "nodeId", "b", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "nodeType", "c", h.F, "o", "text", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/markdown/data/e;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "f", "()Ljava/util/ArrayList;", "quoteDataList", "Lcom/tencent/qqnt/markdown/data/c;", "Lcom/tencent/qqnt/markdown/data/c;", "()Lcom/tencent/qqnt/markdown/data/c;", "k", "(Lcom/tencent/qqnt/markdown/data/c;)V", "multiPicData", "Lcom/tencent/qqnt/markdown/a;", "Lcom/tencent/qqnt/markdown/a;", "g", "()Lcom/tencent/qqnt/markdown/a;", DomainData.DOMAIN_NAME, "(Lcom/tencent/qqnt/markdown/a;)V", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "", "I", "()I", "j", "(I)V", NodeProps.MAX_WIDTH, "", "Z", "()Z", "i", "(Z)V", "end", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String nodeId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String nodeType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String text;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<e> quoteDataList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c multiPicData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.markdown.a<?> render;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int maxWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean end;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.nodeId = "";
        this.nodeType = "";
        this.text = "";
        this.quoteDataList = new ArrayList<>();
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.end;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.maxWidth;
    }

    @Nullable
    public final c c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (c) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.multiPicData;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.nodeId;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.nodeType;
    }

    @NotNull
    public final ArrayList<e> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.quoteDataList;
    }

    @Nullable
    public final com.tencent.qqnt.markdown.a<?> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.qqnt.markdown.a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.render;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.text;
    }

    public final void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.end = z16;
        }
    }

    public final void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.maxWidth = i3;
        }
    }

    public final void k(@Nullable c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) cVar);
        } else {
            this.multiPicData = cVar;
        }
    }

    public final void l(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.nodeId = str;
        }
    }

    public final void m(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.nodeType = str;
        }
    }

    public final void n(@Nullable com.tencent.qqnt.markdown.a<?> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        } else {
            this.render = aVar;
        }
    }

    public final void o(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.text = str;
        }
    }
}
