package gs1;

import android.content.Intent;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.guild.mainframe.i;
import com.tencent.mobileqq.guild.mainframe.k;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class a extends k {
    public a(i iVar) {
        super(iVar);
    }

    public boolean i(Intent intent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FragmentManager j() {
        return this.f227466d.getChildFragmentManager();
    }

    public abstract int k();

    public abstract void l();

    public abstract void m(ViewGroup viewGroup);

    public abstract void n(@Nullable Intent intent);
}
