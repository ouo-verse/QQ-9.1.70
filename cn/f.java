package cn;

import androidx.recyclerview.widget.DiffUtil;
import com.qzone.reborn.base.h;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f extends h<bn.f> {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends DiffUtil.ItemCallback<bn.f> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(bn.f fVar, bn.f fVar2) {
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(bn.f fVar, bn.f fVar2) {
            return Objects.equals(fVar.a().relation.f430365id.get(), fVar2.a().relation.f430365id.get());
        }
    }

    public f() {
        super(new a(), new AdapterDelegatesManager(new com.qzone.reborn.qzmoment.itemview.d()));
    }
}
