package kf1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import kf1.a;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static RecyclerView.ViewHolder a(int i3, ViewGroup viewGroup) {
        RecyclerView.ViewHolder dVar;
        RecyclerView.ViewHolder viewHolder;
        Context context = viewGroup.getContext();
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        viewHolder = null;
                        if (viewHolder == null) {
                            QLog.e("Guild.c.picker.QQGuildSelectChannelViewHolderFactory", 1, "Maybe type error! type == " + i3);
                        }
                        return viewHolder;
                    }
                    dVar = new a.C10654a(LayoutInflater.from(context).inflate(R.layout.f168182f84, viewGroup, false));
                } else {
                    dVar = new a.c(LayoutInflater.from(context).inflate(R.layout.f86, viewGroup, false));
                }
            } else {
                dVar = new a.b(LayoutInflater.from(context).inflate(R.layout.f85, viewGroup, false));
            }
        } else {
            dVar = new a.d(LayoutInflater.from(context).inflate(R.layout.f87, viewGroup, false));
        }
        viewHolder = dVar;
        if (viewHolder == null) {
        }
        return viewHolder;
    }
}
