package com.tencent.mobileqq.avatar.handler;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u0000 \u001a*\u0004\b\u0000\u0010\u00012\u0012\u0012\u0004\u0012\u00028\u00000\u0002j\b\u0012\u0004\u0012\u00028\u0000`\u0003:\u0001\u001bB\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\b\u0010\fJ\u0006\u0010\r\u001a\u00020\u0007R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/avatar/handler/RecordArrayList;", "E", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "", "d", DTConstants.TAG.ELEMENT, "", "add", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "isIncreaseQuickly", "type", "I", "getType", "()I", "enableRecord", "Z", "getEnableRecord", "()Z", "setEnableRecord", "(Z)V", "<init>", "(I)V", "Companion", "a", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RecordArrayList<E> extends ArrayList<E> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int DURATION = 30;
    public static final int MAX_ITEM_SIZE = 15;

    @NotNull
    public static final String TAG = "Q.qqhead.AvatarHandler.RecordArrayList";
    public static final int TIMES = 4;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Map<Integer, Long> f200126d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Map<Integer, Integer> f200127e;
    private boolean enableRecord;
    private final int type;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/avatar/handler/RecordArrayList$a;", "", "", "DURATION", "I", "MAX_ITEM_SIZE", "", "TAG", "Ljava/lang/String;", "TIMES", "", "", "lastAddTimeMap", "Ljava/util/Map;", "quicklyAddTimesMap", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.avatar.handler.RecordArrayList$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17385);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        INSTANCE = new Companion(null);
        f200126d = new LinkedHashMap();
        f200127e = new LinkedHashMap();
    }

    public RecordArrayList(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.type = i3;
        }
    }

    private final void d() {
        long j3;
        if (!this.enableRecord) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Map<Integer, Long> map = f200126d;
        Long l3 = map.get(Integer.valueOf(this.type));
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = 0;
        }
        int i3 = 0;
        if (currentTimeMillis - j3 <= 30) {
            Map<Integer, Integer> map2 = f200127e;
            Integer valueOf = Integer.valueOf(this.type);
            Integer num = map2.get(Integer.valueOf(this.type));
            if (num != null) {
                i3 = num.intValue();
            }
            map2.put(valueOf, Integer.valueOf(i3 + 1));
        } else {
            f200127e.put(Integer.valueOf(this.type), 0);
        }
        map.put(Integer.valueOf(this.type), Long.valueOf(currentTimeMillis));
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) element)).booleanValue();
        }
        d();
        return super.add(element);
    }

    public final boolean getEnableRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.enableRecord;
    }

    public /* bridge */ int getSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return super.size();
    }

    public final int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.type;
    }

    public final boolean isIncreaseQuickly() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (!this.enableRecord || size() >= 15) {
            return false;
        }
        Integer num = f200127e.get(Integer.valueOf(this.type));
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        if (i3 <= 4) {
            return false;
        }
        return true;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (E) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        return (E) removeAt(i3);
    }

    public /* bridge */ Object removeAt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        return super.remove(i3);
    }

    public final void setEnableRecord(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.enableRecord = z16;
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return getSize();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, index, (Object) element);
        } else {
            d();
            super.add(index, element);
        }
    }
}
