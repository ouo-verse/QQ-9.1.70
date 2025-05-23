package com.tencent.mobileqq.cardcontainer;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&R#\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/g;", "Landroidx/lifecycle/ViewModel;", "", "fromCache", "", "P1", "O1", "", "position", "M1", "", ZPlanPublishSource.FROM_SCHEME, "N1", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "i", "Landroidx/lifecycle/MutableLiveData;", "L1", "()Landroidx/lifecycle/MutableLiveData;", "cards", "<init>", "()V", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class g extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<com.tencent.mobileqq.cardcontainer.data.a>> cards;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.cards = new MutableLiveData<>();
        }
    }

    @NotNull
    public final MutableLiveData<List<com.tencent.mobileqq.cardcontainer.data.a>> L1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.cards;
    }

    public abstract void M1(int position);

    public abstract void N1(int position, @NotNull String scheme);

    public abstract void O1();

    public abstract void P1(boolean fromCache);
}
