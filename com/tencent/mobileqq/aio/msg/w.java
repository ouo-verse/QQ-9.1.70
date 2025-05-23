package com.tencent.mobileqq.aio.msg;

import android.text.TextUtils;
import com.tencent.mobileqq.aio.msglist.holder.base.PicSize;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0002\"#B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001c\u0010\u000b\u001a\u00020\n2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0001H\u0016J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J:\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n\u0018\u00010\u00122\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000fj\b\u0012\u0004\u0012\u00020\b`\u0010H\u0016J,\u0010\u0017\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bR \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/w;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msg/j;", "", "k2", "", "Lcom/tencent/mobileqq/aio/msg/ElementIdType;", "elementId", "Lcom/tencent/mobileqq/aio/msglist/holder/base/PicSize;", "picSize", "", "i2", "newMsgItem", "l", "f", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "picSizeList", "Lkotlin/Pair;", "j2", "", "status", "path", "l2", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/aio/msg/w$b;", "W0", "Ljava/util/concurrent/ConcurrentHashMap;", "elementThumbStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "X0", "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class w extends AIOMsgItem implements j {
    static IPatchRedirector $redirector_;

    /* renamed from: X0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: W0, reason: from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, b> elementThumbStatus;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/w$a;", "", "", "EMPTY_THUMB_PATH", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.w$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/w$b;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "path", "", "I", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()I", "c", "(I)V", "status", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String path;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int status;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.status = 1;
            }
        }

        @Nullable
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.path;
        }

        public final void b(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                this.path = str;
            }
        }

        public final void c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.status = i3;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57482);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
        } else {
            this.elementThumbStatus = new ConcurrentHashMap<>();
            k2();
        }
    }

    private final String i2(long elementId, PicSize picSize) {
        return elementId + "_" + picSize.name();
    }

    private final void k2() {
        boolean z16;
        ArrayList<MsgElement> arrayList = getMsgRecord().elements;
        if (arrayList != null) {
            ArrayList<MsgElement> arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((MsgElement) obj).elementType == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList2.add(obj);
                }
            }
            for (MsgElement msgElement : arrayList2) {
                PicElement picElement = msgElement.picElement;
                Intrinsics.checkNotNullExpressionValue(picElement, "it.picElement");
                for (Pair<PicSize, String> pair : com.tencent.mobileqq.aio.msglist.holder.base.util.f.a(picElement, getMsgRecord().isImportMsg)) {
                    l2(msgElement.elementId, 4, pair.getSecond(), pair.getFirst());
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.j
    @Nullable
    public String f(long elementId, @NotNull PicSize picSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, Long.valueOf(elementId), picSize);
        }
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        b bVar = this.elementThumbStatus.get(i2(elementId, picSize));
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    @Nullable
    public Pair<PicSize, String> j2(long elementId, @NotNull ArrayList<PicSize> picSizeList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Pair) iPatchRedirector.redirect((short) 4, this, Long.valueOf(elementId), picSizeList);
        }
        Intrinsics.checkNotNullParameter(picSizeList, "picSizeList");
        Iterator<PicSize> it = picSizeList.iterator();
        while (it.hasNext()) {
            PicSize picSize = it.next();
            Intrinsics.checkNotNullExpressionValue(picSize, "picSize");
            String f16 = f(elementId, picSize);
            if (!TextUtils.isEmpty(f16)) {
                Intrinsics.checkNotNull(f16);
                return new Pair<>(picSize, f16);
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        ConcurrentHashMap<String, b> concurrentHashMap = ((w) newMsgItem).elementThumbStatus;
        concurrentHashMap.putAll(concurrentHashMap);
    }

    public final void l2(long elementId, int status, @Nullable String path, @NotNull PicSize picSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(elementId), Integer.valueOf(status), path, picSize);
            return;
        }
        Intrinsics.checkNotNullParameter(picSize, "picSize");
        String i26 = i2(elementId, picSize);
        b bVar = this.elementThumbStatus.get(i26);
        if (bVar == null) {
            bVar = new b();
        }
        bVar.c(status);
        if (!TextUtils.isEmpty(path)) {
            bVar.b(path);
        }
        this.elementThumbStatus.put(i26, bVar);
    }
}
