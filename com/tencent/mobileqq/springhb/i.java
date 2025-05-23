package com.tencent.mobileqq.springhb;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/springhb/i;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "blessWordList", "", "c", "Z", "a", "()Z", "setShouldTriggerVibration", "(Z)V", "shouldTriggerVibration", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f289200a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<String> blessWordList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean shouldTriggerVibration;

    static {
        ArrayList<String> arrayListOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60528);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f289200a = new i();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("\u795d\u60a82025\u86c7\u6765\u8fd0\u8f6c", "\u795d\u60a82025\u86c7\u5e74\u5927\u5409", "\u795d\u60a82025\u86c7\u5e8f\u5448\u7965", "\u795d\u60a82025\u86c7\u5e74\u7eb3\u798f", "\u795d\u60a82025\u86c7\u89c5\u9686\u53d1", "\u795d\u60a82025\u7965\u86c7\u7eb3\u5409", "\u795d\u60a82025\u86c7\u8fd0\u4ea8\u901a", "\u795d\u60a82025\u86c7\u8dc3\u65b0\u7a0b", "\u795d\u60a82025\u798f\u86c7\u76c8\u95e8", "\u795d\u60a82025\u86c7\u542f\u9e3f\u56fe");
        blessWordList = arrayListOf;
        shouldTriggerVibration = true;
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return shouldTriggerVibration;
    }
}
