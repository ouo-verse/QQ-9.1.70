package com.tencent.mobileqq.activity.specialcare;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00032\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/activity/specialcare/b;", "", "", "e", "", com.tencent.luggage.wxa.c8.c.E, "", "c", "buf", "d", "a", "I", "sizeLimit", "Ljava/util/LinkedList;", "b", "Ljava/util/LinkedList;", "buffersByLastUse", "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "buffersBySize", "currentSize", "<init>", "(I)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Comparator<byte[]> f186560f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static b f186561g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int sizeLimit;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<byte[]> buffersByLastUse;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<byte[]> buffersBySize;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int currentSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/activity/specialcare/b$a;", "", "Ljava/util/Comparator;", "", "BUF_COMPARATOR", "Ljava/util/Comparator;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.specialcare.b$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21271);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        f186560f = new Comparator() { // from class: com.tencent.mobileqq.activity.specialcare.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int b16;
                b16 = b.b((byte[]) obj, (byte[]) obj2);
                return b16;
            }
        };
        f186561g = new b(RFixConstants.MD5_FILE_BUF_LENGTH);
    }

    public b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.sizeLimit = i3;
        this.buffersByLastUse = new LinkedList<>();
        this.buffersBySize = new ArrayList<>(64);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(byte[] bArr, byte[] bArr2) {
        return bArr.length - bArr2.length;
    }

    private final synchronized void e() {
        while (this.currentSize > this.sizeLimit) {
            byte[] remove = this.buffersByLastUse.remove(0);
            Intrinsics.checkNotNullExpressionValue(remove, "buffersByLastUse.removeAt(0)");
            byte[] bArr = remove;
            this.buffersBySize.remove(bArr);
            this.currentSize -= bArr.length;
        }
    }

    @NotNull
    public final synchronized byte[] c(int len) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this, len);
        }
        int size = this.buffersBySize.size();
        for (int i3 = 0; i3 < size; i3++) {
            byte[] bArr = this.buffersBySize.get(i3);
            Intrinsics.checkNotNullExpressionValue(bArr, "buffersBySize[i]");
            byte[] bArr2 = bArr;
            if (bArr2.length >= len) {
                this.currentSize -= bArr2.length;
                this.buffersBySize.remove(i3);
                this.buffersByLastUse.remove(bArr2);
                return bArr2;
            }
        }
        return new byte[len];
    }

    public final synchronized void d(@Nullable byte[] buf) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) buf);
            return;
        }
        if (buf != null) {
            if (buf.length > this.sizeLimit) {
                return;
            }
            this.buffersByLastUse.add(buf);
            int binarySearch = Collections.binarySearch(this.buffersBySize, buf, f186560f);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 1;
            }
            this.buffersBySize.add(binarySearch, buf);
            this.currentSize += buf.length;
            e();
        }
    }
}
