package cn;

import androidx.recyclerview.widget.DiffUtil;
import com.qzone.reborn.base.h;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c extends h<com.qzone.reborn.qzmoment.comment.f> {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends DiffUtil.ItemCallback<com.qzone.reborn.qzmoment.comment.f> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(com.qzone.reborn.qzmoment.comment.f fVar, com.qzone.reborn.qzmoment.comment.f fVar2) {
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(com.qzone.reborn.qzmoment.comment.f fVar, com.qzone.reborn.qzmoment.comment.f fVar2) {
            return Objects.equals(fVar.f58883a, fVar2.f58883a);
        }
    }

    public c() {
        super(new a(), new AdapterDelegatesManager(new com.qzone.reborn.qzmoment.itemview.b()));
    }
}
