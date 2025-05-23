package pl2;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lpl2/h;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "BizRsp", "Lpl2/o;", "Lpl2/f;", "Landroidx/fragment/app/Fragment;", "getFragment", "Lmqq/util/WeakReference;", "fragmentRef", "Lmqq/util/WeakReference;", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class h<BizRsp extends MessageMicro<BizRsp>> implements o<BizRsp>, f {

    @NotNull
    private final WeakReference<Fragment> fragmentRef;

    public h(@Nullable Fragment fragment) {
        this.fragmentRef = new WeakReference<>(fragment);
    }

    @Override // pl2.b
    @Nullable
    public Context getContext() {
        return f.a.a(this);
    }

    @Override // pl2.f
    @Nullable
    public Fragment getFragment() {
        return this.fragmentRef.get();
    }

    @Override // pl2.b
    public boolean isAlive() {
        return f.a.b(this);
    }
}
