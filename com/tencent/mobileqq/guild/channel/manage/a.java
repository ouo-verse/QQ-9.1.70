package com.tencent.mobileqq.guild.channel.manage;

import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a<T> extends ItemTouchHelper.Callback {

    /* renamed from: a, reason: collision with root package name */
    protected RecyclerView f215078a;

    /* renamed from: b, reason: collision with root package name */
    protected List<T> f215079b;

    /* renamed from: c, reason: collision with root package name */
    protected int f215080c;

    public a(RecyclerView recyclerView, List<T> list) {
        new ArrayList();
        this.f215079b = list;
        this.f215078a = recyclerView;
    }

    private void a(RecyclerView.ViewHolder viewHolder, boolean z16) {
        View view;
        float f16;
        if (viewHolder != null && (view = viewHolder.itemView) != null) {
            try {
                view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
                View view2 = viewHolder.itemView;
                if (z16) {
                    f16 = 20.0f;
                } else {
                    f16 = 0.0f;
                }
                view2.setTranslationZ(f16);
            } catch (Exception e16) {
                QLog.i("Guild.mnr.BaseDragTouchCallBack", 1, "setItemShadow", e16);
            }
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        QLog.i("Guild.mnr.BaseDragTouchCallBack", 1, "clearView");
        a(viewHolder, false);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        int adapterPosition = viewHolder.getAdapterPosition();
        int adapterPosition2 = viewHolder2.getAdapterPosition();
        int size = this.f215079b.size();
        if (QLog.isColorLevel()) {
            QLog.d("Guild.mnr.BaseDragTouchCallBack", 2, "onMove fromPosition:", Integer.valueOf(adapterPosition), " toPosition:", Integer.valueOf(adapterPosition2), " size:", Integer.valueOf(size));
        }
        int i3 = this.f215080c;
        if (i3 > 0 && (adapterPosition < i3 || adapterPosition >= size || adapterPosition2 < i3 || adapterPosition2 >= size)) {
            QLog.w("Guild.mnr.BaseDragTouchCallBack", 1, "onMove wrong pos!");
            return false;
        }
        if (adapterPosition == adapterPosition2) {
            return false;
        }
        if (adapterPosition < adapterPosition2) {
            int i16 = adapterPosition;
            while (i16 < adapterPosition2) {
                int i17 = i16 + 1;
                Collections.swap(this.f215079b, i16, i17);
                i16 = i17;
            }
        } else {
            for (int i18 = adapterPosition; i18 > adapterPosition2; i18--) {
                Collections.swap(this.f215079b, i18, i18 - 1);
            }
        }
        this.f215078a.getAdapter().notifyItemMoved(adapterPosition, adapterPosition2);
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i3) {
        QLog.i("Guild.mnr.BaseDragTouchCallBack", 1, "onSelectedChanged" + i3);
        if (i3 == 0) {
            RecyclerView recyclerView = this.f215078a;
            if (recyclerView instanceof OverScrollRecyclerView) {
                ((OverScrollRecyclerView) recyclerView).I();
                ((OverScrollRecyclerView) this.f215078a).K();
                return;
            }
            return;
        }
        if (i3 == 2) {
            a(viewHolder, true);
            RecyclerView recyclerView2 = this.f215078a;
            if (recyclerView2 instanceof OverScrollRecyclerView) {
                ((OverScrollRecyclerView) recyclerView2).H();
            }
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i3) {
    }
}
