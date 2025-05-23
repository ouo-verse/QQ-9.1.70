package com.tencent.mobileqq.troop.widget.labelv2;

import android.util.SparseIntArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\bR \u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/widget/labelv2/a;", "", "Landroid/util/SparseIntArray;", "b", "Landroid/util/SparseIntArray;", "a", "()Landroid/util/SparseIntArray;", "getPriorityList$annotations", "()V", "priorityList", "<init>", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f302604a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseIntArray priorityList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25671);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f302604a = new a();
        SparseIntArray sparseIntArray = new SparseIntArray();
        priorityList = sparseIntArray;
        sparseIntArray.put(1, 1);
        sparseIntArray.put(4, 2);
        sparseIntArray.put(8, 3);
        sparseIntArray.put(7, 4);
        sparseIntArray.put(6, 5);
        sparseIntArray.put(5, 6);
        sparseIntArray.put(3, 8);
        sparseIntArray.put(2, 9);
        sparseIntArray.put(101, 10);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public static final SparseIntArray a() {
        return priorityList;
    }
}
