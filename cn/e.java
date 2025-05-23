package cn;

import androidx.recyclerview.widget.DiffUtil;
import bn.g;
import com.qzone.reborn.base.h;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e extends h<g> {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends DiffUtil.ItemCallback<g> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(g gVar, g gVar2) {
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(g gVar, g gVar2) {
            return Objects.equals(gVar.a().f430364id.get(), gVar2.a().f430364id.get());
        }
    }

    public e() {
        super(new a(), new AdapterDelegatesManager(new com.qzone.reborn.qzmoment.itemview.c()));
    }
}
