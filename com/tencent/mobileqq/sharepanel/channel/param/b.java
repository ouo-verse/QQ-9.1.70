package com.tencent.mobileqq.sharepanel.channel.param;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.channel.handler.f;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/channel/param/b;", "Lcom/tencent/mobileqq/sharepanel/channel/handler/f;", "Landroid/content/Intent;", "a", "Landroid/content/Intent;", "()Landroid/content/Intent;", "forwardIntent", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "b", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "selectedTargets", "", "c", "Z", "()Z", "supportMultiSelect", "<init>", "(Landroid/content/Intent;Ljava/util/ArrayList;Z)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b extends f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Intent forwardIntent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ArrayList<ResultRecord> selectedTargets;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean supportMultiSelect;

    public b(@Nullable Intent intent, @Nullable ArrayList<ResultRecord> arrayList, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, intent, arrayList, Boolean.valueOf(z16));
            return;
        }
        this.forwardIntent = intent;
        this.selectedTargets = arrayList;
        this.supportMultiSelect = z16;
    }

    @Nullable
    public final Intent a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Intent) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.forwardIntent;
    }

    @Nullable
    public final ArrayList<ResultRecord> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.selectedTargets;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.supportMultiSelect;
    }
}
